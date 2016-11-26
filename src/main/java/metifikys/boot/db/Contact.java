package metifikys.boot.db;

/**
 * Created by metifikys on 2016-11-26
 */
public class Contact
{
    private Long id;
    private String name;

    public Contact(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
