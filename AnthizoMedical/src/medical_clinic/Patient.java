import java.time.LocalDate;

public class Patient {
    private String name;
    private LocalDate birthdate;

    public Patient(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        return name + " (born " + birthdate + ")";
    }
}
