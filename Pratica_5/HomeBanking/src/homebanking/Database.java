/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homebanking;

import java.util.ArrayList;

/**
 *
 * @author italo
 */
public class Database {
    public static final ArrayList<Letra> caracteres;
    static
    {
        Letra letter;
        caracteres = new ArrayList<>();
        
        letter= new Letra(String.valueOf(" "));
            caracteres.add(letter);  
            
        for (char i='a';i<='z';i++){
            letter= new Letra(String.valueOf(i));
            caracteres.add(letter);  
        }
        for (char i='A';i<='Z';i++){
            letter= new Letra(String.valueOf(i));
            caracteres.add(letter);  
        }
        for (char i='0';i<= '9';i++){
            letter= new Letra(String.valueOf(i));
            caracteres.add(letter);  
        }
        
    }
    
    public static Letra getLetra(String md5){
        for(int i=0;i<caracteres.size();i++){
            if(caracteres.get(i).getMd5().equals(md5)){
                return caracteres.get(i);
            }
        }
        return null;
    }
    
    public static Conta getConta(String[] Chaves){
        Conta contaRetorno;
        String nome_Saldo="";
        String nome="";
        String saldo;
        Letra letra;
        
        for (int i=0;i<Chaves.length;i++){
            letra=getLetra(Chaves[i]);
            nome_Saldo=nome_Saldo+letra.getCaractere();
        }
        
        String palavras[]=nome_Saldo.split(" "); 
        int n=palavras.length;
        
        saldo=palavras[n-1];
        
        for (int i=0;i<n-1;i++){
            nome=nome+palavras[i];
            if (n!=n-2){
                nome=nome+" ";
            }
        }
       
        contaRetorno= new Conta(nome, saldo);
        
        return contaRetorno;
    }
}
