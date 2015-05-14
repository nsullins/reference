package com.nms

/**
 * User: nsullins
 * Date: 1/10/11
 * Time: 9:51 PM
 */

class NotesOnBasics{

	//This class is really just a bookmark for notes for the meantime

	//1) A sign for not using functoinal techniques is apparent in either the use of vars and/or
	//the methods that return Unit which implies side effects, also use immutable types
	//2) Scala scripts are files that must end in a result expression and can be called directly from
	//the command line using scala with the .scala filetype as part of the call i.e. >scala script.scala
	//3) Leaving off the = sign before the body of a function results in the return type being Unit
	//This is the preferred style because it speaks of a procedural programming style that is executed
	//only for its side-effects.
	//4) Semicolon inference - a line ending is treated as a semicolon unless one of the following is true
	//		a) line ends in a word tha woud not be legal as the end of a statement i.e period or infix operator
	//		b) the next line begins with a word that cannot start a statement
	//		c) the line ends while inside parentheses or brackets which cannon contain multiple statements anyway
	//5) Singletons - The object is the companion object and the class that is also of the same file
	//is the companion class. The object is of the type of the companion class however is an object of
	//its superclass and any mixed in traits and can act like each.
	//Each singleton class is implented as a synthetic class ending in $ i.e. MySingleton$ and have
	//the same intialization semantics as a Java static class
	//6) A singleton object that does not share the same name with a companion class is called a standalone
	//object. Stand alone objects are used for many purposes including collection related utility methods
	//together or defining an entry point for a application i.e. main class
	//7) All classes implicitly import java.lang and scala packages along with Predef singleton
	//8) Compiling can be done via scalac which does jar scans and other checks. For faster compiling
	//one can use fsc (fast scala compiler). Upon initial call to fsc a daemon is created that then runs
	//in the background and available for next time it is called. to close initiate fsc -shutdown
	//9) Application/main method = by extending Application you don't need to explicitly add a main method
	//however you can't used passed in arguments in this case. Also for multi-threaded applications an
	//explicit main method is required. Thus only inherit from Application when program is simple and single threaded
	//10)Symbol - symbol literal is of the form 'ident i.e. 'cymbol will translate in the compiler to Symbol("cymbol")
	//Symbol literals are used like identifiers in a dynamically typed language. For instance if you have a method
	//def updateRecord(r: Symbol, value: Any) where "r" is the name of a record field in a database in a dynamically typed
	//language you could call this method passing in an unidentified field identifier but in scala this would not compile
	//instead and almost as concisely you would have to call updateRecord('favoriteAlbum, "OK Computer")
	//Symbols are interned that is if you write the same symbol literal twice both expressions will refer to the same Symbol object
	//11) Postfix operators are methods that take no args when invoked without a dot or parentheses the convention is to only use
	//parenthese when side effects occur.
	//12) In the interpreter console hitting enter twice will start a new command useful when you have typos using the interpreter
	//13) recursive functions must explicitly declare result type
	//14) Given that Scala doesnt have operators, just methods used in operator notation the operator precedence is based on the first
	//character of the methods used in operator notation
	//15) assignment operators have lowest precedence i.e =+
	//16) Scala classes can take params directly i.e. class Rational(n: Int, d: Int) the class params will be gathered up as part of the
	//primary constructor of the class. The class params will not be available as fields of the class
	//17) Identifiers i.e. methods or fields shouldnot start with $ symbol this will compile but could cause runtime clashes with
	//identifiers created by Scala compiler
	//18) Constants in Scala are capitalized and camel case i.e. java constant MAX_HEIGHT in Scala would be MaxHeight
	//19) Operator Indentifiers are mangled by java to form legal values i.e. :-> would be transformed to $colon$minus$greater
	//20) A mixed identifier consists of an alphanumeric followed by an underscore and an operator identifier i.e. unary_+ which
	//results in the + operator
	//21) Literal identifiers are of the form `arbitrary  string`. A typical usage is when trying to call Thread.yield in Java. yield
	//in scala is a reserved word so to call this Java method you would need to use back ticks i.e. Thread.`yield`()
	//22) Overloaded methods when invoked are determined by the right operand
	//23) Implicit conversions are powerful but because they are applied implicitly by the compiler not explicitly written down in the
	//source code it can become non-obvious to the client programmers what implicit conversions are being applied.
	//24) Unit refers to the unit value and is written (). The existence of () is how Scala's Unit differs from Java's void
	//25) Variable assignemnt returns () or Unit always. That's why the following won't compile in Scala
	//while( (line = readLine()) != "") because assigning line always results in ()
	//26) You can create a variable in an inner scope with the same name as a varaiable in an outer scope the inner variable is said to shadow the outer variable
	//27) The interpreter creates a new nested scope for each statement you tyupe in
	//28) Function literals exist in source code and function values exist as objects at runtime. class:object::literal::value
	//29) Tail recursive functions do not create a new stack frame for each call and thus are efficient and avoid stackoutof bounds exceptions
	//30) Tail call optimitzation is limtied to situations in which a method or nested functino calls itself directly as its last operation without going
	//through a function value or some other intermediary
	//31) Looping methods like exists act on the collection and can reduce any code used for looping. just pass the function to the exists looping
	//method i.e. for is negative numbers exist in collection call num.exists(_ < 0)
	//32) In any method invocation in Scala where you're passing in only one parameter you can use () or {} The purpose of this is to all programmers
	//to write function literals between the braces
	//33) A function is 'pure' if it doesnt have any side effects and doesn't depend on mutable state
	//34) Fields and methods are in the same namespace thus a field can override a parameterless method
	//35) The note above makes it invalid to have a field and method of the same name
	//36) If you goal is code reuse prefer composition to inheritance. Only inheritance suffers from the fragile base class problem where changing
	//the implementation could break client code
	//37) With inheritace vs composition it's important to ask yourself these questions
	//		a) does the relationship model an is-a realtionship
	//		b) will clients want to use the subclass type as a super class (does the fragile base class problem rear its head)

