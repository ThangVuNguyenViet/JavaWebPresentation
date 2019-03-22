/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.dtos.tickets;

/**
 *
 * @author Thang
 */
public class TicketDetailDTO {
    private String startDate, tourName, imgUrl;
    private int ticketLeft, priceAdult, priceChild, ticketId, tourId;

    public TicketDetailDTO() {
    }

    public TicketDetailDTO(String startDate, String tourName, String imgUrl, int ticketLeft, int priceAdult, int priceChild, int ticketId, int tourId) {
        this.startDate = startDate;
        this.tourName = tourName;
        this.imgUrl = imgUrl;
        this.ticketLeft = ticketLeft;
        this.priceAdult = priceAdult;
        this.priceChild = priceChild;
        this.ticketId = ticketId;
        this.tourId = tourId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getTicketLeft() {
        return ticketLeft;
    }

    public void setTicketLeft(int ticketLeft) {
        this.ticketLeft = ticketLeft;
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
}
