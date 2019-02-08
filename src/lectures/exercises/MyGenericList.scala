package lectures.exercises

/**
  * Generic List of type "Covariant"
  *
  * To remember:
  *
  *  Variance: if B extends A, should List[B] extends List[A]?
  *
  *  trait List[+A]   yes (covariant)
  *  trait List[A]    no (invariant)
  *  trait List[-A]   hell no! (contravariant)
  *
  * To implement:
  * head = first element of the list
  * tail = remainder of the list
  * isEmpty = is the list empty
  * add(int) => new List with the element added
  * toString => a String representation of the list
  */
abstract class MyGenericList[+A] {
  def head(): A
  def tail(): MyGenericList[A]
  def isEmpty(): Boolean
  def add[B >: A](element: B): MyGenericList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object GenericEmpty extends MyGenericList[Nothing] {
  def head(): Nothing = throw new NoSuchMethodException
  def tail(): MyGenericList[Nothing] = throw new NoSuchMethodException
  def isEmpty(): Boolean = true
  def add[B >: Nothing](element: B): MyGenericList[B] = new GenericCons(element, GenericEmpty)
  def printElements: String = ""
}

class GenericCons[+A](h:A, t:MyGenericList[A]) extends MyGenericList[A] {
  def head(): A = h
  def tail(): MyGenericList[A] = t
  def isEmpty(): Boolean = false
  def add[B >: A](element: B): MyGenericList[B] = new GenericCons(element, this)
  def printElements: String = {
    if(t.isEmpty()) "" + h
    else h + ", " + t.printElements
  }
}

object ListGenericTest extends App {

  val listOfIntegers: MyGenericList[Int] = new GenericCons(1, new GenericCons(2, new GenericCons(3, GenericEmpty)))
  println(listOfIntegers)
  val listOfStrings: MyGenericList[String] = new GenericCons("Carlos", new GenericCons("Maria", new GenericCons("Katy", GenericEmpty)))
  println(listOfStrings)

  class Animal
  class Cat extends Animal{
    override def toString: String = "Miau!"
  }

  val listOfCats: MyGenericList[Animal] = GenericEmpty
  listOfCats.add(new Cat)
  println(listOfCats.toString)


}