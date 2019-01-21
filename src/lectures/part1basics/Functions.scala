package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  def aFunction(a: String, b: String): String = {
    a + " " + b
  }

  println(aFunction("Hello", "World"))

  def repeatAndConcatenate(value: String, times: Int): String = {
    if (times == 1) value
    else value + repeatAndConcatenate(value + "", times - 1)
  }

  println(repeatAndConcatenate("Hello", 10))

  // 1. Greeting function
  def greeting(name: String, year: Int): String = {
    "Hello, my name is " + name + " and I am " + year + " years old."
  }

  println(greeting("Carlos", 39))

  // 2. factorial function
  def factorial(number: Int): Int = {
    if (number == 1)
      number
    else
      number * factorial(number - 1)
  }

  println("Factorial: " + factorial(5))

  // 3. Fibonacci
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  // 1 1 2 3 5 8 13 21 ...
  println("Fibonacci: " + fibonacci(8))

  // 4. Tests if a number is a prime
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }

  println("isPrime 2: " + isPrime(2))
  println("isPrime 3: " + isPrime(3))
  println("isPrime 4: " + isPrime(4))
  println("isPrime 5: " + isPrime(5))
  println("isPrime 6: " + isPrime(6))

  // 5. Smart factorial
  def smartFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator)
    }

    factorialHelper(n, 1)
  }

  println("smartFactorial " + smartFactorial(120))

  /** SMART ALGORITHM ***/

  // 1. Concatenate a String n times
  @tailrec
  def smartConcatenation(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else smartConcatenation(aString, n - 1, aString + accumulator)
  }

  println(smartConcatenation("Hello", 10, ""))


  // 2. IsPrime function tail recursive
  def smartIsPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeUntil(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeUntil(n / 2, true)
  }

  println("smartIsPrime 2: " + smartIsPrime(2))
  println("smartIsPrime 3: " + smartIsPrime(3))
  println("smartIsPrime 4: " + smartIsPrime(4))
  println("smartIsPrime 5: " + smartIsPrime(5))
  println("smartIsPrime 6: " + smartIsPrime(6))

  // 3. Fibonacci function, tail recursive
  def smartFibonacci(n: Int): Int = {
    @tailrec
    def fibonacciTailrec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fibonacciTailrec(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else fibonacciTailrec(2, 1, 1)
  }

  // 1 1 2 3 5 8 13 21 ...
  println("smartFibonacci: " + smartFibonacci(8))
}
