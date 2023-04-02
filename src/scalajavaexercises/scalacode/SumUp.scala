package exercises.scalacode

object SumUp extends App {

  /*
    * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
        For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
    */

  def sumUp(numbers: Array[Int], number: Int, checkedNumbers: Set[Int], arrayPos: Int = 0): Boolean = {
    if (checkedNumbers.contains(number - numbers(arrayPos))) true
    else if (arrayPos == numbers.length - 1) false
    else
      sumUp(numbers, number, checkedNumbers + numbers(arrayPos), arrayPos + 1)
  }

  println(s"sumUp() = ${sumUp(Array(10, 15, 3, 7), 10, Set.empty, 0)}")


}
