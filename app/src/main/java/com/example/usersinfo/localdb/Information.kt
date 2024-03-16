package com.example.usersinfo.localdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Information")
data class Information(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "Gender")
    var gender: String,
    @ColumnInfo(name = "Title")
    var title: String,
    @ColumnInfo(name = "FirstName")
    var firstName: String,
    @ColumnInfo(name = "LastName")
    var lastName: String,
    @ColumnInfo(name = "StreetNumber")
    var streetNumber: Int,
    @ColumnInfo(name = "StreetName")
    var streetName: String,
    @ColumnInfo(name = "City")
    var city: String,
    @ColumnInfo(name = "State")
    var state: String,
    @ColumnInfo(name = "Country")
    var country: String,
    @ColumnInfo(name = "Postcode")
    var postcode: Int,
    @ColumnInfo(name = "Latitude")
    var latitude: String,
    @ColumnInfo(name = "Longitude")
    var longitude: String,
    @ColumnInfo(name = "Offset")
    var offset: String,
    @ColumnInfo(name = "Description")
    var description: String,
    @ColumnInfo(name = "Email")
    var email: String,
    @ColumnInfo(name = "Uuid")
    var uuid: String,
    @ColumnInfo(name = "Username")
    var username: String,
    @ColumnInfo(name = "Password")
    var password: String,
    @ColumnInfo(name = "Salt")
    var salt: String,
    @ColumnInfo(name = "md5")
    var md5: String,
    @ColumnInfo(name = "Sha1")
    var sha1: String,
    @ColumnInfo(name = "Sha256")
    var sha256: String,
    @ColumnInfo(name = "DateBirth")
    var dateBirth: String,
    @ColumnInfo(name = "AgeBirth")
    var ageBirth: Int,
    @ColumnInfo(name = "DateRegis")
    var dateRegis: String,
    @ColumnInfo(name = "AgeRegis")
    var ageRegis: Int,
    @ColumnInfo(name = "Phone")
    var phone: String,
    @ColumnInfo(name = "Cell")
    var cell: String,
    @ColumnInfo(name = "IdName")
    var idName: String,
    @ColumnInfo(name = "IdValue")
    var idValue: String?,
    @ColumnInfo(name = "PictureLarge")
    var pictureLarge: String,
    @ColumnInfo(name = "PictureMedium")
    var pictureMedium: String,
    @ColumnInfo(name = "PictureThumbnail")
    var pictureThumbnail: String,
    @ColumnInfo(name = "Nat")
    var nat: String,
    @ColumnInfo(name = "Seed")
    var seed: String,
    @ColumnInfo(name = "Results")
    var results: Int,
    @ColumnInfo(name = "Page")
    var page: Int,
    @ColumnInfo(name = "Version")
    var version: String
)