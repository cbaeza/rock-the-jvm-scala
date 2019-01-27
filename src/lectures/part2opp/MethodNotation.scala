package lectures.part2opp

object MethodNotation extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def apply(): String = s"Hi may name is $name and I like $favoriteMovie"

    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(nickname: String): Person = new Person(this.name + "(" + nickname + ")", this.favoriteMovie)

    def +(): Person = new Person(this.name, this.favoriteMovie, age + 1)

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def learns(thing: String): String = s"$name is learning $thing"

    def learnsScala: String = this learns "Scala"
  }

  var mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar)

  // "operators" in scala
  var tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)

  // apply
  println(mary.apply())
  println(mary())

  println("-------------------------------")
  println(mary + "the rockstar" apply)
  println(mary.+("the rockstar").apply())

  var person2 = new Person("Charles", "The exorcist", 39)
  println(person2.+().apply())
  println(+person2.age)

  println(person2.learns("Scala"))

  println(person2.learnsScala)

  println(person2.apply(10))
  println(person2(10))
}
