package com.nms.unitTesting


import com.nms.compAndInherit.UniformElement
import org.scalatest.FunSuite

/**
 * User: nsullins
 * Date: 1/15/11
 * Time: 3:45 PM
 */



//this is an example suite which refers to functional suite. see notes for more details.
class FunElementSuite extends FunSuite {

	test("width should be 2"){

		val ele = new UniformElement('x', 2, 3)
		assert(ele.width == 3)
	}

	//same test but with === operator by scalatest which provides a message indicating failure

	test("width should be 2 with message"){
		val ele = new UniformElement('x', 2, 3)
		assert(ele.width === 2)
		//running this test in command line resulted in the following
		/*
		 *
		 * Test Starting - FunElementSuite: width should be 2
			Test Succeeded - FunElementSuite: width should be 2
			Test Starting - FunElementSuite: width should be 2 with message
			TEST FAILED - FunElementSuite: width should be 2 with message (FunElementSuite.scala:20)
			  3 did not equal 2
			  org.scalatest.TestFailedException: 3 did not equal 2
			  ...
			  at com.nms.unitTesting.FunElementSuite$$anonfun$2.apply$mcV$sp(FunElementSuite.scala:20)
			  at com.nms.unitTesting.FunElementSuite$$anonfun$2.apply(FunElementSuite.scala:18)
			  at com.nms.unitTesting.FunElementSuite$$anonfun$2.apply(FunElementSuite.scala:18)
			  at org.scalatest.FunSuite$$anon$2.apply(FunSuite.scala:1158)
			  at org.scalatest.Suite$class.withFixture(Suite.scala:1509)
			  at com.nms.unitTesting.FunElementSuite.withFixture(FunElementSuite.scala:8)
			  at org.scalatest.FunSuite$class.runTest(FunSuite.scala:1155)
			  ...
		 */
	}


	//an alternative option is to use the expect method. the === method does care about expected and actual values it just compares the left operand to the right

	test("width should be 2 with the expect method resulting in better messaging at least with regard to comment above and oh yeah this is longggg"){

		val ele = new UniformElement('x', 2, 3)
		expect(2){
			ele.width
		}
		//output below from command line. can also run this with eclipse runner obviously
		/*
		 *
		 * TEST FAILED - FunElementSuite: width should be 2 with the expect method resulting in better messaging at least with regard to comment above and oh yeah this is longggg (FunElementSuite.scala:48)
			  Expected 2, but got 3
			  org.scalatest.TestFailedException: Expected 2, but got 3
			  ...
			  at com.nms.unitTesting.FunElementSuite$$anonfun$3.apply$mcV$sp(FunElementSuite.scala:48)
			  at com.nms.unitTesting.FunElementSuite$$anonfun$3.apply(FunElementSuite.scala:45)
			  at com.nms.unitTesting.FunElementSuite$$anonfun$3.apply(FunElementSuite.scala:45)
			  at org.scalatest.FunSuite$$anon$2.apply(FunSuite.scala:1158)
			  at org.scalatest.Suite$class.withFixture(Suite.scala:1509)
			  at com.nms.unitTesting.FunElementSuite.withFixture(FunElementSuite.scala:8)
			  at org.scalatest.FunSuite$class.runTest(FunSuite.scala:1155)
			  ...
		 */
	}


	test("AssertionError should be thrown"){

		intercept[AssertionError]{
			val ele = new UniformElement('x', -2, 3)
		}
		//this passes because the exception is thrown
	}



































}
