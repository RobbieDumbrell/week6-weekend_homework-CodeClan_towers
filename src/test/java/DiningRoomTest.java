import Guests.Guest;
import RoomVariants.ConferenceRoom;
import RoomVariants.DiningRoom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    Guest ellie;
    Guest robbie;
    Guest john;
    Guest kevin;
    DiningRoom diningRoom;
    DiningRoom miniDiningRoom;

    @Before
    public void before(){
        ellie = new Guest("Ellie");
        robbie = new Guest("Robbie");
        john = new Guest("John");
        kevin = new Guest("Kevin");
        diningRoom = new DiningRoom(30);
        miniDiningRoom = new DiningRoom(2);
    }

    @Test
    public void hasCapacity(){
        assertEquals(30, diningRoom.getCapacity());
    }

    @Test
    public void startsWithZeroGuests(){
        assertEquals(0, diningRoom.guestCount());
    }

    @Test
    public void canAddGuests(){
        diningRoom.addGuest(ellie);
        diningRoom.addGuest(robbie);
        assertEquals(2, diningRoom.guestCount());
    }

    @Test
    public void canRemoveGuests(){
        diningRoom.addGuest(ellie);
        assertEquals(1, diningRoom.guestCount());
        diningRoom.removeGuest(ellie);
        assertEquals(0, diningRoom.guestCount());
    }

    @Test
    public void spacesLeft(){
        diningRoom.addGuest(ellie);
        assertEquals(29, diningRoom.spacesLeft());
    }

    @Test
    public void canNotAddGuestsWhenNoSpaces(){
        miniDiningRoom.addGuest(ellie);
        miniDiningRoom.addGuest(robbie);
        miniDiningRoom.addGuest(john);
        assertEquals(2, miniDiningRoom.guestCount());
    }

    @Test
    public void canNotRemoveGuestWhenNotFound(){
        diningRoom.addGuest(ellie);
        diningRoom.addGuest(robbie);
        diningRoom.removeGuest(john);
        assertEquals(2, diningRoom.guestCount());
    }
}
