import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class MedicalSystemGUI extends JFrame {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private JPanel appointmentsPanel;
    private JPanel patientsPanel;
    private JPanel doctorsPanel;

    private ArrayList<Appointment> appointments;
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;

    public MedicalSystemGUI() {
        appointments = new ArrayList<Appointment>();
        patients = new ArrayList<Patient>();
        doctors = new ArrayList<Doctor>();
        
        frame = new JFrame("Anthizo Medical System"); // This creates the main frame for the system
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane(); // creates the tabbed pane so tabs can be added
        
        appointmentsPanel = new JPanel(new BorderLayout());
        appointmentsPanel.add(new JLabel("Appointments"), BorderLayout.NORTH); // creates appointments tab
        
        JPanel appointmentsListPanel = new JPanel(new GridLayout(0, 1));
        for (Appointment appointment : appointments) { 
            appointmentsListPanel.add(new JLabel(appointment.toString()));
        }
        appointmentsPanel.add(appointmentsListPanel, BorderLayout.CENTER);

        JPanel appointmentsButtonPanel = new JPanel(new FlowLayout());
        JButton bookAppointmentButton = new JButton("Book Appointment"); // creates book appointment button
        bookAppointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAppointmentDialog();
            }
        });
        JButton btnViewAppointments = new JButton("View Appointments");
        btnViewAppointments.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewAppointmentsDialog(); // when button clicked, summon the dialogue 
            }
        });

        
        appointmentsButtonPanel.add(bookAppointmentButton);
        appointmentsButtonPanel.add(btnViewAppointments);
        appointmentsPanel.add(appointmentsButtonPanel, BorderLayout.SOUTH);

        tabbedPane.addTab("Appointments", appointmentsPanel);

        patientsPanel = new JPanel(new BorderLayout());
        patientsPanel.add(new JLabel("Patients"), BorderLayout.NORTH);

        JPanel patientsListPanel = new JPanel(new GridLayout(0, 1));
        for (Patient patient : patients) {
            patientsListPanel.add(new JLabel(patient.toString()));
        }
        patientsPanel.add(patientsListPanel, BorderLayout.CENTER);

        JPanel patientsButtonPanel = new JPanel(new FlowLayout());
        JButton createPatientButton = new JButton("Create Patient");
        createPatientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPatientDialog();
            }
        });
        patientsButtonPanel.add(createPatientButton);
        patientsPanel.add(patientsButtonPanel, BorderLayout.SOUTH);

        tabbedPane.addTab("Patients", patientsPanel);

        doctorsPanel = new JPanel(new BorderLayout());
        doctorsPanel.add(new JLabel("Doctors"), BorderLayout.NORTH);

        JPanel doctorsListPanel = new JPanel(new GridLayout(0, 1));
        for (Doctor doctor : doctors) {
            doctorsListPanel.add(new JLabel(doctor.toString()));
        }
        doctorsPanel.add(doctorsListPanel, BorderLayout.CENTER);

        JPanel doctorsButtonPanel = new JPanel(new FlowLayout());
        JButton createDoctorButton = new JButton("Create Doctor");
        createDoctorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDoctorDialog();
            }
        });
        doctorsButtonPanel.add(createDoctorButton);
        doctorsPanel.add(doctorsButtonPanel, BorderLayout.SOUTH);

        tabbedPane.addTab("Doctors", doctorsPanel);

        frame.add(tabbedPane);
        frame.pack();
        frame.setVisible(true);

    }
    
    private void showAppointmentDialog() {
        JFrame dialogFrame = new JFrame("Book Appointment");
        JPanel dialogPanel = new JPanel(new GridLayout(0, 2));

        dialogPanel.add(new JLabel("Patient:"));
        JComboBox<Patient> patientComboBox = new JComboBox<Patient>(patients.toArray(new Patient[patients.size()]));
        dialogPanel.add(patientComboBox);

        dialogPanel.add(new JLabel("Doctor:"));
        JComboBox<Doctor> doctorComboBox = new JComboBox<Doctor>(doctors.toArray(new Doctor[doctors.size()]));
        dialogPanel.add(doctorComboBox);

        dialogPanel.add(new JLabel("Date:"));
        JTextField dateTextField = new JTextField();
        dialogPanel.add(dateTextField);

        dialogPanel.add(new JLabel("Time:"));
        JTextField timeTextField = new JTextField();
        dialogPanel.add(timeTextField);

        int result = JOptionPane.showConfirmDialog(dialogFrame, dialogPanel, "Book Appointment", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Patient patient = (Patient) patientComboBox.getSelectedItem();
            Doctor doctor = (Doctor) doctorComboBox.getSelectedItem();
            LocalDate date = LocalDate.parse(dateTextField.getText());
            LocalTime time = LocalTime.parse(timeTextField.getText());
            LocalDateTime appointmentDateTime = LocalDateTime.of(date, time);
            Appointment appointment = new Appointment(doctor, patient, appointmentDateTime);
            appointments.add(appointment);

            JPanel appointmentsListPanel = (JPanel) appointmentsPanel.getComponent(1);
            appointmentsListPanel.add(new JLabel(appointment.toString()));
            appointmentsListPanel.revalidate();
            appointmentsListPanel.repaint();
        }
    }
    
    private void viewAppointmentsDialog() {
        JFrame frame = new JFrame("Appointments");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // Create a table to display the appointments
        String[] columnNames = {"Patient Name", "Doctor Name", "Date & Time"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        // Populate the table with appointments
        for (Appointment appointment : appointments) {
            String[] rowData = {
                    appointment.getPatient().getName(),
                    appointment.getDoctor().getName(),
                    appointment.getDateTime().toString(),
            };
            model.addRow(rowData);
        }

        // Add the table to the frame
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    
    private void showDoctorDialog() {
        JFrame dialogFrame = new JFrame("Add Doctor");
        JPanel dialogPanel = new JPanel(new GridLayout(0, 2));

        dialogPanel.add(new JLabel("Name:"));
        JTextField nameTextField = new JTextField();
        dialogPanel.add(nameTextField);

        dialogPanel.add(new JLabel("specialisation:"));
        JTextField specialisationTextField = new JTextField();
        dialogPanel.add(specialisationTextField);

        int result = JOptionPane.showConfirmDialog(dialogFrame, dialogPanel, "Add Doctor", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameTextField.getText();
            String specialisation = specialisationTextField.getText();
            Doctor doctor = new Doctor(name, specialisation);
            doctors.add(doctor);

            JPanel doctorsListPanel = (JPanel) doctorsPanel.getComponent(1);
            doctorsListPanel.add(new JLabel(doctor.toString()));
            doctorsListPanel.revalidate();
            doctorsListPanel.repaint();
        }
    }
    
    private void showPatientDialog() {
        JFrame dialogFrame = new JFrame("Add Patient");
        JPanel dialogPanel = new JPanel(new GridLayout(0, 2));

        dialogPanel.add(new JLabel("Name:"));
        JTextField nameTextField = new JTextField();
        dialogPanel.add(nameTextField);

        dialogPanel.add(new JLabel("Birthdate:"));
        JTextField birthdateTextField = new JTextField();
        dialogPanel.add(birthdateTextField);

        int result = JOptionPane.showConfirmDialog(dialogFrame, dialogPanel, "Add Patient", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameTextField.getText();
            LocalDate birthdate = LocalDate.parse(birthdateTextField.getText());
            Patient patient = new Patient(name, birthdate);
            patients.add(patient);

            JPanel patientsListPanel = (JPanel) patientsPanel.getComponent(1);
            patientsListPanel.add(new JLabel(patient.toString()));
            patientsListPanel.revalidate();
            patientsListPanel.repaint();
        }
    }
    public static void main(String[] args) {
        // Create and show the GUI
    	JFrame frame = new MedicalSystemGUI();
    	frame.setVisible(true);
    }

}
