package cafitac.example.chapter2.weathremonitoring;

import cafitac.example.chapter2.weathremonitoring.observer.CurrentConditionDisplay;
import cafitac.example.chapter2.weathremonitoring.observer.ForecastDisplay;
import cafitac.example.chapter2.weathremonitoring.observer.StatisticsDisplay;
import cafitac.example.chapter2.weathremonitoring.subject.WeatherData;

public class WeatherStation {

    public static void main(String[] args) {
        final WeatherData weatherData = new WeatherData();

        final CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        final StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        final ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
