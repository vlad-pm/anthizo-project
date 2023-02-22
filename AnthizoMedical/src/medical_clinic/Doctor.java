public class Doctor {
    private String name;
    private String specialisation;

    public Doctor(String name, String specialisation) {
        this.name = name;
        this.specialisation = specialisation;
    }

    public String getName() {
        return name;
    }

    public String getspecialisation() {
        return specialisation;
    }

    @Override
    public String toString() {
        return name + " (" + specialisation + ")";
    }
}
