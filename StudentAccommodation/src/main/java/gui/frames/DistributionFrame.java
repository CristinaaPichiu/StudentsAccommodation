package gui.frames;

/**
 * Frame for the distribution in rooms -- 1, 2, 3, 4 ,5
 */

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DistributionFrame extends JPanel implements ActionListener {
    int flag = 0;
    JPanel buttonsPanel;
    JScrollPane tablePanel;
    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JButton jButton4;
    JButton jButton5;

    public DistributionFrame() {
        initializePanel();
    }

    public static void showFrame() {
        JPanel mainPanel = new DistributionFrame();
        mainPanel.setPreferredSize(new Dimension(975, 657));
        mainPanel.setOpaque(true);
        mainPanel.setBackground(new Color(250, 248, 249));

        JFrame frame = new JFrame("Student Distribution for 2023");
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBackground(new Color(250, 248, 249));
    }

    /**
     * Buttons settings
     */
    private void setupButtonsPanel() {
        buttonsPanel.setPreferredSize(new Dimension(1280, 50));
        buttonsPanel.setBackground(new Color(250, 248, 249));

        JLabel dormitoryLabel = new JLabel("Choose dormitory for distribution: ");
        dormitoryLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 23));
        dormitoryLabel.setBounds(10, 30, 150, 70);
        dormitoryLabel.setForeground(new Color(29, 5, 105));
        buttonsPanel.add(dormitoryLabel);

        jButton1 = new JButton("Dormitory 1");
        jButton2 = new JButton("Dormitory 2");
        jButton3 = new JButton("Dormitory 3");
        jButton4 = new JButton("Dormitory 4");
        jButton5 = new JButton("Dormitory 5");

        jButton1.setBackground(new Color(29, 5, 105));
        jButton1.setForeground(Color.WHITE);
        jButton1.setFocusPainted(false);
        jButton2.setBackground(new Color(29, 5, 105));
        jButton2.setForeground(Color.WHITE);
        jButton2.setFocusPainted(false);
        jButton3.setBackground(new Color(29, 5, 105));
        jButton3.setForeground(Color.WHITE);
        jButton3.setFocusPainted(false);
        jButton4.setBackground(new Color(29, 5, 105));
        jButton4.setForeground(Color.WHITE);
        jButton4.setFocusPainted(false);
        jButton5.setBackground(new Color(29, 5, 105));
        jButton5.setForeground(Color.WHITE);
        jButton5.setFocusPainted(false);
    }

    /**
     * Action Listener settings
     */
    private void setupActionListener() {
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        jButton5.addActionListener(this);
    }

    /**
     * Table settings
     * @param columnModel
     */
    private void setCenteredColumns(TableColumnModel columnModel) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );

        for(int index = 0; index < 3; index++) {
            columnModel.getColumn(index).setPreferredWidth(100);
            columnModel.getColumn(index).setCellRenderer(centerRenderer);
        }
    }

    /**
     * Table settings
     * @param flag
     */
    private void initializeTabel(int flag) {
        StudentDistributionTableModel tableModel = new StudentDistributionTableModel(flag);
        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);

        TableColumnModel columnModel = table.getColumnModel();
        setCenteredColumns(columnModel);

        tablePanel = new JScrollPane(table);
    }

    /**
     * Table settings
     */
    private void setupTablePanel() {
        tablePanel.setPreferredSize(new Dimension(975, 657));
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLUE));
    }

    /**
     * Panel settings
     */
    private void initializePanel() {
        buttonsPanel = new JPanel();
        setupButtonsPanel();
        flag = 0;

        drawApp(flag);
        setupActionListener();
    }

    /**
     * App settings
     * @param flag
     */
    private void drawApp(int flag) {
        buttonsPanel.add(jButton1);
        buttonsPanel.add(jButton2);
        buttonsPanel.add(jButton3);
        buttonsPanel.add(jButton4);
        buttonsPanel.add(jButton5);
        this.add(buttonsPanel, BorderLayout.NORTH);

        if(flag != 0) {
            this.remove(tablePanel);
            this.revalidate();
            this.repaint();
        }
        initializeTabel(flag);
        setupTablePanel();

        this.add(tablePanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {
            flag = 1;
        } else if (e.getSource() == jButton2) {
            flag = 2;
        } else if (e.getSource() == jButton3) {
            flag = 3;
        } else if (e.getSource() == jButton4) {
            flag = 4;
        }  else {
            flag = 5;
        }
        drawApp(flag);
        this.revalidate();
        this.repaint();
    }
}
