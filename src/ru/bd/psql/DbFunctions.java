package ru.bd.psql;

import java.sql.*;
public class DbFunctions {
    public Connection connect_to_db(String host, String dbname, String user, String pass){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:" + host + "/" + dbname, user, pass);
            if (conn != null){
                System.out.println("Connection Established");
            }
            else {
                System.out.println("Connection Failed");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void createTable(Connection conn, String table_name){
        Statement statement;
        try{
            String query = "CREATE TABLE " + table_name + "(empid SERIAL, name varchar(200), address varchar(200), PRIMARY KEY(empid));";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void insert_row(Connection conn, String table_name, String name, String address){
        Statement statement;
        try {
            String query = "INSERT INTO " + table_name + "(name, address) VALUES('" + name + "', '" + address +"');";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void delete_row_by_id(Connection conn,String table_name, int empid){
        Statement statement;
        try{
            String query=String.format("DELETE FROM %s WHERE empid= %s",table_name,empid);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void update_name_by_empid(Connection conn, String table_name, int empid, String new_name){
        Statement statement;
        try {
            String query=String.format("UPDATE %s SET name='%s' WHERE empid='%d'",table_name,new_name,empid);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void update_country_by_empid(Connection conn, String table_name, int empid, String new_country){
        Statement statement;
        try {
            String query=String.format("UPDATE %s SET country='%s' WHERE empid='%d'",table_name,new_country,empid);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void search_by_name(Connection conn, String table_name, String name){
        Statement statement;
        ResultSet rs;
        try {
            String query=String.format("SELECT * FROM %s WHERE name= '%s'",table_name,name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("address"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void read_data(Connection conn, String table_name){
        Statement statement;
        ResultSet rs;
        try {
            String query=String.format("SELECT * FROM %s",table_name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("address"));
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void delete_table(Connection conn, String table_name){
        Statement statement;
        try {
            String query= String.format("DROP table %s",table_name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Deleted");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
