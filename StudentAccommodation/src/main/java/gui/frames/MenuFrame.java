package gui.frames;


import java.awt.*;
import java.io.Serial;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class MenuFrame extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    private final JPanel contentPane;

    private JButton btnNewButton;


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MenuFrame frame = new MenuFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Title settings
     */
    private void settingTitle() {
        JLabel lblNewUserRegister = new JLabel("Student accommodation");
        lblNewUserRegister.setFont(new Font("Helvetica Neue", Font.PLAIN, 29));
        lblNewUserRegister.setBounds(475, 50, 375, 50);
        lblNewUserRegister.setForeground(new Color(48, 83, 113));
        contentPane.add(lblNewUserRegister);
    }

    /**
     * Create the frame.
     */
    public MenuFrame() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/students.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1280, 720);
        setResizable(false);
        setTitle("Student accommodation 2022");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        //contentPane.setBackground(new Color(0xD2D6D9));
        Border roundBorder = new RoundBorder(20);
        //contentPane.setBorder(roundBorder);
        contentPane.setBackground(new Color(240, 242, 243));




        settingTitle();


        btnNewButton = new JButton("Apply");
        btnNewButton.addActionListener(e -> EventQueue.invokeLater(() -> {
            try {
                StudRegistrationFrame frame = new StudRegistrationFrame();
                frame.setVisible(true);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(340, 270, 180, 90);
        btnNewButton.setForeground(new Color(23, 72, 23));
        btnNewButton.setBorder(roundBorder);
        btnNewButton.setFocusPainted(false); // Elimină efectul de focus la click
        btnNewButton.setBackground(new Color(23, 72, 23)); // Setează culoarea de fundal a butonului la verde
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        btnNewButton = new JButton("See results");
        btnNewButton.addActionListener(e -> SwingUtilities.invokeLater(DistributionFrame::showFrame));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(550, 270, 180, 90);
        btnNewButton.setForeground(new Color(23, 72, 23));
        btnNewButton.setBorder(roundBorder);
        btnNewButton.setBackground(new Color(23, 72, 23)); // Setează culoarea de fundal a butonului la verde
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        btnNewButton = new JButton("Exit");
        btnNewButton.addActionListener(e -> System.exit(1));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(760, 270, 180, 90);
        btnNewButton.setForeground(new Color(23, 72, 23));
        btnNewButton.setBorder(roundBorder);
        btnNewButton.setBackground(new Color(23, 72, 23)); // Setează culoarea de fundal a butonului la verde
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);
    }
}
