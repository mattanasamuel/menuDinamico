
/**
 *
 */
public class Ereditarietà {

    private static Object obj;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        Persone listaPersone = new Persone();
        Studente s1 = new Studente("123matricola", "uniPadova", "cf456", "mario", "rossi");
        Docente d1 = new Docente("matematica", 123, "codiice123454", "pino", "verdi");
        Persona p3 = new Persona("skidhc", "gino", "gialli");

        //String inputFileName = "../Ereditarietà/src/ereditarietà/menu.txt";
        String inputFileName = "src/ereditarietà/menu.txt";
        boolean corretto = false;
        Scanner in = new Scanner(System.in);
        Funzione funzioneChiamata = null;
        Menu mioMenu;
        /*
		 * try { Menu mioMenu= new Menu(inputFileName); System.out.println(mioMenu); }
		 * catch(IOException e) { System.out.println(inputFileName+" FileNotFound"); }
         */
        // CONTROLLI INPUT CON CICLO FINO A CONDIZIONI CORRETTE

//__________________________________________________________________________________________________
        System.out.println("p3:" + p3.toString());
        System.out.println("s1:" + s1.toString());
        System.out.println("d1:" + d1.toString());

        try {
            listaPersone.aggiungi(p3);
            System.out.println("persona p3 aggiunta");
        } catch (Exception e) {
            System.out.println("persona p3 non insetita");
        }

        try {
            listaPersone.aggiungi(s1);
            System.out.println("studente s1 aggiunto");
        } catch (Exception e) {
            System.out.println("studente s1 non insetita");
        }
        try {
            listaPersone.aggiungi(d1);
            System.out.println("docente d1 aggiunto");
        } catch (Exception e) {
            System.out.println("docente d1 non insetito");
        }
    
    while (!corretto) {
	try {
            mioMenu = new Menu(inputFileName);
            System.out.println(mioMenu);
            System.out.println("Inserisci il numero corrispondente alla voce di menų");
            int numeroFunzione = in.nextInt();
            funzioneChiamata = mioMenu.getFunzioneFromKey(numeroFunzione);
            if (funzioneChiamata != null) {
                corretto = true;
                System.out.println(funzioneChiamata);
            } 

        } catch (IOException e) {
            System.out.println(inputFileName + " FileNotFound");
        } catch (InputMismatchException e) {
            System.err.println("Inserire un numero intero intero senza virgola");
        } catch (NullPointerException e) {
            System.err.println("Inserire un numero di funzione valido tra quelli seguenti: ");
        } finally {
            in.nextLine();
        }

          /*
				 * Per usare la riflessione devo fare import di import java.lang.reflect.*;
				 * La Riflessione (Reflection) č, come suggerisce il nome, la capacitā introspettiva degli oggetti grazie alla quale 
				 * potremo analizzare ed interagire a runtime con le Classi.
				 * Tipicamente le classi ed i metodi utilizzati sono noti. 
				 * Con la riflessione si stravolge quest'approccio e 
				 * si analizzano e utilizzano oggetti delle cui classi non conosciamo i metodi e gli attributi.
                 * Grazie alla Reflection, infatti, identificando il tipo (Classe di Appartenenza) degli oggetti istanziati,
                 * di conoscerne i metodi, le loro firme e persino la possibilitā di invocarli. Questo risulta comodo nella definizione di framework dove il programmatore
                 * non sa quali sono i metodi e le classi da invocare. Di fatto nell'esempio che segue noi stiamo costruendo un piccolo 
                 * FW che a partire da un file istanzia dinamicamente un menų e richiama le classi ed i metodi referenziati dal manų
            
            Class c = Class.forName(funzioneChiamata.classeDaInvocare);
            Method m1 = c.getDeclaredMethod(funzioneChiamata.metodo,funzioneChiamata.parametri);
            obj = c.newInstance(.....aggiungere i parametri della classe da invocare);
            System.out.println(m1.invoke(p1));
            System.out.println(m1.invoke(obj,));

        } catch (Throwable e) {
            System.err.println(e);
        }
    }
    }
}
