# Hangman (Java)

A simple command-line Hangman game written in Java, as a practice project for me and as a reference for others!
The program randomly picks a word from a text file and lets you guess one letter at a time. You have a limited number of lives, so choose wisely!

## Requirements

- Java JDK 8 or newer
- A terminal or IDE

## How to Compile

From the project root directory:

```
javac -d bin src/Main.java
```

This compiles the program and puts the compiled files into the bin folder.

## How to Run

Still from the project root:

```
java -cp bin Main
```

Make sure words.txt is located in the project root folder. The program reads from it directly. Feel free to change the contents of the wordlists to have more fun!

## Contributing

All contributions are welcomed! Just make sure they are relevant, clear, and helpful. Contributions not following these simple guidelines will likely be closed.
