package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private double avgTemp;
    private double devTemp;
    private double minTemp;
    private double maxTemp;

    public TempSummaryStatistics(double average,  double dev,
                                 double min, double max) {
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

