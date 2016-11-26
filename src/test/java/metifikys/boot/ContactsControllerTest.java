package metifikys.boot;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import metifikys.boot.db.Contact;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by metifikys on 2016-11-26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DatabaseSetup("/nplusone.xml")
public class ContactsControllerTest
{
    @Autowired
    private ContactsController contactsController;

    @org.junit.Test
    public void testSelectContacts() throws Exception
    {
        List<Contact> list = contactsController.selectContacts("N.*");
        System.out.println(list);
    }
}