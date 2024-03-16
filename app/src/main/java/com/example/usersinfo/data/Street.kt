package com.example.usersinfo.data

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Street(
    val name: String,
    val number: Int
): Serializable
