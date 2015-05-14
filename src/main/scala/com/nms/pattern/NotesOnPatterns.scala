package com.nms.pattern

/**
 * User: nsullins
 * Date: 1/11/11
 * Time: 9:59 PM
 */

class NotesOnPatterns{

	/*	Case Classes -
	 *
	 * 	1) All case classes come with a factory method for creating instantiating the class. Thus no need to use the new keyword when creating one
	 * 	2) All arguments in the parameter list of a case class implicitly get a val prefix so they are maintained as fiels
	 *  3) The compiler adds "natural" implementations of methods toString, hashcode and equals to your class
	 *  4) The biggest advantage of case classes is that they support pattern matching
	 */

	/*	Pattern Matching -
	 *
	 * 	1) Pattern matching is facilitated with the match keyword and is of the form
	 * 		selector match { alternatives} an => symbol separates the pattern from the expression
	 * 	2) A match expression is evaluated in order and there are several patterns to choose from, some listed below
	 * 	3) Some patterns
	 * 		a) Constant Pattern - like '+' or 1 matches values that are equal to the constant
	 * 		b) Variable Pattern - matches every value. the variable then refers to that value in the right hand side of the case clause. The variable may
	 * 		only appear once in the pattern
	 * 		c) Wildcard Pattern - also matches every value but does not introduce a variable name to refer to that value
	 * 		d) Constructor Pattern - a constructor is mathced with each of the arguments matched too
	 * 	4) If a pattern is not matched then a MatchError is thrown
	 * 	5) An empty default pattern looks like so case _ => 		In this case the unit value () is returned
	 * 	6) Scala uses a simple lexical rule for disambiguation: a simple name starting with a lowercase letter is taken to be a pattern variable; all other
	 * 	referneces are taken to be constants. If you need to, you can still use a lowercaase name for a pattern constant using one of two tricks. First if
	 * 	the constant is a field of some object you can prefix it with a qualifier i.e. this.pi or obj.pi. You can alternatively enclose the variable in back
	 *  ticks like so `pi`
	 *
	 */


	/*	Constructor Patterns -
	 *
	 * 	Constructor patterns are where pattern matching becomes really powerful. These patterns consist of a name e.g. BinMethod and then a number of
	 *  patterns within parentheses i.e. BinMethod("-", e, Number(0)). Assuming the name designates a case class such a pattern means to first check that
	 *  the object is a member of the named case class and then to check that the constructor parameters of the object match the extra patterns supplied.
	 *  These extra patterns mean that Scala supports deep matches.
	 */

	/*	Sequence Patterns -
	 * 	You can match against sequence types like List or Array just like you match against case classes. Use the same syntax but now you can specify
	 *  any number of elements within the pattern.
	 *  e.g.
	 *
	 *  expr match {
	 *  	case List(1, _, _) => println("found it")
	 * 		case _ =>
	 * 	}
	 *  This pattern checks for a 3 element list starting with 1
	 *
	 *  If you want to match against a sequence without specifying how long it can be you can specifiy _* as the last element. Here's an example.
	 *
	 *  expr match{
	 *  	case List(1, _*) => println("found it")
	 *  	case _ =>
	 *  }
	 *  This previous pattern matches any list starting with 1
	 *
	 *
	 */


	/*	Tuple Patterns -
	 * 	A pattern like (a, b, c) matches an arbitrary 3-tuple
	 *
	 * 	expr match{
	 * 		case (a,b,c) => println("matched " + a + b + c)
	 * 		case _ =>
	 * 	}
	 */

	/*	Typed Patterns -
	 * 	You can use a typed pattern as a convenient replacement for type tests and type casts. Here's an example. Notice in the example that x is of
	 *	type Any which doesnt support the length method so we couldnt use x.length
	 *
	 * 	def generalSize(x: Any) = x match{
	 * 		case s: String => s.length
	 * 		case m: Map => m.size
	 * 		case _ => 1
	 * 	}
	 *
	 * 	Note that we could use a type test followed by a type test to achieve the same result as above. we would test by saying expr.isInstanceOf[String]
	 * 	and case using expr.asInstanceOf[String]. This is longwinded intentionally because it is not encouraged. You are better of using a pattern match
	 * 	with a typed pattern
	 *
	 */

