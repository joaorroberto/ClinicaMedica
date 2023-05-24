package DataBaseConnection;

import Model.Doctor;

public interface DoctorDAO {

    void adicionarDoctor(Doctor doctor);
    Doctor recuperarDoctor(int id);
    void atualizarDoctor(Doctor doctor);
    void excluirDoctor(int id);

}
