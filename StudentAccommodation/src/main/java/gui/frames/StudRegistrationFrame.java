package gui.frames;


import database.repository.ValidationDataRepository;
import gui.util.DateLabelFormatter;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class StudRegistrationFrame extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    private final JPanel contentPane;

    private JTextField lastname;
    private JTextField firstname;
    JRadioButton radioButtonMale;
    JRadioButton radioButtonFemale;
    private JComboBox<String> yearSelector;
    private JComboBox<String> groupSelector;

    private JTextField email;
    private JTextField serialNumber;
    private JTextField gpaField;
    private JDatePickerImpl datePicker;

    private JButton btnNewButton;
    private int addHeight = 120;
    private int addWidth = 580;

    /**
     * Title settings
     */
    private void settingTitle() {
        JLabel lblNewUserRegister = new JLabel("Student accommodation");
        lblNewUserRegister.setFont(new Font("Helvetica Neue", Font.BOLD, 35));
        lblNewUserRegister.setBounds(320, 30, 550, 50);
        lblNewUserRegister.setForeground(new Color(29, 5, 105));
        contentPane.add(lblNewUserRegister);
    }
    /**
     * Label settings
     */
    private void settingLabels(int posX, int posY, int width, int height, String labelName) {
        JLabel lblNewLabel = new JLabel(labelName);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(Font.BOLD, 20));
        lblNewLabel.setForeground(new Color(29, 5, 105));
        lblNewLabel.setBounds(posX, posY, width, height);
        contentPane.add(lblNewLabel);
    }

    /**
     * Last name settings
     */
    private void settingLastName(int posX, int posY) {
        settingLabels(posX, posY, 110, 29, "Last name");

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));

        lastname.setBounds(posX + 156, posY - 8, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);
    }

    /**
     * First name settings
     */
    private void settingFirstName(int posX, int posY) {
        settingLabels(posX, posY, 110, 29, "First name");

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(posX + 156, posY - 8, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);
    }


    /**
     * Gender settings
     */
    private void settingGender(int posX, int posY) {
        settingLabels(posX, posY, 110, 29, "Gender");
        settingLabels(posX + 170, posY - 8, 150, 50, "Male");

        radioButtonMale = new JRadioButton("");
        radioButtonMale.setBounds(posX + 170 + 50, posY, 30, 30);
        radioButtonMale.setBackground(new Color(0xD2D6D9));
        contentPane.add(radioButtonMale);

        settingLabels(posX + 170 + 60 + 50, posY - 8, 150, 50, "Female");

        radioButtonFemale = new JRadioButton("");
        radioButtonFemale.setBounds(posX + +170 + 60 + 50 + 75, posY, 30, 30);
        radioButtonFemale.setBackground(new Color(0xD2D6D9));
        contentPane.add(radioButtonFemale);
    }

    /**
     * Year settings
     */
    private void settingYearGroup(int posX, int posY) {
        settingLabels(posX - 8, posY - 30, 200, 29, "Year and Group");

        yearSelector = new JComboBox<>();
        yearSelector.addItem("Select year");
        yearSelector.addItem("1");
        yearSelector.addItem("2");
        yearSelector.addItem("3");
        yearSelector.setBounds(posX + 156, posY - 30, 100, 30);
        contentPane.add(yearSelector);

        groupSelector = new JComboBox<>();
        groupSelector.addItem("Select group");
        groupSelector.addItem("A1");
        groupSelector.addItem("A2");
        groupSelector.addItem("A3");
        groupSelector.addItem("A4");
        groupSelector.addItem("A5");
        groupSelector.addItem("B1");
        groupSelector.addItem("B2");
        groupSelector.addItem("B3");
        groupSelector.addItem("B4");
        groupSelector.addItem("B5");
        groupSelector.setBounds(posX + 156 + 120, posY - 30, 100, 30);
        contentPane.add(groupSelector);
    }

    /**
     * Email settings
     */
    private void settingEmail(int posX, int posY) {
        settingLabels(posX, posY, 200, 29, "Email\r\n address");

        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(posX + 156, posY - 8, 228, 50);
        contentPane.add(email);
        email.setColumns(10);
    }
    /**
     * Serial number settings
     */
    private void settingSerialNumber(int posX, int posY) {
        settingLabels(posX - 8, posY - 8, 200, 29, "Serial number");

        serialNumber = new JTextField();
        serialNumber.setFont(new Font("Tahoma", Font.PLAIN, 32));
        serialNumber.setBounds(posX + 156, posY - 8, 228, 50);
        contentPane.add(serialNumber);
        serialNumber.setColumns(10);
    }

    /**
     * Gpa settings
     */
    private void settingGpa(int posX, int posY) {
        settingLabels(posX, posY, 110, 29, "GPA");

        gpaField = new JTextField();
        gpaField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        gpaField.setBounds(posX + 156, posY - 8, 228, 50);
        contentPane.add(gpaField);
    }

    /**
     * Date of birth settings
     */
    private void settingDateOfBirth(int posX, int posY) {
        settingLabels(posX, posY - 30, 200, 29, "Date of birth");

        UtilDateModel model = new UtilDateModel();
        model.setDate(1995, 1, 1);
        model.setSelected(true);

        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(posX + 156, posY - 30, 228, 30);
        contentPane.add(datePicker);
    }

    /**
     * Label settings
     */
    private void settingAllLabels() {
        settingTitle();

        int startPositionX = 120;
        int startPositionY = 125;

        settingLastName(startPositionX, startPositionY);

        startPositionY += addHeight;
        settingFirstName(startPositionX, startPositionY);

        startPositionY += addHeight;
        settingGender(startPositionX, startPositionY);

        startPositionY += addHeight;
        settingYearGroup(startPositionX, startPositionY);

        startPositionX = 200 + addWidth;
        startPositionY = 125;
        settingEmail(startPositionX, startPositionY);

        startPositionY += addHeight;
        settingSerialNumber(startPositionX, startPositionY);

        startPositionY += addHeight;
        settingGpa(startPositionX, startPositionY);

        startPositionY += addHeight;
        settingDateOfBirth(startPositionX, startPositionY);
    }

    /**
     * Content panel settings
     */
    private void contentPaneProperties() {
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        contentPane.setBackground(new Color(0xD2D6D9));
    }

    /**
     * Frame settings
     */
    private void frameProperties() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/student.png"));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(0, 0, 975, 657);
        setResizable(false);
    }

    /**
     * Create the frame.
     */
    public StudRegistrationFrame() {
        frameProperties();
        contentPane = new JPanel();
        contentPaneProperties();

        settingAllLabels();

        btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(e -> {
            boolean valid = false;
            int countDifCharacters = 0;
            int countNumbers = 0;
            int count = 0;

            String lastName = this.lastname.getText();
            String firstName = this.firstname.getText();
            String femaleGender = String.valueOf(this.radioButtonFemale.isSelected());
            String maleGender = String.valueOf(this.radioButtonMale.isSelected());
            String year = Objects.requireNonNull(this.yearSelector.getSelectedItem()).toString();
            String group = Objects.requireNonNull(this.groupSelector.getSelectedItem()).toString();
            String emailAddr = this.email.getText();
            String serialNumber = this.serialNumber.getText();
            String gpa = this.gpaField.getText();
            String dob = this.datePicker.getJFormattedTextField().getText();

            ValidationDataRepository validationDataRepository = new ValidationDataRepository(lastName, firstName, year, group, emailAddr, serialNumber, gpa, dob, femaleGender, maleGender);
            try {
                if (serialNumber.length() > 0 && firstName.length() > 0 && lastName.length() > 0 && (femaleGender.equals("true") || maleGender.equals("true")) && year.length() > 0 && group.length() > 0 && emailAddr.length() > 0 && gpa.length() > 0) {

                    for (int index = 0; index < gpa.length(); index++) {

                        if (gpa.charAt(index) == '0' || gpa.charAt(index) == '1' || gpa.charAt(index) == '2' || gpa.charAt(index) == '3' || gpa.charAt(index) == '4' || gpa.charAt(index) == '5' || gpa.charAt(index) == '6' || gpa.charAt(index) == '7' || gpa.charAt(index) == '8' || gpa.charAt(index) == '9') {
                            countNumbers++;
                        } else if (gpa.charAt(index) == '.') {
                            count++;
                        } else
                            countDifCharacters++;
                    }
                    if (count == 1 && countDifCharacters == 0 && gpa.length() == (count + countNumbers) && gpa.charAt(1) == '.') {
                        valid = true;
                    }
                    if (valid && !year.equals("Select year")) {
                        JOptionPane.showMessageDialog(btnNewButton, validationDataRepository.validare());
                    } else
                        JOptionPane.showMessageDialog(btnNewButton, "Invalid data!");

                } else {
                    JOptionPane.showMessageDialog(btnNewButton, "All fields must be completed!");
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Border roundBorder = new RoundBorder(20);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(550, 550, 148, 74);
        btnNewButton.setForeground(new Color(23, 72, 23));
        btnNewButton.setBorder(roundBorder);
        btnNewButton.setFocusPainted(false); // Elimină efectul de focus la click
        btnNewButton.setBackground(new Color(23, 72, 23)); // Setează culoarea de fundal a butonului la verde
        btnNewButton.setForeground(Color.WHITE);        contentPane.add(btnNewButton);
    }
}