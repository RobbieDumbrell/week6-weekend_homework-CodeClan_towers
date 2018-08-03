package RoomVariants.Enums;

public enum BedRoomType {

    SINGLE("Single Room", 1),
    DOUBLE("Double Room", 2),
    TWIN("Twin Room", 2),
    SUITE("Suite Room", 4),
    FAMILY("Family Room", 6),
    PENTHOUSE("Penthouse Room", 8);

    private String description;
    private int capacity;

    BedRoomType(String description, int capacity){
        this.description = description;
        this.capacity = capacity;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public String getDescription(){
        return this.description;
    }

}
