import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.border.*;

public class CheckInDialog extends JDialog {

    private JButton btnCheckIn;
    private JButton btnCancel;
    private boolean succeeded;
    String name = "";
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    public CheckInDialog(Frame parent) {
        super(parent, "Check In", true);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.VERTICAL;

        if (!LoginDialog.getUsername().equals("")) {
            name = LoginDialog.getUsername();
        } else if (!RegisterDialog.getUsername().equals("")) {
            name = RegisterDialog.getUsername();
        } else if (!GuestDialog.getUsername().equals("")) {
            name = GuestDialog.getUsername();
        }else{
            name = "";
        }

        btnCheckIn = new JButton("Check In");

        btnCheckIn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (!name.equals("")) {
                    JOptionPane.showMessageDialog(CheckInDialog.this,
                            "Hi " + name + "! You have successfully checked in at ." + dtf.format(now),
                            "Check In",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(CheckInDialog.this,
                            "Please login, register, or continue as guest before checking In!",
                            "Check In Failed",
                            JOptionPane.ERROR_MESSAGE);
                    succeeded = false;

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
        bp.add(btnCheckIn);
        bp.add(btnCancel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}
