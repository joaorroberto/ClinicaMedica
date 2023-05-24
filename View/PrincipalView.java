package View;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.ConsultationController;
import DataBaseConnection.DoctorDAO;
import DataBaseConnection.DoctorJDBC;
import DataBaseConnection.PatientDoctorDAO;
import DataBaseConnection.PatientJDBC;

import java.util.InputMismatchException;
import java.util.Scanner;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Dimension;

public class PrincipalView extends JFrame {
    private JPanel mainPanel;
    private JButton AddPatient;
    private JButton AddDoctor;
    private JButton AddConsultation;
    private JButton VisualizarConsultas;
    private JButton DeletarDoctor;
    private JButton DeletarPaciente;
    private JButton MarcarConsultas;
    public PrincipalView() {
        
        //WINDOW SETTINGS
        setTitle("Consultorio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 200);
        setResizable(false);

        //CREATION OF THE MAIN PANEL
        mainPanel = new JPanel(new BorderLayout());

        //BUTTON CREATION
        AddPatient = new JButton("Adicionar paciente");
        AddDoctor = new JButton("Adicionar doutor");
        AddConsultation = new JButton("Adicionar consulta");
        VisualizarConsultas = new JButton("Visualizar consultas");
        DeletarDoctor = new JButton("Deletar doutor do banco de dados");
        DeletarPaciente = new JButton("Deletar paciente do banco de dados");
        MarcarConsultas = new JButton("Adicionar consultas ao banco de dados");

        //BUTTON LAYOUT CONFIGURATION
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 0, 10));
        buttonPanel.setPreferredSize(new Dimension(200, 120)); // Define tamanho do painel
        buttonPanel.add(AddPatient);
        buttonPanel.add(AddDoctor);
        buttonPanel.add(AddConsultation);
        buttonPanel.add(VisualizarConsultas);
        buttonPanel.add(DeletarDoctor);
        buttonPanel.add(DeletarPaciente);
        buttonPanel.add(MarcarConsultas);

        //ADDS BUTTON PANEL TO MAIN PANEL
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        //ADD MAIN PANEL 
        add(mainPanel);

        //MAKES THE WINDOW VISIBLE
        setVisible(true);


        PrincipalView viewPrincipal = this;
        ConsultationController consultacontroller = ConsultationController.getInstance();

        //ADD A PATIENT
        AddPatient.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddPatient addP = new AddPatient(viewPrincipal);
            }
            
        });

        //ADD A DOCTOR
        AddDoctor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddDoctor addD = new AddDoctor(viewPrincipal);
            }
            
        });

        //ADD MEDICAL APPOINTMENT
        AddConsultation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddConsultation addC = new AddConsultation(viewPrincipal); 
            }
            
        });
        DeletarDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o ID do médico a ser excluído: ");
                int id;
                try {
                    id = scanner.nextInt();
                    DoctorJDBC doctorJDBC = new DoctorJDBC();
                    doctorJDBC.excluirDoctor(id);
                    System.out.println("Médico excluído com sucesso!");
                } catch (InputMismatchException ex) {
                    System.out.println("Id inválido");
                }
            }
        });

        DeletarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o ID do paciente a ser excluído: ");
                int id;
                try {
                    id = scanner.nextInt();
                    PatientJDBC poctorJDBC = new PatientJDBC();
                    poctorJDBC.excluirPaciente(id);
                    System.out.println("Paciente excluído com sucesso!");
                } catch (InputMismatchException ex) {
                    System.out.println("Id inválido");
                }
            }
        });

        MarcarConsultas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Digite o ID do paciente: ");
                int pacienteId = scanner.nextInt();
        
                System.out.print("Digite o ID do médico: ");
                int doctorId = scanner.nextInt();
        
                PatientDoctorDAO patientDoctorDAO = new PatientDoctorDAO();
        
                try {
                    patientDoctorDAO.adicionarAssociacao(pacienteId, doctorId);
                    System.out.println("Associação paciente-médico adicionada com sucesso!");
                } catch (SQLException ex) {
                    System.out.println("Erro ao adicionar associação paciente-médico: " + ex.getMessage());
                }
            }
        });
        

        Scanner scanner = new Scanner(System.in);

        //VISUALIZAR CONSULTAS
        VisualizarConsultas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                consultacontroller.retornarconsultas();
            }
            
        });
    }

    public static void main(String[] args) {
        PrincipalView PrincipalView = new PrincipalView();
    }
}
