package Test;

import com.riis.JDBC;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Calendar;

public class JDBCTest {
    JDBC jdbc = new JDBC();

    @Before
    public void setup() {
    }

    /*@Test
    public void connectTest() {
        Connection c= jdbc.getURL;
        Assert.assertNotNull(c);
    }*/
    //@Test //too many test data in database
    public void newUserTest() {

        int i = JDBC.newUser( "name1", "name2", "email", 3, 2, "password");
        Assert.assertEquals(0, i);
    }

    //@Test
    public void CreateRequestTest() {
        String url = "jdbc:sqlserver://localhost;user=sa;password=reallyStrongPwd123";

        //yyyy-mm-dd
        int i = JDBC.CreateRequest("2000-1-1", "2000-8-30", 3);
        Assert.assertEquals(0, i);
    }

    @Test
    public void getEmployeeIdTest() {
        String email = "emorningstar@riis.com";
        int i = JDBC.getEmployeeId(email);
        Assert.assertEquals(3, i);
    }

    @Test
    public void logInTestGood() {

        String u = "emorningstar@riis.com";
        String p = "password";
        String s = JDBC.login(u, p);
        Assert.assertEquals("emorningstar@riis.com", s);
    }

    @Test
    public void logInTestBad() {

        String u = "er@riis.com";
        String p = "password";
        String s = JDBC.login( u, p);
        Assert.assertEquals("Log in error please enter the correct information", s);
    }

    //@Test //test will be wrong after new table additions
    public void viewTest() {
        int eid = 3;
        ResultSet rs = JDBC.view(eid);
        Assert.assertNotNull(rs);


    }
    @Test
    public void statusTest(){
        int id=1;
        Assert.assertEquals("Approved",JDBC.getStatus(id));
        id=2;
        Assert.assertEquals("Pending",JDBC.getStatus(id));
        id=3;
        Assert.assertEquals("Denied",JDBC.getStatus(id));
    }
    @Test
    public void addTest(){
        Date start=new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Date end=new java.sql.Date(Calendar.getInstance().getTime().getTime());
       //int employeeId=3;
        Assert.assertEquals("ok",JDBC.addRequest(start,end,"emorningstar@riis.com"));
    }
}
