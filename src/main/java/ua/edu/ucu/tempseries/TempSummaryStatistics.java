package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private double avgTemp;
    private double devTemp;
    private double minTemp;
    private double maxTemp;

    public void setTemps(double average,  double dev, double min, double max){
        avgTemp = average;
        devTemp = dev;
        minTemp = min;
        maxTemp = max;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

}

//- TempSummaryStatistics summaryStatistics()
//        Повертає immutable екземпляр классу TempSummaryStatistics в якому міститься інформація:
//        - double avgTemp;
//        - double devTemp;
//        - double minTemp;
//        - double maxTemp;
//        Якщо ряд порожній, генерує IllegalArgumentException.
