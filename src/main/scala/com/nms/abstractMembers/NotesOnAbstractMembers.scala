package com.nms.abstractMembers

/**
 * User: nsullins
 * Date: 1/15/11
 * Time: 3:58 PM
 */

class NotesOnAbstractMembers{


  /* Type Members
   *
   * The type keyword is an alias to a type.
   */

  /*
  Abstract Vars

  Abstract vars that are declared as members of a class will also by default declare abstract getter/setter methods
   */


  /*
  Abstract Vals

  Abstract vals sometimes play a role analogous to superclass parameters. This is particularly important in traits as they
  don't have constructors to pass params. So the usual notion of parameterizing a trait works via abstract vals that are
  implemented in subclasses.

  Initializaing Abstract Vals

  The initialization order is not the same for class parameters and abstract fields. A class parameter argument is evaluated
  before it is passed to the class constructor(unless the parameter is by-name). An implementing val definition in a sub
  class by contrast is evalutated only after the superclass has been initialized
   */

  /*
  Pre-Initialized Fields

  To pre-initialize fields just place the fields wihtin curly braces before the superclass constructor call

  e.g
  Anonymous class example where x is a predefined in scope val/var this is a closure
  new {
    val numerArg = 1 * x
    val denomArg = 2 * x
    } with RationalTrait


  Pre-initialized fields in an object definition
  object twoThirds extends {
    val numerArg = 2
    val denomArg = 3
    } with RationalTrait

  Here's an example of how class parameters can be made available for the initialization of a supertrait

  class RationalClass(n: Int, d: Int) extends {
    val numerArg = n
    val denomArg = d
    } with RationalTrait{

    def someMethod: Int
  }

  NOTE: Because pre-initialized fields are initialized before the superclass constructor is called their initializers cannot
  refer to the object that's being constructed. Consequently if such an initializer refers to this, the reference goes to
  the object containing the class or object being constructed not the constructed object itself
   */


  /*
  Lazy Vals

  Lazy vals are refernces that are only initialized once they are used and not before. These values are intialized on demand
  and have nothing to do with their textual ordering in the class/object definition

  e.g.
  lazy val x = {println("initializing"); "done"}

  Object definitions are a form of lazy initialization. In fact the definitino can be seen as a shorthand for a definition
  of a lazy val with an anonymous class that describes the object's contents

  NOTE: Because lazy initialization is on demand the programmer is free from having to think hard how to arrange val definitions
  to ensure everything is defined when it is needed. However this advantage holds only as long as the intialization of lazy
  vals neither produces side effects nor depends on them. In the presence of side effects initialization order starts to matter.
  Thus lazy vals are an ideal complement to funtional objects where the order of initialization doesn't matter. They are well
  less suited for code that's predominantly imperative.

   */

  /*
  Abstract Types

  Path-dependent types - objects in Scala can have types as members. For instance in the book on page 421 programming in
  scala we saw the compiler reference bessy.SuitableFood where type SuitableFood is a member of the object referenced from
  bessy. A type like bessy.SuitableFood is called a path-dependent type. The word "path" here means a refernce to an object.

  A path-dependent type resembles the syntax for an inner class type in Java, but there is a crucial difference: a path-
  dependent type names an outer object where an inner class ytpe names an outer class.


  # operator is used to address an inner class the . operator is reserved for objects only.


   */
}