/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homebanking;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author italo
 */
public class SecurityProvider {
    public static String salt ="5a1t";
    
    public static String md5(String stringToConvert){
        String hashtext="";
        stringToConvert +=salt;
        MessageDigest m;
        try
        {
            m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(stringToConvert.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1,digest);
            hashtext = bigInt.toString(16);
        }
        catch (NoSuchAlgorithmException ex)
        {
            Logger.getLogger(SecurityProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashtext;
    }
    
    public static String md5ToServer(Conta conta){
        String cat = conta.agencia+conta.numero+conta.senha+SecurityProvider.salt;
        return md5(cat);
    }
    
    public static String[] md5ToClient(Conta conta){
        String toCrypt = conta.getNome()+" "+conta.getSaldo();
        int n=toCrypt.length();
        
        String chars[];
        
        chars= new String [n];
        
        for (int i=0;i<toCrypt.length();i++){
            chars[i]=md5(String.valueOf(toCrypt.charAt(i)));
        }
        return chars;
    }


}

