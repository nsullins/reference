package com.nms.typeParameterization

/**
 * User: nsullins
 * Date: 1/13/11
 * Time: 4:14 PM
 */

class NotesOnTypeParam{


  /**
   * 1) Object private members are 'immune' to variance classifications i.e. scala will not enforce variance rules on
   * this type of data. Thus this is a useful technique for obtaining flexible variance annotations. Another useful technique
   * for achieving flexible variance annotations is to use lower bounds. Lower bounds achieves flexible variance because
   * it flips the position i.e. U >: T flips the U to negative and double flips the T to positive. e
   *
   *
   * 2) The rules to variance annotations are more imperative with mutable data versus a purely functional world where
   * many types are naturally covariant.
   */

	//The Queue trait defined in this package is a trait, but not a type. Queue is not a type bercause it takes a type parameter. As a result you cannot
	//create variables of type Queue. Instead Queue enables you to specify parameterized types such as Queue[String]. Thus Queue is a trait and Queue[String]
	//is a type. Queue is also called a 'Generic Trait" which means that you are defining many specific types with one generically written class or trait

	/* Variance Annotations -
	 *
	 *
	 * Covariant - if S is a subtype of T this implies Queue[S] is a subtype of Queue[T]
	 *
	 * Generic types by default in Scala are nonvariant
	 *
	 * Nonvariant (Rigid) subtyping - In the queue scenario rigid typing implys defferent element types would never be in a subtype. A Queue[String] would
	 * not be usabled as a Queue[AnyRef]
	 *
	 * Overriding default generic behavior with the following syntax trait Queue[+T]. This indicates that subtyping is covariant(flexible) in that parameter
	 *
	 *
	 * Contravariant - if T is a subtype of type S, this would imply that Queue[S] is a subtype of Queue[T]
	 */


	/* Covariant Rule -
	 *
	 * If a generic parameter type appears as the type of a method parameter, the containing class or trait may not be covariant in that type parameter.
	 * For queues the append method violates this condition
	 *
	 * class Queue[+T]{
	 * 	def append(x: T) = ...
	 * }
	 *
	 * Furthermore, reassignable fields will such as var x: T will create getter/setter def x:T and def x_=(y: T) and the setter method has a parameter
	 * of the field type T. So that type may not be covariant
	 */


	/* Mechanism by which the Scala compiler checks variance annotations
	 *
	 * Position - A position is any location in the class body where a type parameter may be used
	 * This is based on position of type parameters either for methods or type arguments like Arg in C[Arg]. For further (confusing) details see page 394
	 * of Programming in Scala. Type parameters annotated with + can only be in positive positions while type params annotated with - may only be used in
	 * negative positions. By definition positions at deeper nesting levels are classified as the same as that at enclosing levels, but there are a handful
	 * of exceptions.
	 *
	 * 		Different Exceptions
	 * 		1) Method value parameter positions are classified to the flipped classification relative to the positions outside of the method
	 * 		2) Besides method value parameter positions, the current classification is also flipped at the type parameters of methods.
	 * 		3) A classification is sometimes flipped at the type argument position of a type (like C[Arg] mentioned above). If C's type parameter is annotated
	 * 		with a + the the classification stays the same. If C's type param is annotated with a -, the the current classification is flipped
	 *
	 * One important basic note is that at the class declaration level all positions are positive. Thus in class Queue[T] T is classified positive. Thus Queue
	 * can't be covariant because that would put a covariant annotated value (+) in a negative position which isn't allowed as stated abvove. The opposite is
	 * true for contravariance.
	 *
	 */


	/* Lower bounds
	 *
	 * As mentioned in the comments of the Queue trait/class definition, the Queue can be covariant because of the use of lower bounds. What happens
	 * 'technically' according to the book is that a flip occurs for lower bounds. The type parameter U is in a negative position (1 flip) while the lower
	 * bound (>: T) is in a positive position (2 flips).
	 *
	 * This new version of Queue with lower bounds allows you to append an arbitrary supertype U of the queue element type T, the result is then a Queue[U]
	 * Together with queue covariance this gives the right kind of flexibility for modeling queues of different element types in a natural way. This shows
	 * that variance annotations and lower bounds play well together. They are a good example of type-driven design, where the types of an interface guide
	 * its detailed design implementation.
	 */

	/* Contravariance
	 * As stated above contravariance says that if T is a subtype of type S, this would imply that Queue[S] is a subtype of Queue[T]. It flips the collection
	 * inheritance and is not very intuitive. The reasoning this works points to a general principle in type system design: it is safe to assume that a type T
	 * is a subtype of a type U if you can substitute a value of type T wherever a value of type U is required. This is called the Liskov Substitution principle.
	 * The principle holds if T supports the same operations as U and all of T's operations require less and provide more more than the corresponding operations
	 * in U.
	 *
	 */

}