package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.ConsultationController;
import Model.FactoryMethod;
import Model.Patient;


public class AddPatient extends JFrame {

    private JLabel labelId;
    private JLabel labelNome;
    private JTextField inputId;
    private JTextField inputNome;
    private JLabel labelBirthdate;
    private JTextField inputBirthdate;
    private JButton voltarButton;
    private ArrayList<Patient> patients = new ArrayList<>();

    public AddPatient(PrincipalView viewPrincipal) {
        
        //Singleton Patient
        ConsultationController medical = ConsultationController.getInstance();

        //BASIC WINDOW SETTINGS
        setTitle("Consultorio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLayout(null);
        setResizable(false);
        setVisible(true);

        this.patients = patients;

        labelId = new JLabel("Id");
        labelId.setBounds(50, 50, 50, 20);
        add(labelId);

        inputId = new JTextField();
        inputId.setBounds(100, 50, 200, 20);
        add(inputId);

        labelNome = new JLabel("Nome do paciente");
        labelNome.setBounds(50, 80, 50, 20);
        add(labelNome);

        inputNome = new JTextField();
        inputNome.setBounds(100, 80, 200, 20);
        add(inputNome);

        labelBirthdate = new JLabel("Data de nascimento");
        labelBirthdate.setBounds(50, 110, 50, 20);
        add(labelBirthdate);

        inputBirthdate = new JTextField();
        inputBirthdate.setBounds(100, 110, 200, 20);
        add(inputBirthdate);

        JButton salvarButton = new JButton("Salvar");
        salvarButton.setBounds(150, 150, 80, 25);
        add(salvarButton);

        //BACK BUTTON
        voltarButton = new JButton("Voltar");
        voltarButton.setBounds(250, 150, 80, 25);
        add(voltarButton);

        voltarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                viewPrincipal.setVisible(true);
            }
            
        });

        //SAVE BUTTON
        salvarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(inputId.getText());
                String nome = inputNome.getText();
                String birthdate = inputBirthdate.getText();

                Patient paciente = new Patient(id, nome, birthdate);
                medical.adicionarpaciente(paciente);
                Patient fact = FactoryMethod.CreatePatient(id, nome, birthdate);
                System.out.println("Paciente adicionado com sucesso !");
                
            }
        });
    }
}
