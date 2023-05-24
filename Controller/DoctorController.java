package Controller;

import java.util.ArrayList;
import Model.Doctor;

public class DoctorController {
    private ArrayList<Doctor> doctors = new ArrayList<>();

    public DoctorController(){

    }

    public void addDoctor(Doctor doctor){
        doctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor){
        doctors.remove(doctor);

    }

    public void removeDoctorById(int id){
        for(Doctor doctor : doctors){
            if(doctor.getId() ==(id)){
                doctors.remove(doctor);
            }
        }
    }

    public void getbyID(int id){
        for(Doctor doctor : doctors){
            if(doctor.getId() == (id)){
                System.out.println(doctor.getName());
                System.out.println(doctor.getSpecialization());
                System.out.println(doctor.getPhone());
            }
        }
    }

    public void adicionarMedico(Doctor doctor) {
    }
}
