package com.example.usersinfo.data

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Timezone(
    val description: String,
    val offset: String
): Serializable
