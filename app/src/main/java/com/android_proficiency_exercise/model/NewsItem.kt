package com.android_proficiency_exercise.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class NewsItem(
    @Json(name = "title")
    var title: String? = "",
    @Json(name = "description")
    var description: String? = "",
    @Json(name = "imageHref")
    var imageUrl: String? = ""
)