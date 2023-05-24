package Controller;

import java.util.ArrayList;
import Model.Patient;

public class PatientRepository {
    private ArrayList<Patient> patients = new ArrayList<>();

    public void add(Patient patient){
        patients.add(patient);
    }

    public void remove(Patient patient){
        patients.remove(patient);
    }

    public ArrayList<Patient> getAll() {
        return patients;
    }

    public ArrayList<Patient> getByName(String name) {
        ArrayList<Patient> patientsByName = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getName().equals(name)) {
                patientsByName.add(patient);
            }
        }
        return patientsByName;
    }
}
