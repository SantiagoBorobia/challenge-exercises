/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curatechchallenge;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author santiagoborobia
 */
public class CuratechChallenge {

    /*
    PROBLEM #3
    Write a short program that prints each number from 1 to 100 on a new line.
    For each multiple of 3, print "Fizz" instead of the number.
    For each multiple of 5, print "Buzz" instead of the number.
    For numbers which are multiples of both 3 and 5, print "FizzBuzz" instead of the number.    
    */
    
    public static void fizzBuzz(){
        
        for(int i=1; i<=100; i++){
            //Si es multiplo de 3 escribe "Fizz"
            if(i%3==0)
                System.out.print("Fizz");
            //Si es multiplo de 5 agrega (o escribe) "Buzz"
            if(i%5==0)
                System.out.print("Buzz");
            //Si no es multiplo de 3 ni de 5 escribe el numero
            else
                if(i%3!=0)
                    System.out.print(i);
            //Realiza el salto de linea
            System.out.println();
        }
    }
    
    /*
    PROBLEM #2
    An avid hiker keeps meticulous records of their hikes. 
    During the last hike that took exactly steps, for every step it was noted if it was an uphill, Ʊ , or a downhill, Ɗ step. 
    Hikes always start and end at sea level, and each step up or down represents a 1 unit change in altitude. 
    
    We define the following terms:
    A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
    A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
    
    Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.   
    */
    
    public static int countingValleys(int steps, String path){
        int cont = 0; //Contador para llevar la cantidad de valles
        int prev = 0; //Estado del paso previo al actual
        for (char s: path.toCharArray()) {
            if(prev==0 && s=='D') //Si el estado es "sea level" y bajo (D), entonces entro a un valle
                cont++;
            if(s=='D') //Paso hacia abajo
                prev--;
            if(s=='U')  //Paso hacia arriba
                prev++;
        }
        return cont;
    }
    
    /*
    Sandy works at a groceries store. 
    There is a large pile of milk boxes that must be paired by flavor for sale. 
    Given an array of integers representing the color of each milk box, determine how many pairs of milk boxes with matching colors there are.
    
    For example, there are n = 7 milk boxes with colors ar = [1, 2, 1, 2, 1, 3, 2]. 
    There is one pair of color and one of color . 
    There are three odd socks left, one of each color. 
    The number of pairs is 2
    */
    
    public static int MilkMerchant(int n, int ar[]){
        Set<Integer> pares =  new HashSet<>(); //Crea una instancia de tipo Set
        int cont = 0; //Contador para llevar el numero de pares de cajas
        
        for(int i=0; i<n; i++){
            if(!pares.contains(ar[i])) //Si no hay una caja igual a ar[i] en el Set, la agrega
                pares.add(ar[i]);
            else{                      //Si ya hay una caja igual a ar[i] en el Set, significa que se encontro un par
                pares.remove(ar[i]);   //Entonces se saca el par del Set y se suma el contador
                cont++;
            }
        } 
        return cont;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Prueba de corrida problema #3
        fizzBuzz();
        System.out.println();
        
        // Prueba de corrida problema #2
        System.out.println(countingValleys(8, "UDDDUDUU"));
        System.out.println(countingValleys(12, "DDUUDDUDUUUD"));
        System.out.println();
        
        // Prueba de corrida problema #1
        int ar[] = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int ar2[] = {4, 5, 5, 5, 6, 6, 4, 1, 4, 4, 3, 6, 6, 3, 6, 1, 4, 5, 5, 5};
        System.out.println(MilkMerchant(9,ar));
        System.out.println(MilkMerchant(20,ar2));
        


    }
    
}
