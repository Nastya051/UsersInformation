package com.example.usersinfo.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.usersinfo.MainActivity
import com.example.usersinfo.RandomUser
import com.example.usersinfo.RandomUserApiStatus
import com.example.usersinfo.RandomUserViewModelFactory
import com.example.usersinfo.UserItemAdapter
import com.example.usersinfo.UserRepository
import com.example.usersinfo.UserViewModel
import com.example.usersinfo.databinding.FragmentAllUsersBinding
import com.example.usersinfo.localdb.Information
import com.example.usersinfo.localdb.LocalViewModel
import com.example.usersinfo.localdb.Maindb
import com.example.usersinfo.localdb.UserViewModelFactory

class AllUsersFragment : Fragment(), UserItemAdapter.Listener {

    lateinit var binding: FragmentAllUsersBinding
    lateinit var db: Maindb
    var currentInfo: Information? = null
    var previousInfo: Information? = null
    lateinit var localviewModel: LocalViewModel
    var flag: Boolean = false
    private var users: List<Information> = listOf()
    lateinit var adapter: UserItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val context = requireContext()
        db = Maindb.getdb(context)

        val application = requireNotNull(this.activity).application
        val dao = Maindb.getdb(application).getDao()
        val viewModelFactory = UserViewModelFactory(dao)
        localviewModel = ViewModelProvider(this, viewModelFactory).get(LocalViewModel::class.java)
        localviewModel.getUsers()


        val viewModel: UserViewModel by viewModels {
            val repository = UserRepository()
            RandomUserViewModelFactory(repository)
        }
        binding = FragmentAllUsersBinding.inflate(inflater, container, false)

        adapter = UserItemAdapter(this)
        binding.allUsers.adapter = adapter


        binding.buttonUpdate.setOnClickListener {
            viewModel.getUserFromRepository()
        }

        localviewModel.allUsers.observe(viewLifecycleOwner, Observer {
            if (localviewModel.allUsers.value?.size!! > 0) {
                users = localviewModel.allUsers.value!!
                if (users.isNotEmpty()) {
                    if (!flag) {
                        for (i in 0 until users.size) {
                            adapter.addUser(fillRandomUser(users[i]))
                        }
                        flag = true
                    }
                }
            }
        })

        localviewModel.getUsers()
        if (users.isNotEmpty()) {
            if (!flag) {
                for (i in 0 until users.size) {
                    adapter.addUser(fillRandomUser(users[i]))
                }
                flag = true
            }
        }

        viewModel.status.observe(viewLifecycleOwner, Observer {
            if (it == RandomUserApiStatus.DONE) {
                currentInfo = fillInformation(viewModel.randomUser.value!!)
                if (previousInfo != null) {
                    if (currentInfo != null) {
                        if (previousInfo!!.idValue != currentInfo?.idValue) {
                            localviewModel.insertUser(currentInfo!!)
//                            Log.d("MyLog", "insert user ${currentInfo!!.firstName}")
                            adapter.addUser(viewModel.randomUser.value!!)
                            previousInfo = currentInfo
                            localviewModel.getUsers()
                        }
                    }
                } else {
                    localviewModel.insertUser(currentInfo!!)
//                        Log.d("MyLog", "insert user ${currentInfo!!.firstName} ${previousInfo}")
                    adapter.addUser(viewModel.randomUser.value!!)
                    previousInfo = currentInfo
                    localviewModel.getUsers()
                }
            } else if (it == RandomUserApiStatus.ERROR) {
                Toast.makeText(activity as MainActivity, "ERROR!!!", Toast.LENGTH_SHORT).show()
            }
            localviewModel.getUsers()
        })

        return binding.root
    }


    override fun onClick(user: RandomUser) {
        flag = false
        val controller = findNavController()
        val action =
            AllUsersFragmentDirections.actionAllUsersFragmentToCurrentUserFragment(userInfo = user)
        controller.navigate(action)
    }

    private fun fillRandomUser(inf: Information): RandomUser {
        return RandomUser(
            title = inf.title,
            photo = inf.pictureLarge,
            name = "${inf.firstName} ${inf.lastName}",
            firstName = inf.firstName,
            lastName = inf.lastName,
            streetNumber = inf.streetNumber,
            streetName = inf.streetName,
            city = inf.city,
            state = inf.state,
            country = inf.country,
            postcode = inf.postcode,
            latitude = inf.latitude,
            longitude = inf.longitude,
            offset = inf.offset,
            description = inf.description,
            email = inf.email,
            uuid = inf.uuid,
            username = inf.username,
            password = inf.password,
            salt = inf.salt,
            md5 = inf.md5,
            sha1 = inf.sha1,
            sha256 = inf.sha256,
            dateBirth = inf.dateBirth,
            ageBirth = inf.ageBirth,
            birthday = inf.dateBirth,
            age = inf.ageBirth,
            dateRegis = inf.dateRegis,
            ageRegis = inf.ageRegis,
            phone = inf.phone,
            cell = inf.cell,
            idName = inf.idName,
            idValue = inf.idValue,
            pictureLarge = inf.pictureLarge,
            pictureMedium = inf.pictureMedium,
            pictureThumbnail = inf.pictureThumbnail,
            nat = inf.nat,
            seed = inf.seed,
            results = inf.results,
            page = inf.page,
            version = inf.version,
            address = inf.streetName,
            gender = inf.gender
        )
    }

    private fun fillInformation(random: RandomUser): Information {
        return Information(
            null,
            gender = random.gender,
            title = random.title,
            firstName = random.firstName,
            lastName = random.lastName,
            streetNumber = random.streetNumber,
            streetName = random.streetName,
            city = random.city,
            state = random.state,
            country = random.country,
            postcode = random.postcode,
            latitude = random.latitude,
            longitude = random.longitude,
            offset = random.offset,
            description = random.description,
            email = random.email,
            uuid = random.uuid,
            username = random.username,
            password = random.password,
            salt = random.salt,
            md5 = random.md5,
            sha1 = random.sha1,
            sha256 = random.sha256,
            dateBirth = random.dateBirth,
            ageBirth = random.ageBirth,
            dateRegis = random.dateRegis,
            ageRegis = random.ageRegis,
            phone = random.phone,
            cell = random.cell,
            idName = random.idName,
            idValue = random.idValue,
            pictureLarge = random.pictureLarge,
            pictureMedium = random.pictureMedium,
            pictureThumbnail = random.pictureThumbnail,
            nat = random.nat,
            seed = random.seed,
            results = random.results,
            page = random.page,
            version = random.version
        )
    }
}