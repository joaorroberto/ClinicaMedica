package DataBaseConnection;

import java.sql.SQLException;

public interface IntPatientDoctorDAO {

    void adicionarAssociacao(int patientId, int doctorId, String date, String details) throws SQLException;

    void desmarcarAssociacao(int patientId, int doctorId, String date) throws SQLException;


}
