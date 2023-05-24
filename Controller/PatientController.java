package Controller;

import java.util.ArrayList;

import Model.Patient;

public class PatientController {
    private ArrayList<Patient> patients = new ArrayList<>();

    public PatientController(){

    }
    /* Creating functions to remove or add patients to the ArrayList. */
    public void addPatient(Patient patient){
        patients.add(patient);
    }

    public void removePatient(Patient patient){
        patients.remove(patient);
    }

    /*Creating a function about to remove the patient by id.  */

    public void removebyIdPatient(int id){
        for(Patient patient : patients){
            if(patient.getId() == (id)){
                patients.remove(patient);
            }
        }
    }

    public void getbyID(int id){
        for(Patient patient : patients){
            if(patient.getId() == (id)){
                System.out.println(patient.getName());
                System.out.println(patient.getPhone());
            }
        }
    }


}
