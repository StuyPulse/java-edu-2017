# java-edu-2017

Java education code and lesson notes for 2016-17 year.

# Lesson summaries

### Summary #1
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

### Summary #2
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

### Summary #3

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
