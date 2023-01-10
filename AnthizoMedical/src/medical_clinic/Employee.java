package medical_clinic;

import medical_clinic.Patient;
import medical_clinic.Appointment;

public class Employee {

	public void handlePatient(Patient patient, boolean finance, Appointment appointment) {
		if(finance == true) {
			double loanAmount = appointment.getPrice() - patient.getMoney();
			runCreditHistory(patient, loanAmount);			
		} else if(appointment.getPrice() <= patient.getMoney()) {
			// customer pays in cash
			processTransaction(patient, appointment);
		} else {
			System.out.println("Customer will need more money to book " + appointment);
		}
	}
	
	public void runCreditHistory(Patient patient, double loanAmount) {
		System.out.println("Ran credit history for patient...");
		System.out.println("Patient has been approved to pay for the appointment.");
	}

	public void processTransaction(Patient patient, Appointment appointment) {
		System.out.println(patient.getName() + " the patient " + ", living at " + patient.getAddress() + ", has purchased a " + appointment.getType() + " for the price of " + appointment.getPrice());
	}
}
