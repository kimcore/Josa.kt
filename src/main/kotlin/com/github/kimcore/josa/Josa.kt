package com.github.kimcore.josa

@Suppress("ObjectPropertyName", "NonAsciiCharacters", "unused")
object Josa {
    private val handlers = arrayOf(
        { s: String -> if (has(s)) "을" else "를" },
        { s: String -> if (has(s)) "은" else "는" },
        { s: String -> if (has(s)) "이" else "가" },
        { s: String -> if (has(s)) "과" else "와" },
        { s: String -> if (has(s)) "으로" else "로" },
        { s: String -> if (has(s)) "이나" else "나" },
        { s: String -> if (has(s)) "아" else "야" },
        { s: String -> if (has(s)) "이라" else "라" },
        { s: String -> if (has(s)) "이야" else "야" }
    )

    private val formats = mapOf(
        "을/를" to handlers[0], "을" to handlers[0], "를" to handlers[0], "을를" to handlers[0],
        "은/는" to handlers[1], "은" to handlers[1], "는" to handlers[1], "은는" to handlers[1],
        "이/가" to handlers[2], "이" to handlers[2], "가" to handlers[2], "이가" to handlers[2],
        "와/과" to handlers[3], "와" to handlers[3], "과" to handlers[3], "와과" to handlers[3],
        "로/으로" to handlers[4], "로" to handlers[4], "으로" to handlers[4], "로으로" to handlers[4],
        "나/이나" to handlers[5], "나" to handlers[5], "이나" to handlers[5], "나이나" to handlers[5],
        "아/야" to handlers[6], "아" to handlers[6], "야" to handlers[6], "아야" to handlers[6],
        "라/이라" to handlers[7], "라" to handlers[7], "이라" to handlers[7], "라이라" to handlers[7],
        "야/이야" to handlers[8], "야" to handlers[8], "이야" to handlers[8], "야이야" to handlers[8]
    )

    private fun has(s: String): Boolean =
        ("[가-힣]$|/".toRegex().containsMatchIn(s) && (s.trim().last().toInt() - 0xac00) % 28 > 0)
                || ("[가-힣]\\d*[013678]$|/".toRegex().containsMatchIn(s)
                || "[a-z]\\d*[1789]$|/i".toRegex().containsMatchIn(s))
                || "([clmnp]|[blnt](e)|[co](k)|[aeiou](t)|mb|ng|lert)$|/i".toRegex().containsMatchIn(s)

    private fun replace(s: String): String = s
        .replace("(.*)/gi".toRegex(), "").replace("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z\\d]".toRegex(), "")
        .replace("ㄳ", "ㄱㅅ").replace("ㄵ", "ㄴㅈ")
        .replace("ㄼ", "ㄹㅂ").replace("ㄽ", "ㄹㅅ")
        .replace("ㄾ", "ㄹㅌ").replace("ㅄ", "ㅂㅅ")
        .replace("ㄺ", "ㄹㄱ").replace("ㄻ", "ㄹㅁ")
        .replace("ㄿ", "ㄹㅍ").replace("ㄶ", "ㄴㅎ")
        .replace("ㅀ", "ㄹㅎ").replace("ㄱ", "기역")
        .replace("ㄴ", "니은").replace("ㄷ", "디귿")
        .replace("ㄹ", "리을").replace("ㅁ", "미음")
        .replace("ㅂ", "비읍").replace("ㅅ", "시옷")
        .replace("ㅇ", "이응").replace("ㅈ", "지읒")
        .replace("ㅊ", "치읓").replace("ㅋ", "키읔")
        .replace("ㅌ", "티읕").replace("ㅍ", "피읖")
        .replace("ㅎ", "히읗").replace("ㄲ", "쌍기역")
        .replace("ㄸ", "쌍디귿").replace("ㅃ", "쌍비읍")
        .replace("ㅆ", "쌍시옷").replace("ㅉ", "쌍지읒")
        .replace("ㅏ", "아").replace("ㅓ", "어")
        .replace("ㅗ", "오").replace("ㅜ", "우")
        .replace("ㅡ", "으").replace("ㅣ", "이")
        .replace("ㅐ", "애").replace("ㅔ", "에")
        .replace("ㅚ", "외").replace("ㅟ", "위")
        .replace("ㅑ", "야").replace("ㅕ", "여")
        .replace("ㅛ", "요").replace("ㅠ", "유")
        .replace("ㅒ", "얘").replace("ㅖ", "예")
        .replace("ㅘ", "와").replace("ㅙ", "왜")
        .replace("ㅝ", "워").replace("ㅞ", "웨")
        .replace("ㅢ", "의")

    @JvmStatic
    fun get(s: String, format: String): String {
        if (!formats.containsKey(format)) throw UnknownFormatException()
        val value = replace(s)
        if (value.isBlank()) return ""
        return formats.getValue(format)(value)
    }

    @JvmStatic
    fun getAttached(s: String, format: String): String = s + get(s, format)

    @JvmStatic
    fun String.josa(format: String): String = getAttached(this, format)

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

    @JvmStatic
    val String.라이라: String
        get() = getAttached(this, "라/이라")

    @JvmStatic
    val String.야이야: String
        get() = getAttached(this, "야/이야")

    class UnknownFormatException : Exception("Unknown format for Josa.")
}