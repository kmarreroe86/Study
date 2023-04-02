package exercises.scalacode

import scala.Array.ofDim
import scala.annotation.tailrec

// https://www.hackerrank.com/challenges/circular-array-rotation/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

object CircularArrayRotation extends App {


  def circularArrayRotation(a: Array[Int], k: Int, queries: Array[Int]): Array[Int] = {

    @tailrec
    def circularRotationHelper(currentQueryIndex:Int, acc: Array[Int]): Array[Int] = {
      if(currentQueryIndex == queries.length) acc
      else{
        acc(currentQueryIndex) =  a(
          (a.length + ((queries(currentQueryIndex) - k) % a.length)) % a.length
        )
        circularRotationHelper(currentQueryIndex + 1, acc)
      }
    }
    circularRotationHelper(0, ofDim[Int](queries.length))
  }

  val result = circularArrayRotation(Array(1,2,3), 2, Array(0, 1, 2))
  result.foreach(el => println(el))
}
