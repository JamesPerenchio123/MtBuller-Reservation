package stage2_James;

import java.io.*;
import java.time.*;

/**
 * booking class
 */

public class Booking {
    private int bookingId;
    private int custId;
    private int PCNo;
    private String startDate;
    private int duration;
    private double cost;
    static int nextID = 10;
    public Booking () {
        bookingId = nextID++;
    }

    public Booking (int custId, int PCNo, String startDate, int duration) {
        this.custId = custId;
        this.PCNo = PCNo;
        this.startDate = startDate;
        this.duration = duration;
        bookingId = nextID++;
    }
    public Booking (int custId, String startDate, int duration) {
        this.custId = custId;
        this.startDate = startDate;
        this.duration = duration;
        bookingId= nextID++;
    }

    public Booking (int custId,  int duration) {
        this.custId = custId;
        this.duration = duration;
        bookingId = nextID++;
    }
    public int getBookingId () {
        return bookingId;
    }

    public int getCustId () {
        return custId;
    }

    public String getDate () {
        return startDate;
    }

    public int getDuration () {
        return duration;
    }

    public int getPCNo () {
        return PCNo;
    }

    public void setTotalCost(double cost){
        this.cost = cost;
    }

    public void setDate (String dateStr) {
        startDate = dateStr;
    }

    public void setDuration (int duration){
        this.duration = duration;
    }

    public void setRoomNo (int PCNo) {
        this.PCNo = PCNo;
    }

    public double getTotalCost(){
        return cost;
    }

    public String toString () {
        return "Booking ID: " + bookingId+ ", customer ID: " + custId + ", start date: " + startDate + ", duration: " + duration +
                "\nPC #: " + PCNo + "\n";
    }

}