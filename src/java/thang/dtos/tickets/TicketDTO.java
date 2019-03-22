/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.dtos.tickets;

import java.io.Serializable;

/**
 *
 * @author Thang
 */
public class TicketDTO implements Serializable {
    private String startDate;
    private int ticketLeft, priceAdult, priceChild, ticketId, tourId;

    public TicketDTO(int ticketId, int tourId, String startDate, int priceAdult, int priceChild, int ticketLeft) {
        this.ticketId = ticketId;
        this.tourId = tourId;
        this.startDate = startDate;
        this.priceAdult = priceAdult;
        this.ticketLeft = ticketLeft;
        this.priceChild = priceChild;
    }

    public TicketDTO(int tourId, String startDate, int ticketLeft, int priceAdult, int priceChild) {
        this.tourId = tourId;
        this.startDate = startDate;
        this.ticketLeft = ticketLeft;
        this.priceAdult = priceAdult;
        this.priceChild = priceChild;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getPriceAdult() {
        return priceAdult;
    }

    public void setPriceAdult(int priceAdult) {
        this.priceAdult = priceAdult;
    }

    public int getTicketLeft() {
        return ticketLeft;
    }

    public void setTicketLeft(int ticketLeft) {
        this.ticketLeft = ticketLeft;
    }

    public int getPriceChild() {
        return priceChild;
    }

    public void setPriceChild(int priceChild) {
        this.priceChild = priceChild;
    }
}
