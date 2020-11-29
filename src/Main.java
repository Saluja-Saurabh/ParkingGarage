import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("Parking Garage");
        final JButton btnLogin = new JButton("Click to login");
        final JButton btnReg = new JButton("Register");
        final JButton btnGuest = new JButton("Continue as Guest");

        btnLogin.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        LoginDialog loginDlg = new LoginDialog(frame);
                        loginDlg.setVisible(true);
                        // if logon successfully
                        if(loginDlg.isSucceeded()){
                            btnLogin.setText("Hi " + loginDlg.getUsername() + "!");
                        }
                    }
                });

        btnReg.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        RegisterDialog RegisterDlg = new RegisterDialog(frame);
                        RegisterDlg.setVisible(true);
                        // if logon successfully
                        if(RegisterDlg.isSucceeded()){
                            btnReg.setText("Hi " + RegisterDlg.getUsername() + "!");
                        }
                    }
                });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 500);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(btnLogin);
        frame.getContentPane().add(btnReg);
        frame.getContentPane().add(btnGuest);
        frame.setVisible(true);
    }
}