package electricity;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ElectricityMeterTest {

    @Test
    void addKwh() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.addKwh(1);
        assertEquals(1, electricityMeter.getKwh());
    }
}