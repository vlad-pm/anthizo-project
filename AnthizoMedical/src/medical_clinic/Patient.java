package medical_clinic;

import medical_clinic.Employee;
import medical_clinic.Appointment;

public class Patient {
		
		private String name;
		private String address;
		private double money;

		
		public Patient(String name, String address, double money) {
			super();
			this.name = name;
			this.address = address;
			this.money = money;
		}

		public double getMoney() {
			return money;
		}

		public void setMoney(double money) {
			money += 500;
			this.money = money;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			address += " London";
			this.address = address;
		}
		
		public void bookAppointment(Appointment appointment, Employee emp, boolean finance) {
			emp.handlePatient(this, finance, appointment);
		}

		@Override
		public String toString() {
			return "Patient [name=" + name + ", address=" + address + ", money=" + money + "]";
		}
		
		
	}

	
