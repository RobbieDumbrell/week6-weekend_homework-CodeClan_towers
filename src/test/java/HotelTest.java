import Guests.Guest;
import Hotel.Hotel;
import RoomVariants.BedRoom;
import RoomVariants.ConferenceRoom;
import RoomVariants.DiningRoom;
import RoomVariants.Enums.BedRoomType;
import Rooms.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Guest ellie;
    Guest robbie;
    Guest john;
    BedRoom suiteBedroom;
    BedRoom twinBedroom;
    BedRoom singleBedroom;
    ConferenceRoom conferenceRoom1;
    ConferenceRoom conferenceRoom2;
    DiningRoom diningRoom;
    Hotel codeClanTowers;

    @Before
    public void before(){
        ellie = new Guest("Ellie");
        robbie = new Guest("Robbie");
        john = new Guest("John");
        suiteBedroom = new BedRoom(87, BedRoomType.SUITE, 30);
        twinBedroom = new BedRoom(43, BedRoomType.TWIN, 15);
        singleBedroom = new BedRoom(53, BedRoomType.SINGLE, 10);
        conferenceRoom1 = new ConferenceRoom(5, "The Average Room", 20);
        conferenceRoom2 = new ConferenceRoom(10, "The Big Room", 40);
        diningRoom = new DiningRoom(20);
        codeClanTowers = new Hotel("CodeClan Towers");

        codeClanTowers.addRoomCategory("Bedrooms");
        codeClanTowers.addRoomCategory("Conference Rooms");
        codeClanTowers.addRoomCategory("Dining Rooms");

        codeClanTowers.addRoom("Bedrooms", suiteBedroom);
        codeClanTowers.addRoom("Bedrooms", singleBedroom);
        codeClanTowers.addRoom("Conference Rooms", conferenceRoom1);
        codeClanTowers.addRoom("Conference Rooms", conferenceRoom2);
        codeClanTowers.addRoom("Dining Rooms", diningRoom);

    }

    @Test
    public void hasName(){
        assertEquals("CodeClan Towers", codeClanTowers.getName());
    }

    @Test
    public void hasRooms(){
        assertEquals(3, codeClanTowers.getAllRooms().size());
    }

    @Test
    public void canGetAllRoomsOfACategory(){
        assertEquals(1, codeClanTowers.getCategoryRooms("Dining Rooms").size());
        assertEquals(2, codeClanTowers.getCategoryRooms("Bedrooms").size());
    }

    @Test
    public void canGetAllRoomCategories(){
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Dining Rooms");
        expected.add("Bedrooms");
        expected.add("Conference Rooms");
        assertEquals(expected, codeClanTowers.getRoomCategories());
    }

    @Test
    public void canAddRoomCategory(){
        codeClanTowers.addRoomCategory("Test");
        assertEquals(4, codeClanTowers.getAllRooms().size());
    }

    @Test
    public void canAddRoomToHotel(){
        codeClanTowers.addRoom("Bedrooms", twinBedroom);
        ArrayList<Room> expectedRooms = new ArrayList<>();
        expectedRooms.add(suiteBedroom);
        expectedRooms.add(singleBedroom);
        expectedRooms.add(twinBedroom);
        assertEquals(expectedRooms, codeClanTowers.getAllRooms().get("Bedrooms"));
    }

    @Test
    public void canNotAddRoomToHotelWithInvalidCategory(){
        codeClanTowers.addRoom("BlahBlah", twinBedroom);
        assertEquals(3, codeClanTowers.getAllRooms().size());
    }

    @Test
    public void canCheckInGuestToSpecificRoom(){
        codeClanTowers.checkInGuest(robbie, "Bedrooms", suiteBedroom);
        assertEquals(1, suiteBedroom.guestCount());
    }

    @Test
    public void canNotCheckInGuestToRoomNotInHotel(){
        codeClanTowers.checkInGuest(ellie, "Bedrooms", twinBedroom);
        assertEquals(0, twinBedroom.guestCount());
    }

    @Test
    public void canNotCheckInGuestTwiceToSameRoom(){
        codeClanTowers.checkInGuest(ellie, "Bedrooms", suiteBedroom);
        codeClanTowers.checkInGuest(ellie, "Bedrooms", suiteBedroom);
        assertEquals(1, suiteBedroom.guestCount());
    }

    @Test
    public void canCheckOutGuest(){
        codeClanTowers.checkInGuest(robbie, "Bedrooms", suiteBedroom);
        assertEquals(1, suiteBedroom.guestCount());
        codeClanTowers.checkOutGuest(robbie, "Bedrooms", suiteBedroom);
        assertEquals(0, suiteBedroom.guestCount());
    }

    @Test
    public void canNotCheckOutGuestFromWrongRoom(){
        codeClanTowers.checkInGuest(robbie, "Bedrooms", suiteBedroom);
        assertEquals(1, suiteBedroom.guestCount());
        codeClanTowers.checkOutGuest(robbie, "Conference Rooms", conferenceRoom1);
        assertEquals(1, suiteBedroom.guestCount());
        assertEquals(0, conferenceRoom1.guestCount());
    }

    @Test
    public void canGetListOfCurrentGuestsFromRoom(){
        codeClanTowers.checkInGuest(robbie, "Bedrooms", suiteBedroom);
        codeClanTowers.checkInGuest(ellie, "Bedrooms", suiteBedroom);
        ArrayList<Guest> expectedGuests = new ArrayList<>();
        expectedGuests.add(robbie);
        expectedGuests.add(ellie);
        assertEquals(expectedGuests, codeClanTowers.listGuests("Bedrooms", suiteBedroom));
    }

    @Test
    public void canListEmptyRoomsInARoomCategory(){
        codeClanTowers.checkInGuest(robbie, "Bedrooms", suiteBedroom);
        ArrayList<Room> expectedRooms = new ArrayList<>();
        expectedRooms.add(singleBedroom);
        assertEquals(expectedRooms, codeClanTowers.listEmptyRooms("Bedrooms"));
    }

}
