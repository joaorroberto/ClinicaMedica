package View;

import java.util.ArrayList;
import Model.Consultation;
import Model.Doctor;
import Model.Patient;

public interface IConsultationRepository {
    void addConsultation(Consultation consultation);
    void removeConsultation(Consultation consultation);
    ArrayList<Consultation> getAllConsultations();
    ArrayList<Consultation> getConsultationsByDoctor(Doctor doctor);
    ArrayList<Consultation> getConsultationsByPatient(Patient patient);
}