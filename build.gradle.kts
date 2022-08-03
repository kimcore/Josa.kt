plugins {
    `maven-publish`
    kotlin("jvm") version "1.7.10"
}

group = "com.github.kimcore"
version = "1.7"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.9.0")
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

publishing {
    publications {
        create<MavenPublication>("Josa.kt") {
            from(components["java"])

            group = project.group
            version = project.version as String
            artifactId = project.name
            artifact(sourcesJar)
        }
    }
}