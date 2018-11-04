/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

/**
 *
 * @author italo
 */
public class Operacao {
    
    public char code;
    public double a,b;
    
    public Operacao(double a){
        code='e';
        this.a=a;
    }
    public Operacao(char code, double a, double b){
        this.code=code;
        this.a=a;
        this.b=b;
    }
    public String toString(){
        if(code=='e'){
            return(Double.toString(a));
        }
        else{
            return (String.valueOf(code));
        }
    }
    
    public static void main (String[] args) {
    Operacao[] op = new Operacao[9];
    op[0] = new Operacao(16.0);
    op[1] = new Operacao(8.0);
    op[2] = new Operacao(4.0);
    op[3] = new Operacao(2.0);
    op[4] = new Operacao(1.0);
    op[5] = new Operacao('+', 2.0, 1.0);
    op[6] = new Operacao('-', 4.0, 3.0);
    op[7] = new Operacao('*', 8.0, 1.0);
    op[8] = new Operacao('/', 16.0, 8.0);
    for (int i=0; i<op.length; i++)
        System.out.print(op[i] + " ");
    System.out.println();
}
}
