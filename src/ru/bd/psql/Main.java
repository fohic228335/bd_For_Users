package ru.bd.psql;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DbFunctions db = new DbFunctions();
        System.out.print("Введите хост: ");
        String host = scanner.nextLine();
        System.out.print("Введите название вашей базы данных: ");
        String dataBaseName = scanner.nextLine();
        System.out.print("Введите имя пользователя: ");
        String user = scanner.nextLine();
        System.out.print("Введите пароль пользователя: ");
        String password = scanner.nextLine();
        Connection conn = db.connect_to_db(host, dataBaseName, user, password);
        //Введите свой код, используя методы из класса DbFunctions.
    }
}