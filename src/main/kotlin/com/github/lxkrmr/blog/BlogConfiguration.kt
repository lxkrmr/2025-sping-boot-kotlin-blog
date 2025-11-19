package com.github.lxkrmr.blog

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(
        userRepository: UserRepository,
        articleRepository: ArticleRepository
    ) = ApplicationRunner {
        val johnDoe = userRepository.save(User("johnDoe", "John", "Doe"))

        articleRepository.save(Article(
            title = "Title",
            headline = "This is a headline",
            content = "Some content",
            author = johnDoe
        ))

        articleRepository.save(Article(
            title = "Another title",
            headline = "This is another headline",
            content = "And even more content",
            author = johnDoe
        ))

    }
}