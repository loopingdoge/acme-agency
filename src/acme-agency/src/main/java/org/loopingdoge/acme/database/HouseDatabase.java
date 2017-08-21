package org.loopingdoge.acme.database;

import org.loopingdoge.acme.model.Address;
import org.loopingdoge.acme.model.House;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseDatabase {

    private static ArrayList<House> houseList = new ArrayList<House>(Arrays.asList(
            new House(
                new Address("Italia", "MO", "Quarantoli", "Via Unica", "31"),
                    "Casa nel Bosco", "Geppetto", 125, true, 125000
            ),
            new House(
                new Address("Italia", "MO", "Mirandola", "Via Secca", "77"),
                "Grattacielo", "Paperone", 300, false, 500000
            ),
            new House(
                    new Address("Italia", "MO", "Medolla", "Via Lunga", "1"),
                    "Casa sull'Albero", "Luciano", 25, true, 7000
            )
    ));

    public static House getHouse(int index) {
        return houseList.get(index);
    }

    public static List<House> getHouseList() {
        return houseList;
    }

    public static void addHouse(House house) {
        houseList.add(house);
    }

}
