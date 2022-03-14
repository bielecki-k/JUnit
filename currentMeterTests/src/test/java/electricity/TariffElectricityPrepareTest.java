package electricity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TariffElectricityPrepareTest {

    ElectricityMeter electricityMeter;

    TariffProvider tp;

    @BeforeEach
    public void setup(){
        tp = Mockito.mock(TariffProvider.class);
        electricityMeter = new ElectricityMeter(tp);
        electricityMeter.setTariffOn(true);
        electricityMeter.setElectricityTariffStartHour(12);
        electricityMeter.setElectricityTariffEndHour(14);
    }

    @Test
    public void GivenOnTariffWhenKwhAdditionThenCounterTariffIsIncreased(){
        //given

        Mockito.when(tp.isTariffNow()).thenReturn(true);
        //when
        electricityMeter.addKwh(100);
        //then
        Assertions.assertEquals(100, electricityMeter.getKwhTariff());

    }

    @Test
    public void GivenOnTariffWhenKwhAdditionThenCounterIsIncreased(){
        //given
        Mockito.when(tp.isTariffNow()).thenReturn(false);
        //when
        electricityMeter.addKwh(100);
        //then
        Assertions.assertEquals(100, electricityMeter.getKwh());

    }

}
