/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gergely.vajda
 */
public class Robot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FileReader buta = new FileReader("program.txt");
            BufferedReader okos= new BufferedReader(buta);
            Integer sorszam= Integer.parseInt(okos.readLine());
            String[] programok= new String[sorszam];
            
            for (int i = 0; i < sorszam; i++) {
                programok[i]=okos.readLine();
            }
            
            System.out.println("---MÁSODIK FELADAT---");
            Scanner sc= new Scanner(System.in);
            System.out.println("Kérem adja meg az utasítássor számát!");
            Integer sor=sc.nextInt();
            Integer egyszeru=0;
            
            for (int i = 0; i < sorszam; i++) {
                if (i==sor-1) {
                     for (int j = 0; j < programok[i].length(); j++) {
                         if (programok[i].charAt(j)=='E' && programok[i].charAt(j+1)=='D') {
                             egyszeru++;
                         }
                         if (programok[i].charAt(j)=='D' && programok[i].charAt(j+1)=='E') {
                             egyszeru++;
                         }
                         if (programok[i].charAt(j)=='K' && programok[i].charAt(j+1)=='N') {
                             egyszeru++;
                         }
                         if (programok[i].charAt(j)=='N' && programok[i].charAt(j+1)=='K') {
                             egyszeru++;
                         }
                         break;
                    }
                }
                break;
            }
                if (egyszeru>0) {
                    System.out.println("Nem egyszerűsíthető");
            }else{
                    System.out.println("Egyszerűsíthető");    
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Nem található a file!");
        } catch (IOException ex) {
            System.out.println("Olvasási hiba!");
        }
        
        
    }
    
}
