package Model;


public class Consultation {
    private String date;
    private Doctor doctor;
    private Patient patient;
    private String details;

    public Consultation(String date, Doctor doctor, Patient patient, String details) {
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}