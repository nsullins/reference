package com.nms.pkgsImports

/**
 * User: nsullins
 * Date: 1/11/11
 * Time: 10:06 PM
 */

class NotesOnPackagesImports{

	//1) _root_ = is outside any package you can write. in other words every top level package you can write is treated as a memeber of _root_ package
	//2) Imports can be anywhere in the class file. They can also import regular (not singleton) objects see the following as an example
	//	def showFruit(fruit: Fruit){
	//		import fruit._
	//		println(name + "s are " + color)
	//	}
	//in the above example all members of the parameter fruit which is of type Fruit are imported. The println statement can refer to name and color directly
	//where name and color are members of class Fruit. The two references are equivalent to fruit.name and fruit
	//3) There are three main principle differences between Java and Scala imports
	//	a) in Scala imports may appear anywhere
	//	b) may refer to objects (singleton or regular) in addition to packages
	//	c) let you rename and hide some of the imported members
	//4) An example of a renamed import is as follows
	//	import java.sql.{Date => SDate} then Date is reanmed to SDate  and then for example you could import java.util.Date and not have to prefix one or
	//the other with the fully qualified name as you would have to if you were using both date types in a java class
	//5) There is a hiding clause import too e.g. import com.fruit.{Pear => _, _} would import all fruit classes except Pear. Renaming anything to _
	//essentially hides the member
	//6) If a catch-all is used it must come last inthe import. a catch all is when using _ such as the Pear example above
	//7) Implicit imports - scala adds the following import statements to all .scala source file
	//	a) import java.lang._
	//	b) import scala._
	//	c) import Predef._
	//Furthermore imports abide by shadowing laws. e.g. both java.lang and scala. have a StringBuilder class but because scala import is last that is the one used
	//8) Companion objects - A class shares all its access rights with its compainion object and vice versa. In particular an object can access
	//all private members of its companion class just as a class can access all private members of its companion object


//a knitty gritty example
//	package bobsrockets {
//		package navigation{
//			private[bobsrockets] class Navigator{
//				protected[navigation] def useStarChart(){}
//			}
//			class LegOfJourney{
//				privagte[Navigator] val distance = 200
//			}
//			private[this] var speed = 300
//		}
//
//		package launch{
//			import navigation._
//			object Vehicle{
//				private[launch] val guide = new Navigator
//			}
//		}
//	}
//


//	private[bobsrockets] class Navigator = means that Navigator is private to package bobsrockets

//	private[launch] val guide = Navigator = means that launch is package private in Java land

//	protected[navigation] def useStarChart() = means that launch is protected in Java land

//	private[C] where C is the outer class is the same as private in Java

//	private[Navigator] val distance = 200 = means the same as private in Java that is it is availabe in inner classes of Navigator too

//	private[this] var speed = 300 = means even more restricted than private in Java this means that only the object encapsulating the data can access it







	/*Private memebers - unlike Java, Scala doesn't allow Outer classes private memeber access to inner classes. The rule is as follows
	 * A private member is only visible inside the class or object that contains the member definition
	 *
	 */

	/*Protected members - In Scala a protected member is only accessible from subclasses of the class in which the member is defined.
	 *
	 *
	 */

	/*Public members - are not explicit; if it isn't private or protected it's public
	 *
	 *
	 */

}