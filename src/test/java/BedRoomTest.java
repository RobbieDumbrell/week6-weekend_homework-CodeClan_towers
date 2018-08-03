import Guests.Guest;
import RoomVariants.BedRoom;
import RoomVariants.Enums.BedRoomType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedRoomTest {
    Guest ellie;
    Guest robbie;
    Guest john;
    BedRoom doubleBedroom;
    BedRoom singleBedroom;

    @Before
    public void before(){
        ellie = new Guest("Ellie");
        robbie = new Guest("Robbie");
        john = new Guest("John");
        doubleBedroom = new BedRoom(87, BedRoomType.DOUBLE, 30);
        singleBedroom = new BedRoom(43, BedRoomType.SINGLE, 15);
    }

    @Test
    public void hasCapacityDouble(){
        assertEquals(2, doubleBedroom.getCapacity());
    }

    @Test
    public void hasCapacitySingle(){
        assertEquals(1, singleBedroom.getCapacity());
    }

    @Test
    public void startsWithZeroGuests(){
        assertEquals(0, doubleBedroom.guestCount());
    }

    @Test
    public void canAddGuests(){
        doubleBedroom.addGuest(ellie);
        doubleBedroom.addGuest(robbie);
        assertEquals(2, doubleBedroom.guestCount());
    }

    @Test
    public void canRemoveGuests(){
        doubleBedroom.addGuest(ellie);
        assertEquals(1, doubleBedroom.guestCount());
        doubleBedroom.removeGuest(ellie);
        assertEquals(0, doubleBedroom.guestCount());
    }

    @Test
    public void spacesLeft(){
        doubleBedroom.addGuest(ellie);
        assertEquals(1, doubleBedroom.spacesLeft());
    }

    @Test
    public void canNotAddGuestsWhenNoSpaces(){
        doubleBedroom.addGuest(ellie);
        doubleBedroom.addGuest(robbie);
        doubleBedroom.addGuest(john);
        assertEquals(2, doubleBedroom.guestCount());
    }

    @Test
    public void canNotRemoveGuestWhenNotFound(){
        doubleBedroom.addGuest(ellie);
        doubleBedroom.addGuest(robbie);
        doubleBedroom.removeGuest(john);
        assertEquals(2, doubleBedroom.guestCount());
    }

//    BedRoom specific tests:

    @Test
    public void hasRoomNumber(){
        assertEquals(87, doubleBedroom.getRoomNumber());
    }

    @Test
    public void hasBedRoomType(){
        assertEquals(BedRoomType.DOUBLE, doubleBedroom.getType());
    }

    @Test
    public void hasNightlyRate(){
        assertEquals(30, doubleBedroom.getNightlyRate(), 0);
    }

    @Test
    public void canCalculateBill(){
        double bill = doubleBedroom.calculateBill(4);
        assertEquals(120, bill, 0);
    }

}


