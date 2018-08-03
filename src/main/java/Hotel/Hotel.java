package Hotel;

import Guests.Guest;
import Rooms.Room;

import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private String name;
    private HashMap<String, ArrayList<Room>> rooms;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public HashMap getRooms() {
        return this.rooms;
    }

    public void addRoomCategory(String roomCategory) {
        rooms.put(roomCategory, new ArrayList<>());
    }

    public void addRoom(String roomCategory, Room newRoom) {
        ArrayList<Room> roomsInCategory = rooms.get(roomCategory);
        roomsInCategory.add(newRoom);
    }

    public void checkInGuest(Guest guest, String roomCategory, Room room) {
        ArrayList<Room> roomsInCategory = rooms.get(roomCategory);
        if (roomsInCategory.contains(room)) {
            room.addGuest(guest);
        }
    }

    public void checkOutGuest(Guest guest, String roomCategory, Room room) {
        ArrayList<Room> roomsInCategory = rooms.get(roomCategory);
        if (roomsInCategory.contains(room)) {
            room.removeGuest(guest);
        }
    }

    public ArrayList<Guest> listGuests(String roomCategory, Room room) {
        ArrayList<Room> roomsInCategory = rooms.get(roomCategory);
        if (roomsInCategory.contains(room)) {
            return room.getCurrentGuests();
        } else {
            return new ArrayList<>();
        }
    }

    public ArrayList<Room> listEmptyRooms(String roomCategory){
        ArrayList<Room> roomsInCategory = rooms.get(roomCategory);
        ArrayList<Room> EmptyRoomsInCategory = new ArrayList<>();

        for (Room room: roomsInCategory){
            if (room.guestCount() == 0){
                EmptyRoomsInCategory.add(room);
            }
        }
        return EmptyRoomsInCategory;
    }


}