	//Controll structures - they all return values
	/*
	 * val filename =
	 * 	if(!args.isEmpty) args(0)
	 * 	else "default.txt"          either way the value is returned and we don't have to use vars but can use vals
	 *
	 *
	 *
	 * WHILE LOOPS - is often left out of pure functional languages because it returns () not a real value thus don't use it.
	 * Try recursion instead and always challenge your use of vars and while loops
	 *
	 *
	 * FOR expression - the swiss army knife of iteration
	 *
	 * some usefule examples are for(i <- 1 to 4 ) iterates 4 times or for(i <- 1 until 4) iterates 3 times not including the upper bound also called a Range
	 *
	 *
	 * FOR and Filtering - filters are applied with an if
	 * i.e. if you want to filters file ina directory that are scala files then you would use the following
	 *
	 *	for(file <- filesHere if file.getName.endsWith(".scala"))
	 *		println(file)
	 *
	 * multipe filters - the if expressions must be delimited by 6semicolons
	 *
	 * this for expression checks that .scala file is a file too thus two filters
	 *	for(file <- filesHere
	 *		if file.getName.endsWith(".scala"));
	 *		if file.isFile
	 *		println(file)
	 *
	 *
	 * nested iteration notice line is a val here
	 *
	 * for(file <- fileshere
	 * 		line <- fileLines(file)
	 * 		if line.trim.matches("somePattern")
	 * 	  )println(file + ":" + line.trim)

	 *
	 * nested interation with midstream variable binding. In this case we assign line to a var and not a val so we can avoid second .trim call
	 *
	 * for(file <- fileshere
	 * 		line <- fileLines(file)
	 * 		trimmed - line.trim
	 * 		if trimmed.matches("somePattern")
	 * 	  )println(file + ":" + trimmed)
	 *
	 */


