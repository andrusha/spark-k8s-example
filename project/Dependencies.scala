import sbt._

object Dependencies {
  val sparkVersion = "2.3.0"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"

  lazy val spark = Seq(
    "org.apache.spark" %% "spark-kubernetes",
    "org.apache.spark" %% "spark-streaming",
    "org.apache.spark" %% "spark-sql"
  ).map(_ % sparkVersion % "provided") ++ Seq(
    "org.apache.spark" %% "spark-sql-kafka-0-10",
    "org.apache.spark" %% "spark-streaming-kafka-0-10"
  ).map(_ % sparkVersion)
}
