plugins { 
kotlin("jvm") version     "1.9.23" 
application
}
group = "org.example"
version = "1.0-SNAPSHOT"

repositories { mavenCentral()
}

dependencies { 
    testImplementation(kotlin("test"))
}

tasks.test { useJUnitPlatform()
}

kotlin { jvmToolchain(21)
}

application { 
    mainClass.set("edu.ukma.ExceptionsKt")
}

