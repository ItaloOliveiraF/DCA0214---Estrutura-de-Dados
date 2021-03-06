/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenwicktree;

/**
 *
 * @author italo
 */
public class FenwickTree {

    /**
     * @param args the command line arguments
     */
    int value;
    int leftSize;
    FenwickTree left;
    FenwickTree rigth;
        
    FenwickTree(int value){
        this.value=value;
        this.leftSize=0;
        this.left=null;
        this.rigth=null;
    }
    
    FenwickTree(int leftSize, FenwickTree left, FenwickTree rigth){
        this.leftSize=leftSize;
        this.left=left;
        this.rigth=rigth;
        this.value=left.value+rigth.value;
    }
    
    @Override
    public String toString(){
        String tree;
        
        tree="["+value+","+ leftSize;
        if(left!=null){    
            tree+=","+left.toString()+","+rigth.toString();
        }
        tree+="]";
        
        return tree;
        
    }
    
    static FenwickTree allZeros(int n){
        if (n==0) return null;
        if (n==1) return new FenwickTree(0);
        int m = n/2;
        return new FenwickTree(n-m, allZeros(n-m), allZeros(m));
    }

    int size(){
        int sizeTree =leftSize;
        if(rigth!=null){
            if (rigth.leftSize != 0) return (sizeTree+rigth.size());
        }
        return sizeTree+1;
    }
    
    void increment(int i, int delta){
        value+=delta;
        if(leftSize==0){
            return;
        }
        if(i<leftSize){
            left.increment(i,delta);
        }
        else{
            rigth.increment(i-leftSize,delta);
        }
    }
    
    int prefixSum(int upto){
        
        if(upto==0){
            return 0;
        }
        else if(leftSize==0){
            return value;
        }
        
        if(upto==leftSize){
            return left.value;
        }
        
        if(upto<leftSize){
            return left.prefixSum(upto);
        }
        else{
            return left.value+rigth.prefixSum(upto-leftSize);
        }
        
    }
    
    int between(int lo, int hi){
        
        return prefixSum(hi)-prefixSum(lo);
    }
    
    public static void main(String[] args) {
            
    }
}
