package View;

import java.util.ArrayList;
import Model.Doctor;

public interface IDoctorRepository {
    void add(Doctor doctor);
    void remove(Doctor doctor);
    void getbyID(int id);
    ArrayList<Doctor> getAll();
}