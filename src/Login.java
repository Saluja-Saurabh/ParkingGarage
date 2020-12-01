import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Login {
    static Statement stmt;
    static ResultSet resultSet;

    public static boolean authenticate(String username, String password) throws SQLException {
        // hardcoded username and password
        if (username.equals("bob") && password.equals("secret")) {
            return true;
        } else if (password.equals("admin")) {
            stmt.executeQuery( "create role AdminUser;");
            String a = "grant parking_admin to AdminUser; --if user is a admin";
            String b = "grant membership to AdminUser;";
            String c = "grant non_membership to AdminUser;";
            String d = "grant application_manager to AdminUser;";
            String e = "grant parking_lots to AdminUser;";
            String[] commands = new String[]{a, b, c, d, e};
            for (int i = 0; i <= commands.length; i++) {
                stmt.executeQuery(commands[i]);
            }
            ApplicationManager.QueryExecution();
        } else if (password.equals("staff")) {
            stmt.executeQuery( "create role StaffUser;");
            String a = "grant customers to StaffUser; --if user is a staff";
            String b = "grant parking_lots to StaffUser;";
            String c = "grant parking_lots to StaffUser;";
            String[] commands = new String[]{a, b, c};
            for (int i = 0; i <= commands.length; i++) {
                stmt.executeQuery(commands[i]);
            }
        } else if (password.equals("member")) {
            stmt.executeQuery( "create role MemberUser;");
            String a = "grant membership to MemberUser; --if user is a member";
            String b = "grant time_slot to MemberUser;";
            String c = "grant car to MemberUser;";
            String[] commands = new String[]{a, b, c};
            for (int i = 0; i <= commands.length; i++) {
                stmt.executeQuery(commands[i]);
            }
        } else if (password.equals("nonMember")) {
            stmt.executeQuery( "create role NonMemberUser;");
            String a = "grant non_membership to NonMemberUser; --if user is a nonmember";
            String b = "grant time_slot to NonMemberUser;";
            String c = "grant car to NonMemberUser;";
            String[] commands = new String[]{a, b, c};
            for (int i = 0; i <= commands.length; i++) {
                stmt.executeQuery(commands[i]);
            }
        } else if (password.equals("guestUser")) {
            stmt.executeQuery( "create role guestUser;");
            String a = "grant non_membership to GuestUser; --if user is a guest";
            String b = "grant customers to GuestUser;";
            String c = "grant time_slot to GuestUser;";
            String d = "grant car to GuestUser;";
            String[] commands = new String[]{a, b, c, d};
            for (int i = 0; i <= commands.length; i++) {
                stmt.executeQuery(commands[i]);
            }
        }
        return true;
    }

}