package com.github.kimcore.josa

import com.github.kimcore.josa.Josa.나이나
import com.github.kimcore.josa.Josa.로으로
import com.github.kimcore.josa.Josa.아야
import com.github.kimcore.josa.Josa.와과
import com.github.kimcore.josa.Josa.은는
import com.github.kimcore.josa.Josa.을를
import com.github.kimcore.josa.Josa.이가
import org.junit.Test
import org.junit.Assert.*

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
    }
}