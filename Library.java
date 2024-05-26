/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cen3024cmodule2sdlcassignmentpart2;

/**
 * Name: Robiana Labady
 * Class: CEN3024C - Software Development 1
 * Date: May 26, 2024
 * Purpose: This class includes methods for the actions the user can take regarding the collection.
 * Purpose(cont): The user can add and remove books from the collection, and list all books currently in the collection
*/

import java.util.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robianalabady
 */
public class Library {
    private List<Book> collection;
    
    //creates new array list named "collection"
    public Library(){
        collection = new ArrayList<>();
    }
    
    /**
     * Method: addBook
     * Parameters: Book book
     * Return: none
     * Purpose: Adds a new book to the collection and then confirmations the addition was successful
     */
    public void addBook(Book book){
        collection.add(book);
        System.out.println("\nYou have added " + book + " to the Library's Collection.\n\n");
    }//end addBook method
    
    /**
     * Method: removeBook
     * Parameters: int ID
     * Return: none
     * Purpose: Removes a book from the collection based on the ID number the user entered and then confirmations the removal was successful
     * Purpose(cont): An error message is outputted if the entered book ID is not found in the collection
     */
    public void removeBook(int ID){
        Book removeThisBook = null;
        
        for (Book book : collection){
            if (book.getID() == ID){
                removeThisBook = book;
                break;
            }//end if
        }//end for
        
        if (removeThisBook != null){
            collection.remove(removeThisBook);
            System.out.println("\nYou have removed " + removeThisBook + " from CEN3024C's library collection.\n\n");
        }//end if
        else {
            System.out.println("\nNo books have been found with the ID " + ID + " in CEN3024C's library collection.\n\n"); 
        }//end else
        
    }//end removeBook method
    
    /**
     * Method: listAllBooks
     * Parameters: none
     * Return: none
     * Purpose: Lists all of the books that are currently in the collection
     * Purpose(cont): A message is outputted if the collection is empty (this means that there are no books in the collection)
     */
    public void listAllBooks(){
        if (collection.isEmpty()){
            System.out.println("There are no books in CEN3024C's library collection.");
        }//end if
        else {
            for (Book book : collection){
                System.out.println(book);
            }//end for
        }//end else
        
    }//end listAllBooks
    
}//end Library class
