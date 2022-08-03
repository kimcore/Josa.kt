package com.github.kimcore.josa

import com.github.kimcore.josa.Josa.josa
import com.github.kimcore.josa.Josa.나이나
import com.github.kimcore.josa.Josa.로으로
import com.github.kimcore.josa.Josa.아야
import com.github.kimcore.josa.Josa.와과
import com.github.kimcore.josa.Josa.은는
import com.github.kimcore.josa.Josa.을를
import com.github.kimcore.josa.Josa.이가
import com.github.kimcore.josa.Josa.라이라
import com.github.kimcore.josa.Josa.야이야
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class JosaTest {
    @Test
    fun testJosa() {
        assertEquals("사과를", "사과".을를)
        assertEquals("사과 3을", "사과 3".을를)
        assertEquals("apple 3를", "apple 3".을를)
        assertEquals("apple 을", "apple ".을를)

        assertEquals("사과는", "사과".은는)
        assertEquals("사과 3은", "사과 3".은는)
        assertEquals("apple 3는", "apple 3".은는)
        assertEquals("apple 은", "apple ".은는)

        assertEquals("사과가", "사과".이가)
        assertEquals("사과 3이", "사과 3".이가)
        assertEquals("apple 3가", "apple 3".이가)
        assertEquals("apple 이", "apple ".이가)

        assertEquals("사과와", "사과".와과)
        assertEquals("사과 3과", "사과 3".와과)
        assertEquals("apple 3와", "apple 3".와과)
        assertEquals("apple 과", "apple ".와과)

        assertEquals("사과로", "사과".로으로)
        assertEquals("사과 3으로", "사과 3".로으로)
        assertEquals("apple 3로", "apple 3".로으로)
        assertEquals("apple 으로", "apple ".로으로)

        assertEquals("사과나", "사과".나이나)
        assertEquals("사과 3이나", "사과 3".나이나)
        assertEquals("apple 3나", "apple 3".나이나)
        assertEquals("apple 이나", "apple ".나이나)

        assertEquals("사과야", "사과".아야)
        assertEquals("사과 3아", "사과 3".아야)
        assertEquals("apple 3야", "apple 3".아야)
        assertEquals("apple 아", "apple ".아야)

        assertEquals("사과라", "사과".라이라)
        assertEquals("사과 3이라", "사과 3".라이라)
        assertEquals("apple 3라", "apple 3".라이라)
        assertEquals("apple 이라", "apple ".라이라)

        assertEquals("사과야", "사과".야이야)
        assertEquals("사과 3이야", "사과 3".야이야)
        assertEquals("apple 3야", "apple 3".야이야)
        assertEquals("apple 이야", "apple ".야이야)

        // 숫자 0-12
        assertEquals("0을", "0".을를)
        assertEquals("1을", "1".을를)
        assertEquals("2를", "2".을를)
        assertEquals("3을", "3".을를)
        assertEquals("4를", "4".을를)
        assertEquals("5를", "5".을를)
        assertEquals("6을", "6".을를)
        assertEquals("7을", "7".을를)
        assertEquals("8을", "8".을를)
        assertEquals("9를", "9".을를)
        assertEquals("10을", "10".을를)
        assertEquals("11을", "11".을를)
        assertEquals("12를", "12".을를)

        // 알파벳 a-z
        assertEquals("a를", "a".을를)
        assertEquals("b를", "b".을를)
        assertEquals("c를", "c".을를)
        assertEquals("d를", "d".을를)
        assertEquals("e를", "e".을를)
        assertEquals("f를", "f".을를)
        assertEquals("g를", "g".을를)
        assertEquals("h를", "h".을를)
        assertEquals("i를", "i".을를)
        assertEquals("j를", "j".을를)
        assertEquals("k를", "k".을를)
        assertEquals("l을", "l".을를)
        assertEquals("n을", "n".을를)
        assertEquals("m을", "m".을를)
        assertEquals("o를", "o".을를)
        assertEquals("p를", "p".을를)
        assertEquals("q를", "q".을를)
        assertEquals("r을", "r".을를)
        assertEquals("s를", "s".을를)
        assertEquals("t를", "t".을를)
        assertEquals("u를", "u".을를)
        assertEquals("v를", "v".을를)
        assertEquals("w를", "w".을를)
        assertEquals("x를", "x".을를)
        assertEquals("y를", "y".을를)
        assertEquals("z를", "z".을를)

        // 커스텀 포맷
        assertEquals("2였", "2".josa("이었/였"))
        assertEquals("3이었", "3".josa("이었/였"))
    }
}