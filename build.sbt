import CoffeelandProject._

lazy val core = libProject("core")
  .settings(version := "0.0.1")
  .settings(libraryDependencies ++= Seq(Dependencies.cats))

lazy val fiveElephant = playProject("five-elephant")
  .settings(version := "0.0.1")

lazy val theBarn = playProject("the-barn")
  .settings(version := "0.0.1")

lazy val starbucks = playProject("starbucks")
  .settings(version := "0.0.1")

lazy val root = project.in(file(".")).aggregate(core, fiveElephant, theBarn, starbucks)
