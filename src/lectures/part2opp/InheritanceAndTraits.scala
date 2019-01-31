package lectures.part2opp

object InheritanceAndTraits extends App {

  class Animal {
    val creatureType = "Animal"

    def eat = println("mommon")

    protected def crunch = println("crunch crunch")
  }

  class Cat extends Animal

  val cat = new Cat
  cat.eat

  class Dog extends Animal {
    def crunchAndEat: Unit = {
      crunch
      eat
    }
  }

  val dog = new Dog
  dog.crunchAndEat

  // constructor
  class Person(name: String, age: Int)

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  var adult = new Adult("Carlos", 39, "123456")
  println(adult)

  // overriding
  class Horse extends Animal {
    //override val creatureType: String = "Caballo"
    override def eat: Unit = println("nyam naym")
  }

  val horse = new Horse
  horse.eat

  println(horse.creatureType)

  // type substitution (polymorphism)
  var unknownAnimal: Animal = new Dog
  unknownAnimal.eat

  // overRIDING vs overLOADING

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = only class in same file can extend -> sealed class Animal

}
