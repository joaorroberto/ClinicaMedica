package Controller;

import java.util.ArrayList;
import Model.Doctor;

public class DoctorRepository {
    private ArrayList<Doctor> doctors = new ArrayList<>();

    public void add(Doctor doctor){
        doctors.add(doctor);
    }

    public void remove(Doctor doctor){
        doctors.remove(doctor);
    }

    public Doctor getById(int id){
        for(Doctor doctor : doctors){
            if(doctor.getId() == (id)){
                return doctor;
            }
        }
        return null;
    }

    public ArrayList<Doctor> getAll() {
        return doctors;
    }
}
