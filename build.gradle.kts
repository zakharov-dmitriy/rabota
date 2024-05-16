plugins {
    id("java")
//    id("io.qameta.allure") version "<latest>"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation ("org.junit.jupiter:junit-jupiter-engine:5.10.2")
    testImplementation ("org.junit.jupiter:junit-jupiter-params:5.10.2")
    testImplementation ("org.seleniumhq.selenium:selenium-java:4.20.0")
    testImplementation ("commons-io:commons-io:2.13.0")
    testImplementation ("io.github.bonigarcia:webdrivermanager:5.8.0")
    testImplementation ("com.intuit.karate:karate-core:1.4.1")
    testImplementation ("com.intuit.karate:karate-junit5:1.4.1")
    testImplementation ("net.masterthought:cucumber-reporting:5.7.6")
    testImplementation ("com.intuit.karate:karate-apache:0.9.6")
    testImplementation ("io.qameta.allure:allure-junit5:2.27.0")
    testImplementation ("io.qameta.allure:allure-assertj:2.27.0")
    testImplementation ("io.qameta.allure:allure-rest-assured:2.27.0")
    testImplementation ("io.qameta.allure:allure-java-commons:2.27.0")
    testImplementation ("org.aspectj:aspectjweaver:1.9.22")
}

tasks.test {
    useJUnitPlatform()
    reports.junitXml.required.set(true)
    reports.junitXml.outputLocation.set(file("${buildDir}/allure-results"))
}
