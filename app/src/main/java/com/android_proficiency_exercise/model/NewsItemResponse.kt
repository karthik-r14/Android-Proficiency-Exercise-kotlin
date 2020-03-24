package com.android_proficiency_exercise.model

import com.squareup.moshi.Json

class NewsItemResponse {
    @Json(name = "rows")
    var newsItems: List<NewsItem>? = null

    @Json(name = "title")
    var title: String? = null
}
