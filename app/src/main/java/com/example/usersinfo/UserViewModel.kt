package com.example.usersinfo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.usersinfo.data.parsing

enum class RandomUserApiStatus { LOADING, ERROR, DONE }

class UserViewModel(private val userRepository: UserRepository): ViewModel() {
    private val _status = MutableLiveData<RandomUserApiStatus>()
    val status: LiveData<RandomUserApiStatus> = _status

    private val _randomUser = MutableLiveData<RandomUser>()
    val randomUser: LiveData<RandomUser> = _randomUser

    init {
        getUserFromRepository()
    }

    fun getUserFromRepository() {
        viewModelScope.launch {
            _status.value = RandomUserApiStatus.LOADING
            try {
                _randomUser.value = userRepository.getUser().parsing().first()
                _status.value = RandomUserApiStatus.DONE
            } catch (e: Exception) {
                _status.value = RandomUserApiStatus.ERROR
                Log.d("MyLog", "exeption $e")
            }
        }
    }
}

class RandomUserViewModelFactory(private val randomUserRepository: UserRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            UserViewModel(randomUserRepository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}