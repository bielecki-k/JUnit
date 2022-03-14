package electricity;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ExistElectricityMeterTest {

    static ElectricityMeter electricityMeter;

    @BeforeAll
    public static void setup(){
        electricityMeter = new ElectricityMeter();
        electricityMeter.addKwh(100);
    }

    @AfterAll
    public static void release(){
        electricityMeter.reset();
    }

    @AfterEach
    public void tearDown(){
        electricityMeter.reset();
        electricityMeter.addKwh(100);
    }

    @Test
    void addKwh_newMeter_properAddition() {
        //when
        electricityMeter.addKwh(1);
        //then
        assertEquals(101, electricityMeter.getKwh());
    }

    @Test
    void addKwh_newMeter2_properAddition() {


        electricityMeter.addKwh(1);
        electricityMeter.addKwh(3);
        assertEquals(104, electricityMeter.getKwh());
    }


    @Test()
    void getHowMoreExpensiveNormalIs() {
        electricityMeter.setCentsForKwh(90);
        assertThrows(ArithmeticException.class, electricityMeter::getHowMoreExpensiveNormalIs);
    }


}
