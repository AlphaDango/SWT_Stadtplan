package JUnit.Test;

import Stadtplan.Main;
import Stadtplan.Model.StrassenAbschnitt;
import Stadtplan.Model.StreetNetwork;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StreetNetworkTest {

    private StreetNetwork streetNetwork = new StreetNetwork();
    private StrassenAbschnitt strassenAbschnitt;

    @BeforeClass
    public static void fillData(){
        Main.fillData();
    }

    @Test
    public void TestGetStreetByName() {
        strassenAbschnitt = streetNetwork.getStreetByName("Hagenweg");
        assertEquals(strassenAbschnitt.getName(),"Hagenweg");
    }

    @Test
    public void FailGetStreetByName(){
        strassenAbschnitt = streetNetwork.getStreetByName("Birkenstrasse");
        assertNull(strassenAbschnitt);
    }
}