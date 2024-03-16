package com.example.usersinfo.data

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
): Serializable
