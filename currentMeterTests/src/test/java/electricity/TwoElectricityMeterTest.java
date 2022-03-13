package electricity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TwoElectricityMeterTest {

    @Test
    void addKwh_newMeter_properAddition() {
        //given
        ElectricityMeter electricityMeter = new ElectricityMeter();
        ElectricityMeter electricityMeter1 = new ElectricityMeter();
        //when
        electricityMeter.addKwh(1);
        //then
        assertEquals(1, electricityMeter.getKwh());
    }

    @Test
    void addKwh_newMeter2_properAddition() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        ElectricityMeter electricityMeter1 = new ElectricityMeter();
        electricityMeter.addKwh(1);
        electricityMeter.addKwh(4);
        assertEquals(5, electricityMeter.getKwh());
    }


    @Test()
    void getHowMoreExpensiveNormalIs() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        ElectricityMeter electricityMeter1 = new ElectricityMeter();
        electricityMeter.setCentsForKwh(90);
        assertThrows(ArithmeticException.class, electricityMeter::getHowMoreExpensiveNormalIs);
    }
}
