plugins {
    java
    id("application")
    kotlin("jvm") version "1.8.0"
    id("org.javamodularity.moduleplugin") version "1.8.+"
    id("org.openjfx.javafxplugin") version "0.1.+"
    id("org.beryx.jlink") version "3.1.+"
}

group = "si.uni-lj.fri"
version = "1.0.0"

repositories {
    mavenCentral()
}

val junitVersion = "5.12.+"
val sourceCompatibility = "21"
val targetCompatibility = "21"

tasks.compileJava {
    options.encoding = Charsets.UTF_8.name()
}

application {
    mainModule = "si.unilj.fri.uporabniskivmesniki"
    mainClass = "si.unilj.fri.uporabniskivmesniki.HelloApplication"
}

javafx {
    version = "21"
    modules = listOf("javafx.controls", "javafx.fxml")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
}

tasks.test {
    useJUnitPlatform()
}

jlink {
    imageZip.set(File("${layout.buildDirectory}/distributions/app-${javafx.platform.classifier}.zip"))
    addOptions("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages")
    launcher {
        name = "app"
    }
}