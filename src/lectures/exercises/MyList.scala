package lectures.exercises

/**
  * head = first element of the list
  * tail = remainder of the list
  * isEmpty = is the list empty
  * add(int) => new List with the element added
  * toString => a String representation of the list
  */
abstract class MyList {
  def head(): Int
  def tail(): MyList
  def isEmpty(): Boolean
  def add(element: Int): MyList
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  def head(): Int = throw new NoSuchMethodException
  def tail(): MyList = throw new NoSuchMethodException
  def isEmpty(): Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)
  override def printElements: String = ""
}

class Cons(h:Int, t:MyList) extends MyList {
  def head(): Int = h
  def tail(): MyList = t
  def isEmpty(): Boolean = false
  def add(element: Int): MyList = new Cons(element, this)
  override def printElements: String = {
    if(t.isEmpty()) "" + h
    else h + ", " + t.printElements
  }
}

object ListTest extends App {

  val myList = new Cons(1, Empty)
  println(myList.head())

  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println("list head: " + list.head())
  println("list tail head: " + list.tail().head())
  println("list add: " + list.add(100))
  println("list toString: " + list.toString)
}