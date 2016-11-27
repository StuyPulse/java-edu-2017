# java-edu-2017

Java education code and lesson notes for 2016-17 year.

# Summary #1
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

# Summary #2
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

# Summary #3

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

# Summary #4

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

# <span id="summary-5">Summary #5</span>

2016-11-21

Today we went over some key concepts in Java. First an foremost are...

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

    myAccount.<a field> = <initial value>;

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
