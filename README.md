# <b id="README-top">java-edu-2017</b>

Java education code and lesson notes for 2016-17 year.

# Contents
- <a href="#summary-1">Lesson 1</a>
- <a href="#summary-2">Lesson 2</a>
- <a href="#summary-3">Lesson 3</a>
- <a href="#summary-4">Lesson 4</a>
- <a href="#summary-5">Lesson 5</a>
- <a href="#summary-6">Lesson 6</a>
- <a href="#summary-7">Lesson 7</a>
- <a href="#summary-8">Lessons 8 and 9</a>

# <b id="summary-1">Summary #1</b> <a href="#README-top">↑ </a>
11/01/2016

Today we took a look at the Animation class which animated a circle moving down the screen.
We first drew some helpful diagrams and pseudocode on the board which helped us understand how the real code worked.
asdwadswad
Then we went over the class and some of its key components.
The Animation code along with comments describing each element is available on thisasdwrepository within the `src` folder, which you should definitely check out if you want to understand the code along with what we did today.

Edit: To make things clearer, I will describe some of the specific details in the animation class which we went over in our lesson.

The first thing to note is these lines of code:

`

    private double xPos;
    private double yPos;
`

These initialize the variables xPos and yPos to hold doubles (numbers with a decimal point). These variables are now usable in the code but do not yet have any value assigned to them or put into them. In order to place values in to a variable you must use the `=` operator as such:

`

    xPos = 200.0;
    yPos = 0.0;
`

Here we put `200.0` into xPos and `0.0` into yPos. These values are now accessible if we call `xPos` and `yPos` in our code.

Now that our variables are initialized and are assigned values, we can use these variables. In our code, the variables are used in the `draw()` method.

`

    xPos += 1.0;
    yPos += 1.0;
`

this code increases `xPos` and `yPos` by 1, and is the same thing as writing

`

    xPos = xPos + 1;
    yPos = yPos + 1;
`

These operations are done every time the `draw()` method is called. In the background, Java code is running the `draw()` method once every frame.

(For those of you who are wondering how `draw()` is called: We cannot see how `draw()` is called because our workspace does not have the source code for the class which externally calls the `draw()` method in `Animation.java`. Instead, we have a precompiled jar file located in the `lib` directory which handles everything for us. This jar file is compiled from Wilson's java-education system found at https://github.com/Team694/java-education. This is way ahead of where we are in our lesson so you really don't have to worry about this.)

Thats about it for today. Looking foward to our next lesson!

# <b id="summary-2">Summary #2</b> <a href="#README-top">↑ </a>
11/03/2016

We had some new newbies who came in today!
The lesson began with everybody creating and logging in to an account using the wonderful workspacer system created by Wilson which lets one to safely save files when on a guest account without internet.

The way we create an account and log in works as follows:

1) Log in to a guest account on a school computer

2) Once logged in, open a terminal window using Ctrl+Alt+T

3) Type

 `$ /var/tmp/setmeup`

 (without the dollar sign) and press enter to execute (this runs the file `setmeup` in the directory `/var/tmp/`

4) close your terminal window (either press the X button or Alt+F4 or Ctrl+C and Ctrl+D. Keyboard shortcuts make things a lot faster as you will all eventually learn)

5) Reopen a terminal window and type

 `$ make-user`

 Follow instructions and answer yes to the yes/no prompt.

 There will then be further instructions on how to access your workspace and you should be able to look at the files that are found in the workspace.

6) Once you are done and you have some changes that you want to save, type

 `$ save`

 and your workspace should be saved and accessible next time you log on to the computer.

#### Editing Files

You can click on "Files" which is usually the first shortcut on the left toolbar and use the gui to find and double click on your files

You can open up gedit in the command line too:

`$ gedit`

and if you want to you can open files with the same command:

`$ gedit your_file_here`


After this we went over the code that we wrote last meeting so that everyone was more or less up to speed, but nothing new was added to our class.

Until next time!

# <b id="summary-3">Summary #3</b> <a href="#README-top">↑ </a>


