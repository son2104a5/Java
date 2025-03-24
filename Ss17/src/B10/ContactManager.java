package B10;

import java.util.*;

public class ContactManager {
    private Set<Contact> contacts = new HashSet<>();

    public boolean addContact(Contact c) {
        if (contacts.contains(c)) {
            System.out.println("SĐT \"" + c.getPhoneNumber() + "\" đã tồn tại. Không thể thêm.");
            return false;
        }
        contacts.add(c);
        return true;
    }

    public boolean removeContactByPhone(String phoneNumber) {
        Contact target = findContactByPhone(phoneNumber);
        if (target != null) {
            contacts.remove(target);
            return true;
        }
        return false;
    }

    public Contact findContactByPhone(String phoneNumber) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                return c;
            }
        }
        return null;
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ trống.");
            return;
        }
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public int size() {
        return contacts.size();
    }
}
