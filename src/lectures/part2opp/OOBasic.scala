package lectures.part2opp

object OOBasic extends App {

  val person = new Person("Carlos", 39)
  println(person.age)
  println(person.x)
  person.greet("Juan")
  person.greet()

  var person2 = new Person()
}

// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2

  // multiple constructor
  def this(name: String) = this(name, 0)

  def this() = this("John Doe")

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi I am $name")
}