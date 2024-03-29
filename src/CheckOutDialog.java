import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.border.*;

public class CheckOutDialog extends JDialog {

    private JButton btnCheckOut;
    private JButton btnCancel;
    private boolean succeeded;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    public CheckOutDialog(Frame parent) {
        super(parent, "Check Out", true);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.VERTICAL;

        btnCheckOut = new JButton("Check Out");

        btnCheckOut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (Login.getPressed()>0) {
                    JOptionPane.showMessageDialog(CheckOutDialog.this,
                            "You have successfully checked out at ." + dtf.format(now),
                            "Check Out",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(CheckOutDialog.this,
                            "Please login, register, or continue as guest before checking out!",
                            "Check Out Failed",
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
        bp.add(btnCheckOut);
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
