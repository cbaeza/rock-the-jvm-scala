package lectures.part2opp

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String = "vertebrado"

    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = println("Crunch crunch ")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait CoolBlooded

  class Cocodrile extends Animal with Carnivore with CoolBlooded {
    override def eat: Unit = println("I am cocodrile and I am eating Canine")

    override def eat(animal: Animal): Unit = println(animal.eat)
  }

  val cocodrile = new Cocodrile
  cocodrile.eat

  // trait vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class -> Cocodrile
  // 3 - traits = behavior, abstract class = "things"
}
