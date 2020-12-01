import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        final JFrame frame = new JFrame("Parking Garage");
        final JButton btnLogin = new JButton("Click to login");
        final JButton btnReg = new JButton("Register");
        final JButton btnGuest = new JButton("Continue as Guest");
        final JButton btnCheckOut = new JButton("Check Out");
        final JButton btnCheckIn = new JButton("Check In");

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

        btnGuest.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        GuestDialog GuestDlg = new GuestDialog(frame);
                        GuestDlg.setVisible(true);
                        // if logon successfully
                        if(GuestDlg.isSucceeded()){
                            try {
                                SQL.UpdateUsers(GuestDlg.getUsername());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            btnGuest.setText("Hi " + GuestDlg.getUsername() + "!");
                        }
                    }
                });

        btnCheckOut.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        CheckOutDialog CheckOutDlg = new CheckOutDialog(frame);
                        CheckOutDlg.setVisible(true);
                    }
                });

        btnCheckIn.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        CheckInDialog CheckInDlg = new CheckInDialog(frame);
                        CheckInDlg.setVisible(true);
                    }
                });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 500);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(btnLogin);
        frame.getContentPane().add(btnReg);
        frame.getContentPane().add(btnGuest);
        frame.getContentPane().add(btnCheckOut);
        frame.getContentPane().add(btnCheckIn);
        frame.setVisible(true);
    }
}