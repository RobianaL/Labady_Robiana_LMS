/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cen3024cmodule6softwareimplementationphase1logicandfunctionality;

/**
 * Name: Robiana Labady
 * Class: CEN3024C - Software Development 1
 * Date: June 24, 2024
 * Purpose: This class includes the variables needed for the each book: title, author, barcode, genre, status, and due date.
 * Purpose(cont): Setter and getter methods are included, as well as a formatted String output.
 */

import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

class Book {
    private String title;
    private String author;
    private String barcode;
    private String genre;
    private String status;
    private Date dueDate;

    //constructor
    public Book(String title, String author, String barcode, String genre, String status, Date dueDate) {
        this.title = title;
        this.author = author;
        this.barcode = barcode;
        this.genre = genre;
        this.status = status;
        this.dueDate = dueDate;
    }

    //set title
    public void setTitle(String title) {
        this.title = title;
    }

    //get title
    public String getTitle() {
        return title;
    }

    //set suthor
    public void setAuthor(String author) {
        this.author = author;
    }

    //set author
    public String getAuthor() {
        return author;
    }

    //set barcode
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    //get barcode
    public String getBarcode() {
        return barcode;
    }

    //set genre
    public void setGenre(String genre) {
        this.genre = genre;
    }

    //get genre
    public String getGenre() {
        return genre;
    }

    
    //set status
    public void setStatus(String status) {
        this.status = status;
    }

    //get stauts
    public String getStatus() {
        return status;
    }

    //set due date
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    //get due date
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Method: toString
     * Parameters: none
     * Return: String
     * Purpose: Returns the title, author, barcode, genre, status, and due date in a formatted String
     */
    @Override
    public String toString() {
        return title + " by " + author + " (Barcode = " + barcode +
                ", Genre = " + genre + ", Status = " + status + ", Due Date = " + dueDate + ")";
    }//end toString
    
}//end Book class