	//first class functions *****************************************
	/*
	 *
	 * Every function value is an instance of some class that extends one of FunctionN traits where Function0 has 0 params and so on
	 * Each FunctionN trait has an apply method used to invoke the function
	 * Function values are objects so you can store them invariables if you like and can be invoked using the usual parentheses function notation
	 *
	 * Function literals have short form too
	 * 	1) leave off function type i.e. (x: Int) => x > 0 turns into (x) => x > 0. The compiler uses target-typing to discern the type for the meantime
	 * 	   don't concern yourself with how target-type and if the compiler complains add the type. one will get a good feel over time. target typing
	 * 	   means to infer the type based on the type calling the method
	 * 	2) The second way is to leave off the parentheses when the type is inferred i.e x => x > 0 would be the more terse usage of the literal
	 *
	 * 	3) Use placeholder syntax : that is use _ as long as the parameter appears only once in the funtion literal i.e. _ > 0 Multiple underscores
	 * 	   means multiple params not resue of a single param. Thus _ + _ wont work because it can't infer the types but this will work
	 *    (_: Int) + (_: Int) because now the compiler that we're using two different Int type params
	 *
	 *
	 */

	//partially applied functions ***********************************
	/*
	 * A PA function is an expression where you dont supply all of the arguments needed by the function.
	 *
	 * e.g. sum function in which you supply NONE of the three required params
	 *
	 * 	given function def sum(a: Int, b: Int, c: Int) = a + b + c
	 * 	the partially defined functioned mentioned above is
	 * 	val a = sum _
	 *
	 * Another way to think about this kind of expression where an underscore is used to represent a parameter list is as a way to represent
	 * a def into a function value. This is useful as above for passing a method around and also useful with nested functions since they can't
	 * be passed around either
	 *
	 * If you are writing a partially applied funciton expresion leaving off all params such as sum _ you can express it more concisely by laving off the underscore
	 * e.g.
	 *
	 * 	someVariables.foreach(println _) becomes someVariables.foreach(println)
	 */

	//closures ***************************
	/*
	 * A function literal with no free variables is called a closed term.
	 * A function literal with one or more free variables is an open term. where the open term is bound at runtime to the function literal,
	 * this is in essence the definition of a closure.
	 * Closures bind the variable not the value thus any changes to the free variable(open term) are refelcted in the closure and vice versa
	 *
	 *
	 *
	 */

	//Repeated parameters
	/*
	 * to indicate that the last parameter is repeated  place an asterisk after the type of the parameter
	 *
	 * e.g.
	 *
	 * def echo(args: String*) for(arg <- args) println(arg)
	 *
	 *
	 * Then you could call the method like so: echo("oneParam", "twoparam") but the params are all ofthe same type
	 * Inside the functino the type of the repeated parameter is an array of the declared type. even though passing an array of string to the
	 * echo method would be a compiler error. to have the array pass each element as an argument to the echo method the following would do
	 *
	 * val arr = Array("whats", "up", "doc?")
	 * echo(arr: _*)
	 */


	/* Currying ***************************
	 *
	 * A curried function is applied to multiple argument lists instead of just one
	 *
	 * e.g. def curriedSum(x: Int)(y: Int) = x + y
	 *
	 * invoking curried sum actually gets two traditional function invocations back to back
	 * In the case of curriedSum the first function takes the x parameter and returns a function value for the second equivalent to the following
	 *
	 * def first(x: Int) = (y: Int) = x + y
	 *
	 * when viewing curried functions imagine they are two functions  with the first returning a function value to the second
	 *
	 *
	 * You can get a reference to curriedSum's second function using placeholder notation
	 * i.e. val onePlus = curriedSum(1)_ The underscore is the placeholder
	 * You don't need to use a space between the placeholder because curriedSum(1)_ is not a legal identifier
	 *
	 */

	/* Scala vs Java namespaces
	 *
	 * Java namesapces are: fields, methods, types and packages
	 *
	 * Scala namespaces are: values(fields, methods, packages, and singleton objects)
	 * 						 types(class and trait names)
	 *
	 */

}