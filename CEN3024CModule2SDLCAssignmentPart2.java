/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cen3024cmodule2sdlcassignmentpart2;

/**
 * Name: Robiana Labady
 * Class: CEN3024C - Software Development 1
 * Date: May 26, 2024
 * Purpose: This program will be used by librarians to manage the books in their library.
 * Purpose(cont): The librarian will be able to add and remove books, as well as list all books currently in the collection.
*/

import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

/**
 *
 * @author robianalabady
 */
public class CEN3024CModule2SDLCAssignmentPart2 {
    private static Library library = new Library();
    
    /**
     * Method: main
     * Parameters: String[] args
     * Return: none
     * Purpose: Prints out the system menu options and prompts the user to enter a number from 1-4
     * Purpose(cont): Contains switch that provides the options for the user to choose from
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.println("CEN3024C's Library System Menu:\n");
            System.out.println("1. Add a new book");
            System.out.println("2. Remove a currentl book");
            System.out.println("3. List all books in the collection");
            System.out.println("4. Exit system menue");
            System.out.println("\nPlease choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); //new line :)
            
            switch (choice){
                case 1:
                    System.out.println("\nEnter your book's file path: ");
                    String filePath = scanner.nextLine();
                    Path path = Paths.get(filePath);
                    addANewBookFromFile(filePath);
                    break;
                    
                case 2:
                    System.out.println("\nEnter the ID of the book you want to remove: ");
                    int ID = scanner.nextInt();
                    removeABookWithID(ID);
                    break;
                    
                case 3:
                    listAllBooksInCollection();
                    break;
                
                case 4:
                    System.out.println("\nThank you for using CEN3024C's Library System! :)");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("\nYou have entered an invalid choice. Please try again.\n\n");
                
            }//end switch
            
        }//end while
        
    }//end main
    
    /**
     * Method: addANewBookFromFile
     * Parameters: String filePath
     * Return: none
     * Purpose: Adds a new book to the collection from the text file path entered by the user
     * Purpose(cont): Catches exceptions for any reading errors and invalid formatting
     */
    public static void addANewBookFromFile(String filePath){
        Scanner scanner = new Scanner(System.in);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            
            while ((line = reader.readLine()) != null){
                String[] bookInfo = line.split(",");
                
                if (bookInfo.length != 3){
                    System.out.println("\nPlease ensure that your book's information in the following format:");
                    System.out.println("Book ID,Book Title,Book's Author\n\n");
                    continue;
                }//end if
                
                int ID = Integer.parseInt(bookInfo[0].trim());
                String title = bookInfo[1].trim();
                String author = bookInfo[2].trim();
                Book book = new Book(ID, title, author);
                library.addBook(book);
                
                return;
            }//end while
            
        }//end try
        catch (IOException e){
            System.out.println("\nThere has been an error reading your file.\n\n");
        }//end file catch
        
    }//end addANewBookFromFile
    
    /**
     * Method: removeABookWithID
     * Parameters: int ID
     * Return: none
     * Purpose: Removes a book from the collection based on the ID entered by the user
     */
    private static void removeABookWithID(int ID){
        library.removeBook(ID);
    }//end removeABookWithID
    
    /**
     * Method: listAllBooksInCollection
     * Parameters: none
     * Return: none
     * Purpose: Lists all of the books currently in the collection
     */
    private static void listAllBooksInCollection(){
        System.out.println("\n");
        library.listAllBooks();
        System.out.println("\n\n");
    }
    
}//end CEN3024CModule2SDLCAssignmentPart2 class
