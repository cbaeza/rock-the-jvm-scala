package lectures.part2opp

/**
  * Scala application == Scala object with:
  * def main(args: Array[String]):Unit
  */
object Objects extends App {

  // static instance
  // Scala does not have class level functionality "static"
  object Person {
    // static class - level functionality
    var N_EYES = 2

    def canFly(): Boolean = false
  }

  // regular instance
  class Person {
    // instance-level functionality
  }

  // here object Person and class Person are called COMPANIONS design pattern because both coexist in the same scope
  println(Person.N_EYES)
  println(Person.canFly())

  // Scala object == singleton instances
  val mary = Person
  val john = Person

  println(mary == john) // are equal because they reference point to static instance
  println(mary.equals(john)) // are equal because they reference point to static instance

  val carlos = new Person
  val maria = new Person

  println(carlos == maria) // are NOT equal because they reference point to a regular instance
  println(carlos.equals(maria)) // are NOT equal because they reference point to a regular instance


}
