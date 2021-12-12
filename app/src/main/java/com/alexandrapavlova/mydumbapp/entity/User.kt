package com.alexandrapavlova.mydumbapp.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "id") val id: Long,
    @Json(name = "user_name") val userName: String,
    @Json(name = "avatar") val avatarUrl: String, // for example: "http://myapp.com/user_1_avatar.jpg"
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String,
    @Json(name = "email") val groupName: String
)
