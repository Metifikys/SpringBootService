package metifikys.boot.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by metifikys on 2016-11-26
 */
@Component
public class JdbcContactDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Contact> contacts(String filter)
    {
        Pattern pt = Pattern.compile(filter);

        List<Contact> contacts = new ArrayList<>();

        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("select * from contacts");
        while (sqlRowSet.next())
        {
            String name = sqlRowSet.getString("name");

            if (!pt.matcher(name).find())
            {
                contacts.add(
                        new Contact(sqlRowSet.getLong("id"), name)
                );
            }
        }

        return contacts;
    }
}