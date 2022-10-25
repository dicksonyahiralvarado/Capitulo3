/* 
R-3.1 Proporcione los siguientes cinco números pseudoaleatorios generados por el proceso descrito en la 
página 113, con a = 12, b = 5 y n = 100, y 92 como la semilla para cursar.
*/

import java.util.Random;

public class Ejercicio3_1 {    
    public static void main(String[] args){

        int a = 12;
        int b = 5;
        int n = 100;
        int cur = 92;
        int next = 0;

        for(int i = 0; i < 5; i++){

            next = (a * cur + b) % n;

            System.out.println(next);
            cur = next;
        }
    }
}
