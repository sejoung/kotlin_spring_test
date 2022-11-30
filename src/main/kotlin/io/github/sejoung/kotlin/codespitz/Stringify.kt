package io.github.sejoung.kotlin.codespitz

import kotlin.reflect.KProperty

fun <T> T.stringify() = StringBuilder().run {
    jsonValue(this@stringify)
    toString()
}

private fun StringBuilder.jsonValue(value: Any?) {
    when (value) {
        null -> append("null")
        is String -> jsonString(value)
        is Boolean, is Number -> append("$value")
        is Collection<*> -> jsonCollection(value)
        is Map<*, *> -> jsonMap(value)
        else -> jsonObject(value)
    }
}

private fun <T> Iterable<T>.joinTo(sep: () -> Unit, transform: (T) -> Unit) {
    forEachIndexed { count, element ->
        if (count != 0) sep()
        transform(element)
    }
}


private fun StringBuilder.comma() {
    append(',')
}

private fun StringBuilder.wrap(begin: Char, end: Char, block: StringBuilder.() -> Unit) {
    append(begin)
    block()
    append(end)
}

private fun StringBuilder.jsonString(v: String) =
    append(""""${v.replace("\"", "\\\"")}"""")


private fun StringBuilder.jsonObject(target: Any) {
    wrap('{', '}') {
        target::class.members.filterIsInstance<KProperty<*>>().joinTo(::comma) {
            jsonValue(it.name)
            append(':')
            jsonValue(it.getter.call(target))
        }
    }
}

private fun StringBuilder.jsonMap(target: Map<*, *>) {
    wrap('{', '}') {
        target.entries.joinTo(::comma) {
            jsonValue(it.key)
            append(':')
            jsonValue(it.value)
        }
    }
}

private fun StringBuilder.jsonCollection(target: Collection<*>) {
    wrap('[', ']') {
        target.joinTo(::comma) {
            jsonValue(it)
        }
    }
}

