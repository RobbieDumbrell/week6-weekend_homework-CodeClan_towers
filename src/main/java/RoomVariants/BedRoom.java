package RoomVariants;

import RoomVariants.Enums.BedRoomType;
import Rooms.Room;

public class BedRoom extends Room {

    private int roomNumber;
    private BedRoomType type;
    private double nightlyRate;

    public BedRoom(int roomNumber, BedRoomType type, double nightlyRate){
        super(type.getCapacity());
        this.roomNumber = roomNumber;
        this.type = type;
        this.nightlyRate = nightlyRate;
    }

    public int getRoomNumber(){
        return this.roomNumber;
    }

    public BedRoomType getType(){
        return this.type;
    }

    public double getNightlyRate(){
        return this.nightlyRate;
    }

    public double calculateBill(int nights){
        return (this.nightlyRate * nights);
    }


}
