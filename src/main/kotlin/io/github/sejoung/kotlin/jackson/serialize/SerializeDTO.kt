package io.github.sejoung.kotlin.jackson.serialize

data class User(var source: String, var path: String)

data class OldOrder(
    val orderName: String,
    @UserAnnotation
    var user: User,
)

data class NewOrder(
    val orderName: String,

    @get:UserAnnotation
    val user: User,

    @get:UserAnnotations
    val userList: List<User> = emptyList(),
)

class NewTest {
    var orderName: String? = null

    @UserAnnotation
    var user: User? = null

    override fun toString(): String {
        return " orderName = $orderName user =  $user"
    }
}
