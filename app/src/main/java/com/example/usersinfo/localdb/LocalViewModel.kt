package com.example.usersinfo.localdb

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalViewModel(val dao: DaoUser) : ViewModel() {

    private val _allUsers = dao.getAllUsers()
    val allUsers: LiveData<List<Information>> = _allUsers

    fun insertUser(info: Information) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.addUser(info)
        }
    }

    fun getUsers(): LiveData<List<Information>> {
        return allUsers
    }
}

class UserViewModelFactory(private val dao: DaoUser) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LocalViewModel::class.java)) {
            return LocalViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}