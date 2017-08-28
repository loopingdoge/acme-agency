package org.loopingdoge.acme.utils;

import org.loopingdoge.acme.model.Address;
import org.loopingdoge.acme.model.House;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseDatabase {

    private static ArrayList<House> houseList = new ArrayList<House>(Arrays.asList(
            new House(
                    new Address("Via Roma", "10", "Minerbio", "40061", "BO", "Italia"),
                    "Casa nel Bosco", "Geppetto", 125, true, 125000
            ),
            new House(
                    new Address("Via Garibaldi", "108", "Minerbio", "40061", "BO", "Italia"),
                    "Grattacielo", "Paperone", 300, false, 500000
            ),
            new House(
                    new Address("Via Canaletto", "1", "Minerbio", "40061", "BO", "Italia"),
                    "Casa sull'Albero", "Luciano", 25, true, 7000
            ),
            new House(
                    new Address("Via Boccherini", "9", "Casalecchio di Reno", "40033", "BO", "Italia"),
                    "Casa di Piero", "Piero", 250, true, 70000
            ),
            new House(
                    new Address("Italia", "BO", "Marzabotto", "40043", "Via dei Ciclamini", "16"),
                    "Casa di Alby", "Albyxyz", 280, true, 90000
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
