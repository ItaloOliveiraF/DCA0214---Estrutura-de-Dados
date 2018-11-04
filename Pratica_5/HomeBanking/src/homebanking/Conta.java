/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homebanking;

/**
 *
 * @author italo
 */
public class Conta {
    String nomeCliente;
    String saldo;
    String agencia;
    String numero;
    String senha;
    String md5;
    
    Conta(String agencia, String numero, String senha){
        this.agencia=agencia;
        this.numero=numero;
        this.senha=senha;
        this.md5=SecurityProvider.md5ToServer(this);
    }
    
    Conta(String agencia, String numero, String senha, String saldo, String nomeCliente){
        this.agencia=agencia;
        this.numero=numero;
        this.senha=senha;
        this.saldo=saldo;
        this.nomeCliente=nomeCliente;
        this.md5=SecurityProvider.md5ToServer(this);
    }
    
    Conta( String nomeCliente, String saldo){
        this.saldo=saldo;
        this.nomeCliente=nomeCliente;
    }
    
    public void setAgencia(String agencia){
        this.agencia=agencia;
        this.md5=SecurityProvider.md5ToServer(this);
    }
    
    public void setSaldo(String saldo){
        this.saldo=saldo;
    }
    
    public void setNumero(String numero){
        this.numero=numero;
        this.md5=SecurityProvider.md5ToServer(this);
    }
    
    public void setNome(String nomeCliente){
        this.nomeCliente=nomeCliente;
    }
    
    public void setSenha(String senha){
        this.senha=senha;
        this.md5=SecurityProvider.md5ToServer(this);
    }

    public String getAgencia(){
        return agencia;
    }
    
    public String getSaldo(){
        return saldo;
    }
    
    public String getNumero(){
        return numero;
    }
    
    public String getNome(){
        return nomeCliente;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public String getMd5(){
        return md5;
    }
    
    @Override
    public String toString(){
        String saida;
        
        saida="AGENCIA: " + agencia + "\n";
        saida=saida+ "CONTA: " + numero + "\n";
        saida=saida+ "SENHA: " + senha + "\n";
        saida=saida+ "NOME CLIENTE: " + nomeCliente + "\n";
        saida=saida+ "SALDO: " + saldo + "\n";
        saida=saida+ "MD5: " + md5 + "\n";
        
        return saida;
    }
}
