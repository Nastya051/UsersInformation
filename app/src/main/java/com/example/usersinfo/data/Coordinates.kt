package com.example.usersinfo.data

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Coordinates(
    val latitude: String,
    val longitude: String
) : Serializable
