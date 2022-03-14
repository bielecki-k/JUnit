package electricity;

//count kWh
//count tariff
//set tariff&rate
//how much more expensive is electricity outside the tariff?

//tool to set tariff&rate

import java.util.Calendar;

public class ElectricityMeter {

    TariffProvider tp;

    private float kwh = 0;
    private int centsForKwh = 0;

    private boolean tariffOn = false;
    private float kwhTariff = 0;
    private int centsForTariff = 0;

    private int electricityTariffStartHour = 0;
    private int electricityTariffEndHour = 0;

    public ElectricityMeter() {
        tp = () -> {
            Calendar rightNow = Calendar.getInstance();
            int hour = rightNow.get(Calendar.HOUR_OF_DAY);
            return hour > electricityTariffStartHour && hour < electricityTariffEndHour;
        };
    }

    public ElectricityMeter(TariffProvider tp) {
        this.tp = tp;
    }

    public void addKwh(float kwhToAdd){
        if(isTariffNow()){
            kwhTariff +=kwhToAdd;
        }else {
            kwh += kwhToAdd;
        }
    }

    public boolean isTariffNow() {
        return tp.isTariffNow();
    }
//    public boolean isTariffNow() {
//        Calendar rightNow = Calendar.getInstance();
//        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
//        return hour > electricityTariffStartHour && hour < electricityTariffEndHour;
//    }

    int getHowMoreExpensiveNormalIs(){
        return (centsForKwh * 100 / centsForTariff) - 100;
    }

    void setCentsForKwh(int centsForKwh) {
        this.centsForKwh = centsForKwh;
    }

    void setTariffOn(boolean tariffOn) {
        this.tariffOn = tariffOn;
    }

    void setCentsForTariff(int centsForTariff) {
        this.centsForTariff = centsForTariff;
    }

    void setElectricityTariffStartHour(int electricityTariffStartHour) {
        this.electricityTariffStartHour = electricityTariffStartHour;
    }

    void setElectricityTariffEndHour(int electricityTariffEndHour) {
        this.electricityTariffEndHour = electricityTariffEndHour;
    }

    public float getKwh() {
        return kwh;
    }

    public float getKwhTariff() {
        return kwhTariff;
    }

    public void reset(){
        kwh = 0;
        centsForKwh = 0;
        tariffOn = false;
        kwhTariff = 0;
        centsForTariff = 0;
        electricityTariffStartHour = 0;
        electricityTariffEndHour = 0;
    }

}
