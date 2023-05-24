package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ConsultationController;
import Controller.DoctorController;
import Model.Doctor;
import Model.FactoryMethod;
import View.PrincipalView;
import DataBaseConnection.ConnectionDB;
import DataBaseConnection.DoctorDAO;
import DataBaseConnection.DoctorJDBC;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDoctor extends JFrame {
    private JLabel id;
    private JTextField idField;
    private JPanel panel;
    private JLabel nameLabel;
    private JLabel specializationLabel;
    private JTextField nameField;
    private JTextField specializationField;
    private JButton adicionarButton;
    private JButton voltarButton;

    public AddDoctor(PrincipalView principalView) {
        //WINDOW SETTINGS
        setTitle("Cadastro de Médico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        //DASHBOARD CREATION
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.insets.bottom = 5;

        //Singleton consultation
        ConsultationController medical = ConsultationController.getInstance();

        //LABEL AND TEXT FIELD FOR DOCTOR'S ID
        id = new JLabel("ID do Médico:");
        constraints.gridx = 0;
        panel.add(id, constraints);

        idField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(idField, constraints);

        //LABEL AND TEXT FIELD FOR DOCTOR'S NAME
        nameLabel = new JLabel("Nome do Médico:");
        constraints.gridx = 0;
        panel.add(nameLabel, constraints);

        nameField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(nameField, constraints);

        //LABEL AND TEXT FIELD THE THE SPECIALITAZION
        specializationLabel = new JLabel("Especialização:");
        constraints.gridx = 0;
        panel.add(specializationLabel, constraints);

        specializationField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(specializationField, constraints);

        //ADD BUTTON
        adicionarButton = new JButton("Adicionar Médico");
        constraints.gridy = 3;
        panel.add(adicionarButton, constraints);

        //BACK BUTTON
        voltarButton = new JButton("VOLTAR");
        constraints.gridy = 3;
        constraints.gridx = 0;
        panel.add(voltarButton, constraints);

        //ADD PANEL TO WINDOW
        add(panel);

        //MAKES THE WINDOW VISIBLE
        setVisible(true);

        //INSTANCIA O DOCTORCONTROLLER    
        //DoctorController doctorc = new DoctorController();

        //ACTIONS ADD BUTTON
        adicionarButton.addActionListener(new ActionListener() {
            ConnectionDB bd = new ConnectionDB();
            @Override
            public void actionPerformed(ActionEvent e) {
        
                int doctorId = Integer.parseInt(idField.getText());
                String doctorName = nameField.getText();
                String specialization = specializationField.getText();

                Doctor doctor = FactoryMethod.CreateDoctor(doctorId, doctorName, specialization);

                DoctorJDBC doctorJDBC = new DoctorJDBC();
                doctorJDBC.adicionarDoctor(doctor);


                //DELETING PREVIOUS TEXT
                nameField.setText("");
                specializationField.setText("");
                idField.setText("");
            }
        });

        //ACTIONS BACK BUTTON
        voltarButton.addActionListener(new ActionListener() {
            
			@Override
			public void actionPerformed(ActionEvent e) {
                setVisible(false);
                principalView.setVisible(true);
                
			}
        });
        
    }
}
