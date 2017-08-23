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
                    new Address("Italia", "MO", "Quarantoli", "Via Unica", "31")
            ),
            new Notary(
                    "Armando",
                    new Address("Italia", "MO", "Mirandola", "Via Secca", "77")
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
