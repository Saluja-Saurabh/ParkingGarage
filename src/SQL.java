import java.sql.*;

public class SQL {
    static Connection conn;
    static Statement stmt;
    static ResultSet resultSet;

    public static void ConnectionSQL(String directory, String Username, String password) throws SQLException {
        conn = DriverManager.getConnection(directory, Username, password);
        Statement statement = resultSet.getStatement();
        statement.close();
        conn.close();
    }

    public static void InsertUsers(String username) throws SQLException {
        PreparedStatement pStmt = conn.prepareStatement("insert into users values(?)");
        pStmt.setString(1, username); pStmt.executeUpdate();
    }

    public static void InsertMembership(int membID, int resID, Boolean isMember, Boolean spotAssigned, Boolean guestSpot, int ccNum, int membBalance) throws SQLException {
        PreparedStatement pStmt = conn.prepareStatement("insert into membership values(?, ?, ?, ?, ?, ?, ?)");
        pStmt.setInt(1, membID); pStmt.executeUpdate();
        pStmt.setInt(2, resID); pStmt.executeUpdate();
        pStmt.setBoolean(3, isMember); pStmt.executeUpdate();
        pStmt.setBoolean(4, spotAssigned); pStmt.executeUpdate();
        pStmt.setBoolean(5, guestSpot); pStmt.executeUpdate();
        pStmt.setInt(6, ccNum); pStmt.executeUpdate();
        pStmt.setInt(7, membBalance); pStmt.executeUpdate();
    }

    public static void InsertParkingLot(Boolean spotOpen, int spots, int spot, int otherLots, int resLots) throws SQLException {
        PreparedStatement pStmt = conn.prepareStatement("insert into parking_lots values(?, ?, ?, ?, ?)");
        pStmt.setBoolean(1, spotOpen); pStmt.executeUpdate();
        pStmt.setInt(2, spots); pStmt.executeUpdate();
        pStmt.setInt(3, spot); pStmt.executeUpdate();
        pStmt.setInt(4, otherLots); pStmt.executeUpdate();
        pStmt.setInt(5, resLots); pStmt.executeUpdate();
    }

    public static void InsertReservation(int onlineResID, int driveInResID, int membResID) throws SQLException {
        PreparedStatement pStmt = conn.prepareStatement("insert into reservation values(?, ?, ?)");
        pStmt.setInt(1, onlineResID); pStmt.executeUpdate();
        pStmt.setInt(2, driveInResID); pStmt.executeUpdate();
        pStmt.setInt(3, membResID); pStmt.executeUpdate();
    }

    public static void InsertStaff(String nameID, Boolean resAccess) throws SQLException {
        PreparedStatement pStmt = conn.prepareStatement("insert into staff values(?, ?)");
        pStmt.setString(1, nameID); pStmt.executeUpdate();
        pStmt.setBoolean(2, resAccess); pStmt.executeUpdate();
    }

    public static void InsertCustomer(String nameID, Boolean isMember, Boolean hasGuest, int onlineResID, int driveInResID, int carID, int ccNum) throws SQLException {
        PreparedStatement pStmt = conn.prepareStatement("insert into customers values(?, ?, ?, ?, ?, ?, ?)");
        pStmt.setString(1, nameID); pStmt.executeUpdate();
        pStmt.setBoolean(2, isMember); pStmt.executeUpdate();
        pStmt.setBoolean(3, hasGuest); pStmt.executeUpdate();
        pStmt.setInt(4, onlineResID); pStmt.executeUpdate();
        pStmt.setInt(5, driveInResID); pStmt.executeUpdate();
        pStmt.setInt(6, carID); pStmt.executeUpdate();
        pStmt.setInt(7, ccNum); pStmt.executeUpdate();
    }

    public static void InsertCar(String licencePlateNum, Boolean isGuestPlate) throws SQLException {
        PreparedStatement pStmt = conn.prepareStatement("insert into car values(?, ?)");
        pStmt.setString(1, licencePlateNum); pStmt.executeUpdate();
        pStmt.setBoolean(2, isGuestPlate); pStmt.executeUpdate();
    }

    public static void InsertTimeSlot(int daysRemovedGuest, String checkInTime, String checkOutTime, String spotTimeSync) throws SQLException {
        PreparedStatement pStmt = conn.prepareStatement("insert into time_slot values(?, ?, ?, ?)");
        pStmt.setInt(1, daysRemovedGuest); pStmt.executeUpdate();
        pStmt.setString(2, checkInTime); pStmt.executeUpdate();
        pStmt.setString(3, checkOutTime); pStmt.executeUpdate();
        pStmt.setString(4, spotTimeSync); pStmt.executeUpdate();
    }

    public static void InsertParkingAdmin(Boolean updateMembership, String nameID, int membID, int spotsAvailable, int monthlyRevenue, int parkingUsage, int ccMemb, int ccNonMemb) throws SQLException {
        PreparedStatement pStmt = conn.prepareStatement("insert into parking_admin values(?, ?, ?, ?, ?, ?, ?, ?)");
        pStmt.setBoolean(1, updateMembership); pStmt.executeUpdate();
        pStmt.setString(2, nameID); pStmt.executeUpdate();
        pStmt.setInt(3, membID); pStmt.executeUpdate();
        pStmt.setInt(4, spotsAvailable); pStmt.executeUpdate();
        pStmt.setInt(5, monthlyRevenue); pStmt.executeUpdate();
        pStmt.setInt(6, parkingUsage); pStmt.executeUpdate();
        pStmt.setInt(7, ccMemb); pStmt.executeUpdate();
        pStmt.setInt(8, ccNonMemb); pStmt.executeUpdate();
    }

    public static void InsertNonMembership(String nameID, Boolean assignedSpot, int resID, int ccNum, int nonMembBalance) throws SQLException {
        PreparedStatement pStmt = conn.prepareStatement("insert into non_membership values(?, ?, ?, ?, ?)");
        pStmt.setString(1, nameID); pStmt.executeUpdate();
        pStmt.setBoolean(2, assignedSpot); pStmt.executeUpdate();
        pStmt.setInt(3, resID); pStmt.executeUpdate();
        pStmt.setInt(4, ccNum); pStmt.executeUpdate();
        pStmt.setInt(5, nonMembBalance); pStmt.executeUpdate();
    }

    public static void InsertApplicationManager(int membFeeAccess, int membID, int trackMembSpots, String userLogin, String guestLogin, String timeStampLogin) throws SQLException {
        PreparedStatement pStmt = conn.prepareStatement("insert into application_manager values(?, ?, ?, ?, ?, ?)");
        pStmt.setInt(1, membFeeAccess); pStmt.executeUpdate();
        pStmt.setInt(2, membID); pStmt.executeUpdate();
        pStmt.setInt(3, trackMembSpots); pStmt.executeUpdate();
        pStmt.setString(4, userLogin); pStmt.executeUpdate();
        pStmt.setString(5, guestLogin); pStmt.executeUpdate();
        pStmt.setString(6, timeStampLogin); pStmt.executeUpdate();
    }

}










