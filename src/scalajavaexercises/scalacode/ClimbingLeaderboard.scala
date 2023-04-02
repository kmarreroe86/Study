package exercises.scalacode

import scala.Array.ofDim
import scala.annotation.tailrec
// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=7-day-campaign


object ClimbingLeaderboard {

  def main(args: Array[String]): Unit = {

        val resp = climbingLeaderboard(Array(100, 100, 50, 40, 40, 20, 10), Array(5, 25, 50, 120))
//    val resp = climbingLeaderboard(Array(100, 90, 90, 80), Array(70, 80, 105))
    resp.foreach(x => println(x))

//    println("Removing duplicates")
//    val k = Array(100, 100, 50, 40, 40, 20, 10)
//    k.distinct.foreach(n => println(n))
  }

  def climbingLeaderboard(ranked: Array[Int], player: Array[Int]): Array[Int] = {

    val cleanRank = ranked.distinct

    @tailrec
    def findPlayRank(playIndex: Int, rankedIndex: Int, acc: Array[Int]): Array[Int] = {
      if (playIndex == player.length) acc
      else if (rankedIndex == -1){
        acc(playIndex) = 1
        findPlayRank(playIndex + 1, rankedIndex, acc)
      }
      else if (cleanRank(rankedIndex) <= player(playIndex)) findPlayRank(playIndex, rankedIndex - 1, acc)
      else {
        acc(playIndex) = rankedIndex + 2
        findPlayRank(playIndex + 1, rankedIndex, acc)
      }
    }

    val playerRanks = findPlayRank(0, cleanRank.length - 1, ofDim[Int](player.length))
    playerRanks
  }


}
