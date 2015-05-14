package com.nms.traits

/**
 * User: nsullins
 * Date: 1/15/11
 * Time: 3:28 PM
 */

object MyQueueApp extends Application {


	//the following are examples of stackable modifications
	//doubling modification
	val doublingQ = new BasicQueue with Doubling
	doublingQ.put(123)

	println(doublingQ.get)

	val doublingFilteredQ = new BasicQueue with Doubling with Filtering
	doublingFilteredQ.put(-3)
	println(doublingFilteredQ)

	val dfQ = new BasicQueue with Doubling with Filtering
	dfQ.put(3)
	println(dfQ.get)

	//fully stacked mods
	val stacked = new BasicQueue with Doubling with Filtering with Incrementing
	stacked.put(5)
	println(stacked.get)

	//test linearization: the IncrementingPlus trait extends another trait so we can test how linearization and left to right trait mixins work

	//linearization of traitTest = BasicQueue => Filtering => IncrementingPlus => Incrementing => Doubling => IntQueue => AnyRef => Any
	val traitTest = new BasicQueue with Doubling with IncrementingPlus with Filtering
	traitTest.put(1)

	//with the classes definded in this package one can define many different combinations. that's a lot of flexibility for a small amount of code
	//Keep you eyes open for opportunities to arrange code as stackable modifications

}
