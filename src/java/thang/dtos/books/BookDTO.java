/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.dtos.books;

import java.io.Serializable;

/**
 *
 * @author Thang
 */
public class BookDTO implements Serializable {
    private int bookId, ticketId, adultQuant, childQuant;
    private String username;

    public BookDTO(int bookId, int ticketId, int adultQuant, int childQuant, String username) {
        this.bookId = bookId;
        this.ticketId = ticketId;
        this.adultQuant = adultQuant;
        this.childQuant = childQuant;
        this.username = username;
    }

    public BookDTO(int ticketId, int adultQuant, int childQuant, String username) {
        this.ticketId = ticketId;
        this.adultQuant = adultQuant;
        this.childQuant = childQuant;
        this.username = username;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getAdultQuant() {
        return adultQuant;
    }

    public void setAdultQuant(int adultQuant) {
        this.adultQuant = adultQuant;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getChildQuant() {
        return childQuant;
    }

    public void setChildQuant(int childQuant) {
        this.childQuant = childQuant;
    }
}
