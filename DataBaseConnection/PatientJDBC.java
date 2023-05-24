package DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Patient;

public class PatientJDBC implements PatientDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/ClinicaMedica";
    private static final String USUARIO = "root";
    private static final String SENHA = "12345";

    public void adicionarPaciente(Patient paciente) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "INSERT INTO patient (id, name, birth_date) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, paciente.getId());
            statement.setString(2, paciente.getName());
            statement.setString(3, paciente.getBirthDate());
            statement.executeUpdate();
            System.out.println("Paciente adicionado ao banco de dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar paciente: " + e.getMessage());
        }
    }

    public Patient recuperarPaciente(int id) {
        Patient paciente = null;
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "SELECT id, name, birth_date FROM patient WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                paciente = new Patient(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("birth_date"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar paciente: " + e.getMessage());
        }
        return paciente;
    }

    public void atualizarPaciente(Patient paciente) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "UPDATE patient SET name = ?, birth_date = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, paciente.getName());
            statement.setString(2, paciente.getBirthDate());
            statement.setInt(3, paciente.getId());
            statement.executeUpdate();
            System.out.println("Paciente atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar paciente: " + e.getMessage());
        }
    }

    public void excluirPaciente(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "DELETE FROM patient WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir paciente: " + e.getMessage());
        }
    }

}
