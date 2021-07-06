
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OqueEResultset {

    void bla() throws SQLException {
        Connection con = null; //de alguma forma vc pega conexao com o banco
        Statement stmt = con.createStatement();
        //aqui voce recebe um objeto ResultSet com todos os elementos
        //da tabela cliente:
        ResultSet rs = stmt.executeQuery("SELECT * FROM Clientes");
        //para percorrer o resultset, faca:
        while (rs.next()) {
            //pega o valor da coluna nome, de cada linha:
            String nome = rs.getString("Nome");
            //imprime no console:
            System.out.println("Nome do Cliente: " + nome);
        }
    }
}
