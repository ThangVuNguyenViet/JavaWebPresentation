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
public class BookDetailDTO implements Serializable {
    int bookId, ticketId, adultQuant, childQuant;
    String username, tourName, startDate, imgUrl;
    int priceAdult, priceChild;
    long total;

    public BookDetailDTO(int bookId, int ticketId, int adultQuant, int childQuant, String username, String tourName, String startDate) {
        this.bookId = bookId;
        this.ticketId = ticketId;
        this.adultQuant = adultQuant;
        this.childQuant = childQuant;
        this.username = username;
        this.tourName = tourName;
        this.startDate = startDate;
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

    public int getChildQuant() {
        return childQuant;
    }

    public void setChildQuant(int childQuant) {
        this.childQuant = childQuant;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getPriceAdult() {
        return priceAdult;
    }

    public void setPriceAdult(int priceAdult) {
        this.priceAdult = priceAdult;
    }

    public int getPriceChild() {
        return priceChild;
    }

    public void setPriceChild(int priceChild) {
        this.priceChild = priceChild;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
