package com.xeus.restApiAuthDemo.controller

import java.util.*

data class ArticleResponse(
    val id: UUID,
    val title: String,
    val content: String
)
