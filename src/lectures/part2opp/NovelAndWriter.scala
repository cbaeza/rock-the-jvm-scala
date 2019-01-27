package lectures.part2opp

object NovelAndWriter extends App {

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Spirit's house", 1861, author)

  println(novel.authorAge())
  println(novel.isWriterBy(author))
  println(novel.isWriterBy(imposter))

  val counter = new Counter()
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print

  counter.dec.print
  counter.dec.dec.dec.print
  counter.dec(10).print
}

class Writer(firstName: String, surname: String, val year: Int) {
  def fulName(): String = firstName + " " + surname

  def copy(): Writer = new Writer(firstName, surname, year)
}

class Novel(name: String, year: Int, author: Writer) {

  def authorAge(): Int = author.year

  def isWriterBy(author: Writer): Boolean = this.author == author

  def copy(yearOfRelease: Int): Novel = new Novel(name, yearOfRelease, author)
}

class Counter(val count: Int = 0) {
  def inc = {
    println(s"Incrementing... $count")
    new Counter(count + 1) // immutable
  }

  def dec = {
    println(s"decrementing... $count")
    new Counter(count - 1) // immutable
  }

  def inc(x: Int): Counter = {
    if (x <= 0) this
    else inc.inc(x - 1)
  }

  def dec(x: Int): Counter = {
    if (x <= 0) this
    else dec.dec(x - 1)
  }

  def print = println(count)

}
