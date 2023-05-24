package Controller;

import java.util.ArrayList;
import Model.Consultation;
import Model.Doctor;
import Model.Patient;

public class ConsultationRepository {
    private ArrayList<Consultation> consultations = new ArrayList<>();

    public void add(Consultation consultation) {
        consultations.add(consultation);
    }

    public void remove(Consultation consultation) {
        consultations.remove(consultation);
    }

    public ArrayList<Consultation> getAll() {
        return consultations;
    }

    public ArrayList<Consultation> getByDoctor(Doctor doctor) {
        ArrayList<Consultation> consultationsByDoctor = new ArrayList<>();
        for (Consultation consultation : consultations) {
            if (consultation.getDoctor().equals(doctor)) {
                consultationsByDoctor.add(consultation);
            }
        }
        return consultationsByDoctor;
    }

    public ArrayList<Consultation> getByPatient(Patient patient) {
        ArrayList<Consultation> consultationsByPatient = new ArrayList<>();
        for (Consultation consultation : consultations) {
            if (consultation.getPatient().equals(patient)) {
                consultationsByPatient.add(consultation);
            }
        }
        return consultationsByPatient;
    }
}
