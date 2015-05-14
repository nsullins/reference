package com.nms.scalaHierarchy

/**
 * User: nsullins
 * Date: 1/11/11
 * Time: 10:09 PM
 */

class Notes{

	//1) At the top of the scala class hierarchy is the class Any
	//2) At the bottomw of the scala hierarchy are the classes Null and Nothing
	//3) Just as Any is a superclass of every class in scala Nothing is a subclass of every class in scala
	//4) Any defines the following methods
	//	a) final def ==(that: Any) => Boolean
	//	b) final def !=(that: Any) => Boolean
	//	c) def equals(that: Any) => Boolean
	//	d) def hashcode: Int
	//	e) def toString: String
	// the final methods call the equals and negation of equals so to modify this behaviour modify the equals method
	//5) The root class Any has two subclasses AnyRef and AnyVal
	//6) AnyVal is a parent class of every built-in value lass in Scala. There are nine such classes: Byte, Short, Int, Char, Long, Float, Double
	// Boolean and Unit. The first eight of these correspond to Java's primitive types and their values are represented at runtime as Java primitives
	// the instances of these classes are written as literals in scala. You cant create instances of these with new because they are abstract and final
	//7) The last value class mentioned above is Unit. Unit corresponds roughly to void in Java. It is used as the result type for a method that
	//does not wish to return an interesting result. Unit has a single instance value which is written as ()
	//8) All value classes mentioned above also subclass Any and have all methods available to it i.e. toString ...etc
	//9) If a method is invoked on one of these value types above and the method exists for its corresponding Rich<valueType> i.e. RichInt there is
	//an implicit conversion to use the RichInt method
	//10) The other Any subclass is AnyRef and is the superclass of all reference classes in Scala. This is in fact a reference for java.lang.Object
	//11) To compare reference equality use eq and ne methods
	//12) Null is a subclass of any AnyRef class but not the value classes thus you can't set val i: Int = null
	//13) Nothing is at the very bottom of the class hierarchy.
}