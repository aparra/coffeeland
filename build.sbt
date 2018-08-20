import CoffeelandProject._
import PlayKeys._

lazy val core = libProject("core")
  .settings(version := "0.0.1")

lazy val fiveElephant = playProject("five-elephant")
  .settings(version := "0.0.1")
  .dependsOn(core)
  .settings(libraryDependencies += guice)
  .settings(playDefaultPort := 9001)

lazy val theBarn = playProject("the-barn")
  .settings(version := "0.0.1")
  .dependsOn(core)
  .settings(libraryDependencies += guice)
  .settings(playDefaultPort := 9002)

lazy val starbucks = playProject("starbucks")
  .settings(version := "0.0.1")
  .dependsOn(core)
  .settings(libraryDependencies += guice)
  .settings(playDefaultPort := 9003)

lazy val root = project.in(file(".")).aggregate(core, fiveElephant, theBarn, starbucks)
