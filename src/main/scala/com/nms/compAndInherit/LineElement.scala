package com.nms.compAndInherit

/**
 * User: nsullins
 * Date: 1/11/11
 * Time: 9:12 PM
 */

class LineElement(s: String) extends Element {

	//the following line demostrates that parameterless methods and fields are equivalent here we are implementing a method with a field
	val contents = Array(s)
	//override is required for all methods that override a parent's concrete method
	override def width: Int = s.length
	override def height: Int = 1

}