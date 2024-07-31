/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cen3024clms;

/**
 * Name: Robiana Labady
 * Class: CEN3024C - Software Development 1
 * Date: July 30, 2024
 * Purpose: This program will be used by librarians to manage the books in their library.
 * Purpose(cont): The librarian will be able to add and remove books, check out/check in books, and list all books currently in the collection.
 */
import javax.swing.*;
import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CEN3024CLMS extends JFrame {
    private static Library library = new Library();

    /**
     * Method: main
     * Parameters: String[] args
     * Return: none
     * Purpose: Prints out the system menu options and prompts the user to click on a button option from the menu
     * Purpose(cont): Contains JPanel, JFrame, JLabel, & JButtons with action listeners.
     */

    private JPanel menu;
    private JFrame frame;
    private JLabel mainMenu;
    private JButton addANewBookButton;
    private JButton removeBookByBarcodeButton;
    private JButton removeBookByTitleButton;
    private JButton listAllBooksInButton;
    private JButton checkOutBookButton;
    private JButton checkInBookButton;
    private JButton exitSystemMenuButton;

    public static void main(String[] args) {
        //setting up the basics
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //set the frame positions/size
        int frameWidth = 250;
        int frameHeight = 350;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setBounds(
                (int) screenSize.getWidth()/2 - frameWidth,
                (int) screenSize.getHeight()/2 - frameHeight,
                frameWidth,
                frameHeight);
        frame.setVisible(true);

        frame.setTitle("Library Management System");

        //set up contents of the frame
        frame.setLayout(new GridLayout(8, 2));

        //main menu label
        JLabel mainMenu = new JLabel("                      Main Menu");
        frame.add(mainMenu);

        //add new book button
        JButton addANewBookButton = new JButton("Add New Book");
        frame.add(addANewBookButton);

        addANewBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = JOptionPane.showInputDialog("Enter the file path:");
                if (filePath != null) {
                    addANewBookFromFile(filePath);
                }//end if
            }//end actionPerformed
        });//end add new book action listener

        //remove book by barcode button
        JButton removeBookByBarcodeButton = new JButton("Remove Book by Barcode");
        frame.add(removeBookByBarcodeButton);

        removeBookByBarcodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String barcode = JOptionPane.showInputDialog("Enter the barcode:");
                if (barcode != null) {
                    library.removeBookByBarcode(barcode);
                }//end if
            }//end actionPerformed
        });//end remove book by barcode action listener


        //remove book by title button
        JButton removeBookByTitleButton = new JButton("Remove Book by Title");
        frame.add(removeBookByTitleButton);

        removeBookByTitleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter the title:");
                if (title != null) {
                    library.removeBookByTitle(title);
                }//end if
            }//end actionPerformed
        });//end remove book by title action listener

        //list all books in collection button
        JButton listAllBooksInButton = new JButton("List All Books");
        frame.add(listAllBooksInButton);

        listAllBooksInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listAllBooksInCollection();
            }//end actionPerformed
        });//end list all books in collection action listener

        //check in book button
        JButton checkOutBookButton = new JButton("Check Out Book");
        frame.add(checkOutBookButton);

        checkOutBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter the title:");
                if (title != null) {
                    library.checkOutBook(title);
                }//end if
            }//end actionPerformed
        });//end check out book action listener

        //check out book button
        JButton checkInBookButton = new JButton("Check In Book");
        frame.add(checkInBookButton);

        checkInBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter the title:");
                if (title != null) {
                    library.checkInBook(title);
                }//end if
            }//end actionPerformed
        });//end check in book action listener

        //exit system menu button
        JButton exitSystemMenuButton = new JButton("Exit System Menu");
        frame.add(exitSystemMenuButton);

        exitSystemMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Thank you for using CEN3024C's Library System! :)");
                System.exit(0);
            }//end actionPerformed
        });//end exit menu action listener

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
                }//end if

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

}//end CEN3024CLMS class
