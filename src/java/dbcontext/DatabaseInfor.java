/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcontext;

/**
 *
 * @author Admin
 */
public interface DatabaseInfor {
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=QuanLyBanHang_KTCK_Java;";
    String user = "sa";
    String pass = "phu0763161092";
}
