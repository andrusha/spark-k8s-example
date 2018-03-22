import Dependencies._

lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging, sbtdocker.DockerPlugin, AshScriptPlugin)
  .settings(
    inThisBuild(List(
      organization := "me.andrusha",
      scalaVersion := "2.11.12",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Spark K8S Example",
    scalacOptions ++= Seq("-deprecation", "-unchecked"),
    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= spark,
  )

dockerfile in docker := {
  val targetDir = stage.value
  val containerDir = "/app"

  new Dockerfile {
    from("andrusha/spark-k8s:2.3.0-hadoop2.7")
    entryPoint(s"$containerDir/bin/${executableScriptName.value}")
    copy(targetDir, containerDir)
  }
}