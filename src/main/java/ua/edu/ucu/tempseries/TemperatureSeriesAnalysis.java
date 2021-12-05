package ua.edu.ucu.tempseries;
import java.lang.Math;

public class TemperatureSeriesAnalysis {
//    private int final  = -273;
    private double[] temperatureSeries;
    private int len;

    public TemperatureSeriesAnalysis() {
        temperatureSeries = new double[1];
        len = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperature) {
        for(int i = 0; i < temperature.length; i++){
            temperatureSeries[i] = temperature[i];
            len++;
        }
    }

    public double average() {
        if (len == 0){
            throw new IllegalArgumentException("Empty array");
        }
        double sum = 0;
        for(int i = 0; i < len; i++){
            sum += temperatureSeries[i];
        }
        return sum / len;
    }

    public double deviation() {
        if (len == 0){
            throw new IllegalArgumentException("Empty array");
        }
        double av = average();
        double sum = 0;
        for(int i =0; i < len; i++){
            sum += Math.pow((av - temperatureSeries[i]), 2);
        }
        return Math.sqrt(sum / len);
    }

    public double min() {
        if (len == 0){
            throw new IllegalArgumentException("Empty array");
        }
        double res = temperatureSeries[0];
        for(int i = 1; i < len; i++){
            if(res < temperatureSeries[i]){
                res = temperatureSeries[i];
            }
        }
        return res
    }

    public double max() {
        if (len == 0){
            throw new IllegalArgumentException("Empty array");
        }
        double res = temperatureSeries[0];
        for(int i = 1; i < len; i++){
            if(res > temperatureSeries[i]){
                res = temperatureSeries[i];
            }
        }
        return res
    }

    public double findTempClosestToZero() {
        if (len == 0){
            throw new IllegalArgumentException("Empty array");
        }
        double min_diff = Math.abs(temperatureSeries[0]);
        for(int i = 1; i < len ; i++){
            double curr = Math.abs(temperatureSeries[i]);
            if(min_diff > curr){
                min_diff = curr;
            }
        }
        return min_diff;
    }

    public double findTempClosestToValue(double tempValue) {
        if (len == 0){
            throw new IllegalArgumentException("Empty array");
        }
        double min_diff = Math.abs(tempValue - temperatureSeries[0]);
        for(int i = 1; i < len ; i++){
            double curr = Math.abs(tempValue - temperatureSeries[i]);
            if(min_diff > curr){
                min_diff = curr;
            }
        }
        return min_diff;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (len == 0){
            throw new IllegalArgumentException("Empty array");
        }
        double[] res;
        for(int i = 0; i < len; ++i){
            if (temperatureSeries[i] < tempValue){
                res.add(temperatureSeries[i]);
            }
        }
        return res;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (len == 0){
            throw new IllegalArgumentException("Empty array");
        }
        double[] res;
        for(int i = 0; i < len; ++i){
            if (temperatureSeries[i] > tempValue){
                res.add(temperatureSeries[i]);
            }
        }
        return res;
    }

    public TempSummaryStatistics summaryStatistics(){
        if (len == 0){
            throw new IllegalArgumentException("Empty array");
        }
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        if (len == 0){
            throw new IllegalArgumentException("Empty array");
        }
        for(double temp: temps){
            if(temp <= -273.0){
                throw new InputMismatchException();
            }
            if(len == temperatureSeries.size()){
                double newArray[] = new double[len * 2];
                len *= 2;
                System.arraycopy(temperatureSeries, 0, newArray, 0, len);
                System.arraycopy(newArray, 0, temperatureSeries, 0, len);
                temperatureSeries[temperatureSeries.size()] = temp;
            }
        }
        double sum = 0;
        for(int i = 0; i < len; i++){
            sum += temperatureSeries[i];
        }
        return sum;
    }
}
