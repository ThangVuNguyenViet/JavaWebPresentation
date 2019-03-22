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
public class TicketInvalid {
    private String priceAdultInvalid, priceChildInvalid, ticketLeftInvalid;

    public String getPriceAdultInvalid() {
        return priceAdultInvalid;
    }

    public void setPriceAdultInvalid(String priceAdultInvalid) {
        this.priceAdultInvalid = priceAdultInvalid;
    }

    public String getPriceChildInvalid() {
        return priceChildInvalid;
    }

    public void setPriceChildInvalid(String priceChildInvalid) {
        this.priceChildInvalid = priceChildInvalid;
    }

    public String getTicketLeftInvalid() {
        return ticketLeftInvalid;
    }

    public void setTicketLeftInvalid(String ticketLeftInvalid) {
        this.ticketLeftInvalid = ticketLeftInvalid;
    }
    
    
}
