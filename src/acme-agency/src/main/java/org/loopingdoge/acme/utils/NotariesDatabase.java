package org.loopingdoge.acme.utils;

import org.loopingdoge.acme.model.Address;
import org.loopingdoge.acme.model.Notary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotariesDatabase {

    private static ArrayList<Notary> notaries = new ArrayList<Notary>(Arrays.asList(
            new Notary(
                    "Giancarlo",
                    new Address("Via Unica", "31", "Quarantopoli", "41037", "MO", "Italia")
            ),
            new Notary(
                    "Armando",
                    new Address("Via Secca", "77", "Mirandola", "41037", "Mo", "Italia")
            )
    ));

    public static Notary getNotary(int index) {
        return notaries.get(index);
    }

    public static List<Notary> getNotaryList() {
        return notaries;
    }

    public static void addNotary(Notary notary) {
        notaries.add(notary);
    }

}
