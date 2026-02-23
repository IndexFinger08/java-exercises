package com.conexaosql;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/banco_teste?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "";
        Scanner scanner = new Scanner(System.in);

        try {

            Connection conexao = DriverManager.getConnection(url, usuario, senha); // Abre a conexão com o banco
            System.out.println("Conexão realizada com sucesso!");

            String insert = "INSERT INTO tabela_teste (nome, email) VALUES (?, ?);"; // comando para inserir os dados na tabela
            PreparedStatement execInsert = conexao.prepareStatement(insert); // criação do objeto que executa os comandos sql

            // coleta das informações que serão colocadas na tabela
            System.out.println("Digite o nome do novo usuário:");
            String nome = scanner.nextLine();
            System.out.println("Digite o email do novo usuário:");
            String email = scanner.nextLine();

            execInsert.setString(1, nome); // coloca o nome na tabela
            execInsert.setString(2, email); // coloca o email na tabela

            execInsert.executeUpdate(); // executa o comando insert

            execInsert.close();
            conexao.close();
            scanner.close();

        } catch(SQLException e){ // caso ocorra algum erro na conexão esse comando será executado
            System.out.println("Erro na conexão: "+e);
        }

    }
}