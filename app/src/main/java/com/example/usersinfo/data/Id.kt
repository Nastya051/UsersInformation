package com.example.usersinfo.data

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Id(
    val name: String,
    val value: String?
): Serializable
