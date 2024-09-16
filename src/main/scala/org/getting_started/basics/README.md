Scala notes related to the chapter

Scala adheres to OOP and FP paradigms

• It’s a pure object-oriented programming (OOP) language. Every variable is an
object, and every “operator” is a method.

• It’s also a functional programming (FP) language, so functions are also variables,
and you can pass them into other functions. You can write your code using OOP,
FP, or combine them in a hybrid style.

Other scala features:

• Scala source code compiles to “.class” files that run on the JVM.

• Scala also works extremely well with the thousands of Java libraries that have
been developed over the years.

scalac is just like javac, and that command creates two new files:

• Hello$.class

• Hello.class

These are the same types of “.class” bytecode files you create with javac, and they’re
ready to work with the JVM.


When you run the scalac command it creates .class JVM bytecode
files. You can see this for yourself. As an example, run this javap command on the
Hello.class file:

$ javap Hello.class

Compiled from "Hello.scala"

public final class Hello {

public static void main(java.lang.String[]);

}

As that output shows, the javap command reads that .class file just as if it was created
from Java source code. Scala code runs on the JVM and can use existing Java libraries
— and both are terrific benefits for Scala programmers.

The Scala REPL (“Read-Evaluate-Print-Loop”) is a command-line interpreter that you
use as a “playground” area to test your Scala code. To start a REPL session, just type
scala at your operating system command line

In Scala the general rule is that you should always use a val field unless there’s a good
reason not to. This simple rule 

a) makes your code more like algebra and 

b) helps get you started down the path to functional programming, where all fields are immutable.


The REPL isn’t 100% the same as working with source code in an IDE, so there are a
few things you can do in the REPL that you can’t do when working on real-world code
in a project. One example of this is that you can redefine a val field in the REPL, like
this:

scala> val age = 18

age: Int = 18

scala> val age = 19

age: Int = 19

val fields can’t be redefined like that in the real world, but they can be redefined in the
REPL playground.