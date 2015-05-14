package com.nms.collections

/**
 * User: nsullins
 * Date: 1/11/11
 * Time: 9:02 PM
 */

class NotesOnCollections{

	//1) The Scala collections library involves many classes and traits. As a result it can be challenging to get a big picture of the library by
	//browsing the ScalaDoc. The best idea is to review the traits for an overview of the library.
	//2) The main trait is Iterable, which is the supertrait of both mutalbe and immutable variations of sequeces(list, array), sets and maps. Iterable
	//is so named because it represents collection objects that produce an Iterator via a method named 'elements'
	//3) Among the many methods defined in Iterable are many of the higher-order methods including map, flatMap, filter, exists and find
	//4) The difference between Iterable and Iterator is that trait Iterable represents types that can be iterated over, whereas Iterator is the
	//mechanism used to perform an iteration. Futhermore an Iterable can be iterated over many times but an Iterator can be used just once. If you need
	//to iterate through a collection more than once you will need to call the elements funtion to get another Iterator to iterate through
	//5) Although Iterable implementations you are likely to encounter will represent collections of a finite size Iterable can be used to represent
	//infinite collections
	//6) ListBuffer - is a mutable object which can help you build lists more efficiently when you need to append elements to the list. ListBuffer
	//provides constant time append and prepend methods. You append elements with the += operator and prepend with the +: operator. When done to obtain
	//a list invode the toList method on the ListBuffer. Another reason to use ListBuffer instead of list is to avoid stack overflow. If you can build
	//a list in the desired order by prepending, but the recursive algorithm that would be required is not tail recursive you can use a for or while
	//loop with ListBuffer instead
	//7) ArrayBuffer - is like Array but allows for adding and removing elements at the beginning and end of a sequence. All normal Array methods are
	//availble but are slower because of the wrapping of the Array.
	//8) Calling deque on a Queue return a Tuple2 with the first element being the head of the queue and the tail being the second element
	//9) Mutable queues are somewhat different. Instead of enqueue use += and ++= operators. Also on mutable queues dequeue method will just remove the
	//head element from the queue and return its
	//10) If you want to refer to both mutable and immutable collections just add the mutable import and preface each mutable object with mutable i.e.
	//mutable.Set
	//11) To create an empty mutable map use the following expression : val emp = mutable.Map.empty[String, Int]
	//12) Immutable Maps are operated on by the following addition operators (+ and ++ for multipe elements added) and subtraction operators (- and --)
	//13) Mutable Maps are operated much similarly but with different operators: addition ( += and ++=) subtraction (-= and --=)


	/* Syntactic Sugar with regards to any operator ending in = i.e. +=, ++=, -=, --=
	 * If the operator applied ends in = and isn't supported by the class being invoked i.e a =+ b scala will try to interpret it as a = a+b
	 * This is especailly useful when working refactoring mutable sets to immutable sets because the methods are defined for mutable sets but not
	 * immutable sets but because of this sugar it will all work. Also, this works for all values not just collections
	 *
	 */

	/* Sorted Sets/Maps
	 *
	 * The Scala library provides traits SortedSet and SortedMap for sorted collections. These traits are implemented by classes TreeSet and TreeMap
	 * These classes must mix in the Ordered trait or be implicitly convertible to
	 * These traits are only available for immutable sets/maps
	 */

}