package org.example.LLD.ParkingLotDesign.entities;

import org.example.LLD.ParkingLotDesign.enums.TicketStatus;

import java.sql.Timestamp;
import java.util.UUID;

public class ParkingTicket {
    private String ticketNumber;

    private String issuedTime;

    private String payedTime;

    private TicketStatus ticketStatus;

    private final double baseFare = 10.00;

    private final double hourFare = 15.00;


    public Double calculateFare() {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        Timestamp issueTime = new Timestamp(Long.parseLong(issuedTime));

        int remainingHours = currentTime.getHours() - issueTime.getHours() - 1;

        if(remainingHours <= 0)
            return baseFare;
        else
            return baseFare + (hourFare * remainingHours);

    }


    public ParkingTicket() {
        ticketNumber = "" + UUID.randomUUID();
        issuedTime = "" + System.currentTimeMillis();
        ticketStatus = TicketStatus.ACTIVE;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getIssuedTime() {
        return issuedTime;
    }

    public void setIssuedTime(String issuedTime) {
        this.issuedTime = issuedTime;
    }

    public String getPayedTime() {
        return payedTime;
    }

    public void setPayedTime(String payedTime) {
        this.payedTime = payedTime;
    }
}
