package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Operacoes implements java.io.Serializable  {
    
    private static final String dbURL = "jdbc:mysql://localhost:3306/JavaStudies";
    private static final String username = "root";
    private static final String password = "84404714";
    public static Connection conn;

    public static void conectar() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, username, password);
        System.out.println("Conectado");
    }

    public static void desconectar() throws SQLException {
        conn.close();
        System.out.println("Desconectado");
    }

    public static void apagar(String tabela, String usuario) throws SQLException {
        String sql = "DELETE FROM ? WHERE nome_usuario=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, tabela);
        statement.setString(2, usuario);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("usuario deletado");
        }
    }

    public static void inserir(String tabela,
                               String nome, 
                               String senha, 
                               String email, 
                               String sexo, 
                               String dataNascimento,
                               String numero,
                               String cpf) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
         //Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, username, password);
        String sql = "INSERT INTO usuario_animados (nome, senha, email, sexo, telefone, cpf ) VALUES ( ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        //statement.setString(1, tabela);
        statement.setString(1, nome);
        statement.setString(2, senha);
        statement.setString(3, email);
        statement.setString(4, sexo);
        //statement.setString(6, dataNascimento);
        statement.setString(5, numero);
        statement.setString(6, cpf);
        

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Novo usuario incluído");
        }
    }

    public static boolean verificar(String email) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
//Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, username, password);
        String sql = "SELECT * FROM usuario_animados where email= ?";

        PreparedStatement statement = conn.prepareStatement(sql);
       
        statement.setString(1, email);
        ResultSet result = statement.executeQuery();
        
        if(!result.next()){
            return false;
        }
        conn.close();
        return true;
    }
    
    public static String contaAlgo(String parametroSelect, String parametroWhere, String entrada) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        ArrayList<String> resultado = new ArrayList<>();        
        String sql = "select "+parametroSelect+" FROM usuario_animados where "+parametroWhere+"= ?";
        conn = DriverManager.getConnection(dbURL, username, password);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, entrada);
        ResultSet result = statement.executeQuery();//quando fazemos consultas parametrizadas não passamos o sql como parâmetro        
        while(result.next()){
            resultado.add(result.getString(1));
        }
        conn.close();
        return resultado.get(0);            
    }
    public static String contaTudo() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        ArrayList<String> resultado = new ArrayList<>();        
        String sql = "select count(*) FROM usuario_animados ";
        conn = DriverManager.getConnection(dbURL, username, password);
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery();//quando fazemos consultas parametrizadas não passamos o sql como parâmetro        
        while(result.next()){
            resultado.add(result.getString(1));
        }
        conn.close();
        return resultado.get(0);            
    }
    
    
    public static void atualizarAlgo(String mudado, String dado, String id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn= DriverManager.getConnection(dbURL, username, password);
        String sql = "UPDATE usuario_animados SET "+mudado+"= ? WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, dado);
        statement.setString(2, id);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Dados atualizados");
        }
        conn.close();
    }
    
}
