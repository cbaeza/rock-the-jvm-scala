package lectures.part1basics

object Expressions extends App{

  var func = {
    "hola"
  }
  println(func) // "hola"

  val someValue = {
    2 < 3
  }

  println(someValue) // true

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  println(someOtherValue) // 42
}
