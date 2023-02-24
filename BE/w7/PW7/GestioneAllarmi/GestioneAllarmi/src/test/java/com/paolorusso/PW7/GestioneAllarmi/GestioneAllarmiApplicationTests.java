package com.paolorusso.PW7.GestioneAllarmi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.paolorusso.PW7.GestioneAllarmi.classes.Sensor;

import static org.junit.Assert.assertEquals;



@SpringBootTest
class GestioneAllarmiApplicationTests {

	
	Sensor s1 = new Sensor(1, 12.345, 67.899);
	
	@Test
    public void testGetId() {
        assertEquals(1, s1.getId());
    }

    @Test
    public void testGetLatitudine() {
        assertEquals(12.345, s1.getLatitude(), 0.001);
    }


    @Test
    public void testGetLongitudine() {
        assertEquals(67.899, s1.getLongitude(), 0.001);
    }

    @Test
    public void testGetLivelloFumo() {
        assertEquals(0, s1.getSmokeLevel());
    }
}
