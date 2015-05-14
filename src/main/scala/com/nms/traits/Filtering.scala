package com.nms.traits

/**
 * User: nsullins
 * Date: 1/13/11
 * Time: 4:42 PM
 */

trait Filtering extends IntQueue{

	abstract override def put(x: Int) = {
		println("Filtering")
		if(x > 0) super.put(x)
	}
}