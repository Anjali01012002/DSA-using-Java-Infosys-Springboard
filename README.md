# Data Structures and Algorithms using Java

This repository contains Java implementations of various data structures and algorithms based on the Infosys Springboard course.

## Course Content

- **Introduction to Data Structures**
- **Array**
- **Linked List**
- **Stack**
- **Queue**
- **Collections Framework and Generics**
- **Introduction to Algorithms**
- **Analysis of Algorithms**
- **Searching Algorithms**
- **Sorting Algorithms**
- **Algorithm Techniques**
- **Comparison of Algorithms**

## Files Added

 ### 1 : `src/ArrayOperations.java`

This file demonstrates basic array operations with user input, including:

- **Initialization**: Displays an initial array.
- **Insertion**: Inserts an element at a specified position.
- **Deletion**: Removes an element from a specified position.
- **Traversal**: Displays all elements with their indices.

The program takes user input for insertion and deletion operations and prints the state of the array after each operation.

### 2 : `src/SinglyLinkedList.java`

This file demonstrates various operations on a singly linked list, including:

- **Insertion at Beginning**: Adds a new node at the start of the linked list.
- **Insertion at End**: Adds a new node at the end of the linked list.
- **Insertion After a Given Node**: Adds a new node after a specific node.
- **Deletion of Node by Key**: Deletes the first occurrence of a specified key in the linked list.
- **Search for a Node**: Searches for a node with a specified key.
- **Print List**: Displays the linked list from the first to the last node.

The program includes a menu-driven interface that allows the user to perform different operations on the singly linked list based on user input.

### 3. `src/DoublyLinkedList.java`

This file demonstrates operations on a doubly linked list, including:

- **Insertion at Beginning**: Adds a new node at the start of the list.
- **Insertion at End**: Adds a new node at the end of the list.
- **Insertion After a Node**: Inserts a new node after a specified node.
- **Deletion**: Deletes a node by its value.
- **Search**: Searches for a node by its value.
- **Print List**: Displays all nodes in the list in forward order.
- **Print List in Reverse**: Displays all nodes in reverse order.

The program allows users to perform various operations interactively, making it easy to understand the functioning of a doubly linked list.

### 4: `src/CircularLinkedList.java`

This file demonstrates operations on a circular linked list with string data, including:

- **Insertion at Beginning**: Adds a new node at the start of the circular linked list, making it the new head.
- **Insertion at End**: Adds a new node at the end of the circular linked list, linking it back to the head to maintain the circular structure.
- **Insertion After a Node**: Inserts a new node after a specified node in the circular linked list.
- **Deletion of Node by Key**: Deletes the first node containing the specified string value, adjusting the links to maintain the circular nature.
- **Search for a Node**: Searches for a node containing a specified string value within the circular linked list.
- **Print List**: Displays all nodes in the circular linked list, starting from the head and looping back to the head.

The program includes menu interface, allowing users to perform these operations interactively, making it easy to see how a circular linked list works.

### 5: `src/FindPositionInLinkedList.java - Exercise 1`

This exercise demonstrates how to find the position of a given element in a linked list. The implementation of the `findPosition()` method is provided in the `FindPositionInLinkedList` class.

#### **Problem Statement**

Given a linked list, find and return the position of a given element in the linked list. If the element is not present, return 0. The position starts from 1.

#### **Approach Used**

1. Traverse the linked list starting from the head node.
2. Maintain a counter for the current position starting from 1.
3. Compare each node's data with the given element.
4. Return the position if the element is found.
5. Return 0 if the element is not found after traversing the list.

## How to Use This Repository

1. **Clone the repository**:

   git clone https://github.com/Anjali01012002/dsa-java-infosys-springboard.git

2. **Navigate to the project directory**: 

    cd dsa-java-infosys-springboard

3. **Compile and run Java files**:

    **Compile**: To compile a Java file, use:

        javac src/filename.java

    **Run**: To run the compiled Java file, use: 

        java -cp src filename  

    **Note**: The -cp src option specifies the classpath for the Java runtime, which is necessary if your .java files are organized in a directory like src/.

4. **File Types**:

    **Java Source Files (.java)**: These files contain the implementations of various data structures and algorithms. These are the files you should focus on and commit.
    **Compiled Class Files (.class)**: These are generated when you compile Java files. They are not included in the repository and should not be pushed to GitHub.

5. **Repository Structure**:

    **src/**: Directory containing Java source files.
    **README.md**: This file, providing an overview and usage instructions.
    **.gitignore**: Specifies files and directories to be ignored by Git.

## Contributing
Contributions are welcome! If you have suggestions or improvements, please submit a pull request or open an issue.