package Model;

import java.util.ArrayList;


public class Clinic {
    private String name;
    private String address;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Clinic(String name, String address) {
        this.name = name;
        this.address = address;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }
}