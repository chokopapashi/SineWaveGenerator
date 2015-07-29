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
    version      := "1.1.0",
    scalaVersion := "2.11.6"
)

lazy val root = (project in file(".")).
    settings(commonSettings: _*).
    settings(
        // set the name of the project
        name := "SineWaveGenerator",

        // Reflect of Ver2.10.1-> requires to add libraryDependencies explicitly
//        libraryDependencies <+= scalaVersion { "org.scala-lang" % "scala-reflect" % _ },

        // add Scala Swing dependency
//        libraryDependencies <+= scalaVersion { "org.scala-lang" % "scala-swing" % _ },
        libraryDependencies += "org.scala-lang" % "scala-swing" % "2.11.0-M7",

        // add Akka dependency
//        resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/",
//        libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4-SNAPSHOT",
        libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11",
        libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.3.11",

        // add ScalaTest dependency
        libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.2.4" % "test",

        // add Logback, SLF4j dependencies
        libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3",
        libraryDependencies += "ch.qos.logback" % "logback-core" % "1.1.3",
        libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.12",

        // add HZUtil dependency
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

