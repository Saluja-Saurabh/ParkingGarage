import java.sql.*;

/*
1) Track available parking spots at different time slots on different days of the week.
2) Track monthly revenue for each parking lot from both membership fees and guest reservations.
3) Track parking usage. For each parking lot, identify the percentage of customers in each of the three categories (members, online reservation, and drive-in).
4) Tracks different user login and logout times including guest login.
*/


public class ApplicationManager {
    static Connection conn;
    static Statement stmt;
    static ResultSet resultSet;

    static String directory = "jdbc:postgresql://localhost:5432/CarParkingLotManagementSQL";
    static String Username = "postgres";
    static String password = "ipad";


    public static void QueryExecution() throws SQLException {
        SQL.ConnectionSQL(directory, Username, password);
        stmt.executeQuery("select parking_space, has_spot_open from parking_lots where parking_lots natural join time_slot;");
        stmt.executeQuery("select monthly_revenue, membership_fee_access, make_guest_spot from parking_admin, application_manager, membership;");
        stmt.executeQuery("select parking_usage from parking_usage;");
        stmt.executeQuery("select count (online_reservation_id) from customers where count/100;");
        stmt.executeQuery("select count (drive_in_reservation_id) from customers where count/100;");
        stmt.executeQuery("select count (membership_id) from membership where count/100;");
        stmt.executeQuery("select user_login, guest_login, spot_time_sync from application_manager, time_slot;");
    }
}
