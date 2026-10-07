import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PasswordGeneratorApp extends JFrame {

    private final JCheckBox cbUppercase;
    private final JCheckBox cbNumbers;
    private final JCheckBox cbSpecialChars;
    private final JSpinner spinnerLength;
    private final JTextField txtGeneratedPassword;  
    private final JButton btnGenerate;
    private final JButton btnCopy;

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{};:,.<>/?";

    private final SecureRandom random = new SecureRandom();

    public PasswordGeneratorApp() {
        setTitle("Secure Password Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 15));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

       
        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS));
        settingsPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Configuration", TitledBorder.LEFT, TitledBorder.TOP));

        JPanel lengthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lengthPanel.add(new JLabel("Password Length:"));
        spinnerLength = new JSpinner(new SpinnerNumberModel(16, 4, 2048, 1));
        lengthPanel.add(spinnerLength);

        cbUppercase = new JCheckBox("Include Uppercase (A-Z)", true);
        cbNumbers = new JCheckBox("Include Numbers (0-9)", true);
        cbSpecialChars = new JCheckBox("Include Special Characters (!@#$)", true);

        cbUppercase.setAlignmentX(Component.LEFT_ALIGNMENT);
        cbNumbers.setAlignmentX(Component.LEFT_ALIGNMENT);
        cbSpecialChars.setAlignmentX(Component.LEFT_ALIGNMENT);
        lengthPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        settingsPanel.add(lengthPanel);
        settingsPanel.add(cbUppercase);
        settingsPanel.add(Box.createVerticalStrut(5));
        settingsPanel.add(cbNumbers);
        settingsPanel.add(Box.createVerticalStrut(5));
        settingsPanel.add(cbSpecialChars);
        settingsPanel.add(Box.createVerticalStrut(10));

    
        JPanel outputPanel = new JPanel(new BorderLayout(10, 10));

        btnGenerate = new JButton("Generate Password");
        btnGenerate.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnGenerate.setFocusPainted(false);

        txtGeneratedPassword = new JTextField(20);
        txtGeneratedPassword.setEditable(false);
        txtGeneratedPassword.setFont(new Font("Monospaced", Font.BOLD, 16));
        txtGeneratedPassword.setHorizontalAlignment(JTextField.LEFT);
        txtGeneratedPassword.setMargin(new Insets(8, 10, 8, 10));

        btnCopy = new JButton("Copy");
        btnCopy.setFocusPainted(false);

        JPanel bottomActionPanel = new JPanel(new BorderLayout(5, 0));
        bottomActionPanel.add(txtGeneratedPassword, BorderLayout.CENTER);
        bottomActionPanel.add(btnCopy, BorderLayout.EAST);

        outputPanel.add(btnGenerate, BorderLayout.NORTH);
        outputPanel.add(bottomActionPanel, BorderLayout.CENTER);

        mainPanel.add(settingsPanel, BorderLayout.NORTH);
        mainPanel.add(outputPanel, BorderLayout.CENTER);
        add(mainPanel);

  
        btnGenerate.addActionListener(e -> generatePassword());

        btnCopy.addActionListener(e -> {
            String password = txtGeneratedPassword.getText();
            if (!password.isEmpty()) {
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(new StringSelection(password), null);
                JOptionPane.showMessageDialog(PasswordGeneratorApp.this,
                        "Password copied to clipboard!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

  
        pack();
        setMinimumSize(new Dimension(450, getHeight()));
        setLocationRelativeTo(null);
    }

    private void generatePassword() {
       
        List<String> groups = new ArrayList<>();
        groups.add(LOWERCASE);
        if (cbUppercase.isSelected()) groups.add(UPPERCASE);
        if (cbNumbers.isSelected()) groups.add(NUMBERS);
        if (cbSpecialChars.isSelected()) groups.add(SPECIAL_CHARS);

    
        StringBuilder pool = new StringBuilder();
        for (String g : groups) pool.append(g);

        int length = (Integer) spinnerLength.getValue();
        List<Character> chars = new ArrayList<>();

        
        for (String g : groups) {
            chars.add(g.charAt(random.nextInt(g.length())));
        }

       
        while (chars.size() < length) {
            chars.add(pool.charAt(random.nextInt(pool.length())));
        }

      
        for (int i = chars.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = chars.get(i);
            chars.set(i, chars.get(j));
            chars.set(j, temp);
        }

        StringBuilder password = new StringBuilder();
        for (char c : chars) password.append(c);

        txtGeneratedPassword.setText(password.toString());
        txtGeneratedPassword.setCaretPosition(0);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException
                 | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new PasswordGeneratorApp().setVisible(true));
    }
}