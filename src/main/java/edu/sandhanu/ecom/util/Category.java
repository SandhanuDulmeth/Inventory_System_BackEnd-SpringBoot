package edu.sandhanu.ecom.util;

public enum Category {
    ELECTRONICS(1),
    OFFICE_SUPPLIES(2),
    FURNITURE(3),
    APPLIANCES(4);

    private final int id;

    Category(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
