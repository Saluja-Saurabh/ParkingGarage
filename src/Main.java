import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import java.sql.*;


public class Main {
    public static JButton btnLogin;
    public static JButton btnReg;
    public static JButton btnGuest;
    public static JButton btnCheckOut;
    public static JButton btnCheckIn;
    public static JButton btnReserve;
    public int pressed = 0;
    public static void main(String[] args) throws SQLException {
        final JFrame frame = new JFrame("Parking Garage");
        btnLogin = new JButton("Sign In");
        btnReg = new JButton("Sign Up");
        btnGuest = new JButton("Continue as Guest");
        btnCheckOut = new JButton("Check Out");
        btnCheckIn = new JButton("Check In");
        btnReserve = new JButton("Reserve");

        btnLogin.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        LoginDialog loginDlg = new LoginDialog(frame);
                        loginDlg.setVisible(true);
                        // if logon successfully
                        if(loginDlg.isSucceeded()){
                            try {
                                SQL.InsertUsers(loginDlg.getUsername());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
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
                            try {
                                SQL.InsertUsers(RegisterDlg.getUsername());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
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
                                SQL.InsertUsers(GuestDlg.getUsername());
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

        btnReserve.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        ReserveDialog ReserveDlg = new ReserveDialog(frame);
                        ReserveDlg.setVisible(true);
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
        frame.getContentPane().add(btnReserve);
        frame.setVisible(true);
    }

}