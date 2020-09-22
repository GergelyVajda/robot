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
import static java.lang.Math.abs;
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
            BufferedReader okos = new BufferedReader(buta);
            Integer sorszam = Integer.parseInt(okos.readLine());
            String[] programok = new String[sorszam];

            for (int i = 0; i < sorszam; i++) {
                programok[i] = okos.readLine();
            }

            System.out.println("---MÁSODIK FELADAT---");

            Scanner sc = new Scanner(System.in);
            System.out.println("Kérem adja meg az utasítássor számát!");
            Integer sor = sc.nextInt() - 1;
            //2/A
            Integer egyszeru = 0;

            for (int j = 0; j < programok[sor].length(); j++) {

                if (programok[sor].charAt(j) == 'E' && programok[sor].charAt(j + 1) == 'D') {
                    egyszeru++;
                    break;
                }
                if (programok[sor].charAt(j) == 'D' && programok[sor].charAt(j + 1) == 'E') {
                    egyszeru++;
                    break;
                }

                if (programok[sor].charAt(j) == 'K' && programok[sor].charAt(j + 1) == 'N') {
                    egyszeru++;
                    break;
                }
                if (programok[sor].charAt(j) == 'N' && programok[sor].charAt(j + 1) == 'K') {
                    egyszeru++;
                    break;
                }
            }

            if (egyszeru == 0) {
                System.out.println("Nem egyszerűsíthető");
            } else {
                System.out.println("Egyszerűsíthető");
            }
            //2/B
            Integer E = 0;
            Integer D = 0;
            Integer N = 0;
            Integer K = 0;
            Integer ED = 0;
            Integer KN = 0;
            for (int i = 0; i < programok[sor].length(); i++) {
                if (programok[sor].charAt(i) == 'E') {
                    E++;
                }
                if (programok[sor].charAt(i) == 'D') {
                    D++;
                }
                if (programok[sor].charAt(i) == 'N') {
                    N++;
                }
                if (programok[sor].charAt(i) == 'K') {
                    K++;
                }
            }
            ED = abs(E - D);
            KN = abs(K - N);
            System.out.println(ED + " lépést kell tenni az ED, " + KN + " lépést a KN tengely mentén.");
            //2/C
            ED = 0;
            KN = 0;
            Integer maxED=0;
            Integer maxKN=0;
            Integer pytagoras=0;
            Double tavolsag;
            for (int i = 0; i < programok[sor].length(); i++) {
                if (programok[sor].charAt(i) == 'E') {
                    ED++;
                }
                if (programok[sor].charAt(i) == 'D') {
                    ED--;
                }
                if (programok[sor].charAt(i) == 'K') {
                    KN++;
                }
                if (programok[sor].charAt(i) == 'N') {
                    KN--;
                }
                    if (ED>maxED) {
                    maxED=ED;
                }
                    if (KN>maxKN) {
                    maxKN=KN;
                }      
            }
            pytagoras=(maxED*maxED)+(maxKN*maxKN);
            tavolsag=Math.sqrt(pytagoras);
            
            System.out.print("A robot az utasítássor során légvonalban ");
            System.out.printf("%3.3f", tavolsag);
            System.out.println("cm távolságra volt a kiinduló ponttól.");
            
            System.out.println("---HARMADIK FELADAT---");
            
            
            

        } catch (FileNotFoundException ex) {
            System.out.println("Nem található a file!");
        } catch (IOException ex) {
            System.out.println("Olvasási hiba!");
        }

    }

}
