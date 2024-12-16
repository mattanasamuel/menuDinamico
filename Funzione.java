/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ereditarietà;

import java.util.*;
import java.io.*;
import java.lang.reflect.*;

/**
 *
 * @author scarpa.giulia
 */
public class Funzione {

    String descrizione;
    String classeDaInvocare;
    String metodo;
    Class[] parametri;

    public Funzione(String descrizione, String classeDaInvocare, String metodo, Class[]  parametri) {
        this.descrizione = descrizione;
        this.classeDaInvocare = classeDaInvocare;
        this.metodo = metodo;
        this.parametri = parametri;

    }

    
    @Override
    public String toString() {
        return "Funzione{" + "descrizione=" + descrizione + ", classeDaInvocare=" + classeDaInvocare + ", metodo=" + metodo + ", parametri=" + parametri + '}';
    }
   
    
}
