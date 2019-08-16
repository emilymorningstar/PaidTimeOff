
import com.riis.JDBC;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
public class JDBCTest {
    JDBC jdbc=new JDBC();
    @Before
    public void setup(){
    }
    /*@Test
    public void connectTest() {

        String url="jdbc:sqlserver://localhost;user=sa;password=reallyStrongPwd123";
        Connection c= jdbc.connect(url);
        Assert.assertNotNull(c);
    }*/
    @Test
    public void newUserTest(){
        String url="jdbc:sqlserver://localhost;user=sa;password=reallyStrongPwd123";
        int i= JDBC.newUser(url,"name1","name2","email",3,2,"password");
        Assert.assertEquals(0,i);
    }}