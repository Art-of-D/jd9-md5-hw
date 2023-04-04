plugins {
    id("java")
}

group = "org.main"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    // https://mvnrepository.com/artifact/com.h2database/h2
    implementation("com.h2database:h2:2.1.214")
    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.10.1")
    implementation(files("/Users/art_of_d/Java/jd9-md5-hw/src/main/resources/sql"));
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<Wrapper> {
    gradleVersion = "7.4.0"
    distributionType = Wrapper.DistributionType.BIN
}


tasks {
    withType<Jar> {
        manifest {
            attributes["Main-Class"] = "org.main.Main"
            archiveFileName.set("jd9-md5-hw.jar")
        }
        // here zip stuff found in runtimeClasspath:
        from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    }
}