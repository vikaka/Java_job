resolvers in ThisBuild ++= Seq("Apache Development Snapshot Repository" at "https://repository.apache.org/content/repositories/snapshots/",
  Resolver.mavenLocal)

name := "Flink Project"

version := "0.1-SNAPSHOT"

organization := "org.example"

scalaVersion in ThisBuild := "2.11.7"

fork in run := true

val flinkVersion = "1.3.0"

val flinkDependencies = Seq(
  "org.apache.flink" %% "flink-scala" % flinkVersion % "provided",
  "org.apache.flink" %% "flink-streaming-scala" % flinkVersion % "provided",
  "org.apache.flink" %% "flink-connector-kafka-0.10" % flinkVersion,
  "org.apache.flink" %% "flink-connector-cassandra" % flinkVersion,
  "org.apache.flink" %% "flink-table" % flinkVersion,
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc41")

lazy val root = (project in file(".")).
  settings(
    libraryDependencies ++= flinkDependencies
  )

mainClass in Compile := Some("org.example.Job")

// make run command include the provided dependencies
run in Compile <<= Defaults.runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run))

// exclude Scala library from assembly
// assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
