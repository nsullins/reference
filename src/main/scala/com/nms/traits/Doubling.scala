package com.nms.traits

/**
 * User: nsullins
 * Date: 1/13/11
 * Time: 4:41 PM
 */

trait Doubling extends IntQueue{

	//Notes about this trait
	//1) This trait extending IntQueue means that only classes that extends IntQueue can inherit from this trait
	//2) This trait also has an abstract method defined on a super call. Since super calls in a trait are dynamically bound the super call in
	//this trait will work so long as the trait is mixed in after another trait or class that gives a concrete definition. This arrangement is
	//frequently needed with traits that implement stackable modifications.This combination is of modifiers are only allowed for traits
	abstract override def put(x: Int) {
		println("Doubling")
		super.put(2 * x)
	}
}