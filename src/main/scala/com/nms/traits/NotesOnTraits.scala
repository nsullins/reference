package com.nms.traits

/**
 * User: nsullins
 * Date: 1/13/11
 * Time: 4:35 PM
 */

class NotesOnTraits{

	//1) You might philosophize that traits are like Java interfaces with concrete methods but they can actually do much more
	//2) Traits can declare fields and maintain state. One can do anything with a trait that one can with a class with only two exceptions
	//		a) Traits cannot have any class parameters i.e. parameters passed to the primary constructor
	//		b) Secondly in classes super method calls are statically bound. In traits they're dynamically bound. This curious behavior allows for
	//		   stackable modifications
	//3) Traits allowing concrete classes infers the use of rich-interfaces versus thin interfaces. Thin means fewer methods and rich means more
	//methods. However in Java rich interfaces implies lots of coding to implement all of the methods whereas in Scala the interfaces can have the
	//concrete methods.
	//4) One key differene between traits and mulitple inheritance is the interpretation of super(). With multiple inheritance the method called
	//by a super call can be determined right where the call appears. With traits the super calls are determined by a process called linearization
	//5) Linearization - when you instantiate a class with new, Scala takes the class and all of its inherited classes and traits and puts them
	//in a single linear order. Then whenever you call super inside one of those classes the invoked method is the next on up the chain. If all of
	//the methods but the last call super the net result is stackable behavior. The crux of linearization is that a class is always linearized
	//before ALL of its superclasses and mixed in traits. Below is a diagram illustrating this linearization
	//6) The order of mixins is significant.Generally speaking the trait to the further right is called first and then to the left and so on.
	//7) When a class calls super the method calling super modifies the behaviour of the superclasses and not the other way around


	/* To Trait or not to Trait - Important guidelines to consider when deciding to use a trait or not
	 *
	 * 	1) If the behavior will not be reused then make it a concrete class
	 *  2) If it might be reused in multiple, unrelated classes make it a trait
	 *  3) If you want to inherit from it in Java code use an abstract class because it tends to be awkward to inherit from a trait in Java class
	 *  4) If you plan to distribute it in compiled form and expect outside groups to write classes inheriting from it you might lean towards using
	 *  an abstract class. The issue is that when a trait gains or leses a memeber any classes that inherit from it must be recompiled even if they
	 *  are not changed. If our clients will only call into a behavior instead of inheriting from it then a trait is fine
	 *  5) If efficiency is very important lean towards using classes. Runtimes make a virtual method invocation on a class a faster operation than
	 *  an interface method invocation. Ensure that this runtime optimization is the bottleneck and that using a class solves the problem before
	 *  avoiding traits
	 *  6) If you still don't know use a trait, you can always change it later
	 *
	 */


	/* Notes on design with regard to Traits   ---very IMPORTANT!!!!!!
	 *
	 * Traits do not merely support the idioms described above, they are a fundamental unit of code that is reusable through inheritance. Because
	 * of this many experienced Scala programmers start with traits when they are at the eraly stages of implementation. Each trait can hold less that an
	 * entire concept. As the design solidifies the fragments can be combined into more complete concepts through trait mixin
	 *
	 *
	 *
	 *
	 */






	/*Given the following classes and traits
	 *
	 * 	class Animal
	 *  trait Furry extends Animal
	 *  trait HasLegs extends Animal
	 *  trait FourLegged extends HasLegs
	 *  class Cat extends Animal with Furry with FourLegged
	 *
	 *  Thus the component linearizations
	 *
	 *  Animal ==> Animal => AnyRef => Any
	 *
	 *  Furry ==> Furry => Animal => AnyRef => Any
	 *
	 *  FourLegged ==> FourLegged => HasLegs => Animal => AnyRef => Any
	 *
	 *  Cat ==> FourLegged => HasLegs => Furry => Animal => AnyRef => Any
	 *
	 *  Thus when any of these classes and traits invokes a method via super the implementation invoked will the first implementation on the right
	 *
	 *
	 */

}