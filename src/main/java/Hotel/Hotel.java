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

    public HashMap getAllRooms() {
        return this.rooms;
    }

    public ArrayList<Room> getCategoryRooms(String roomCategory) {
        ArrayList<Room> roomsInCategory = rooms.get(roomCategory);
        return roomsInCategory;
    }

    public ArrayList<String> getRoomCategories() {
        ArrayList<String> categoriesList = new ArrayList<String>(rooms.keySet());
        return categoriesList;
    }

    public void addRoomCategory(String roomCategory) {
        rooms.put(roomCategory, new ArrayList<>());
    }

    public boolean addRoom(String roomCategory, Room newRoom) {
        if (rooms.containsKey(roomCategory) == true) {
            ArrayList<Room> roomsInCategory = rooms.get(roomCategory);
            roomsInCategory.add(newRoom);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkInGuest(Guest guest, String roomCategory, Room room) {
        if (rooms.containsKey(roomCategory) == true) {

            ArrayList<Room> roomsInCategory = rooms.get(roomCategory);

            if (roomsInCategory.contains(room)) {
                ArrayList<Guest> currentGuests = room.getCurrentGuests();

                if (!currentGuests.contains(guest)) {
                    room.addGuest(guest);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean checkOutGuest(Guest guest, String roomCategory, Room room) {
        if (rooms.containsKey(roomCategory) == true) {

            ArrayList<Room> roomsInCategory = rooms.get(roomCategory);

            if (roomsInCategory.contains(room)) {
                ArrayList<Guest> currentGuests = room.getCurrentGuests();

                if (currentGuests.contains(guest)) {
                    room.removeGuest(guest);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public ArrayList<Guest> listGuests(String roomCategory, Room room) {
        if (rooms.containsKey(roomCategory) == true) {
            ArrayList<Room> roomsInCategory = rooms.get(roomCategory);

            if (roomsInCategory.contains(room)) {
                return room.getCurrentGuests();

            } else {
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
    }

    public ArrayList<Room> listEmptyRooms(String roomCategory) {
        if (rooms.containsKey(roomCategory) == true) {
            ArrayList<Room> roomsInCategory = rooms.get(roomCategory);
            ArrayList<Room> EmptyRoomsInCategory = new ArrayList<>();

            for (Room room : roomsInCategory) {
                if (room.guestCount() == 0) {
                    EmptyRoomsInCategory.add(room);
                }
            }
            return EmptyRoomsInCategory;
        } else {
            return new ArrayList<>();
        }
    }

}
