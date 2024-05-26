/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cen3024cmodule2sdlcassignmentpart2;

/**
 * Name: Robiana Labady
 * Class: CEN3024C - Software Development 1
 * Date: May 26, 2024
 * Purpose: This class includes the variables needed for the each book: an ID, title, and author.
 * Purpose(cont): Setter and getter methods are included, as well as a formatted String output.
 */

import java.util.*;

/**
 *
 * @author robianalabady
 */
public class Book {
    private int ID;
    private String title;
    private String author;
    
    //constructor
    public Book(int ID, String title, String author) {
        this.ID = ID;
        this.title = title;
        this.author = author;
    }

    //get ID
    public int getID() {
        return ID;
    }

    //set ID
    public void setID(int ID) {
        this.ID = ID;
    }

    // get title
    public String getTitle() {
        return title;
    }

    //set title
    public void setTitle(String title) {
        this.title = title;
    }

    //get author
    public String getAuthor() {
        return author;
    }

    //set author
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Method: toString
     * Parameters: none
     * Return: String
     * Purpose: Returns the ID, title, and author in a formatted String
     */
    @Override
    public String toString() {
        return ID + "," + title + "," + author; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}//end Book class