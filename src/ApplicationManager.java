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
        stmt.executeQuery("create view available_parking_spots as select parking_space, has_spot_open from parking_lots where parking_lots natural join time_slot;");
        stmt.executeQuery("create view monthly_revenue as select monthly_revenue, membership_fee_access, make_guest_spot from parking_admin, application_manager, membership;");
        stmt.executeQuery("create view parking_usage as select parking_usage from parking_usage;");
        stmt.executeQuery("create view percentage_of_members as select count (membership_id) from membership where count/100;");
        stmt.executeQuery("create view percentage_of_online_reservations as select count (online_reservation_id) from customers where count/100;");
        stmt.executeQuery("create view percentage_of_driveins as select count (drive_in_reservation_id) from customers where count/100;");
        stmt.executeQuery("create view user_logins as select user_login, guest_login, spot_time_sync from application_manager, time_slot;");
    }

    public static void UpdateMembershipFee(int newMembershipFee) throws SQLException {
        SQL.ConnectionSQL(directory, Username, password);
        stmt.executeQuery("update parking_admin set membership_fee_access = " + newMembershipFee + " where membership_fee_access < 50;");
    }

    public static void UpdateTimeSlot(String newTimeSlot) throws SQLException {
        SQL.ConnectionSQL(directory, Username, password);
        stmt.executeQuery("update time_slot set check_in_time = " + newTimeSlot + ";");
    }

    public static void UpdateMembershipAccess(Boolean newMembershipAccess) throws SQLException {
        SQL.ConnectionSQL(directory, Username, password);
        stmt.executeQuery("update membership set is_member = " + newMembershipAccess + ";");
        stmt.executeQuery("update customers set is_member = " + newMembershipAccess + ";");
    }

    public static void UpdateCarPlate(String newCarPlate) throws SQLException {
        SQL.ConnectionSQL(directory, Username, password);
        stmt.executeQuery("update car set car_plate = " + newCarPlate + ";");
    }

    public static void UpdateGuestPlate(int newGuestPlate) throws SQLException {
        SQL.ConnectionSQL(directory, Username, password);
        stmt.executeQuery("update car set guest_plate = " + newGuestPlate + ";");
    }

    public static void UpdateMemberCreditCardInfo(int newMemberCreditCardInfo) throws SQLException {
        SQL.ConnectionSQL(directory, Username, password);
        stmt.executeQuery("update membership set Credit_Card_info = " + newMemberCreditCardInfo + ";");
    }

    public static void UpdateNonMemberCreditCardInfo(int newNonMemberCreditCardInfo) throws SQLException {
        SQL.ConnectionSQL(directory, Username, password);
        stmt.executeQuery("update non_membership set Credit_Card_info = " + newNonMemberCreditCardInfo + ";");
    }

    public static void UpdateSpotAvailabilty(int newSpotAvailability) throws SQLException {
        SQL.ConnectionSQL(directory, Username, password);
        stmt.executeQuery("update parking_admin set membership_fee_access = " + newSpotAvailability + ";");
    }
}
