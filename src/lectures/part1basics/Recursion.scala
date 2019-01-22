package lectures.part1basics

object Recursion extends App {

  def factorial(n: Int): BigInt = {
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      println("X: " + x + ", Accumulator: " + accumulator)
      if (x <= 1) accumulator
      else
        factorialHelper(x - 1, x * accumulator)
    }
    factorialHelper(n, 1)
  }

  println(factorial(10))

}
