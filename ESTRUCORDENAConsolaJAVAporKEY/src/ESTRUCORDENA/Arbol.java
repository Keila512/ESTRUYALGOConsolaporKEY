package ESTRUCORDENA;

import java.util.Scanner;

public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(int valor, String prioridad) {
        raiz = insertarRec(raiz, valor, prioridad);
    }

    private NodoArbol insertarRec(NodoArbol nodo, int valor, String prioridad) {
        if (nodo == null) {
            return new NodoArbol(valor, prioridad);
        }

        if (prioridad.compareToIgnoreCase(nodo.prioridad) > 0) {
            if (valor < nodo.valor) {
                nodo.izquierda = insertarRec(nodo.izquierda, valor, prioridad);
            } else {
                nodo.derecha = insertarRec(nodo.derecha, valor, prioridad);
            }
        } else {
            nodo.izquierda = insertarRec(nodo.izquierda, valor, prioridad);
        }

        return nodo;
    }

    public void recorridoInordenPrioridad() {
        recorridoInordenPrioridad(raiz);
    }

    private void recorridoInordenPrioridad(NodoArbol nodo) {
        if (nodo != null) {
            recorridoInordenPrioridad(nodo.izquierda);
            System.out.println("Valor: " + nodo.valor + ", Prioridad: " + nodo.prioridad);
            recorridoInordenPrioridad(nodo.derecha);
        }
    }

    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        llenarArbolConPrioridades(arbol);

        System.out.println("Recorrido Inorden del árbol con prioridades:");
        arbol.recorridoInordenPrioridad();
    }

    public static void llenarArbolConPrioridades(Arbol arbol) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese elementos para el árbol (separados por espacio): ");
        String[] elementos = scanner.nextLine().split(" ");

        for (String elemento : elementos) {
            try {
                int num = Integer.parseInt(elemento);
                System.out.print("Ingrese la prioridad para el elemento " + num + " (alta, media, baja): ");
                String prioridad = scanner.nextLine().toLowerCase();
                if (prioridad.equals("alta") || prioridad.equals("media") || prioridad.equals("baja")) {
                    arbol.insertar(num, prioridad);
                } else {
                    System.out.println("Prioridad no válida. Se asignará 'media' por defecto.");
                    arbol.insertar(num, "media");
                }
            } catch (NumberFormatException e) {
                // Manejar la entrada no válida (no es un número)
            }
        }
    }
}