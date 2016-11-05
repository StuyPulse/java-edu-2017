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
