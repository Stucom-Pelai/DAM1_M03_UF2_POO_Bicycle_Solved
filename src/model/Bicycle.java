package model;

import java.util.Arrays;

public class Bicycle {
	
	String code;
	int date;
	double [] parkings =  new double[4];
	boolean electric;
	
	public Bicycle(String code, int date) {
		super();
		this.code = code;
		this.date = date;
	}
	
	
	public Bicycle(String code, int date, double[] parkings, boolean electric) {
		super();
		this.code = code;
		this.date = date;
		this.parkings = parkings;
		this.electric = electric;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setParking(int number, double parking) {
		this.parkings[number] = parking;
	}
	
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public double[] getParkings() {
		return parkings;
	}
	public void setParkings(double[] parkings) {
		this.parkings = parkings;
	}
	public boolean isElectric() {
		return electric;
	}
	public void setElectric(boolean electric) {
		this.electric = electric;
	}
	
	@Override
	public String toString() {
		return "Bicycle [code=" + code + ", date=" + date + ", parkings=" + Arrays.toString(parkings) + ", electric="
				+ electric + "]";
	}
	
	/**
	 * show all information for a specific bicycle
	 */
	public void showData() {
		System.out.println("Bicicleta [fecha fabricacion=" + date + ", distancia media=" + this.getAverageDistance() + ", electrica="
				+ electric + "]");
	}
	
	
	
	/**
	 * @return average distance of parkings where bicycle was
	 */
	public double getAverageDistance() {
		double totalDistance=0.0;
		int totalParking=0;
		
		for (double parking : parkings) {
			if (parking !=0.0) {
				totalDistance+=parking;				
				totalParking++;				
			}
		}
		if (parkings.length>0) {
			return 1.0* (totalDistance/totalParking);			
			
		} else {
			return 0.0;			

		}
		
	}

	
	
	
}
