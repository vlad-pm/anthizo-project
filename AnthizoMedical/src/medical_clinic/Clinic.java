package medical_clinic;

import java.util.Random;
import java.util.Random.*;
import java.util.Scanner;

public class Clinic {
// Employeee is like a receptionist. Doctors are part of an array
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double minMoney = 0;
		double maxMoney = 200000;
		
		Patient p1 = new Patient("Goujon", "123 Playground Street", 120000);
		p1.setName("Goujon");
		p1.setAddress("123 Playground Street");
		p1.setMoney(120000);
		
		Employee emp = new Employee();
		Random r = new Random();
		
		Appointment dental = new Appointment("10/01/2023", "12:00", "Dental", "Dr Slime", 200);
		Appointment checkUp = new Appointment ("11/01/2023", "14:30", "Check up", "Dr Nelson", 100);
		Appointment heartSurgery = new Appointment("25/01/2023", "8:30", "Heart surgery", "Dr Surgeon", 25000);
		
		p1.bookAppointment(heartSurgery, emp, false);
		System.out.println(p1.getMoney());
		
		while(true) {
			System.out.println("Welcome to the Anthizo Medical System!"
					+ "Please select one of the following options depending on what you want to achieve: \n"
					+ "1. Create a patient \n"
					+ "2. Create an appointment \n"
					+ "3. Quit");
		
			String menuChoice = scan.nextLine();
			if (menuChoice.equals("1")) {
				System.out.println("What is the patient's name?");
				String patientName = scan.nextLine();
				System.out.println("What is the patient's full address?");
				String patientAddress = scan.nextLine();
				double patientMoney = minMoney + (maxMoney - minMoney) * r.nextDouble();
				Patient pn = new Patient(patientName, patientAddress, patientMoney);
				System.out.println(pn);
				
				System.out.println("Would you now like to book an appointment for this patient?");
				String bookAppointmentQuestion = scan.nextLine();
				if (bookAppointmentQuestion.equals("Yes")) {
					System.out.println("Please select an appointment type from the following options:\n"
							+ "1. Dental\n"
							+ "2. Check up\n"
							+ "3. Heart surgery \n");
					String appointmentTypeChoice = scan.nextLine();
					if(appointmentTypeChoice.contains("dental")) {
						pn.bookAppointment(dental, emp, false);
					} else if(appointmentTypeChoice.contains("check up")) {
						pn.bookAppointment(checkUp, emp, false);
					} else if(appointmentTypeChoice.contains("heart surgery")) {
						pn.bookAppointment(heartSurgery, emp, false);
					}
				}
			
			} else if (menuChoice.equals("2")) {
				System.out.println("Currently, you must create a patient first!");
			
			} if (menuChoice.contentEquals("3")) {
				System.out.println("Ok, goodbye!");
				break;
			}
		
		}
	}

}
