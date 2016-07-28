val root = Project(id = "upickle-demo", base = file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    version := "0.1-SNAPSHOT",
    scalaVersion := "2.11.8",
    persistLauncher in Compile := true,
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.1",
      "com.lihaoyi" %%% "upickle" % "0.4.1"
    )
  )