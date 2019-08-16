
import com.riis.JDBC;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

public class JDBCTest {
    JDBC jdbc = new JDBC();

    @Before
    public void setup() {
    }

    /*@Test
    public void connectTest() {

        String url="jdbc:sqlserver://localhost;user=sa;password=reallyStrongPwd123";
        Connection c= jdbc.connect(url);
        Assert.assertNotNull(c);
    }*/
    //@Test
    public void newUserTest() {
        String url = "jdbc:sqlserver://localhost;user=sa;password=reallyStrongPwd123";
        int i = JDBC.newUser(url, "name1", "name2", "email", 3, 2, "password");
        Assert.assertEquals(0, i);
    }

    //@Test
    public void CreateRequestTest() {
        String url = "jdbc:sqlserver://localhost;user=sa;password=reallyStrongPwd123";

        //yyyy-mm-dd
        int i = JDBC.CreateRequest(url, "2000-1-1", "2000-8-30", 3);
        Assert.assertEquals(0, i);
    }

    @Test
    public void getEmployeeIdTest() {
        String email = "emorningstar@riis.com";
        String url = "jdbc:sqlserver://localhost;user=sa;password=reallyStrongPwd123";
        int i = JDBC.getEmployeeId(url, email);
        Assert.assertEquals(3, i);
    }

    @Test
    public void logInTestGood() {
        String url = "jdbc:sqlserver://localhost;user=sa;password=reallyStrongPwd123";

        String u = "emorningstar@riis.com";
        String p = "password";
        String s = JDBC.login(url, u, p);
        Assert.assertEquals("emorningstar@riis.com", s);
    }
}