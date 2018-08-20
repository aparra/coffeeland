import CoffeelandProject._

lazy val core = libProject("core")
  .settings(version := "0.0.1")

lazy val fiveElephant = playProject("five-elephant")
  .settings(version := "0.0.1")
  .dependsOn(core)
  .settings(libraryDependencies += guice)

lazy val theBarn = playProject("the-barn")
  .settings(version := "0.0.1")
  .dependsOn(core)
  .settings(libraryDependencies += guice)

lazy val starbucks = playProject("starbucks")
  .settings(version := "0.0.1")
  .dependsOn(core)
  .settings(libraryDependencies += guice)

lazy val root = project.in(file(".")).aggregate(core, fiveElephant, theBarn, starbucks)
