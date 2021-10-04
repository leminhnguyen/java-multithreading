## Getting Started

Welcome to the Java Multiprocessing Project

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies
- `resources`: the folder to contain static files

## Source Code Structure

- `App.java`: the main class of this project
- `Text2AllophoneProcessor.java`: the simulated class for converting text to allophone (can be any class that need to be processed in parallel)
- `Worker.java`: the class associates with `Text2AllophoneProcessor` for processing the input text files and inherits `Thread` built-in class for spawning multiple threads.

## How To Use This Project

1. Replace the simulated class by your class.
2. Modify the `run()` method in `Worker.java` to your processing flow.
3. Define the `NUM_WORKERS` in `App.java` and runing the program, If everything goes on the right path, `NUM_WORKERS` of processes will be spawned.


## Author
- [nguyenlm](https://github.com/leminhnguyen)
