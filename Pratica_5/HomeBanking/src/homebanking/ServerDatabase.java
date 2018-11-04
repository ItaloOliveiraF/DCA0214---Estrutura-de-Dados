/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homebanking;

import java.util.ArrayList;
import java.math.BigInteger;

/**
 *
 * @author italo
 */

public class ServerDatabase extends Database
{
    public static final ArrayList<ArrayList<Conta>> contas;
    public static final int N = 100;
    static
    {
    contas = new ArrayList<>();
    for(int i=0;i<N;i++)
    {
    contas.add(new ArrayList<>());
    }
    }
    
    public static int hashCode(String md5)
    {
        BigInteger bi = new BigInteger(md5, 16);
        BigInteger m = new BigInteger(Integer.toString(N), 10);
        int pos;
        pos = bi.mod(m).intValue();
        return pos;
    }
    
    public static void insereConta(Conta conta){
        String md5Conta = conta.getMd5();
        int pos=hashCode(md5Conta);
        
        contas.get(pos).add(conta);        
    }
    
    public static Conta getConta(String md5){
        int pos=hashCode(md5);
        int i=0;
        
        ArrayList<Conta> Lista = contas.get(pos);
        
        while(i<Lista.size()){
            if(Lista.get(i).getMd5().equals(md5)){
                return Lista.get(i);
            }
            i++;
        }
        return null;
    }
}
