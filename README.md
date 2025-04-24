# Multithreaded Minimum Finder

This Java code demonstrates how to find the minimum element in a large array using multiple threads to improve performance.

## Overview

The code consists of three main classes:

* **`ArrayClass`**: This class initializes an array of random integers and provides a method (`threadMin()`) to find the minimum element using a specified number of threads. It also includes synchronized methods to collect the minimum value found by each thread and to manage thread completion.
* **`MinThread`**: This class extends `Thread` and is responsible for finding the minimum element within a specific portion (chunk) of the array. It iterates through its assigned segment and reports the local minimum to the `ArrayClass`.
* **`Main`**: This class is the entry point of the application. It creates an `ArrayClass` instance with a large array and a thread count based on the available processors. It then calls the `threadMin()` method to find and print the minimum element.

## How it Works

1.  **Array Initialization**: The `ArrayClass` constructor creates an array of a given length and fills it with random integer values.
2.  **Thread Creation**: The `threadMin()` method in `ArrayClass` divides the array into chunks based on the specified `threadCount`. It then creates and starts a `MinThread` for each chunk.
3.  **Parallel Minimum Finding**: Each `MinThread` iterates through its assigned portion of the array, finds the minimum value within that segment, and uses the synchronized `collectMin()` method in `ArrayClass` to update the overall minimum if its local minimum is smaller.
4.  **Thread Synchronization**: The `increaseThreadCount()` method in `ArrayClass` is called by each `MinThread` upon completion. The `waitForThreads()` method in `ArrayClass` uses `wait()` and `notify()` to ensure that the main thread waits until all worker threads have finished their execution before returning the final minimum value.
5.  **Result Output**: The `Main` class calls `threadMin()` on the `ArrayClass` instance and prints the final minimum element found by the threads.

The output will be the minimum element found in the randomly generated array. The execution time may vary depending on the number of available processors and the size of the array. Using multiple threads can significantly reduce the time taken to find the minimum in large arrays compared to a single-threaded approach.
