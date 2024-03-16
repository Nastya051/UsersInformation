package com.example.usersinfo.data

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Info(
    val page: Int,
    val results: Int,
    var seed: String,
    val version: String
) : Serializable
