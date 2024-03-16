package com.example.usersinfo.data

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Name(
    val first: String,
    val last: String,
    val title: String
): Serializable
