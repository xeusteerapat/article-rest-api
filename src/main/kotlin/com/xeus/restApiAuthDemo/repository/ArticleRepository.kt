package com.xeus.restApiAuthDemo.repository

import com.xeus.restApiAuthDemo.model.Article
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ArticleRepository {
    private val articles = listOf(
        Article(
            id = UUID.randomUUID(),
            title = "Introduction to Docker",
            content = "Many times we write programs and we want our programs to work properly without any external factors interfering."
    ),
        Article(
            id = UUID.randomUUID(),
            title = "Create Graphql server in Next.js",
            content = "Hello, today I will introduce how to create a Graphql server in Next.js project."
        ),
    )
        fun findAll(): List<Article> = articles
}