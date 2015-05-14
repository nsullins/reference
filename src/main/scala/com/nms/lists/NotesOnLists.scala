package com.nms.lists

/**
 * User: nsullins
 * Date: 1/11/11
 * Time: 9:17 PM
 */

class NotesOnLists{

	//1) Lists are quite similar to arrays, but there are two important differences. First, lists are immutable. That is elements of a list cannot
	//be changed by assignment. Second, lists have a recursive structure (i.e. a linked list) whereas arrays are flat
	//2) The list type in Scala is covariant. This means for each pair of types S and T, if S is a subtype of T then List[S] is a subtype of List[T]
	//3) The empty list: List() has type List[Nothing] and thus List[Nothing] is a subtype of every List that's why it's ok to write the following
	// val xs: List[String] = List() because the empty list is again a subtype of any list because Nothing is a subtype of all classes in Scala

	/* Constructing Lists -
	 *
	 * All lists are built from two fundamental building blocks: Nil and the infix operator :: pronounced "cons"
	 */

	/* Basic opertaions -
	 *
	 * head - returns the first element of a list
	 * tail - returns a list consisting of all elements except the first
	 * isEmpty - returns true if the list is empty
	 * head and tail are defined only for non-empty lists otherwise an exception is thrown
	 */

	/* Pattern matching on Lists -
	 *
	 * The "cons" pattern x::xs is a special case of an infix operation pattern. When seen as an expression an infix operation is equivalent to a method
	 * call. For patterns the rules are different. When seen as a pattern an infix operation such as p op q is equivalent to op(p, q). That is the infix
	 * operator op is treated as a constructor pattern.
	 *
	 * Often, pattern matching over lists is clearer than decomposing them with methods, so pattern matching should be a part of your list processing
	 * toolbox. Plus it's a sealed class which means to match away baby!
	 */

	/* First order list methods -
	 *
	 * Length - on lists unlike arrays length is a relatively expensive operation. It needs to traverse the whole list to find its end and therefore
	 * takes time proportional to the length of the list, that's why it's not a good idea to replace isEmpty with length == 0. even though the two tests
	 * are equivalent the second one is slower especially for long lists
	 *
	 * Init - returns all elements of a list except the last one
	 * Last - returns the last element of a list
	 * The above two methods are couterparts to tail and head respectively
	 * Like head and tail; init and last will throw NoSuchElementException on empty Lists
	 * Unlike head and tail which run in constant time init and last need to traverse the entire list and therefore are proportional to the size of the list
	 *
	 * NOTE: It's a good idea to organize your data so that most accesses are at the head of a list
	 *
	 *
	 * drop, take and splitAt -
	 *
	 * drop and take operations generalize tail and init in that they return arbitrary prefixes or suffixes of a list.
	 *
	 * take - the expression "xs take n" returns the first n elements of the list xs. If n is greater than the length of the list the entire list is returned
	 * drop - the expression "xs drop n" returns all elements of the list except the first n ones. If n is greater than the length the empty list is returned
	 * splitAt - the operation splits the list at a given index returning a pair of two lists. It is defined by the equality:
	 * 	xs splitAt n equals (xs take n, xs drop n). However splitAt avoids traversing the list xs twice.
	 */

	/* Element selection: apply and indices
	 *
	 * Random element selection is supported through the apply method however it is a less common operation for lists than for arrays, this is because
	 * xs(n) takes time proportional to the index n. In fact, apply is simply defined by a combination of drop and head
	 *
	 * 			xs apply equals xs.drop(n).head
	 *
	 * indices - returns all valid indices in a list
	 * e.g.
	 * 			abcde.indices returns List(0,1,2,3,4)
	 */


	/* Zip - the zip method takes two lists and forms a list of pairs. If the two lists are of different length any unmatched elements are dropped
	 */


	/* toString and mkString
	 *
	 * toString - returns the canonical string representation of a list
	 * e.g
	 * abcde.toString return String = List(a,b,c,d,e)
	 *
	 *
	 * mkString - the operation mkString involves four operands and is of the form
	 *
	 * 		xs mkString(pre, sep, post)
	 * 	where
	 * 		pre - a prefix to be displayed in front of all elements
	 * 		sep - a separator string to be displayed between all elements
	 * 		post - a string to be displayed at the end
	 *
	 * addString - there is also the addString method which appends the constructed string to a StringBuilder object rather than returning them as a result
	 *
	 * the mkString and addString methods are inherited from List's super trait Iteralbe, so they are applicable to all sorts of iterable collections
	 */


	/* Converting arrays and lists
	 *
	 * To convert data from the flat world of arrays and the recursive world of lists you can use the method toArray in class list and toList in class
	 * Array
	 *
	 * you can also copy to an array using the copyToArray method but ensure that the array is of the right size
	 *
	 * elements - if you need to access list elements via an iterator you can use the elements method
	 */

}