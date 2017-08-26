package org.loopingdoge.acme.utils;

import org.loopingdoge.acme.model.Address;
import org.loopingdoge.acme.model.House;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseDatabase {

    private static ArrayList<House> houseList = new ArrayList<House>(Arrays.asList(
            new House(
                new Address("Italia", "BO", "Minerbio", "Via Roma", "10"),
                    "Casa nel Bosco", "Geppetto", 125, true, 125000
            ),
            new House(
                    new Address("Italia", "BO", "Minerbio", "Via Canaletto", "1"),
                    "Casa sull'Albero", "Luciano", 25, true, 7000
            ),
            new House(
                    new Address("Italia", "BO", "Minerbio", "Via Garibaldi", "108"),
                    "Grattacielo", "Paperone", 300, false, 500000
            ),
            new House(
                    new Address("Italia", "BO", "Casalecchio", "Via Boccherini", "9"),
                    "Casa di Piero", "Piero", 250, true, 70000
            ),
            new House(
                    new Address("Italia", "BO", "Sasso Marconi", "Via dei Ciclamini", "16"),
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
