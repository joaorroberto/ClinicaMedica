package DataBaseConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDoctorDAO implements IntPatientDoctorDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/ClinicaMedica";
    private static final String USUARIO = "root";
    private static final String SENHA = "12345";

    @Override
    public void adicionarAssociacao(int patient_Id, int doctor_Id, String consultadata, String detalhes) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "INSERT INTO patient_doctor (patient_id, doctor_id, consultadata, detalhes) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, patient_Id);
            statement.setInt(2, doctor_Id);
            statement.setString(3, consultadata);
            statement.setString(4, detalhes);
            statement.executeUpdate();
            System.out.println("Consulta marcada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao marcar consulta: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void desmarcarAssociacao(int patientId, int doctorId, String consultadata) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "DELETE FROM patient_doctor WHERE patient_id = ? AND doctor_id = ? AND consultadata = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, patientId);
            statement.setInt(2, doctorId);
            statement.setString(3, consultadata);
            statement.executeUpdate();
            System.out.println("Consulta desmarcada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao desmarcar consulta: " + e.getMessage());
            throw e;
        }
    }

}
