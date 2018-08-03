import Guests.Guest;
import RoomVariants.ConferenceRoom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    Guest ellie;
    Guest robbie;
    Guest john;
    Guest kevin;
    ConferenceRoom conferenceRoom1;

    @Before
    public void before(){
        ellie = new Guest("Ellie");
        robbie = new Guest("Robbie");
        john = new Guest("John");
        kevin = new Guest("Kevin");
        conferenceRoom1 = new ConferenceRoom(3, "The Little Room", 20);
    }

    @Test
    public void hasCapacity(){
        assertEquals(3, conferenceRoom1.getCapacity());
    }

    @Test
    public void startsWithZeroGuests(){
        assertEquals(0, conferenceRoom1.guestCount());
    }

    @Test
    public void canAddGuests(){
        conferenceRoom1.addGuest(ellie);
        conferenceRoom1.addGuest(robbie);
        assertEquals(2, conferenceRoom1.guestCount());
    }

    @Test
    public void canRemoveGuests(){
        conferenceRoom1.addGuest(ellie);
        assertEquals(1, conferenceRoom1.guestCount());
        conferenceRoom1.removeGuest(ellie);
        assertEquals(0, conferenceRoom1.guestCount());
    }

    @Test
    public void spacesLeft(){
        conferenceRoom1.addGuest(ellie);
        assertEquals(2, conferenceRoom1.spacesLeft());
    }

    @Test
    public void canNotAddGuestsWhenNoSpaces(){
        conferenceRoom1.addGuest(ellie);
        conferenceRoom1.addGuest(robbie);
        conferenceRoom1.addGuest(john);
        conferenceRoom1.addGuest(kevin);
        assertEquals(3, conferenceRoom1.guestCount());
    }

    @Test
    public void canNotRemoveGuestWhenNotFound(){
        conferenceRoom1.addGuest(ellie);
        conferenceRoom1.addGuest(robbie);
        conferenceRoom1.removeGuest(john);
        assertEquals(2, conferenceRoom1.guestCount());
    }

    //    ConferenceRoom specific tests:

    @Test
    public void hasName(){
        assertEquals("The Little Room", conferenceRoom1.getName());
    }

    @Test
    public void hasDailyRate(){
        assertEquals(20, conferenceRoom1.getDailyRate(), 0);
    }

    @Test
    public void canCalculateBill(){
        double bill = conferenceRoom1.calculateBill(3);
        assertEquals(60, bill, 0);
    }

}
