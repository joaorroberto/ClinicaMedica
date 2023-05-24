package Model;

import java.util.ArrayList;
import Controller.ConsultationController;

public interface FactoryMethod {
    ConsultationController medical = ConsultationController.getInstance();
    public static ArrayList<Integer> DoctorID =  new ArrayList<Integer>();
    public static ArrayList<Integer> PatientID =  new ArrayList<Integer>();
    public static Doctor CreateDoctor(int id, String name, String specialization){
        if (DoctorID.contains(id)) {
            throw new IllegalArgumentException("ID já está sendo usado por outro médico.");
        }
        else{
            DoctorID.add(id);
            Doctor doctor = new Doctor(id, name, specialization);
            medical.adicionardoutor(doctor);
            return doctor;

        }
    }
    public static Patient CreatePatient(int id, String name, String birthDate){
        if (PatientID.contains(id)) {
            throw new IllegalArgumentException("ID já está sendo usado por outro paciente.");
        }
        else{
            PatientID.add(id);
            Patient paciente = new Patient(id, name, birthDate);
            medical.adicionarpaciente(paciente);
            return paciente;

    
        }
    }
    public static Consultation createConsultation(String date, Doctor doctor, Patient patient, String details){
        return new Consultation(date, doctor, patient, details);
    }
}