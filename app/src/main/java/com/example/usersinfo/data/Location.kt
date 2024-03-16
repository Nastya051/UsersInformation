package com.example.usersinfo.data

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Location(
    val city: String,
    val coordinates: Coordinates,
    val country: String,
    val postcode: Int,
    val state: String,
    val street: Street,
    val timezone: Timezone
): Serializable