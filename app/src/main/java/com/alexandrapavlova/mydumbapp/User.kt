package com.alexandrapavlova.mydumbapp

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "avatar") val avatarUrl: String, // for example: "http://myapp.com/user_1_avatar.jpg"
    @Json(name = "first_name") val userName: String,
    @Json(name = "email") val groupName: String
)