	/*	Type Erasure -
	 *
	 *  Scala uses the erasure model of generics just like Java does. This means that no information about type arguements is maintained
	 * 	at runtime. Consequently there is no way to determine at runtime whether a given Map object has been created with two Int arguments rather than with
	 *  arguments of different types. The only exception to the erasure rule is arrays because they are handled specially in Java as well as Scala. The
	 *  element type of an array is stored with the array value so you can pattern match on it.
	 */

	/* Variable Binding -
	 *
	 * In addition to standalone variable patterns you can also add a variable to any other pattern. You simply write the variable followed by an @ sign
	 * followed by the pattern. This gives you a variable-binding pattern. The meaning of such a pattern is to perform the pattern match as normal and if
	 * the pattern succeeds set the variable to the mathced object just as with a simple variable pattern
	 *
	 * e.g.
	 *
	 * expr match{
	 * 	case UnOp("abs", e @ UnOp("abs", _)) => e
	 * 	case =>
	 * }
	 *
	 * In the above example if the entire pattern match succeeds the matched portion UnOp("abs", _) is made available as variable e
	 */


	/*	Pattern Guards -
	 *
	 *  A pattern guard comes after a pattern and start with an "if". The guard can be an arbitrary boolean which typically refers to variables in the
	 *  pattern. If a pattern guard is present the match succeeds only if the guard evaluates to true.
	 */

	/*	Sealed Classes -
	 *
	 *  A sealed classs cannot have any new subclasses added except the ones in the same file. This is very useful in pattern matching because it means
	 *  you only need to worry about the subclasses you already know about. Whats more you get better compiler support as well. If you match against case
	 *  classes that inherit from a sealed class the compiler will flag missing combinations of patterns with a wanring message. Therefore if you write a
	 *  hierarchy of classes intended to pattern matched you should consider sealing them. The sealed keyword therefore is often a license to pattern match
	 *  If you want the compiler not to warn about missing patterns in a match use the unchecked annotation like so:
	 *
	 *
	 *  def describe(e: Expr): String = (e: @unchecked) match{
	 *  	case Number(_) => "a number"
	 *  	case Var(_) => "a var"
	 *  }
	 *
	 *  In general you can add an annotation to an expression in the same way you add a type: follow the epxression with a colon and the name of the annotation
	 *  preceded by the @ sign
	 */

	/* Case sequences as partial functions
	 *
	 *  A sequence of cases i.e. alternatives in curly braces can be used anywhere a function literal can be used. Essentially a case sequence is a
	 *  function literal, only more general. Instead of having a single entry point and list of parameters, a case sequence has multiple entry points,
	 *  each with their own list of parameters. Each case is an entry point to the function and the parameters are specified with the pattern. The body
	 *  of the entry point is the right-hand side of the case. This facility is quite useful for the actors library. Here is some an actor example
	 *
	 *  react{
	 *  	case (name: String, actor: Actor) =>{
	 *  		actor ! getip(name)
	 *  		act()
	 *  	}
	 *
	 *  	case msg => {
	 *  		println("Unhandled message: " + msg)
	 *  		act()
	 *  	}
	 *  }
	 *
	 *
	 * If you want to check whether a partial function is defined you must first tell the compiler that you know you are working with a partial function
	 * The type List[Int] => Int includes all functions from lists of integers to integers whether or not the functions are partial. The type of function
	 * that only includes partial functions from lists of integers to integers is written ParialFunction[List[Int], Int]. Here is an example of first a
	 * non partial function and then a function
	 *
	 * val second: List[Int] => Int ={
	 * 	case x::y::_ => y
	 * }
	 *
	 * now in partial function form
	 *
	 * val second: PartialFunction[List[Int], Int] ={
	 * 	case x::y::_ => y
	 * }
	 *
	 * Partial functions have a method isDefinedAt which can be used to test whether the function is defined for a particular case
	 */


}