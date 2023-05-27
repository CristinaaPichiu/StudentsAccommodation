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
        lblNewUserRegister.setFont(new Font("Helvetica Neue", Font.BOLD, 50));
        lblNewUserRegister.setBounds(195, 170, 700, 50);
        lblNewUserRegister.setForeground(new Color(29, 5, 105));
        contentPane.add(lblNewUserRegister,0);
    }

    /**
     * Create the frame.
     */
    public MenuFrame() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/students.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 975, 657);
        setResizable(false);
        setTitle("Student accommodation 2023");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        Border roundBorder = new RoundBorder(20);
        contentPane.setBorder(roundBorder);
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
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        btnNewButton.setBounds(195, 300, 150, 90);
        btnNewButton.setBorder(roundBorder);
        btnNewButton.setFocusPainted(false); // Elimină efectul de focus la click
        btnNewButton.setBackground(new Color(46, 22, 108)); // Setează culoarea de fundal a butonului la verde
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        btnNewButton = new JButton("See results");
        btnNewButton.addActionListener(e -> SwingUtilities.invokeLater(DistributionFrame::showFrame));
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        btnNewButton.setBounds(405, 300, 150, 90);
        btnNewButton.setBorder(roundBorder);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBackground(new Color(46, 22, 108)); // Setează culoarea de fundal a butonului la verde
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        btnNewButton = new JButton("Exit");
        btnNewButton.addActionListener(e -> System.exit(1));
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        btnNewButton.setBounds(615, 300, 150, 90);
        btnNewButton.setBorder(roundBorder);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBackground(new Color(46, 22, 108)); // Setează culoarea de fundal a butonului la verde
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        // Creați instanța backgroundLabel și setați imaginea de fundal
        JLabel backgroundLabel= new JLabel();
        ImageIcon backgroundImage = new ImageIcon("src/main/resources/background.jpg");
        Image scaledImage = backgroundImage.getImage().getScaledInstance(980, 620, Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImage);
        backgroundLabel.setIcon(scaledBackgroundImage);

        int panelWidth = 990;
        int panelHeight = 620;
        int imageWidth = 3175;
        int imageHeight = 2000;
        // Calculează raporturile de scalare pentru ajustarea imaginii la dimensiunea panoului
        double widthRatio = (double) panelWidth / imageWidth;
        double heightRatio = (double) panelHeight / imageHeight;
        // Alege raportul de scalare cel mai mic pentru a păstra întreaga imagine în panou
        double scaleRatio = Math.min(widthRatio, heightRatio);
        // Calculează dimensiunile redimensionate ale imaginii
        int scaledWidth = (int) (imageWidth * scaleRatio);
        int scaledHeight = (int) (imageHeight * scaleRatio);
        // Setează dimensiunile și poziția pentru backgroundLabel
        backgroundLabel.setBounds(0, 0, scaledWidth, scaledHeight);

        // Adăugați backgroundLabel în contentPane înainte de alte componente
        backgroundLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundLabel.setVerticalAlignment(SwingConstants.CENTER);
        contentPane.add(backgroundLabel,1);
    }
}
