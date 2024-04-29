package com.xeus.restApiAuthDemo.service

import com.xeus.restApiAuthDemo.model.Article
import com.xeus.restApiAuthDemo.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository
) {
    fun findAll(): List<Article> = articleRepository.findAll()
}