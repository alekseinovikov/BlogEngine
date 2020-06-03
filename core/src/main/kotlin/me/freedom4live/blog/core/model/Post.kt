package me.freedom4live.blog.core.model

import java.time.ZonedDateTime

typealias PostId = Long
typealias PostDate = ZonedDateTime
typealias PostTag = String
typealias PostVersion = Long

data class Post(
    val id: PostId,

    val creationDate: PostDate,
    val lastEditDate: PostDate,
    val author: User,
    val version: PostVersion,

    val title: String,
    val content: String,
    val tags: List<PostTag>
)