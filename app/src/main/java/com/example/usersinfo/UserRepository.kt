package com.example.usersinfo

class UserRepository {
    suspend fun getUser() = RandomUserApi.retrofitService.getUser()
}