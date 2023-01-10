package medical_clinic;

public class Clinic {
// Employeee is like a receptionist. Doctors are part of an array
	public static void main(String[] args) {
		
		Patient p1 = new Patient("Goujon", "123 Playground Street", 120000);
		p1.setName("Goujon");
		p1.setAddress("123 Playground Street");
		p1.setMoney(120000);
		
		Employee emp = new Employee();
		
		Appointment dental = new Appointment("10/01/2023", "12:00", "Dental", "Dr Slime", 200);
		Appointment checkUp = new Appointment ("11/01/2023", "14:30", "Check up", "Dr Nelson", 100);
		
		p1.bookAppointment(checkUp, emp, false);
	}

}
