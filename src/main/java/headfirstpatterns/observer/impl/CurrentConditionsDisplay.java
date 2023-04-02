package headfirstpatterns.observer.impl;

import java.util.Observable;
import java.util.Observer;

import headfirstpatterns.observer.DisplayElement;
import headfirstpatterns.observer.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float pressure;
	private float humidity;
	private float temp;

	private Observable weatherData;

	public CurrentConditionsDisplay(Observable weatherData) {
		this.weatherData = weatherData;
		this.weatherData.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println(String.format("Current conditions: %.2f F degrees and %.2f %% humidity", temp, humidity));
	}

	@Override
	public void update(Observable o, Object arg) {
		if (!(o instanceof WeatherData)) return;
		
		WeatherData weatherData = (WeatherData) o;
		temp = weatherData.getTemp();
		humidity = weatherData.getHumidity();
		display();
	}

}
