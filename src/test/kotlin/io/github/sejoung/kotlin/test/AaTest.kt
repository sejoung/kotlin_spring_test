package io.github.sejoung.kotlin.test

import org.junit.jupiter.api.Test
import org.springframework.web.util.UriComponentsBuilder
import java.lang.StringBuilder
import kotlin.reflect.KProperty

class AaTest {

    @Test
    fun test() {
        val uriString =
            UriComponentsBuilder.fromHttpUrl("https://dev-member.bigpi.co/login").path("/").path("/1234").toUriString()

        print(uriString)
    }

    fun <T : Any> stringify(target: T): String {
        val builder = StringBuilder()
        builder.append("{")
        target::class.members.filterIsInstance<KProperty<*>>().forEach {
            builder.append(it.name, ':')
            val value = it.getter.call(target)
            builder.append(value)
        }
        builder.append("}")
        return "$builder"
    }

    @Test
    fun passingTrailingLambdas() {
        val items: IntArray = intArrayOf(1, 2, 3, 4)
        val product = items.fold(1) { acc, e -> acc * e }
        println(product)
        run { println("...") }
    }
}
