// GameSetupOnly.java
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class GUI {
    private JFrame frame;
    private JTextField nameField;
    private JTextField healthField;
    private JTextField xField;
    private JTextField yField;
    private JComboBox<String> colliderBox;

    private static final boolean OPEN_CSV = true;

    public GUI() {
        initUI();
    }

    private void initUI() {
        frame = new JFrame("Game Setup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 380);
        frame.setMinimumSize(new Dimension(380, 340));
        frame.setLocationRelativeTo(null);

        JPanel content = new JPanel(new GridBagLayout());
        content.setBorder(new EmptyBorder(20, 18, 20, 18));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("Dialog", Font.PLAIN, 13);
        Font fieldFont = new Font("Dialog", Font.PLAIN, 14);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lName = new JLabel("Ime");
        lName.setFont(labelFont);
        content.add(lName, gbc);

        gbc.gridy++;
        JLabel lHealth = new JLabel("Health (0–100)");
        lHealth.setFont(labelFont);
        content.add(lHealth, gbc);

        gbc.gridy++;
        JLabel lX = new JLabel("X pozicija");
        lX.setFont(labelFont);
        content.add(lX, gbc);

        gbc.gridy++;
        JLabel lY = new JLabel("Y pozicija");
        lY.setFont(labelFont);
        content.add(lY, gbc);

        gbc.gridy++;
        JLabel lCollider = new JLabel("Kolajder");
        lCollider.setFont(labelFont);
        content.add(lCollider, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        nameField = new JTextField("Harry Potter");
        nameField.setFont(fieldFont);
        nameField.setPreferredSize(new Dimension(220, 28));
        content.add(nameField, gbc);

        gbc.gridy++;
        healthField = new JTextField("90");
        healthField.setFont(fieldFont);
        content.add(healthField, gbc);

        gbc.gridy++;
        xField = new JTextField("12");
        xField.setFont(fieldFont);
        content.add(xField, gbc);

        gbc.gridy++;
        yField = new JTextField("9");
        yField.setFont(fieldFont);
        content.add(yField, gbc);

        gbc.gridy++;
        colliderBox = new JComboBox<>(new String[] {"Rectangle", "Circle"});
        colliderBox.setFont(fieldFont);
        content.add(colliderBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        content.add(Box.createVerticalGlue(), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;

        JButton startBtn = new JButton("Pokreni igru");
        startBtn.setFont(new Font("Dialog", Font.BOLD, 16));
        startBtn.setPreferredSize(new Dimension(180, 52));
        startBtn.addActionListener(e -> onStart());
        content.add(startBtn, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        content.add(Box.createHorizontalStrut(8), gbc);

        frame.getContentPane().add(content);
        frame.setVisible(true);
    }

    private void onStart() {
        try {
            String name = nameField.getText();
            if (name == null) name = "";
            name = name.trim();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("Ime ne smije biti prazno.");
            }
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1);

            int health;
            try {
                health = Integer.parseInt(healthField.getText().trim());
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Health mora biti cijeli broj.");
            }
            if (health < 0 || health > 100) throw new IllegalArgumentException("Health mora biti između 0 i 100.");

            int x, y;
            try {
                x = Integer.parseInt(xField.getText().trim());
                y = Integer.parseInt(yField.getText().trim());
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Pozicije X i Y moraju biti cijeli brojevi.");
            }

            String collider = (String) colliderBox.getSelectedItem();

            String chosenCsvPath = null;
            if (OPEN_CSV) {
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Izaberite enemies CSV fajl (opciono)");
                int res = chooser.showOpenDialog(frame);
                if (res == JFileChooser.APPROVE_OPTION) {
                    File csv = chooser.getSelectedFile();
                    chosenCsvPath = csv.getAbsolutePath();
                }
            }

            StringBuilder msg = new StringBuilder();
            msg.append("Player: ").append(name).append("\n");
            msg.append("Health: ").append(health).append("\n");
            msg.append("Pozicija: (").append(x).append(", ").append(y).append(")\n");
            msg.append("Kolajder: ").append(collider).append("\n");
            if (chosenCsvPath != null) msg.append("CSV: ").append(chosenCsvPath).append("\n");

            JOptionPane.showMessageDialog(frame, msg.toString(), "Sažetak", JOptionPane.INFORMATION_MESSAGE);

        } catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(frame, iae.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Neočekivana greška: " + ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}
