
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DP
 */
public class NewClass {
    public static void main(String[] args) {
        int[] a=new int[5];
        Scanner p=new Scanner(System.in);
        
        for(int i=0;i<7;i++){
            a[i]=p.nextInt();
        }
        for(int i=0;i<7;i++){
            System.out.println(a[i]);
        }
    
    }
    
}
