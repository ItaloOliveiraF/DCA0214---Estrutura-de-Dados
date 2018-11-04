/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.io.*;
import static java.lang.Double.parseDouble;

class CalcRPN {
    // vari´aveis da instancia :
    // uma pilha para os c´alculos
    private Pilha<Double> aPilha;
    private Pilha<Operacao> hist;
    private Operacao oper;
    // construtor
    public CalcRPN () {
        aPilha= new Pilha<>();
        hist= new Pilha<>();
    }
    // Adi¸c~ao de dois elementos do topo da pilha
    public void mais() {
        Double a = aPilha.desempilha();
        Double b = aPilha.desempilha();
        oper = new Operacao('+',a,b);
        
        Double resultado = b + a;
        aPilha.empilha(resultado);
        
        hist.empilha(oper);
        }
    // Subtra¸c~ao de dois elementos do topo da pilha
    public void menos() {
        Double a = aPilha.desempilha();
        Double b = aPilha.desempilha();
        oper = new Operacao('-',a,b);
        
        Double resultado = b - a;
        aPilha.empilha(resultado);
        
        hist.empilha(oper);
    }
    // Multiplica¸c~ao de dois elementos do topo da pilha
    public void vezes() {
        Double a = aPilha.desempilha();
        Double b = aPilha.desempilha();
        oper = new Operacao('*',a,b);
        
        Double resultado = b * a;
        aPilha.empilha(resultado);
    
        hist.empilha(oper);
    }
    // Divis~ao de dois elementos no topo da pilha
    public void dividido() {
        Double a = aPilha.desempilha();
        Double b = aPilha.desempilha();
        oper = new Operacao('/',a,b);
        
        Double resultado = b / a;
        aPilha.empilha(resultado);
        
        hist.empilha(oper);
    }
    // retorna o conteudo do topo da pilha
    public Double resultado() {
        return aPilha.topo();
    }
    
    public void cancela(){
        Operacao back;
        back=hist.desempilha();
        if(back.code=='e'){
            aPilha.desempilha();
        }
        else{
            aPilha.desempilha();
            aPilha.empilha(back.a);
            aPilha.empilha(back.b);
        }
        
    }
    
    // interpretador de comandos
    public void exec(String cmd) {
        if(cmd.compareTo("+")==0){
            mais();
        }
        else if(cmd.compareTo("-")==0){
            menos();
        }
        else if(cmd.compareTo("*")==0){
            vezes();
        }
        else if(cmd.compareTo("/")==0){
            dividido();
        }
        else if(cmd.compareTo("clear")==0){
            aPilha.reinicializa();
            hist.reinicializa();
        }
        else if(cmd.compareTo("hist")==0){
            System.out.println("Historico = " + hist.toStringInverse());
        }
        else if(cmd.compareTo("undo")==0){
            cancela();
            System.out.println("Historico = " + hist.toStringInverse());
        }
        else{
            aPilha.empilha(parseDouble(cmd));
            oper= new Operacao(parseDouble(cmd));
            hist.empilha(oper);
        }
    }
    
    
    static void interfaceUsuario() throws IOException {
        CalcRPN calc = new CalcRPN() ;
        String line;
        BufferedReader reader = new BufferedReader
        (new InputStreamReader (System.in));
        while((line = reader.readLine()) != null) {
        if (line.isEmpty())
        continue;
        for (String s : line.split(" "))
        calc.exec(s);
        System.out.println("Pilha = " + calc.aPilha);
        }
        System.out.println("At´e logo");
}

    
    public static void main(String[] args) throws IOException
    {
        interfaceUsuario();
    }
}
