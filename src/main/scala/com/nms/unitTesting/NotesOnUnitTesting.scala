package com.nms.unitTesting

/**
 * User: nsullins
 * Date: 1/15/11
 * Time: 3:37 PM
 */

class NotesOnUnitTesting{

	//1) Assert method is of class Predef and has one and two argument methods. The two argument method allows for an object to be passed that is the
	//explanation of the AssertionError that is thrown when the assert if false
	//2) Ensuring is a convenience method on Predef of the type ensuring(cond: Boolean) where cond could be a Boolean or a function returning a boolean
	//the ensuring method executes the condition and returns the result if the assertion passes
	//3) Assertions and ensuring checks can be enabled and diabled using the JVM's -ea and -da command line flags
	//4) FunSuite overrides execute of Suite trait so that you can define tests as function values rathar than methods
	//5) test is a method defined in FunSuite which will be invoked by the primary constructor of the test class the trait is added to
	//6) you specify the name of the test as a string between the parentheses. the test code is a function passed as a by-name parameter to test, which
	//which registers it for tlater execution
	//7) by-name parameter = a param that is marked with a => in front of the parameter type e.g. (x: => Int). The argument corresponding to a by-name
	//parameter is evaluated not before the method is invoked but each time the parameter is referenced by name inside the method. If a parmeter is not
	//by-name is is by-value




	/* Organizing tests with ScalaTest
	 *
	 * 	ScalaTest organizes test suites by nesting Suites inside of other Suites. When a Suite is executed it will execute their nexted suites as well
	 * 	as its tests. You can nest suites manually or automatically. To test manually either override the 'nestedSuites' method on your Suites or pass
	 *  the Suites you want to nest to the constructor of class SuperSuite which ScalaTest provides for this purpose. To nest automatically you provide
	 *  package names to ScalaTest's Runner which will discover Suites automatically, nest them under a root Suite and execute the root Suite.
	 *  You can invoke Runner application from the command line or an ant task. You must specify which suites you want to run either by naming the suites
	 *  explicitly or indicating name prefixes with which you want Runner to perform automatic discovery.
	 *
	 *
	 *  Here's an example that tests the test suites packaged with ScalaTest. This example runs the SuiteSuite that is a suite of tests that test trait
	 *  itself
	 *
	 *  scala -cp scalatest-0.9.4.jar org.scalatest.tools.Runner -p "scalatest-0.9.4-tests.jar" -s org.scalatest.SuiteSuite
	 *
	 *  : -cp sets the scalatest jar on the classpath
	 *  : org.scalatest.tools.Runner is the fully qualified name of the Runner application. Scala will run this application and pass the remaining tokens
	 *  as command line arguments
	 *  : -p specifies the runpath which in this case is a Jar file that contains the suite classes "scalatest-0.9.4-tests.jar"
	 *  : -s indicates SuiteSuite is the suite to execute
	 *
	 *
	 */

}