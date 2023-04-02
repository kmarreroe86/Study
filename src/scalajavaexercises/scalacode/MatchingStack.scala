package exercises.scalacode

import scala.annotation.tailrec
import scala.collection.mutable.Stack

object MatchingStack extends App {


  val str = "[({})]"
  val charStack = Stack[Char]()

  def isBalanced(values: String): Boolean = {

    val balanceMap = Map(
      ')' -> '(',
      '}' -> '{',
      ']' -> '['
    )
    val closedBraces = balanceMap.keys.toSeq
    val openBraces = balanceMap.values.toSeq

    @tailrec
    def isBalancedRec(parsed: Seq[Char], input: Seq[Char]): Boolean = {
      if (input.isEmpty) {
        if (parsed.isEmpty) {
          true
        } else {
          false
        }
      } else {
        input.head match {
          case in if openBraces.contains(in) =>
            isBalancedRec(in +: parsed, input.tail)
          case in if closedBraces.contains(in) =>
            if (parsed.isEmpty) {
              false
            } else if (parsed.head == balanceMap(in)) {
              isBalancedRec(parsed.tail, input.tail)
            } else {
              false
            }
          case _ => false
        }
      }
    }
    isBalancedRec(Nil, values.toCharArray)
  }

}
