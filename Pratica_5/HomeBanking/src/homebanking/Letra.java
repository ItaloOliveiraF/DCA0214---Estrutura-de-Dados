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
public class Letra {
    private  String caractere;
    private  String md5code;
    
    Letra(String caractere){
        this.caractere=caractere;
        md5code=SecurityProvider.md5(caractere);
    }
    
    public void setCaractere(String caractere){
        this.caractere=caractere;
        md5code=SecurityProvider.md5(caractere);
    };
    
    public String getCaractere(){
        return caractere;
    }
    
    public String getMd5(){
        return md5code;
    }
}
