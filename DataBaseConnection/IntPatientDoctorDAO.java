package DataBaseConnection;

import java.sql.SQLException;

public interface IntPatientDoctorDAO {

    void adicionarAssociacao(int patientId, int doctorId) throws SQLException;

    void desmarcarAssociacao(int patientId, int doctorId) throws SQLException;


}
