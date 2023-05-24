package View;

import java.util.ArrayList;
import Model.Patient;

public interface IPatientRepository {
    void add(Patient patient);
    void remove(Patient patient);
    void getbyID(int id);
    ArrayList<Patient> getAll();
}