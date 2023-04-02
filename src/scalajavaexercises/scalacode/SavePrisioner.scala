package exercises.scalacode

import scala.annotation.tailrec


// https://www.hackerrank.com/challenges/save-the-prisoner/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
object SavePrisoner {

  /*
  * n= number of prisoners
  * m= number of sweets
  * s= chair number to begin
   */
  @tailrec
  def saveThePrisonerHelper(n: Int, m: Int, s: Int): Int = {
    if(m == 0) s
    else {
      val k = s + 1
      if(k > n) saveThePrisonerHelper(n, m - 1, 1)
      else saveThePrisonerHelper(n, m - 1, k)
    }
  }

  def main(args: Array[String]): Unit = {
    println("==== Test ====")
    println(saveThePrisonerHelper(7, 19, 2 - 1))
    println(saveThePrisonerHelper(3, 7, 3 - 1))
    println(saveThePrisonerHelper(5, 2, 1 - 1))
    println(saveThePrisonerHelper(5, 2, 2 - 1))
  }



}
