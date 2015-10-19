name := "multi-sbt-project"

val commonSettings = Seq(
  organization := "net.example",
  version := "0.1",
  scalaVersion := "2.11.7",
  scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8"),
  libraryDependencies := Seq(
    "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
    "org.scala-lang" % "scala-library" % "2.11.7"
  )
)

lazy val common = project.in(file("common"))
  .settings(commonSettings:_*)

lazy val mainApp = project.in(file("mainApp"))
  .settings(commonSettings:_*)
  .dependsOn(common % "compile->compile;test->test")

lazy val main = project.in(file("."))
  .aggregate(common, mainApp)
