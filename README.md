# MVC TicTacToe
An implementation of TicTacToe with Kotlin according to the MVC principle.
# Installation
To compile and run the app follow the steps below.
## Files
- Create a new Project in Android Studio
- Replace *MainActivity.kt* with *Controller.kt*
- Copy *Model.kt* into the same directory
- Replace *activity_main.xml* with *view.xml*

Your project Structure should look something like this:

<img width="250" alt="structure" src="https://user-images.githubusercontent.com/64471262/116510571-6915eb80-a8c5-11eb-9e26-8c0a849b9d4b.png">

## Gradle
- Add `apply plugin: 'kotlin-android-extensions'` to *build.gradle (:app)*
- Add `classpath "org.jetbrains.kotlin:kotlin-android-extensions:$kotlin_version"` to dependencies in *build.gradle (:project)*
# MVC Principle and Implementation
The goal was to seperate every part of my program from one another to make them reusable and easy to replace in the future.
Android already seperates *view.xml* and *Controller.kt* for us. I chose to seperate *Model.kt* from *Controller.kt* because there is too much logic and data to keep it in the same class. It's easier to keep it in a seperate class that we access from *Controller.kt*. This way I organized my code and followed the MVC principle.

The first thing I did was create a GUI. Next up I tried to familiarize myself with the MVC principle by studying the given example and watching some tutorials online. Afterwards I dedicated myself to the logic of the TicTacToe game and the implementation of the MVC principle.
## Model
*Model.kt* contains the data that I'm keeping track of. For example the state of the game (X wins, O's turn, etc.), the position of X's and O's, the win logic and the score.
## View
*view.xml* contains everything that is shown to the user. In this case it contains a table layout with multiple buttons (as fields), buttons to reset game and counter and some labels to display the score and some hints.
## Controller
*Controller.kt* binds *view.xml* and *Model.kt* together and handles the user input. It contains multiple onClick listeners.
# Frontend
[Screenshot on Drive](https://user-images.githubusercontent.com/64471262/116379262-23004f80-a813-11eb-97f2-e4eee06a4860.jpg)

[Screencapture on Drive](https://drive.google.com/file/d/1nHmJr_bd70rokGqG8EdI3T17uQu4_5yo/view?usp=sharing)
