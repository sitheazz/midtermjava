import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorAppointmentScheduler {
    public static void main(String[] args) {
        List<Appointment> appointments = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Doctor Appointment Scheduler");
            System.out.println("1. Schedule an appointment");
            System.out.println("2. View appointments");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> scheduleAppointment(appointments, scanner);
                case 2 -> viewAppointments(appointments);
                case 3 -> isRunning = false;
                default -> System.out.println("Invalid choice");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void scheduleAppointment(List<Appointment> appointments, Scanner scanner) {
        System.out.print("Enter patient name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String appointmentDate = scanner.nextLine();
        System.out.print("Enter appointment time (HH:MM): ");
        String appointmentTime = scanner.nextLine();

        Appointment appointment = new Appointment(patientName, appointmentDate, appointmentTime);
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully!");
    }

    private static void viewAppointments(List<Appointment> appointments) {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled");
        } else {
            System.out.println("Appointments:");
            for (int i = 0; i < appointments.size(); i++) {
                System.out.println(i + 1 + ". " + appointments.get(i));
            }
            System.out.print("Enter the appointment number for more details (0 to exit): ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                return;
            }

            if (choice >= 1 && choice <= appointments.size()) {
                Appointment appointment = appointments.get(choice - 1);
                System.out.println("\nAppointment details:");
                System.out.println(appointment);
            } else {
                System.out.println("Invalid appointment number");
            }
        }
    }
}

class Appointment {
    private final String patientName;
    private final String appointmentDate;
    private final String appointmentTime;

    public Appointment(String patientName, String appointmentDate, String appointmentTime) {
        this.patientName = patientName;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    @Override
    public String toString() {
        return "Patient: " + patientName + " | Date: " + appointmentDate + " | Time: " + appointmentTime;
    }
}