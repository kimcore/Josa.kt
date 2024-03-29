# Josa.kt
[![image](https://img.shields.io/jitpack/v/github/kimcore/Josa.kt?style=flat-square)](https://github.com/kimcore/Josa.kt/releases)
[![image](https://img.shields.io/github/license/kimcore/Josa.kt?style=flat-square)](https://github.com/kimcore/Josa.kt/blob/master/LICENSE)

> 조사를 자동으로 교정하는 Kotlin 라이브러리입니다. Java 프로젝트에서도 사용할 수 있습니다.

## 설치
```gradle
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.kimcore", "Josa.kt", "1.7")
}
```
## 사용법
Josa.kt는 3가지 방법으로 사용할 수 있습니다.
#### Extensions 사용
```kotlin
import com.github.kimcore.josa.Josa.나이나
import com.github.kimcore.josa.Josa.로으로
import com.github.kimcore.josa.Josa.아야
import com.github.kimcore.josa.Josa.와과
import com.github.kimcore.josa.Josa.은는
import com.github.kimcore.josa.Josa.을를
import com.github.kimcore.josa.Josa.이가
import com.github.kimcore.josa.Josa.라이라
import com.github.kimcore.josa.Josa.야이야

println("샌즈".은는) // 샌즈는

println("난 ${"준식".야이야}!") // 난 준식이야!
```
#### String.josa 사용
```kotlin
import com.github.kimcore.josa.Josa.josa

println("샌즈".josa("은/는")) // 샌즈는

println("준식".josa("아/야")) // 준식아
```
#### Josa 클래스의 함수 직접 사용
```kotlin
import com.github.kimcore.josa.Josa

println(Josa.getAttached("샌즈", "은/는")) // 샌즈는

println(Josa.getAttached("준식", "아/야")) // 준식아

println(Josa.get("준식", "은/는")) // 은
```
## 지원되는 포맷
* 나/이나
* 로/으로
* 아/야
* 와/과
* 은/는
* 을/를
* 이/가
* 라/이라
* 야/이야

## 커스텀 포맷
기본으로 지원하는 포맷 외에도, 사용자가 직접 지정한 포맷을 사용할 수 있습니다.
`을/를`같이 적용할 조사를 `/`로 구분하여 받침이 있는 경우를 앞에, 받침이 없는 경우를 뒤에 입력하시면 됩니다.
```kotlin
import com.github.kimcore.josa.Josa.josa

println("2".josa("이었/였") + "습니다!") // 2였습니다!
println("3".josa("이었/였") + "습니다!") // 3이었습니다!
```
#### 잘못된 포맷을 입력할 경우
 ```kotlin
import com.github.kimcore.josa.Josa
import com.github.kimcore.josa.Josa.josa
try {
    println("샌즈".josa("잘못된 포맷"))
} catch(e: Josa.MalformedFormatException) {
    println("잘못된 포맷입니다!")
}
 ```
## 라이선스
Josa.kt 라이브러리는 MIT 라이선스를 따르고 있습니다. 자세한 내용은 [LICENSE](https://github.com/JackCme/inko.py/blob/master/LICENSE) 파일을 참고해주세요.
## 감사한 분들
* [hangul.josa.js](https://github.com/naradesign/hangul.josa.js) 를 개발해주신 [naradesign](https://github.com/naradesign) 님께 감사드립니다! 개발하며 많은 도움이 되었습니다.
