package headfirstpatterns.observer.impl;

import java.util.Observable;

public class WeatherData extends Observable {

	private float pressure;
	private float humidity;
	private float temp;

	public WeatherData() {

	}

	public void measureChanged() {
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;

		measureChanged();
	}

	public float getPressure() {
		return pressure;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getTemp() {
		return temp;
	}

}
