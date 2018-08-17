import play.sbt._
import sbt.Keys._
import sbt._

object CoffeelandProject {

  def subProject(name: String): Project =
    Project(id = s"c-$name", base = file(name))
      .settings(
          organization := "com.coffeeland",
          scalaVersion := "2.11.12",
          resolvers := Resolvers.all,
          scalacOptions ++= Seq("-Xmax-classfile-name", "200", "-deprecation")
      )

  def playProject(name: String): Project =
    subProject(name)
      .enablePlugins(PlayScala)

  def libProject(name: String): Project =
    subProject(name)
}
