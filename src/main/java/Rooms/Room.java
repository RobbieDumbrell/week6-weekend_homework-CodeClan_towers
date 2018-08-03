package Rooms;

import Guests.Guest;

import java.util.ArrayList;

public abstract class Room {

    protected int capacity;
    private ArrayList<Guest> currentGuests;

    public Room(int capacity){
        this.capacity = capacity;
        this.currentGuests = new ArrayList<>();
    }

    public int getCapacity(){
        return this.capacity;
    }

    public ArrayList<Guest> getCurrentGuests() {
        return this.currentGuests;
    }

    public int guestCount(){
        return this.currentGuests.size();
    }

    public int spacesLeft(){
        return (this.capacity - this.guestCount());
    }

    public void addGuest(Guest guest){
        if(this.spacesLeft() > 0){
            this.currentGuests.add(guest);
        }
    }

    public void removeGuest(Guest guest){
        if(this.currentGuests.contains(guest)){
            this.currentGuests.remove(guest);
        }
    }



}
