import Guests.Guest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {
    Guest ellie;

    @Before
    public void before(){
        ellie = new Guest("Ellie");
    }

    @Test
    public void hasName(){
        assertEquals("Ellie", ellie.getName());
    }
}
