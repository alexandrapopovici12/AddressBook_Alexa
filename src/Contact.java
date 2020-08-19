import java.util.List;

public class Contact {
    String name;
    List<ContactData> data;

    public List<ContactData> getData() {
        return data;
    }

    public Contact(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
