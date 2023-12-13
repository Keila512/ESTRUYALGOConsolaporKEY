package ESTRUCORDENA;

class NodoArbol {
    int valor;
    String prioridad;
    NodoArbol izquierda;
    NodoArbol derecha;

    public NodoArbol(int valor, String prioridad) {
        this.valor = valor;
        this.prioridad = prioridad;
        this.izquierda = null;
        this.derecha = null;
    }
}
