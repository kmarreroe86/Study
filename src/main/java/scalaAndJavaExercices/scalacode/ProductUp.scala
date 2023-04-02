package exercises.scalacode


/*
* Given an array of integers, return a new array such that each element at index i of the new array is the product
* of all the numbers in the original array except the one at i.
For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
* If our input was [3, 2, 1], the expected output would be [2, 3, 6]
* */


object ProductUp extends App {

  val numbers = List(10, 15, 3, 7)
//  val numbers = List(1, 2, 3, 4, 5)

  def multipliedArray(idx: Int, list: List[Int]): List[Int] = {


    def totalProduct(elements: List[Int]): Int = elements.product

    def multipliedArrayHelper (idx: Int = 0, list: List[Int], newList: List[Int], product: Int): List[Int] = {
      if (idx == list.length) newList
      else {
        (product / list(idx)) :: multipliedArrayHelper(idx + 1, list, newList, product)
      }
    }

    val product = totalProduct(list)

    multipliedArrayHelper(idx, list, List(), product)
  }

  println(s"multipliedArray() = ${multipliedArray(0, numbers)}")

}
