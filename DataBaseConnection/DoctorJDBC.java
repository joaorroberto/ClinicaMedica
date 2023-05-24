package DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Doctor;

public class DoctorJDBC implements DoctorDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/ClinicaMedica";
    private static final String USUARIO = "root";
    private static final String SENHA = "12345";

    public void adicionarDoctor(Doctor doctor) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "INSERT INTO doctor (id, name, specialization) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, doctor.getId());
            statement.setString(2, doctor.getName());
            statement.setString(3, doctor.getSpecialization());
            statement.executeUpdate();
            System.out.println("Médico adicionado ao banco de dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar médico: " + e.getMessage());
        }
    }

    public Doctor recuperarDoctor(int id) {
        Doctor doctor = null;
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "SELECT id, name, specialization FROM doctor WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                doctor = new Doctor(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("specialization"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar médico: " + e.getMessage());
        }
        return doctor;
    }

    public void atualizarDoctor(Doctor doctor) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "UPDATE doctor SET name = ?, specialization = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getSpecialization());
            statement.setInt(3, doctor.getId());
            statement.executeUpdate();
            System.out.println("Médico atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar médico: " + e.getMessage());
        }
    }

    public void excluirDoctor(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "DELETE FROM doctor WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir médico: " + e.getMessage());
        }
    }

}
