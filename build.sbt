lazy val root = (project in file(".")).
  settings(
    name := "jackson-msgpack",
    version := "1.0",
    scalaVersion := "2.12.1"
  )


libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.8"
libraryDependencies += "org.msgpack" % "msgpack-core" % "0.8.17" from "file://./libs/msgpack-core-0.8.17-SNAPSHOT.jar"
libraryDependencies += "org.msgpack" % "jackson-dataformat-msgpack" % "0.8.17" from "file://./libs/jackson-dataformat-msgpack-0.8.17-SNAPSHOT.jar"

