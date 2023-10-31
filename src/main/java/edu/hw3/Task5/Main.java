package edu.hw3.Task5;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String DESCCOMP = "DESC";

    private Main() {
    }

    public static List<Contact> parseContacts(String[] peopleInfo, String sortOrder) {
        if (isEmptyArr(peopleInfo)) {
            return new ArrayList<Contact>();
        }

        if (!isValidOrder(sortOrder)) {
            throw new IllegalArgumentException("Wrong SortOrder");
        }
        ArrayList<Contact> contacts = new ArrayList<>();
        for (var s : peopleInfo) {
            contacts.add(createContact(s));
        }
        if (sortOrder.equals(DESCCOMP)) {
            contacts.sort(Main::compDesc);
        } else {
            contacts.sort(Main::compAsc);
        }
        return contacts;
    }

    private static boolean isValidOrder(String sortOrder) {
        return sortOrder != null && (sortOrder.equals("ASC") || sortOrder.equals(DESCCOMP));
    }

    private static Contact createContact(String str) {
        var tmp = str.split(" ");
        if (tmp.length == 2) {
            return new Contact(tmp[0], tmp[1]);
        }
        if (tmp.length == 1) {
            return new Contact(tmp[0]);
        }
        throw new IllegalArgumentException("Wrong Argument");
    }

    private static int compAsc(Contact c1, Contact c2) {
        String f1 = c1.surname();
        String f2 = c2.surname();
        if (c1.surname() == null) {
            f1 = c1.name();
        }
        if (c2.surname() == null) {
            f2 = c2.name();
        }
        return f1.compareTo(f2);
    }

    private static int compDesc(Contact c1, Contact c2) {
        return -compAsc(c1, c2);
    }

    private static boolean isEmptyArr(String[] arr) {
        return arr == null || arr.length == 0;
    }
}


