// dummy value definition to set java library path
//val dummy_java_lib_path_setting = {
//    def JLP = "java.library.path"
//    val jlpv = System.getProperty(JLP)
//    if(!jlpv.contains(";lib"))
//        System.setProperty(JLP, jlpv + ";lib")
//}

// factor out common settings into a sequence
lazy val commonSettings = Seq(
    organization := "org.hirosezouen",
<<<<<<< HEAD
    version      := "1.0.0",
=======
    version      := "1.1.0",
>>>>>>> f1d8da381dafbb06be20fc64f0fb1c0580a06676
    scalaVersion := "2.11.6"
)

lazy val root = (project in file(".")).
    settings(commonSettings: _*).
    settings(
        // set the name of the project
        name := "SineWaveGenerator",

        // Reflect of Ver2.10.1-> requires to add libraryDependencies explicitly
<<<<<<< HEAD
        libraryDependencies <+= scalaVersion { "org.scala-lang" % "scala-reflect" % _ },

        // add dependency of ScalaFX
        libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.0-R4",

        // add dependency of Akka
=======
//        libraryDependencies <+= scalaVersion { "org.scala-lang" % "scala-reflect" % _ },

        // add Scala Swing dependency
//        libraryDependencies <+= scalaVersion { "org.scala-lang" % "scala-swing" % _ },
        libraryDependencies += "org.scala-lang" % "scala-swing" % "2.11.0-M7",

        // add Akka dependency
>>>>>>> f1d8da381dafbb06be20fc64f0fb1c0580a06676
//        resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/",
//        libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4-SNAPSHOT",
        libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11",
        libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.3.11",

<<<<<<< HEAD
        // add dependency of ScalaTest
        libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.2.4" % "test",

        // add dependencies of Logback and SLF4j
=======
        // add ScalaTest dependency
        libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.2.4" % "test",

        // add Logback, SLF4j dependencies
>>>>>>> f1d8da381dafbb06be20fc64f0fb1c0580a06676
        libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3",
        libraryDependencies += "ch.qos.logback" % "logback-core" % "1.1.3",
        libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.12",

<<<<<<< HEAD
        // add dependency of HZUtil 
=======
        // add HZUtil dependency
>>>>>>> f1d8da381dafbb06be20fc64f0fb1c0580a06676
        libraryDependencies += "org.hirosezouen" %% "hzutil" % "2.0.0",

        // Avoid sbt warning ([warn] This usage is deprecated and will be removed in sbt 1.0)
        // Current Sbt dose not allow overwrite stabele release created publicLocal task.
        isSnapshot := true,

        // fork new JVM when run and test and use JVM options
//        fork := true,
//        javaOptions += "-Djava.library.path=lib",

        // misc...
        parallelExecution in Test := false,
//        logLevel := Level.Debug,
        scalacOptions += "-deprecation",
        scalacOptions += "-feature",
        scalacOptions += "-Xlint",
        scalacOptions += "-Xfatal-warnings"
    )

