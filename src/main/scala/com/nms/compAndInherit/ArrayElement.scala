package com.nms.compAndInherit

/**
 * User: nsullins
 * Date: 1/11/11
 * Time: 9:06 PM
 */

//the constructor below is an example of a class with a parametric field conts
//since val is used the field is unassignable after constructed if you were to use var it would be reassignable you could also use private
//and other modifiers
class ArrayElement(val contents: Array[String]) extends Element {



}