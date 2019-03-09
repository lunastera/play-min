val commonSettings = Def.settings(
  scalaVersion := "2.12.8"
)

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    commonSettings,
    name := "sample-app",
    version := "1.0-SNAPSHOT",
    organization := "com.github.sobreera",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.0" % Test
    )
  )
