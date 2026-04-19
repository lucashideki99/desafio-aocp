/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lucas.desafio.util;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author lucas
 */
public class conexao {
    private static final String URL = "jdbc:postgresql://localhost:5432/desafio";
    private static final String USER = "admin";
    private static final String PASS = "1234";

    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
