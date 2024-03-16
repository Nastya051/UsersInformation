package com.example.usersinfo

import retrofit2.http.GET
import com.example.usersinfo.data.UserParsing
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("https://randomuser.me/")
    .build()

interface UserApi {
    @GET("api")
    suspend fun getUser(): UserParsing

}
object RandomUserApi {

    val retrofitService: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }
}