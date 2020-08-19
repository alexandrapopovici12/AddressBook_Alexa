import java.util.List;

public class AdressBook {
    List<Contact> contacts;

    public void add(Contact contact) {
        contacts.add(contact);
    }

    public boolean delete(String contact) {
        if (contacts.contains(contact)) {
            contacts.remove(contact);
            return true;
        }
        return false;
    }

    public Contact find(String contactName) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(contactName)) {
                return contact;
            }
        }
        return null;
    }
}
