package com.nms.unitTesting

import org.scalatest.Suite
import com.nms.compAndInherit._


/**
 * User: nsullins
 * Date: 1/15/11
 * Time: 3:38 PM
 */

class ElementSuite extends Suite{

	//using ScalaTest
	def testUniformElement(){

		val ele = new UniformElement('x', 2, 3)
		assert(ele.width == 3, "incorrect width")
	}
}