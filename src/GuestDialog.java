import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class GuestDialog extends JDialog {

    private static JTextField tfFirstName;
    private JTextField tfCredit;
    private JTextField tfPlate;
    private JPasswordField pfLastName;
    private JLabel lbFirstName;
    private JLabel lbLastName;
    private JLabel lbCredit;
    private JLabel lbPlate;
    private JButton btnGuest;
    private JButton btnCancel;
    private boolean succeeded;

    public GuestDialog(Frame parent) {
        super(parent, "Continue as Guest", true);


        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.VERTICAL;

        lbFirstName = new JLabel("First Name: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbFirstName, cs);

        tfFirstName = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfFirstName, cs);

        lbLastName = new JLabel("Last Name: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbLastName, cs);

        pfLastName = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfLastName, cs);
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

        btnGuest = new JButton("Register");

        btnGuest.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(GuestDialog.this,
                            "Hi " + getUsername() + "! Welcome to our Parking Garage!.",
                            "Guest",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    dispose();
            }
        });
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel bp = new JPanel();
        bp.add(btnGuest);
        bp.add(btnCancel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }


    public static String getUsername() {
        return tfFirstName.getText().trim();
    }

    public String getPassword() {
        return new String(pfLastName.getPassword());
    }


    public boolean isSucceeded() {
        return succeeded;
    }
}
