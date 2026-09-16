plugins {
    kotlin("jvm") version "2.4.10"
    kotlin("plugin.serialization") version "2.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.ktor:ktor-server-core-jvm:3.3.1")
    implementation("io.ktor:ktor-server-netty-jvm:3.3.1")
    implementation("io.ktor:ktor-server-content-negotiation:3.3.1")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.3.1")
    implementation(
        "org.postgresql:postgresql:42.7.4"
    )


    implementation(
        "org.jetbrains.exposed:exposed-core:0.53.0"
    )

    implementation(
        "org.jetbrains.exposed:exposed-jdbc:0.53.0"
    )
}

kotlin {
    jvmToolchain(26)
}

tasks.test {
    useJUnitPlatform()
}