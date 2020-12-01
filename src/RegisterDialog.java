import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.*;

public class RegisterDialog extends JDialog {

    private static JTextField tfUsername;
    private JTextField tfCredit;
    private JTextField tfPlate;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JLabel lbCredit;
    private JLabel lbPlate;
    private JButton btnReg;
    private JButton btnCancel;
    private boolean succeeded;

    public RegisterDialog(Frame parent) {
        super(parent, "Sign Up", true);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);

        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);

        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);

        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));

        lbCredit = new JLabel("Credit Card Number: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lbCredit, cs);

        tfCredit = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(tfCredit, cs);

        lbPlate = new JLabel("License Plate Number: ");
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(lbPlate, cs);

        tfPlate = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 2;
        panel.add(tfPlate, cs);

        btnReg = new JButton("Sign Up");

        btnReg.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    if (!Login.authenticate(getUsername(), getPassword())) {
                        JOptionPane.showMessageDialog(RegisterDialog.this,
                                "Hi " + getUsername() + "! You have successfully registered.",
                                "Sign Up",
                                JOptionPane.INFORMATION_MESSAGE);
                        succeeded = true;
                        Login.setPressed();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(RegisterDialog.this,
                                "Invalid username or password",
                                "Login",
                                JOptionPane.ERROR_MESSAGE);
                        // reset username and password
                        tfUsername.setText("");
                        pfPassword.setText("");
                        succeeded = false;

                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel bp = new JPanel();
        bp.add(btnReg);
        bp.add(btnCancel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }


    public static String getUsername() {
        return tfUsername.getText().trim();
    }

    public String getPassword() {
        return new String(pfPassword.getPassword());
    }


    public boolean isSucceeded() {
        return succeeded;
    }
}