import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ReserveDialog extends JDialog {

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

    public ReserveDialog(Frame parent) {
        super(parent, "Reserve Parking Time", true);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        lbUsername = new JLabel("Reservation Time: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);

        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);

        btnReg = new JButton("Reserve");

        btnReg.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (Login.getPressed()==0) {
                    JOptionPane.showMessageDialog(ReserveDialog.this,
                            "Please login, register, or continue as guest before Reserving a parking space!",
                            "Reservation Failed",
                            JOptionPane.ERROR_MESSAGE);
                    succeeded = false;
                    dispose();
                }
                else if (getUsername().equals("1:00pm")) {
                    JOptionPane.showMessageDialog(ReserveDialog.this,
                            "Sorry, at that time all spots are full. Please choose another time!",
                            "Reservation Failed",
                            JOptionPane.ERROR_MESSAGE);
                    succeeded = false;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(ReserveDialog.this,
                            "You have successfully reserved a parking spot at " + getUsername(),
                            "Reservation",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    dispose();
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

    public boolean isSucceeded() {
        return succeeded;
    }
}