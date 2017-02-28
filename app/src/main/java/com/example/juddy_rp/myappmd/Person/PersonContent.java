package com.example.juddy_rp.myappmd.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by juddy_000 on 28/02/2017.
 */

public class PersonContent {

    public static final ArrayList<Person> personList = new ArrayList<>();

    public static ArrayList getPersonList() {
        return personList;
    }

    public static final Map<String, Person> ITEM_MAP = new HashMap<String, Person>();

    public static void addPerson(Person item) {
        personList.add(item);
        ITEM_MAP.put(item.getNombre(), item);
    }

    /**
     * Carga en la lista personList
     */

}


