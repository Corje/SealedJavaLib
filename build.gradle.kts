plugins {
    java
    `maven-publish`
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<JavaCompile>() {
    options.compilerArgs.plusAssign("--enable-preview")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "alex.danilov.sealed"
            artifactId = "library"
            version = "1.1"

            from(components["java"])
        }
    }
}