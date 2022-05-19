package io.github.sejoung.kotlin.jackson.serialize

data class User(val source: String, val path: String)


data class OldOrder(
    val orderName: String,
    @UserAnnotation
    val user: User
)

data class NewOrder(
    val orderName: String,

    @UserAnnotation
    val user: User,

    @UserAnnotations
    val userList: List<User> = emptyList(),
)
