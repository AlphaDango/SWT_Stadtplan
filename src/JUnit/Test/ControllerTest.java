package JUnit.Test;

import Stadtplan.Controller.Controller;
import Stadtplan.Main;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    public void addUnfall_Hagenweg() {
        boolean actual = controller.reportAccident("Hagenweg",length,state);
        assertTrue(actual);
    }

    @Test
    public void addUnfall_IvalidStreet() {
        boolean actual = controller.reportAccident("Bachstrasse",length,state);
        assertFalse(actual);
    }

    @Test
    public void addUnfall_IvalidLength(){
        boolean actual = controller.reportAccident(street,"3,60",state);
        assertFalse(actual);
    }
}