package ESTRUCORDENA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Grafo {
    private Map<String, List<String>> adyacencias;

    public Grafo() {
        this.adyacencias = new HashMap<>();
    }

    public void agregarVertice(String vertice) {
        adyacencias.putIfAbsent(vertice, new ArrayList<>());
    }

    public void agregarArista(String origen, String destino) {
        adyacencias.computeIfAbsent(origen, k -> new ArrayList<>()).add(destino);
    }

    public List<String> obtenerVertices() {
        return new ArrayList<>(adyacencias.keySet());
    }

    public List<String> obtenerVecinos(String vertice) {
        return adyacencias.getOrDefault(vertice, Collections.emptyList());
    }

    public void imprimirGrafo() {
        for (Map.Entry<String, List<String>> entry : adyacencias.entrySet()) {
            String vertice = entry.getKey();
            List<String> vecinos = entry.getValue();
            System.out.print(vertice + ": ");
            for (String vecino : vecinos) {
                System.out.print(vecino + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
   Grafo grafo = new Grafo();
        llenarGrafo(grafo);

        System.out.println("Representación del grafo:");
        grafo.imprimirGrafo();
    }     

    public static void llenarGrafo(Grafo grafo) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese vértices para el grafo (separados por espacio): ");
        String[] vertices = scanner.nextLine().split(" ");

        for (String vertice : vertices) {
            grafo.agregarVertice(vertice);
        }

        System.out.println("Ingrese aristas para el grafo (pares de vértices, separados por espacio):");
        String[] aristas = scanner.nextLine().split(" ");

        for (int i = 0; i < aristas.length; i += 2) {
            grafo.agregarArista(aristas[i], aristas[i + 1]);
        }
    }
}