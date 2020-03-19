# Movie-Rental-System
Inventory tracking system automation

## Overview
The Movie-Rental-System will initialize and keep track of movies/videos inventories, allowing customers to borrow and return items. The inventory can display the inventory, and keep track of customers' history of rentals at anytime. The inventory keeps the items sorted by their respective sorting attributes. The history of rentals are displayed in the order of occurrence.

## Movie Data
There are three types of movies/videos (in DVD media) to be tracked:

comedy, drama, and classics — each sorted differently as described below.


·         comedy movies sorted by title, then date

·         dramas are sorted by director, then title

·         classics are sorted by date, then famous actor



– Director, title, and date are stored for each movie.  Classics include the major actor. The business stores the


– Data is uniquely identified by its sorting criteria (other information not used when sorting or retrieving).

A data file is used for initializing the business.  One line in the file contains information on one item.  To facilitate processing, comedy movies are marked with an 'F' (for funny), drama movies are marked with a 'D', and classics are marked with a 'C'.  The first character of each line indicates this movie type.  After this char key is director (comma terminated), title (comma terminated), additional information (e.g., actor, always formatted as two strings, first name and last name), and then the date (ints, only year except for classics
which have month and year).  For example,

 

        F Gore Verbinski, Pirates of the Caribbean, 2003

        D Steven Spielberg, Schindler's List, 1993

        C George Cukor, Holiday, Katherine Hepburn 9 1938

        C George Cukor, Holiday, Cary Grant 9 1938

        Z Hal Ashby, Harold and Maude, Ruth Gordon 2 1971

        D Phillippe De Broca, King of Hearts, 1967

 
## Customer Data
 –  MOVIE customer information will also be found in a data file, one line per customer.  Sample data includes a unique 4-digit ID number, last name, first name.  A blank separates fields.  For example:

        1234 Mouse Mickey

## Command Data
 

– The Command text file contains an arbitrary sequence of commands, one per line. The first char of each line ('B' for  borrow, 'R' for return, 'H' to display a customer’s history) indicates the desired action for a customer, or 'S' for displaying the three categories of the business (by category, sorted within the category).  After this char key is a blank, the customer ID, type of media (currently only 'D' for DVD), and movie data based on the sorting criteria above.  A comma is after director and/or title (commas terminate in the same place as in the movie datafile described previously).  For example:

        B 1234 D C 9 1938 Katherine Hepburn

        B 1234 D F Pirates of the Caribbean, 2003

        R 1234 D C 9 1938 Katherine Hepburn

        B 1234 D D Steven Spielberg, Schindler's List,

        S

        H 1234

        X 1234 Z C 9 1938 Katherine Hepburn

        B 1234 D Y 2 1971 Ruth Gordon

        B 9999 D F Pirates of the Caribbean, 2003

        B 1234 D C 2 1975 Blah Blah
