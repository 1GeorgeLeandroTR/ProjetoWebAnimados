package Model;

import dao.Operacoes;
import java.sql.SQLException;


public class Usuario implements java.io.Serializable {
    String id;
    String nome;
    String email;
    String telefone;
    String sexo;
    Integer count= 0;
    
    public static Usuario user = new Usuario();
    public Usuario() {
    }

    public Usuario(String id, String nome, String email, String telefone, String sexo, Integer count) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.count = count;
    }

    public String getId() throws SQLException, ClassNotFoundException {
        String endereco= Operacoes.contaAlgo("id", "email",email );
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getCount() {
        return count;
    }

    
    public void setCount(Integer count) {
        this.count = count;
    }
    
    
    public void addCount() {
        count++;  
    }
    
    public int getContaSexo(String sexo) throws SQLException, ClassNotFoundException{
        return Integer.valueOf(Operacoes.contaAlgo("count(*)", "sexo", sexo));
    }
    
    public static int getContaTotal() throws SQLException, ClassNotFoundException{
        return Integer.valueOf(Operacoes.contaTudo());
    }
    
    public String getTotalNome() throws SQLException, ClassNotFoundException{
        
        if(count >= getContaTotal()){
            return "";
        }
        count++;
        return Operacoes.contaAlgo("nome", "id", count.toString());
    }    
        
}
