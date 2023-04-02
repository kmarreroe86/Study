package headfirstpatterns.observer;


import headfirstpatterns.observer.impl.CurrentConditionsDisplay;
import headfirstpatterns.observer.impl.HeatIndexDisplay;
import headfirstpatterns.observer.impl.WeatherData;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currDisplay = new CurrentConditionsDisplay(weatherData);
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
		
		weatherData.setMeasurements(2,  3,  4);
		
		currDisplay.display();
		heatIndexDisplay.display();

	}

}
