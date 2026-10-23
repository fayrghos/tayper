plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("uk.co.electronstudio.jaylib:jaylib:6.2.+")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

sourceSets {
    getByName("main") {
        java.setSrcDirs(listOf("src"))
        resources.setSrcDirs(listOf("assets"))
    }
}

application {
    mainClass = "Main"
}
