package com.github.kimcore.josa

@Suppress("ObjectPropertyName", "NonAsciiCharacters", "unused")
object Josa {
    private val functions = arrayOf(
        fun(s: String): String {
            return if (has(s)) "을" else "를"
        },
        fun(s: String): String {
            return if (has(s)) "은" else "는"
        },
        fun(s: String): String {
            return if (has(s)) "이" else "가"
        },
        fun(s: String): String {
            return if (has(s)) "과" else "와"
        },
        fun(s: String): String {
            return if (has(s)) "으로" else "로"
        },
        fun(s: String): String {
            return if (has(s)) "이나" else "나"
        },
        fun(s: String): String {
            return if (has(s)) "아" else "야"
        }
    )

    private val formats = mapOf(
        "을/를" to functions[0],
        "을" to functions[0],
        "를" to functions[0],
        "을를" to functions[0],
        "은/는" to functions[1],
        "은" to functions[1],
        "는" to functions[1],
        "은는" to functions[1],
        "이/가" to functions[2],
        "이" to functions[2],
        "가" to functions[2],
        "이가" to functions[2],
        "와/과" to functions[3],
        "와" to functions[3],
        "과" to functions[3],
        "와과" to functions[3],
        "로/으로" to functions[4],
        "로" to functions[4],
        "으로" to functions[4],
        "로으로" to functions[4],
        "나/이나" to functions[5],
        "나" to functions[5],
        "이나" to functions[5],
        "나이나" to functions[5],
        "아/야" to functions[6],
        "아" to functions[6],
        "야" to functions[6],
        "아야" to functions[6]
    )

    private fun has(s: String): Boolean {
        return ("[가-힣]$|/".toRegex().containsMatchIn(s) && (s.trim().last().toInt() - 0xac00) % 28 > 0)
                || ("[가-힣]\\d*[013678]$|/".toRegex().containsMatchIn(s)
                || "[a-z]\\d*[1789]$|/i".toRegex().containsMatchIn(s))
                || "([clmnp]|[blnt](e)|[co](k)|[aeiou](t)|mb|ng|lert)$|/i".toRegex().containsMatchIn(s)
    }

    @JvmStatic
    fun get(s: String, format: String): String {
        if (!formats.containsKey(format)) throw UnknownFormatException()
        val value = s.replace("(.*)/gi".toRegex(), "").replace("[^가-힣a-z\\d]".toRegex(), "")
        if (value.isBlank()) return ""
        return formats.getValue(format)(value)
    }

    @JvmStatic
    fun getAttached(s: String, format: String): String {
        return s + get(s, format)
    }

    @JvmStatic
    fun String.josa(format: String): String {
        return getAttached(this, format)
    }

    @JvmStatic
    val String.을를: String
        get() = getAttached(this, "을/를")

    @JvmStatic
    val String.은는: String
        get() = getAttached(this, "은/는")

    @JvmStatic
    val String.이가: String
        get() = getAttached(this, "이/가")

    @JvmStatic
    val String.와과: String
        get() = getAttached(this, "와/과")

    @JvmStatic
    val String.로으로: String
        get() = getAttached(this, "로/으로")

    @JvmStatic
    val String.나이나: String
        get() = getAttached(this, "나/이나")

    @JvmStatic
    val String.아야: String
        get() = getAttached(this, "아/야")

    class UnknownFormatException : Exception("Unknown format for Josa.")
}