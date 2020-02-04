package JUnit.Test;

import Stadtplan.Controller.Controller;
import Stadtplan.Main;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
 *JUnit testing class to test the Method
 * used in the Controller class.
 */
public class ControllerTest {

    private Controller controller = new Controller();
    private boolean state = false;
    private String length = "10";
    private String street = "Hagenweg";

    @BeforeClass
    public static void init(){
        Main.fillData();
    }

    @Test
    public void addTrafficAccident_Hagenweg() {
        boolean actual = controller.reportTrafficAccident("Hagenweg",length,state);
        assertTrue(actual);
    }

    @Test
    public void addTrafficAccident_IvalidStreet() {
        boolean actual = controller.reportTrafficAccident("Bachstrasse",length,state);
        assertFalse(actual);
    }

    @Test
    public void addTrafficAccident_IvalidLength(){
        boolean actual = controller.reportTrafficAccident(street,"3,60",state);
        assertFalse(actual);
    }
}