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
public class HomeBanking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conta c = new Conta("124", "333", "1234","10", "john doe");
ServerDatabase.insereConta(c);
String chave = SecurityProvider.md5ToServer(c);
Conta conta = ServerDatabase.getConta(chave);
String chars[];
chars = SecurityProvider.md5ToClient(conta);
System.out.println(Database.getConta(chars));

    }

}
    
