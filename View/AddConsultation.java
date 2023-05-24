package View;

import javax.swing.*;

import Controller.ConsultationController;
import DataBaseConnection.ConnectionDB;
import DataBaseConnection.PatientDoctorDAO;
import Model.Consultation;
import Model.Doctor;
import Model.FactoryMethod;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class AddConsultation extends JFrame {
    private JLabel dataLabel, doutorLabel, pacienteLabel, detalhesLabel;
    private JTextField dataField, doutorField, pacienteField;
    private JTextArea detalhesArea;
    private JButton adicionarButton;
    private JButton removerButton;

    // singleton consultation
    ConsultationController medical = ConsultationController.getInstance();

    public AddConsultation(PrincipalView principalView) {
        super("Consulta");

        dataLabel = new JLabel("Data da consulta:");
        dataField = new JTextField(10);

        doutorLabel = new JLabel("Nome do doutor:");
        doutorField = new JTextField(30);

        pacienteLabel = new JLabel("Nome do paciente:");
        pacienteField = new JTextField(30);

        detalhesLabel = new JLabel("Detalhes da consulta:");
        detalhesArea = new JTextArea(5, 30);
        JScrollPane scrollPane = new JScrollPane(detalhesArea);
        ConnectionDB connection = new ConnectionDB();
        adicionarButton = new JButton("Adicionar consulta");
        adicionarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int doctorId = Integer.parseInt(doutorField.getText());
                int patientId = Integer.parseInt(pacienteField.getText());

                PatientDoctorDAO patientDoctorDAO = new PatientDoctorDAO();
                try {
                    patientDoctorDAO.adicionarAssociacao(patientId, doctorId);
                    System.out.println("Consulta marcada com sucesso!");
                } catch (SQLException ex) {
                    System.out.println("Erro ao marcar consulta: " + ex.getMessage());
                }

                dataField.setText("");
                doutorField.setText("");
                pacienteField.setText("");
                detalhesArea.setText("");
                // ADD CONSULTATION
            }
        });

        removerButton = new JButton("VOLTAR");
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                principalView.setVisible(true);
                // BACK BUTTON
            }

        });

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Configuração dos componentes no painel

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(dataLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(dataField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(doutorLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(doutorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(pacienteLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(pacienteField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(detalhesLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(scrollPane, gbc); // Correção do erro de fechamento do bloco

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(adicionarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(removerButton, gbc);

        setResizable(false);

        setContentPane(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
