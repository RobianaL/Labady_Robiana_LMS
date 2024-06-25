/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cen3024cmodule6softwareimplementationphase1logicandfunctionality;

/**
 * Name: Robiana Labady
 * Class: CEN3024C - Software Development 1
 * Date: June 24, 2024
 * Purpose: This program will be used by librarians to manage the books in their library.
 * Purpose(cont): The librarian will be able to add and remove books, check out/check in books, and list all books currently in the collection.
 */

import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author robianalabady
 */

public class CEN3024CModule6SoftwareImplementationPhase1LogicAndFunctionality {

    private static Library library = new Library();

    /**
     * Method: main
     * Parameters: String[] args
     * Return: none
     * Purpose: Prints out the system menu options and prompts the user to enter a number from 1-7
     * Purpose(cont): Contains switch that provides the options for the user to choose from
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\nCEN3024C's Library System Menu:\n");
            System.out.println("1. Add a new book");
            System.out.println("2. Remove a book by barcode");
            System.out.println("3. Remove a book by title");
            System.out.println("4. List all books in the collection");
            System.out.println("5. Check out a book");
            System.out.println("6. Check in a book");
            System.out.println("7. Exit system menu");
            System.out.print("\nPlease choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("\nEnter your book's file path: ");
                    String filePath = scanner.nextLine();
                    addANewBookFromFile(filePath);
                    break;
                case 2:
                    System.out.print("\nEnter the barcode of the book you want to remove: ");
                    String barcode = scanner.nextLine();
                    library.removeBookByBarcode(barcode);
                    break;
                case 3:
                    System.out.print("\nEnter the title of the book you want to remove: ");
                    String title = scanner.nextLine();
                    library.removeBookByTitle(title);
                    break;
                case 4:
                    listAllBooksInCollection();
                    break;
                case 5:
                    System.out.print("\nEnter the title of the book you want to check out: ");
                    title = scanner.nextLine();
                    library.checkOutBook(title);
                    break;
                case 6:
                    System.out.print("\nEnter the title of the book you want to check in: ");
                    title = scanner.nextLine();
                    library.checkInBook(title);
                    break;
                case 7:
                    System.out.println("\nThank you for using CEN3024C's Library System! :)");
                    scanner.close();
                    return;
                default:
                    System.out.println("\nYou have entered an invalid choice. Please try again.\n");
            }//end switch
            
        }//end while
        
    }//end main

    /**
     * Method: addANewBookFromFile
     * Parameters: String filePath
     * Return: none
     * Purpose: Adds a new book to the collection from the text file path entered by the user
     * Purpose(cont): Reads the file line by line, parses the book information, and then adds the book to the library
     * Purpose(cont): Catches exceptions for any reading errors and invalid formatting
     */
    public static void addANewBookFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookInfo = line.split(",");
                if (bookInfo.length != 6) {
                    System.out.println("\nPlease ensure that your book's information is in the following format:");
                    System.out.println("Title,Author,Barcode,Genre,Status,DueDate\n");
                    continue;
                }

                String title = bookInfo[0].trim();
                String author = bookInfo[1].trim();
                String barcode = bookInfo[2].trim();
                String genre = bookInfo[3].trim();
                String status = bookInfo[4].trim();
                Date dueDate = bookInfo[5].equals("null") ? null : new SimpleDateFormat("mm/dd/yyyy").parse(bookInfo[5].trim());

                Book book = new Book(title, author, barcode, genre, status, dueDate);
                library.addBook(book);
            }//end while
        }//end try
        catch (IOException | ParseException e) {
            System.out.println("\nThere has been an error reading your file.\n");
        }//end catch
    }//end addANewBookFromFile

    /**
     * Method: listAllBooksInCollection
     * Parameters: none
     * Return: none
     * Purpose: Lists all of the books currently in the collection
     */
    private static void listAllBooksInCollection() {
        System.out.println("\n\nAll Current Books in CEN3024C's Library System:\n");
        library.listAllBooks();
        System.out.println();
    }//end listAllBooksInCollection
    
}//end CEN3024CModule6SoftwareImplementationPhase1LogicAndFunctionality class
