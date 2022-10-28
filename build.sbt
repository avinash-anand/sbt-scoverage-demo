import sbt.Keys._
import sbt.ClassLoaderLayeringStrategy.Flat

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "sbt-scoverage-demo"
  )
  .settings(scoverageSettings: _*)
  .settings(resolverSettings: _*)
  .settings(inThisBuild(useSuperShell := false))
  .settings(test / classLoaderLayeringStrategy := Flat)

lazy val scoverageSettings = Seq(
  coverageHighlighting := true,
  Test / coverageEnabled := true,
  coverageMinimumStmtTotal := 97,
  coverageMinimumBranchTotal := 95,
  coverageFailOnMinimum := false
)
lazy val resolverSettings = Seq(
  resolvers ++= Seq(
    "Artifactory Realm" at "https://maven.deere.com",
    "deere-sbt" at "https://sbt.deere.com",
    "DynamoDB Local Release Repository" at "https://s3-us-west-2.amazonaws.com/dynamodb-local/release"
  )
)
