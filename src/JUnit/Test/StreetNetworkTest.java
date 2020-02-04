package JUnit.Test;

import Stadtplan.Main;
import Stadtplan.Model.StreetSection;
import Stadtplan.Model.StreetNetwork;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/*
*JUnit testing class to test some Methods
* used in the StreeNetwork class.
 */
public class StreetNetworkTest {

    private StreetNetwork streetNetwork = new StreetNetwork();
    private StreetSection streetSection;

    @BeforeClass
    public static void fillData(){
        Main.fillData();
    }

    @Test
    public void TestGetStreetByName() {
        streetSection = streetNetwork.getStreetByName("Hagenweg");
        assertEquals(streetSection.getName(),"Hagenweg");
    }

    @Test
    public void FailGetStreetByName(){
        streetSection = streetNetwork.getStreetByName("Birkenstrasse");
        assertNull(streetSection);
    }
}