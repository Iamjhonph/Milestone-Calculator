import javax.swing.*;

public class MilestoneGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MilestoneGUI().setupGUI());
    }

    public void setupGUI() {
        JFrame frame = new JFrame("Milestone Calculator");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label1 = new JLabel("Milestone 1 (Max 25):");
        JLabel label2 = new JLabel("Milestone 2 (Max 40):");
        JLabel label3 = new JLabel("Terminal (Max 35):");

        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JLabel resultLabel = new JLabel("Total Grade: ");

        JButton calcButton = new JButton("Calculate");

        // Set bounds
        label1.setBounds(30, 20, 150, 25);
        field1.setBounds(200, 20, 150, 25);
        label2.setBounds(30, 60, 150, 25);
        field2.setBounds(200, 60, 150, 25);
        label3.setBounds(30, 100, 150, 25);
        field3.setBounds(200, 100, 150, 25);
        calcButton.setBounds(150, 140, 100, 30);
        resultLabel.setBounds(30, 180, 300, 25);

        // Add components
        frame.add(label1);
        frame.add(field1);
        frame.add(label2);
        frame.add(field2);
        frame.add(label3);
        frame.add(field3);
        frame.add(calcButton);
        frame.add(resultLabel);

        GradeCalculator calculator = new GradeCalculator();

        calcButton.addActionListener(e -> {
            try {
                int m1 = Integer.parseInt(field1.getText());
                int m2 = Integer.parseInt(field2.getText());
                int term = Integer.parseInt(field3.getText());

                if (m1 < 0 || m2 < 0 || term < 0) {
                    JOptionPane.showMessageDialog(frame, "Cannot input values lower than Zero (0).");
                    return;
                }

                if (!calculator.setGrades(m1, m2, term)) {
                    JOptionPane.showMessageDialog(frame, "One or more inputs exceeded the allowed maximum points.");
                } else {
                    int total = calculator.calculateTotal();
                    resultLabel.setText("Total Grade: " + total + " / 100");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numeric values.");
            }
        });

        frame.setVisible(true);
    }
}