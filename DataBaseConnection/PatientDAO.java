package DataBaseConnection;

import Model.Patient;

public interface PatientDAO {

    void adicionarPaciente(Patient paciente);
    Patient recuperarPaciente(int id);
    void atualizarPaciente(Patient paciente);
    void excluirPaciente(int id);

}

