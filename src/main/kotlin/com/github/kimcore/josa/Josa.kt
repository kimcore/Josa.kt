package com.github.kimcore.josa

@Suppress("ObjectPropertyName", "NonAsciiCharacters", "unused")
object Josa {
    const val VERSION = "1.8"

    private val toReplace = mapOf(
        "ㄳ" to "ㄱㅅ", "ㄵ" to "ㄴㅈ",
        "ㄼ" to "ㄹㅂ", "ㄽ" to "ㄹㅅ",
        "ㄾ" to "ㄹㅌ", "ㅄ" to "ㅂㅅ",
        "ㄺ" to "ㄹㄱ", "ㄻ" to "ㄹㅁ",
        "ㄿ" to "ㄹㅍ", "ㄶ" to "ㄴㅎ",
        "ㅀ" to "ㄹㅎ", "ㄱ" to "기역",
        "ㄴ" to "니은", "ㄷ" to "디귿",
        "ㄹ" to "리을", "ㅁ" to "미음",
        "ㅂ" to "비읍", "ㅅ" to "시옷",
        "ㅇ" to "이응", "ㅈ" to "지읒",
        "ㅊ" to "치읓", "ㅋ" to "키읔",
        "ㅌ" to "티읕", "ㅍ" to "피읖",
        "ㅎ" to "히읗", "ㄲ" to "쌍기역",
        "ㄸ" to "쌍디귿", "ㅃ" to "쌍비읍",
        "ㅆ" to "쌍시옷", "ㅉ" to "쌍지읒",
        "ㅏ" to "아", "ㅓ" to "어",
        "ㅗ" to "오", "ㅜ" to "우",
        "ㅡ" to "으", "ㅣ" to "이",
        "ㅐ" to "애", "ㅔ" to "에",
        "ㅚ" to "외", "ㅟ" to "위",
        "ㅑ" to "야", "ㅕ" to "여",
        "ㅛ" to "요", "ㅠ" to "유",
        "ㅒ" to "얘", "ㅖ" to "예",
        "ㅘ" to "와", "ㅙ" to "왜",
        "ㅝ" to "워", "ㅞ" to "웨",
        "ㅢ" to "의",
    )

    @JvmStatic
    fun get(input: String, format: String, alternative: String? = null): String {
        if (format.count { it == '/' } != 1) {
            throw MalformedFormatException()
        }

        val (first, second) = format.split('/')

        var value = input
            .replace("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z\\d]".toRegex(RegexOption.IGNORE_CASE), "")

        toReplace.forEach { (k, v) ->
            value = value.replace(k, v)
        }

        if (value.isBlank()) {
            return alternative ?: when ((first + second).replace(" ", "")) {
                "로으로" -> "(으)로"
                "나이나" -> "(이)나"
                "라이라" -> "(이)라"
                "야이야" -> "(이)야"
                else -> "($first)$second"
            }
        }

        val hasConsonant = ("[가-힣]$".toRegex().containsMatchIn(value) && (value.trim().last().code - 0xac00) % 28 > 0)
                || ("[가-힣]\\d*[013678]$".toRegex().containsMatchIn(value)
                || "[a-z]\\d*[1789]$".toRegex(RegexOption.IGNORE_CASE).containsMatchIn(value))
                || (value.trim().length != 1 && "([clmnp]|[blnt](e)|[co](k)|[aeiou](t)|mb|ng|lert)$".toRegex(RegexOption.IGNORE_CASE)
            .containsMatchIn(value))
                || (value.trim().length == 1 && "[lnmr]$".toRegex(RegexOption.IGNORE_CASE).matches(value))
                || ("[\\d]+$".toRegex().matches(value) && "[013678]$".toRegex().containsMatchIn(value))

        return if (hasConsonant) first else second
    }

    fun getAttached(input: String, format: String, alternative: String? = null) =
        input + get(input, format, alternative)

    fun String.josa(format: String, alternative: String? = null) = getAttached(this, format, alternative)

    val String.을를: String
        get() = getAttached(this, "을/를")

    val String.은는: String
        get() = getAttached(this, "은/는")

    val String.이가: String
        get() = getAttached(this, "이/가")

    val String.와과: String
        get() = getAttached(this, "과/와")

    val String.로으로: String
        get() = getAttached(this, "으로/로")

    val String.나이나: String
        get() = getAttached(this, "이나/나")

    val String.아야: String
        get() = getAttached(this, "아/야")

    val String.라이라: String
        get() = getAttached(this, "이라/라")

    val String.야이야: String
        get() = getAttached(this, "야/이야")

    class MalformedFormatException : Exception("Malformed format for Josa.")
}
