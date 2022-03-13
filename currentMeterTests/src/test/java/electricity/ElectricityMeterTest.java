package electricity;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ElectricityMeterTest {

    static ElectricityMeter electricityMeter;

    @BeforeAll
    public static void setup(){
        electricityMeter = new ElectricityMeter();
    }

    @BeforeEach
    public void setupEnv(){
        electricityMeter.reset();
    }

    @Test
    void addKwh_newMeter_properAddition() {
        //when
        electricityMeter.addKwh(1);
        //then
        assertEquals(1, electricityMeter.getKwh());
    }

    @Test
    void addKwh_newMeter2_properAddition() {
        electricityMeter.addKwh(1);
        electricityMeter.addKwh(4);
        assertEquals(5, electricityMeter.getKwh());
    }


    @Test()
    void getHowMoreExpensiveNormalIs() {
        electricityMeter.setCentsForKwh(90);
        assertThrows(ArithmeticException.class, electricityMeter::getHowMoreExpensiveNormalIs);
    }


}
