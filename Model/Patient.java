package Model;

import java.util.ArrayList;


public class Patient extends Person {
    private String birthDate;
    private ArrayList<Consultation> consultations;

    public Patient(int id, String name, String birthDate) {
        super(id, name);
        this.birthDate = birthDate;
        this.consultations = new ArrayList<>();

    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<Consultation> getConsultations() {
        return consultations;
    }

    public void addConsultation(Consultation consultation) {
        consultations.add(consultation);
    }

    public void removeConsultation(Consultation consultation) {
        consultations.remove(consultation);
    }
    @Override
    public String toString() {
        return super.toString();
    }
}