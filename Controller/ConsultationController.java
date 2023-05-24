package Controller;

import java.util.ArrayList;

import Model.Consultation;
import Model.Doctor;
import Model.Patient;

public class ConsultationController {
    ArrayList<Patient> listadospacientes = new ArrayList<>();
    ArrayList<Consultation> listadoconsultation = new ArrayList<>();
    ArrayList<Doctor> doutores = new ArrayList<>();
    //SINGLETON
    private static ConsultationController instance;
    private ConsultationController() {
    }
    /*SINGLETON */
    public static synchronized ConsultationController getInstance() {
        if (instance == null) {
            instance = new ConsultationController();
        }
        return instance;
    } 
    public void adicionarconsulta(Consultation consultation){
        listadoconsultation.add(consultation);
    }

    public Doctor getbyname(String name){
        Doctor retornododoutor = null;
        for(Doctor doctor : doutores){
            if(doctor.getName().equals(name)){
                retornododoutor = doctor;
            }
        }
        return retornododoutor;
    }

    public void adicionardoutor(Doctor doctor){
        doutores.add(doctor);

    }
    
    
    public Patient pegarpaciente(String name){
        Patient retornodopaciente = null;
        for(Patient patient : listadospacientes){
            if(patient.getName().equals(name)){
                retornodopaciente = patient;
            }
        }
        return retornodopaciente;
    }

    public void adicionarpaciente(Patient patient){
        listadospacientes.add(patient);
    }

    public void retornarconsultas(){
        for(Consultation consultas : listadoconsultation){
            System.out.println("CONSULTA");
            System.out.println(consultas.getDate());
            System.out.println(consultas.getDoctor().getName());
            System.out.println(consultas.getPatient().getName());
            System.out.println(consultas.getDetails());
            System.out.println("-------------------");
        }
    }


}