package com.example.usersinfo.data

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Registered(
    val age: Int,
    val date: String
): Serializable
