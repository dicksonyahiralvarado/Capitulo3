//R-3.2 Escriba un método Java que seleccione y elimine repetidamente una entrada aleatoria de una matriz 
//hasta que la matriz no contenga más entradas.

import java.util.Random;

public class Ejercicio3_2
{
    public static void main(String[] args) 
    {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        eliminarElemento(array);
    }

    static void eliminarElemento(int[] array) 
    {
        Random r = new Random();
        while (array.length > 0) 
        {
            int indice = r.nextInt(array.length);
            System.out.println("INDICE = " + indice + "  ELEMENTO = " + array[indice]);
            int[] array1 = new int[array.length - 1];
            for (int i = 0; i < indice; i++)
            array1[i] = array[i];
            for (int i = indice; i < array.length - 1; i++)
            array1[i] = array[i + 1];
            array = array1;
        }
    }
}
