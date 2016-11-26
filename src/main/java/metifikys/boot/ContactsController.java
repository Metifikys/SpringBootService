package metifikys.boot;

import metifikys.boot.db.Contact;
import metifikys.boot.db.JdbcContactDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by metifikys on 2016-11-26
 */
@RestController
public class ContactsController
{
    @Autowired
    private JdbcContactDAO jdbcContactDAO;

    @RequestMapping(
            path = "/hello/contacts",
            method = GET,
            params = {"nameFilter"}
    )
    public List<Contact> selectContacts(@RequestParam("nameFilter") String filter)
    {
        return jdbcContactDAO.contacts(filter);
    }
}