# Tic-Tac-Toe Kata

A kata that I retry from time to time.

credits to [Kata-log](https://kata-log.rocks/tic-tac-toe-kata)

## Rules

In random order

- [X] a game is over when all fields in a row are taken by a player
- [X] players take turns taking fields until the game is over
- [X] a game is over when all fields in a diagonal are taken by a player
- [X] a game is over when all fields are taken
- [X] there are two players in the game (X and O)
- [X] game has nine fields in a 3x3 grid
- [X] a game is over when all fields in a column are taken by a player
- [X] a player can take a field if not already taken

## How to execute the tests and run the game

Install [Apache Maven](https://maven.apache.org/download.cgi).

To run the tests, from the Command Line execute
```
> mvn clean test
```

To run the game, from the Command Line execute
```
> mvn exec:java
```
