/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ereditarietà;

import java.util.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author scarpa.giulia
 */
public class Menu {

    Hashtable<Integer, Funzione> listaFunzioni = new Hashtable<Integer, Funzione>();

    Menu(String nomeFile) throws IOException,ClassNotFoundException  {
        String line = null;
        BufferedReader fileMenu = new BufferedReader(new FileReader(nomeFile));
        line = fileMenu.readLine(); // legge una riga del file
        while (line != null) {

            String[] split = line.split(";");// split è un array di stringhe e col parseInt mi trasforsma da stringa a Intero
            //ciclo for per riempire i parametri
             Class[] parametri = new Class[split.length-4];
             for (int i = 4; i < split.length; i++) {
                try {
                    parametri[i-4] = Class.forName(split[i]);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            listaFunzioni.put(Integer.parseInt(split[0]), new Funzione(split[1], split[2], split[3], parametri));
            line = fileMenu.readLine();
        }
        fileMenu.close();
    }

    @Override
    public String toString() {
        return "Menu{" + "listaFunzioni=" + listaFunzioni + '}';
    }

    public String Stampa() {
        return  listaFunzioni.toString();
    }

    public Funzione getFunzioneFromKey(int numeroFunzione) throws NullPointerException {
        Funzione tmpFunzione;
        tmpFunzione = listaFunzioni.get(numeroFunzione);
        return tmpFunzione;
    }
}
