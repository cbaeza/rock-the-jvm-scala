package lectures.part1basics

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

}
