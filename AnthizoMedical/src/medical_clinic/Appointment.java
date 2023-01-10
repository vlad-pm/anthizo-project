package medical_clinic;

import medical_clinic.Patient;
import java.util.random.*;
import java.util.Objects;
import medical_clinic.Appointment;
import medical_clinic.Employee;



public class Appointment {

	private String date;
	private String time;
	private String type;
	private String doctor;
	private double price;
	
	public Appointment(String date, String time, String type, String doctor, double price) {
		super();
		this.date = date;
		this.time = time;
		this.type = type;
		this.doctor = doctor;
		this.price = price;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(date, time, type, price, doctor);
	}
	
	@Override
	public String toString() {
		return "Appointment [date=" + date + ", time=" + time + ", type=" + type + ", doctor=" + doctor + ", price=" + price + "]";
	}
}