11/14/16

We began our meeting by going over what we learned last time and then we moved on to dealing with variables.

We talked over how to simulate gravity and created a diagram of variables which we needed to use in order to simulate a ball falling due to gravity. The diagram looked something like this:


    Variables:    | yPos             | velocity        |
    Start values: | yPos = 0.0       | velocity = 0.0  |
    Each frame:   | yPos += velocity | velocity += 0.5 |


Essentially, `velocity` is the "speed" of the object and on every frame, `yPos` is updated by `velocity`. While this is happening, `velocity` is increasing which simulates the acceleration of gravity on an object as it falls.

Now that we have the diagram / table in front of us we can convert that into code. (you can go to `java-edu-2017/src/Animation.java` in this repository if you want to see the full code)

Variables:



    private double yPos;
    private double velocity;


Start values:



    yPos = 0.0;
    velocity = 0.0;


Each frame the variables are updated:



    yPos += velocity;
    velocity += 0.5;


Now we have a ball that falls from the top of the screen downward. Cool!

But what if we don't want the ball to continue falling? what if we want it to bounce as soon as it hits the ground?

That's where conditionals come in.

#### Conditionals:

Conditionals help control the code by doing specific actions when certain requirements are met. Their basic structure is this:

` If <condition>, then <do something> `

for example,

` If it is raining outside, then grab an umbrella `

or in our case,

` If the yPos touches or goes below the bottom of the screen, invert the velocity to make the ball bounce `

In Java and in many other programming languages, the syntax for this conditional is as follows:

    if <condition> {
        <do something>
    }

If `<condition>` is true, then the code inside the brackets is executed. Otherwise it is left alone and the code is not executed.

In our case, our pseudocode looks something like this:

    if (yPos is greater than 400) {
        multiply velocity by -1
    }

(400 because the window height is 400 pixels)

So how do we translate that pseudo code into REAL code?

In order to do that we would need to learn how to use comparators.

#### Comparators:

Comparators, as their name implies, compare two values. They are like a "check" for inequality or equality.

Here are a list of some Java comparators:

    x > y     (is x greater than y?)
    x < y     (is x less than y?)
    x == y    (is x equal to y? NOTE THAT WE USE == and NOT =)
    x >= y    (is x greater than or equal to y?)
    x <= y    (is x less than or equal to y?)

we can use these comparators with conditionals to accomplish some impressive feats. And now we have all the things we need in order to make our ball bounce.

But before we move on, here is a brief overview on some Java operators:

#### Some Operators

    x + y   (x plus y)
    x - y   (x minus y)
    x * y   (x multiplied by y)
    x / y   (x divided by y)

Each operator can be used with an equals after it as shorthand, for example `x *= 2` is shorthand for `x = x * 2` just like `x += 2` is shorthand for `x = x + 2`

Lets try applying all that we have learned and write our code:

    if (yPos >= 400) {
        velocity *= -1
    }

Here we check if yPos is greater than 400 (the bottom of the screen) and if it is, we multiply velocity by -1 to make it bounce and go up.

(This is written in the `draw()` method because you check for bouncing each frame)

If you write this and give it a test, the ball should fall and bounce up when it hits the ground up to the same height you started from.

That's pretty much what we did. Again, if you want to look at the whole code, it is available in this repository.

Until next time!

# <b id="summary-4">Summary #4</b> <a href="#README-top">↑ </a>

11/17/2016

Today was not a very eventful day, but we did manage to get some work done.

The first half ot the meeting was spent going over the code that we wrote last time. For those who need clarification on that, you can read Summary #3 for the last meeting.

The other half was spent adding on to what we learned last time and making the ball bounce on the walls as well as the floor. The code that we used was almost identical to our previous code, except we applied it to X in addition to Y.

