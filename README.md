# Josa.kt
[![image](https://img.shields.io/jitpack/v/github/kimcore/inko.kt?style=flat-square)](https://github.com/kimcore/inko.kt/releases)
[![image](https://img.shields.io/github/license/kimcore/inko.kt?style=flat-square)](https://github.com/kimcore/inko.kt/blob/master/LICENSE)

> 조사를 자동으로 교정하는 Kotlin 라이브러리입니다.

## 설치
Gradle
```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.kimcore:Josa.kt:1.0'
}
```
Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.kimcore</groupId>
        <artifactId>Josa.kt</artifactId>
        <version>1.0</version>
    </dependency>
</dependencies>
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

println("샌즈".은는) // 샌즈는

println("준식".아야) // 준식아
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
## 라이선스
Josa.kt 라이브러리는 MIT 라이선스를 따르고 있습니다. 자세한 내용은 [LICENSE](https://github.com/JackCme/inko.py/blob/master/LICENSE) 파일을 참고해주세요.
## 감사한 분들
* [hangul.josa.js](https://github.com/naradesign/hangul.josa.js) 를 개발해주신 [naradesign](https://github.com/naradesign) 님께 감사드립니다! 개발하며 많은 도움이 되었습니다.