package com.nms.lists

/**
 * User: nsullins
 * Date: 1/11/11
 * Time: 9:55 PM
 */

class ListObjecctMethods{

	//this class illustrates the methods of the globally accessible scala.List object companion of List class. Some operations are factory methods and
	//others work on lists of some specific shape

	//List.apply -
	val listFromApplyMethod = List(1,2,3) //this is the same as calling List.apply(1,2,3)

	//List.range - creates a listing consisting of a range of number
	val listFromRangeMethod = List.range(1, 5)
	assert(List(1,2,3,4) == listFromRangeMethod)

	//List.range with step
	val listFromRangeWithStepMethod = List.range(1, 10, 3)
	assert(List(1,4,7) == listFromRangeWithStepMethod)

	//List.make -
	//the make method creates a list consisting of zero or more copies of the same element
	val listFromMakeMethod = List.make(5, "a")
	assert(List("a","a","a","a","a") == listFromMakeMethod)

	//List.unzip -
	//unzip is the inverse of zip. it takes a list of pairs and returns two lists
	val listOfPairs = List((1,2), (2,3))
	val pairOfLists = List.unzip(listOfPairs)
	assert(pairOfLists._1 == List(1,2))
	assert(pairOfLists._2 == List(2,3))

	//Notes on unzip - You might wonder why unzip is a method of the global List object instead of the List class, after all zip is a method of the List
	//class. The problem is that unzip does not work on any list but only on a list of pairs, whereas Scala type system requires every method of a class
	//to be available on every instance of that class, thus unzip cannot go in the List class.


	//List.flatten
	//the flatten method takes a list of lists and concatenates all elements of the list
	val listToFlatten = List(List(1,2), List(1,2,3), List(123, 321, 231))
	val flattenedList = List.flatten(listToFlatten)
	assert(List(1,2,1,2,3,123,321,231) == flattenedList)
	//like unzip above flatten only works for lists of lists thus is part of the companion object


	//concat - similar to flatten but doesn't take a list of lists but instead an arbitrary amount of list to operate on
	val concatenatedLists = List.concat(List(1,2), List(1,2,3), List())
	assert(List(1,2,1,2,3) == concatenatedLists)

	//methods List.map2, List.forall2, and List.exists2 are like their single param counterparts except that they take two lists and apply a function to them
	val map2Example = List.map2(List(10, 20), List(2,4,5))(_ * _)
	assert(List(20, 80) == map2Example)

}