In order to make the ball bounce on the walls, we need to set things up so that we can work with velocity along both the X and the Y axis. If we think about how we dealt with velocity in our previous meeting, we can apply the same to the X axis. In that case, the ball would have both an `xVelocity` variable and a `yVelocity` variable (which replaces our previons `velocity` variable because we're dealing with two axis). So we would initialize our variables just like we do any other variable:

    private double x;
    private double y;
    private double xVelocity;
    private double yVelocity;

NOTE: We can initialize multiple variables in one line, separated by commas, if they have the same type and visibility. So if you wanted to you can potentially initialize everything like this:

    private double x, y, xVelocity, yVelocity;

It is important to keep in mind that `xVelocity` and `yVelocity` correspond to how many pixels the ball moves per frame in the x and y direction. With that in mind we can replace our previous code for handling with velocity in the `draw()` event with this code:

    x += xVelocity;
    y += yVelocity;

Now we can make the ball bounce on the walls using what we learned last time:

    if (x > 400) {
        x = 400;
        xVelocity *= -1;
    }
    if (x < 0) {
        x = 0;
        xVelocity *= -1;
    }

#### Some extra things that you might want to look at

Wilson added a new file which you should check out if you want to learn how to do more with the gui application like keyboard/mouse input or drawing images to the screen. The file is in the repository and the link is over here:

https://github.com/Team694/java-edu-2017/blob/master/extras.md

For those of you who want to make a bigger application, you should take a look at creating your own objects and classes. Those will allow you to create objects which have their own properties which you can modify and use. If you want to learn more about objects and classes you can look at the Java Tutorials from Oracle: https://docs.oracle.com/javase/tutorial/java/javaOO/index.html. You don't have to understand every concept from the tutorials, but skimming over it might help.

See yall later!

# <b id="summary-5">Summary #5</b> <a href="#README-top">↑ </a>

2016-11-21

### *Want to play with this stuff at home? Check out [repl.it](https://repl.it/languages/java)*

Today we went over some Java concepts. First an foremost, statements:

## Statements

Statements are individual commands. You've used few kinds of statements before:

**Assignment statements** assign values to variables. For example...

- `xPos = 0;`
- `xVelocity += 2.0;`

**Method call statements** tell a "method" to run. We'll discuss methods below. For example...

- `screen.circle(xPos, yPos, 10.0);` runs the `circle` method of `screen`

- `screen.clear();` runs the `clear` method of `screen`

- `System.out.println("Hello!");` runs the `println` (pronounced "print line")
method of `System.out`. This is a very useful method, which displays a line of
text to the screen. Quite helpful while debugging code.

**If statements** say "only run these statements if ____ is true".

    if (yPos > 400.0) {
        yVelocity *= -1.0;
    }

**Variable declaration statements** create a variable for us to use temporarily. E.g.:

    double x = 1.5;
    x += 10.0;
    double pi = 3.14;
    x += pi;

Technically we haven't used these yet, but they're very similar to the variables
you have used. To explain how they're "temporary", consider the following:

    if (<condition>) {
        double fred = 3.14;
        ...
    }

the variable `fred` only exists between the '{' and '}' (inside the block). After
the block ends, `fred` can no longer be used.

Also notice the braces (`{` and `}`). A "block" is a series of statements
surrounded by braces, and allows you to group many statements together.
For example:

    if (yPos > 400.0) {
        yPos = 400.0;
        yVelocity *= -1.0;
        System.out.println("Horay");
    }

## Primitive data types

When we declare a variable, we need to specify its *data type*. This specifies
the kind of data we can store in that variable. There are 7 primitive data types:

4 of them are various sizes of integers:
- A `byte` holds an integer from -128 to 127 inclusive
- A `short` holds an integer from -2^15 to 2^15-1 inclusive
- An `int` holds an integer from about -2billion to +2billion
- A `long` holds an integer from about -2^63 to 2^63 inclusive

Of these, `int` is the one that matters the most by far. You may never use the others.

2 of them hold various sizes of floating point numbers:
- A `float` holds a low-precision floating point number.
- A `double` holds a high-precision floating point number.

A few of you asked by `float`s matter. They don't. Don't use them. `double` is better.

And finally, `char` and `boolean`:
- A `char` holds a single character of text. A char is written between single quotes, e.g:<br />`char firstLetter = 'a';`
- A `boolean` is either `true` or `false`. E.g:<br />`boolean collegeAppsSuck = true;`

## Classes

Java allows you to define your own data types, using something called a `class`.

Let's say we want to store information about a bank account in a variable.  We
might want to include information like the balance of the account, the name of
the owner, and the account number.

**None of the primitive datatypes listed above can store all that information.
So, we create a class.**

We start with a file called `BankAccount.java` with the following contents:

    public class BankAccount {
        ...
    }

Now we choose what **information** we want to store.

1. The bank balance:

        public double balance;

2. The name of the account owner:

        public String ownerName;

    What's a `String`?! `String` is a class that Java gives us
    automatically.  A `String` holds text.

3. The account number:

        public int accountNumber;

Putting it all together, we have:

    public class BankAccount {
        public String ownerName;
        public double balance;
        public int accountNumber;
    }

This could be a complete class. It says that a `BankAccount` is a package of
three values: a `double` named `balance`, a `String` named `ownerName`, and an
`int` named `accountNumber`.

To create a `BankAccount`, we say `new BankAccount()`. Now we can use our
class:

    BankAccount myAccount = new BankAccount();
    myAccount.ownerName = "Wilson Berkow";
    myAccount.accountNumber = 932478234; // seems legit
    myAccount.balance = 8000000000.0; // I have 8 biyon dollars

We can refer to the fields of `myAccount` using a period `.` (called the "dot
operator"), and can use them and assign to them just like we would with
variables.

But classes are better than just for storing a lot of data in one variable.
Just like primitive types have built-in operations (like `+` for addition and
`/` for division), we can define operations for our classes.

We call these operations **methods**. What methods might we want for a
`BankAccount`?

We'll want to deposit money...

    public void deposit(double amountToDeposit) {
        balance += amountToDeposit;
    }

Perhaps we'll want to be polite...

    public void sayHello() {
        System.out.println("Good morning " + ownerName + "! Welcome to the bank.");
        // We can use + to combine Strings into a bigger String.
    }

Notice that from these methods, we can talk about our fields `balance` and
`ownerName` by name.

Let's see it all together...

    public class BankAccount {
        public String ownerName;
        public double balance;
        public int accountNumber;

        public void deposit(double amountToDeposit) {
            balance += amountToDeposit;
        }

        public void sayHello() {
            // We can use + to combine values into a bigger String:
            System.out.println("Good morning " + ownerName + "!");
            System.out.println("You have " + balance + " dollars in the bank.");
        }
    }

Example usage of a BankAccount object:

    BankAccount fredsAccount = new BankAccount();
    fredsAccount.ownerName = "Fred Smith";
    fredsAccount.balance = 0.0;
    fredsAccount.accountNumber = 98537485; // or whatever

    fredsAccount.deposit(100.0);
    fredsAccount.sayHello();

This will display:

    Good morning Fred Smith!
    You have 100 dollars in the bank.

## Finally, constructors

Phew. This has been a lot, but we have one more really important thing.

In the above code, we've seen a lot of...

    myAccount.<field name> = <initial value>;

It's annoying to have to explicitly initialize (give an initial value to) all
our fields for all our accounts. To solve this, we have constructors.

A constructor is a block of code that will run when an object is created.

This is the general structure of a constructor:

    public NameOfTheClass(...parameters...) {
        ...code...
    }

Adding a constructor to our BankAccount class leaves us with:

    public class BankAccount {
        public String ownerName;
        public double balance;
        public int accountNumber;

        public BankAccount(String name, double startingValue, int accountNum) {
            ownerName = name;
            balance = startingValue;
            accountNumber = accountNum;
        }

        public void deposit(double amountToDeposit) {
            balance += amountToDeposit;
        }

        public void sayHello() {
            // We can use + to combine values into a bigger String:
            System.out.println("Good morning " + ownerName + "!");
            System.out.println("You have " + balance + " dollars in the bank.");
        }
    }

And now, to create a `BankAccount` object, we can say:

    BankAccount fredsAccount = new BankAccount("Fred Smith", 0.0, 98537485);

    // We've started fredsAccount with 0.0 dollars. Let's give him more:
    fredsAccount.deposit(100.0);
    fredsAccount.sayHello();

## Using this in our animations

Classes give us a lot of power. Look at the `Animation.java` and `Ball.java` files in
the `src` directory (scroll up) for how classes can be used in our `Animation`s.

Finally, a recommendation from Adris:

#### Tutorials

If you still feel unsure about anything that we went over in class, you should
definitely look at some Java tutorials over the break. Going over a tutorial
series will let you get a better understanding on the Java syntax which is
essential for programming in the language.

I suggest you go on YouTube and look up "Beginner Java Tutorial" and follow it
through, at least until you get to methods and classes.

# <b id="summary-6">Summary #6</b> <a href="#README-top">↑ </a>

2016-11-29

Up till now, we've been writing graphical code which draws animations to the
screen. The code we've been writing has used some libraries to do all this
(libraries are code written as tools to make other programmers' work easier).

Today we shifted course a bit and worked with vanilla Java. We begin with
the standard "Hello, World!" program:

    public class MyClass {
        public static void main(String[] args) {
            System.out.println("Hello, world!");
        }
    }

This will print "Hello, world!" to the screen.

This file declares a class `MyClass`, with no instance variables, and with
one method: `main`. This method is different from the ones we've talked
about: it is a `static` method.

We introduced methods as operations that we define on our objects. If we create
a `BankAccount`, we want a `deposit` method; when we work with the robot, the
"drivetrain" of the robot (the part with the wheels and their motors) will be
represented as an instance of class `Drivetrain`, and will have a drive method
(called `tankDrive`).

All these methods operate on an object of their class. To run them, you first
have to make an object of that class. This makes sense: before depositing
money, you have to make a bank account in which to deposit; before driving,
you have to make a drivetrain.

We will often, however, want to write methods that don't operate on objects of
their class. For example, in our `BankAccount` we might want to calculate
interest a lot, and instead of copy+pasting the code to do it, we'd like to put
that code in a method and just say `calculateInterestOn(x, y, z)` whenever we
need to. You don't need a bank account to calculate interest on a loan,
thought&emdash;it's just math. For this kind of case, we can make a `static` method.

**I know that's a lot of text, but read it carefully. You can't tl;dr `static`.**

So, our `main` method is `static`, and it can be run without creating an
instance of `MyClass` *(terminology note: an "instance" of a class is an object
constructed from that class; i.e.&nbsp;<code>new&nbsp;BankAccount()</code> is
an instance of `BankAccount`)*. But what's the big deal?

**Every executable Java program must have a `main` method, and the `main`
method is where every Java programs starts.**

Even in our graphical code from previous meetings, there was a `main` method
at the very bottom, which began our code.

Don't worry, if you don't understand `String[] args` yet. This is
called an "array of strings"&emdash;arrays are explained in the [lesson
7 summary](#summary-7) below.

### While loops

A **loop** is a construct we can use to run a section of code
many times.

The simplest loop is a `while` loop. A `while` loop says "run this
block of code repeatedly, until <some condition> becomes false."

    while (<condition>) {
        ... do things ...
    }

If we want to print out the numbers from 0 to 9, we can say:

    int n = 0;
    while (n < 10) {
        System.out.println(n);
        n += 1;
    }

You can tweak and run [this example at repl.it](https://repl.it/EfYb).

### The Java SE 8 API Documentation

Java SE 8 is "Java Standard Edition 8"&emdash;the latest version of Java.

API is "Application Programming Interface". It is the interface that you,
the programmer, use to interact with a piece of software.

The [Java SE 8 API Documentation](https://docs.oracle.com/javase/8/docs/api/)
lists all the components built in to Java, including every single class. There
is a link to a local copy of the API on your Desktop. Open it up and Ctrl+F to
find a class (listed in the sidebar), click on the class name, and it will show
you all you need to know about the class.

Every class has a summary of its usage, then a list of its constructors,
methods, and other things.

The Java API docs (documentation) are written in pretty technical language, but
if you're itching to do something we haven't yet discussed (e.g. the
`ArrayList` class), check it out.


### User input with `Scanner`

We discussed the `Scanner` class in this lesson. A `Scanner` is used to read
user input, or read text from a file. **Scanner is not very important in the
long-run.**


First of all, we must import the `Scanner` class into our code. At the top of
the file, before "public&nbsp;class...", add:

    import java.util.Scanner;

To create a `Scanner` which will read from user input, we write:

    Scanner myScanner = new Scanner(System.in);

`System.in` represents user **in**put.

Now we can do:

    System.out.println("Enter your age:");
    int age = myScanner.nextInt();
    // myScanner.nextInt() will wait for the user to type some characters
    // and press Enter. If the user typed a number, it will return that
    // number. Otherwise, it will crash your code.

    System.out.println("Enter your first name:");
    String name = myScanner.next();
    // myScanner.next() will wait for the user to type characters and press
    // Enter, and will return the first word the user entered.

# <b id="summary-7">Summary #7</b> <a href="#README-top">↑ </a>

2016-12-01

_**Side note: an object whose class is `MyClass` is called an
*instance* of `MyClass`.** This is important terminology._

In this lesson we talked more about loops, introduced arrays, and got some
practice writing methods that use them.

### The `for` loop

When using `while` loops, we often wanted to count how many iterations had
been run in a variable. Much of our code looked like this:

    int count = 0;
    while (<condition>) {
        ... do stuff with the count variable...
        count += 1;
    }

The `for` loop is a construct that allows us to abbreviate this as:

    for (int count = 0; <condition>; count += 1) {
        ... do stuff with the count variable...
    }

This is exactly the same as the first block of code.

E.g., print the numbers from 0 to 9, inclusive:

    for (int n = 0; n < 10; n += 1) {
        System.out.println(n);
    }

### Arrays

An array is a collection of items **all of the same type.**

In general, the type of an array is `<itemtype>[]`, and an array is created
with the expression <code>new&nbsp;&lt;itemtype&gt;[<length>]</code>, where
`<itemtype>` is the type of the items that will be in the array, and `<length>`
is the number of items it should hold.

For example:

    int[] stuyGrades = new int[10]; // an array of 10 ints

`stuyGrades` is an array of length 10, in which each item is an `int`. As the
default value for an `int` is 0, all of its values are initially `0`.

Terminology note: "item" = "element" = "member" of an array

#### Access

To access an item in `stuyGrades`, we write `stuyGrades[<index>]` for some
expression `<index>`.

Similarly, to set an item in `stuyGrades` to some value, we write:

    stuyGrades[<index>] = <value>;

For example:

    stuyGrades[0] = 73;
    stuyGrades[1] = 88;
    int firstGrade = stuyGrades[0]; // firstGrade is 73
    System.out.println(stuyGrades[1]); // displays 88

Note that the **indices start at zero**, not at one. In software, we label
sequences of things starting from 0 (it happens to be very convenient).

**Warning:** if your code tries to access an index that is *out of bounds*,
it will crash. For example:

    stuyGrades[42] // crashes!
    stuyGrades[10] // crashes!
    stuyGrades[-3] // crashes!
    stuyGrades[x] // works only when x is non-negative and less than 10

Notice that 10 is out of bounds, (recall that the length of `stuyGrades` is
10).  Remember: the index of the first element is 0, so the index of the last
element is 9, in this case. In general, the index of the last element is one
less than the array's length.

#### Length

We can get the *length* of an array (the number of items it can hold) with the
`length` property. E.g.:

    int howManyGrades = stuyGrades.length; // howManyGrades is 10

#### Iterating over an array

We can put together what we've learned above to "iterate" over an array.
That is, to execute a loop which runs once for every element in an array.

If we want to print out every element of `stuyGrades`, we can write:

    for (int i = 0; i < stuyGrades.length; i += 1) {
        // i is short for "index"
        System.out.println(stuyGrades[i]);
    }

#### Writing some methods

Toward the end of the meeting, we started writing methods for
doing math and operating on arrays. See the `Stats.java` file in
`src` for what we exactly wrote.

We ended with a discussion of how to find the minimum value in
an array, and got to a good idea. This is where we'll resume on Tuesday.

# <b id="summary-8"><b id="summary-9">Summaries 8 & 9</b></b> <a href="#README-top">↑ </a>

2016-12-06 and -08

### The stack and the heap

When our code is running, Java keeps track of the variables we have created
in something called **the stack**. When we run the following code:

    int x = 12;
    int y = x / 4;          // <--- position 1
    x = y;                  // <--- position 2
    int[] values = new int[3];
    values[0] = 694;
    values[1] = x;
    values[2] = 42;         // <-- position 3

When the second line (at 'position 1') executes, the stack looks like this:

<table>
<tr><th>Name</th><th>Value</th></tr>
<tr><td>x</td><td>12</td></tr>
<tr><td>y</td><td>3</td></tr>
</table>

After 'position 2', it looks like:

<table>
<tr><th>Name</th><th>Value</th></tr>
<tr><td>x</td><td>3</td></tr>
<tr><td>y</td><td>3</td></tr>
</table>

When we create an array, the items in the array are not actually stored on
the stack. Instead, they are stored away somewhere else, where there is
plenty of space to hold lots of data, called **the heap**.

On the stack, instead of storing the items of the array, the "address" of
the array is stored (also called a "pointer" or "reference" to the array).
You can think of it like an actual address, describing where on the computer's
memory chip the array data exists.

So when we get to 'position 3' in the above code, this is what the stack looks like:

<table>
<tr><th>Name</th><th>Value</th></tr>
<tr><td>x</td><td>3</td></tr>
<tr><td>y</td><td>3</td></tr>
<tr><td>values</td><td><em>345 W Chambers St</em></td></tr>
</table>

The heap is a place where lots of data is stored by many parts of the program.
Somewhere on the heap will be `values`:

<table>
<tr><th>Address</th><th>Data</th></tr>
<tr><td>...</td><td>...</td></tr>
<tr><td><em>345 W Chambers St</em></td><td>694, 12, 42</td></tr>
<tr><td>...</td><td>...</td></tr>
</table>

It's okay if you're a little iffy about the stack and the heap, as long as you
have an intuition about what variables are and feel comfortable using them.

I encourage you to use the [Java
Visualizer](http://cscircles.cemc.uwaterloo.ca/java_visualize/). It's an online
tool which allows you to see the execution of a Java program one step at a time
(just enter your code into the box, and hit 'Visualize Execution'; then hit
'Forward' and 'Back' to step through execution of the code). It displays
the stack (which it labels 'frames') and the heap (which it labels 'objects')
and shows how they are changed. Use [this link](http://cscircles.cemc.uwaterloo.ca/java_visualize/#code=public+class+Stats+%7B%0A++++public+static+void+main%28String%5B%5D+args%29+%7B%0A++++++++double+foo+%3D+0.5%3B%0A++++++++double+bar+%3D+f%28foo%29%3B%0A++++++++foo+%3D+bar%3B%0A++++++++foo+%3D+5%3B%0A++++++++int%5B%5D+values+%3D+new+int%5B5%5D%3B%0A++++++++values%5B0%5D+%3D+7%3B%0A++++++++values%5B1%5D+%3D+3%3B%0A++++++++values%5B2%5D+%3D+4%3B%0A++++++++values%5B3%5D+%3D+-2%3B%0A++++++++values%5B4%5D+%3D+12%3B%0A++++++++int+smallest+%3D+minimum%28values%29%3B%0A%0A++++++++System.out.println%28f%2813%29%29%3B%0A++++%7D%0A%0A++++public+static+int+minimum%28int%5B%5D+dataset%29+%7B%0A++++++++int+minSoFar+%3D+dataset%5B0%5D%3B%0A++++++++for+%28int+i+%3D+1%3B+i+%3C+dataset.length%3B+i%2B%2B%29+%7B%0A++++++++++++if+%28dataset%5Bi%5D+%3C+minSoFar%29+%7B%0A++++++++++++++++minSoFar+%3D+dataset%5Bi%5D%3B%0A++++++++++++%7D%0A++++++++%7D%0A++++++++return+minSoFar%3B%0A++++%7D%0A%0A++++//+An+example+method,+like+the+algebra+function+'f%28x%29+%3D+2x'%0A++++public+static+double+f%28double+x%29+%7B%0A++++++++return+2+*+x%3B%0A++++%7D%0A%0A++++public+static+void+printArray%28int%5B%5D+fred%29+%7B%0A++++++++for+%28int+i+%3D+0%3B+i+%3C+fred.length%3B+i+%2B%3D+1%29+%7B%0A++++++++++++System.out.println%28fred%5Bi%5D%29%3B%0A++++++++%7D%0A++++%7D%0A%7D&mode=display&curInstr=0)
to see the visualization of our Stats.java class.

### Back to Arrays!

We spent some time last week working on creating methods that handled arrays. More specifically we dealt with finding the minimum and the average value of an integer array.

Let's say that we want to find the sum of an int array. How would we go about doing this?

If we map out an algorithm for finding the sum of an int array, it would go something like this:

 1. Have a `sum` variable and set it to 0
 2. Loop through the array, and for each element in the array increase `sum` by the element
 3. Once you finish looping, the sum of the arrays is stored in variable `sum` and your work here is done.

Now that we have an idea as to what our method will do, we can now begin writing our method. 

_If you need help on writing methods you can check out <a href= "http://www.homeandlearn.co.uk/java/java_methods.html" > this quick little tutorial here </a>. If you're confused on static methods, be sure to reread the beginning of <a href="#summary-6"> Summary 6 </a>._

We are inputting an integer array, outputing an integer, and we want our method to be accessible without creating an instance of our class. Our method would be declared like this:


    public static int sum(int[] array) {
        // stuff from the algorithm goes here
    }

Now we fill in our algorithm:


    public static int sum(int[] array) {
        int sum = 0;
        
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        
        return sum;
    }

Using what we've learned from Summary 7 we can loop through the array to get our answer. Now we can apply this function to other tasks and problems, such as finding the average of an array:


    public static int average(int[] array) {
        int sum = sum(array);                // This assumes you've already written the previous sum() method
        return sum / array.length;
    }

Here we don't need to redo the algorithm for finding the sum of a number because we already wrote it into a method, which we can now call and use.

Another problem that we had was finding the minimum value of an integer array. Using the same process as last time, we can create our algorithm:

 1. Create a variable holding a temporary variable (let's call it `tempMinimum`)
 2. Scroll through the array. If you find a number less than `tempMinimum`, set `tempMinimum` to that number.
 3. Once you finish scrolling, you have the minimum of the entire array stored in the `tempMinimum` variable

This looks good, but we don't know what to initialize the `tempMinimum` variable to. We could set it to 0, but if all of the numbers in the array are greater than 0 the minimum would be incorrect. To overcome this, we can set `tempMinimum` to be equal to any element of the array, because we will be comparing all of the elements of the array to this value anyway.

With that out of the way, let's write our function. It has a similar declaration as the `sum` and `average` method because we input an integer array and output an integer:


    public static int minimum(int[] array) {
        int tempMinimum = array[0];               // this assumes that the array has at least 1 element in it
        
        for(int i = 0; i < array.length; i++) {
            if (array[i] < tempMinimum) {
                tempMinimum = array[i];
            }
        }
        
        return tempMinimum;
    }
    
If we wanted to implement a `maximum` method, it would look almost identical to our `minimum` method, but we would switch the "less than" sign into a "greater than" sign when comparing our temporary variable with each element in the array.

