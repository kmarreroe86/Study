package exercises.scalacode

import scala.annotation.tailrec

object StrangeCounter {

  def main(args: Array[String]): Unit = {
    println(s"strangeCounter(4) = ${strangeCounter(4)}")
    println(s"strangeCounter(5) = ${strangeCounter(5)}")
    println(s"strangeCounter(3) = ${strangeCounter(3)}")
  }


  def strangeCounter(t: Long): Long = {
    @tailrec
    def helper(t1: Long, currentInterval: Long):  Long = {
      val tmp = t1 - currentInterval
      if(tmp <= 0) {
        currentInterval - t1 + 1
      } else {
        helper(tmp, currentInterval * 2)
      }
    }
    helper(t, 3)
  }
}
