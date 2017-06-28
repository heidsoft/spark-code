/**
  * Created by heidsoft on 2017/6/9.
  */
object SimpleApp{
  def main(args: Array[String]): Unit = {
    val logFile = "/usr/local/spark-2.1.1-bin-hadoop2.7/README.md"
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile,2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a:%s, Lines with b :%s ".format(numAs,numBs))
  }
}