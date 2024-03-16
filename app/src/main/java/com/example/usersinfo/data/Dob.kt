package com.example.usersinfo.data

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Dob(
    val age: Int,
    val date: String
): Serializable
