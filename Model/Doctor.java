package Model;

import java.util.ArrayList;


public class Doctor extends Person{
    private String specialization;
    private ArrayList<Consultation> consultations;
    

    public Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
        this.consultations = new ArrayList<>();
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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
