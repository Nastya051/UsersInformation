package com.example.usersinfo.data

import com.example.usersinfo.RandomUser

data class UserParsing(
    val info: Info,
    val results: List<Result>
)

fun UserParsing.parsing(): List<RandomUser> {
        return results.map {
            RandomUser(
                gender = it.gender,
                title = it.name.title,
                photo = it.picture.large,
                firstName = it.name.first,
                lastName = it.name.last,
                name = "${it.name.first} ${it.name.last}",
                streetName = it.location.street.name,
                streetNumber = it.location.street.number,
                city = it.location.city,
                state = it.location.country,
                country = it.location.country,
                postcode = it.location.postcode,
                latitude = it.location.coordinates.latitude,
                longitude = it.location.coordinates.longitude,
                offset = it.location.timezone.offset,
                description = it.location.timezone.description,
                email = it.email,
                uuid = it.login.uuid,
                username = it.login.username,
                salt = it.login.salt,
                md5 = it.login.md5,
                sha1 = it.login.sha1,
                sha256 = it.login.sha256,
                dateBirth = it.dob.date.substringBeforeLast(
                    delimiter = 'T',
                    missingDelimiterValue = "T not found"
                ),
                ageBirth = it.dob.age,
                birthday = it.dob.date.substringBeforeLast(
                    delimiter = 'T',
                    missingDelimiterValue = "T not found"
                ),
                age = it.dob.age,
                dateRegis = it.registered.date.substringBeforeLast(
                    delimiter = 'T',
                    missingDelimiterValue = "T not found"
                ),
                ageRegis = it.registered.age,
                address = "${it.location.street.number} ${it.location.street.name}",
                phone = it.phone,
                cell = it.cell,
                password = it.login.password,
                idName = it.id.name,
                idValue = it.id.value,
                pictureLarge = it.picture.large,
                pictureMedium = it.picture.medium,
                pictureThumbnail = it.picture.thumbnail,
                nat = it.nat,
                seed = info.seed,
                results = info.results,
                page = info.page,
                version = info.version
            )
        }
}
