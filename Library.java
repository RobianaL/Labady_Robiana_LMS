/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cen3024cmodule6softwareimplementationphase1logicandfunctionality;

/**
 * Name: Robiana Labady
 * Class: CEN3024C - Software Development 1
 * Date: June 24, 2024
 * Purpose: This class includes methods for the actions the user can take regarding the collection.
 * Purpose(cont): The user can add books or remove them from the collection using its barcode or book title,
 * Purpose(cont): check in and out books, and list all books currently in the collection.
*/

import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

class Library {
    private List<Book> collection = new ArrayList<>();

    /**
     * Method: addBook
     * Parameters: Book book
     * Return: none
     * Purpose: Adds a new book to the collection and then confirms the addition was successful
     */
    public void addBook(Book book) {
        collection.add(book);
        System.out.println("\nYou have added " + book + " to the Library's Collection.\n");
    }//end addBook

    /**
     * Method: removeBookByBarcode
     * Parameters: String barcode
     * Return: none
     * Purpose: Removes a book from the collection based on the barcode the user entered and then confirmations the removal was successful
     * Purpose(cont): An error message is outputted if the entered book ID is not found in the collection
     */
    public void removeBookByBarcode(String barcode) {
        Book removeBookByBarcode = null;
        
        for (Book book : collection){
            if (book.getBarcode() == barcode){
                removeBookByBarcode = book;
                break;
            }//end if
        }//end for
        
        if (removeBookByBarcode != null){
            collection.remove(removeBookByBarcode);
            System.out.println("\nYou have removed " + removeBookByBarcode + " from CEN3024C's library collection.\n\n");
        }//end if
        else {
            System.out.println("\nNo books have been found with the barcode " + barcode + " in CEN3024C's library collection.\n\n"); 
        }//end else
    }//end removeBookByBarcode

    /**
     * Method: removeBookByTitle
     * Parameters: String title
     * Return: none
     * Purpose: Removes a book from the collection based on the ID number the user entered and then confirmations the removal was successful
     * Purpose(cont): An error message is outputted if the entered book ID is not found in the collection
     */
    public void removeBookByTitle(String title) {
        Book removeBookByTitle = null;
        
        for (Book book : collection){
            if (book.getTitle() == title){
                removeBookByTitle = book;
                break;
            }//end if
        }//end for
        
        if (removeBookByTitle != null){
            collection.remove(removeBookByTitle);
            System.out.println("\nYou have removed " + removeBookByTitle + " from CEN3024C's library collection.\n\n");
        }//end if
        else {
            System.out.println("\nNo books have been found with the title " + title + " in CEN3024C's library collection.\n\n"); 
        }//end else
    }//end removeBookByTitle

    /**
     * Method: checkOutBook
     * Parameters: String title
     * Return: none
     * Purpose: Checks out a book by its title, sets its status to "checked out", and assigns a due date
     */

    public void checkOutBook(String title) {
        for (Book book : collection) {
            if (book.getTitle().equals(title) && book.getStatus().equals("checked in")) {
                book.setStatus("checked out");
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.WEEK_OF_YEAR, 4);
                book.setDueDate(cal.getTime());
                System.out.println("\nYou have checked out " + book + ".\n");
                return;
            }//end if
        }//end for
        System.out.println("\nError: Your book is already checked out or not found.");
    }//end checkOutBook

    /**
     * Method: checkInBook
     * Parameters: String title
     * Return: none
     * Purpose: Checks in a book by its title and sets its status to "checked in"
     */
    public void checkInBook(String title) {
        for (Book book : collection) {
            if (book.getTitle().equals(title) && book.getStatus().equals("checked out")) {
                book.setStatus("checked in");
                book.setDueDate(null);
                System.out.println("\nYou have checked in " + book + ".\n");
                return;
            }//end if
        }//end for
        System.out.println("\nError: Your book is already checked in or not found.");
    }//end checkInBook

    /**
     * Method: listAllBooks
     * Parameters: none
     * Return: none
     * Purpose: Lists all of the books that are currently in the collection
     * Purpose(cont): A message is outputted if the collection is empty (this means that there are no books in the collection)
     */
    public void listAllBooks() {
        if (collection.isEmpty()) {
            System.out.println("\nThere are no books in the Library's collection. :(");
        }//end if
        else {
            for (Book book : collection) {
                System.out.println(book);
            }//end for
        }//end else
    }//end listAllBooks
    
}//end Library class
