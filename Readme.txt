
Overview
------------

This program exhibits a data structure that looks like a set of linked list but
mimics some behavior of a balanced binary tree.
The program accepts data values from the user and allows the user to search
the list to see if a value is in this list. The main purpose of the data structure is 
to store the data. The summary of allowed operations
and their restrictions are in the csci 3901 course assignment #2 information 
in the course's Brightspace space. This program does not use any data structures
from the Java Collection Framework.

The main idea is to store data randomly in a hierarchical manner so that
search can be performed in a low time complexity.
The data structure implements some of the functionalities of both a doubly linked list 
and binary balanced tree where the former is used while storing data and the latter 
allows us to search data quickly. 

- elements are present in a sorted manner in each level.
-data will be added firstly in the lowest list, keeping the sorted order. Once inserted,
 we randomly choose weather or not the new item should go into the list above.
-we keep adding data to new higher levels based on the random value. 
-while searching for a value, we begin search in the highest level. If not found,
 we would then follow the link to next lower level.
-we will be using a constructor "coin" to randomly decide if key will be added 
 to the next level. 


The sequence of our class file will be:
- Flip coin to determine number of levels.
- Add key to the data structure based on levels decided by coin flip.
- Search for a key in data structure. 


Files and external data
------------------------------

There are total five files:
  - ListHierarchy.java -- class that stores the data structure and allows add and find operations to be performed
  - SkipUI.java -- main for the program that manages user input until they provide the command "quit"
  - RandomCoin.java -- class that implements the interface coin and generates random value among 0 or 1
  - ArrayCoin.java -- class that implements the interface coin and lets us specify coin flips which can help us in debugging.
  - Coin.java -- An Interface class that declares flip method


Constructor and Methods with their significance
-----------------------------------------
add -- A method of return type boolean, it is used to add a key to the data structure.
	Returns true if the key can be found in the list (return true if key is already in the 
	list too)
find -- A method of return type booelan, it is used to search the data structure for the
	key value. 
ListHierachy -- constructor that accepts objects of type to deliver random values. 
	Returns true if the object is ready to be used at the end of method call. 


Data structures and design elements
-----------------------------------------------------------------

The program stores data every time in a node which is defined in java bean class
named "myNode". The class "myList" is used to perform add and 
find operations in the list by creating a object of class "myNode".
The data structure is designed in a way that the lowest row acts like a 
sorted doubly linked list and has branches that are created hierarchically in a 
random manner.

The new key is always added in a sorted manner at each level.
The new key is always added first in the lowest row and depending upon positive
coin flips, the key is added in higher row levels.

If the coin flip has value 0, it means we do not put the new value into the upper
list. If coin flip value is 1, we do put it into upper list. 

When we add a value to upper list, we fetch another random value to determine
if we add it into next higher list. This random selection process continues until
we are in the topmost list or we have choice to no longer promote the value in a higher
list.If in the topmost list, we still get coin flip value 1, we do add a new level to the hierarchy
and then stop.

Given a value to search, we begin searching in the topmost level. If found we return true,
else we move downwards and continue searching in lower levels. Finally, we search in the
lowest row which has all the data and if still not found we return false.


Assumptions
-----------------

 - No strings to store will be more than 15 characters.


Limitations
--------------

- Only user input of type strings will be processed by the data structures
- The find operation is performed only if exact match is found (case sensitive)