import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Storage {
    AdressBook currentAdressBook;
    public boolean store(AdressBook currentAdressBook) throws IOException {
        FileWriter writer = new FileWriter("output.txt");
        for(Contact contact: currentAdressBook.contacts) {
            try {
                writer.write(contact.getName() + System.lineSeparator());
            } catch (IOException e) {
                System.out.println("AddressBook operation error!");
                e.printStackTrace();
            }
        }
        System.out.println("AddressBook operation finished!");
        writer.close();
        return true;
    }
    public AdressBook load()
    {
        List<String> resultedListFromFolder = null;
        AdressBook loadedAdressBook = new AdressBook();
        try (Stream<String> lines = Files.lines(Paths.get("output.txt"))) {
            resultedListFromFolder = lines.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String result: resultedListFromFolder) {
            Contact myNewEntryContact = new Contact(result);
            loadedAdressBook.contacts.add(myNewEntryContact);
        }
        return loadedAdressBook;
    }
}
