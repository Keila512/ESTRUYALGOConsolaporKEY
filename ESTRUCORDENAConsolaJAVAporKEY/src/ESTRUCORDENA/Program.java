package ESTRUCORDENA;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Program {
	public static void main(String[] args) {
	        boolean continuarPrograma = true;
	        List<Integer> data = new ArrayList<>();

	        while (continuarPrograma) {
	            System.out.println("Seleccione una estructura de datos:");
	            System.out.println("1. Pila");
	            System.out.println("2. Cola");
	            System.out.println("3. Lista");
	            System.out.println("4. Árbol");
	            System.out.println("5. Grafo");
	            System.out.println("6. Salir");
	            System.out.println("7. Menú de Ordenamientos");

	            System.out.print("Ingrese el número de la opción: ");
	            Scanner scanner = new Scanner(System.in);
	            String opcionEstructura = scanner.nextLine();

	            switch (opcionEstructura) {
	                case "1":
	                    ejecutarOperacionesPila();
	                    break;
	                case "2":
	                    ejecutarOperacionesCola();
	                    break;
	                case "3":
	                    ejecutarOperacionesLista();
	                    break;
	                case "4":
	                    ejecutarOperacionesArbol();
	                    break;
	                case "5":
	                    ejecutarOperacionesGrafo();
	                    break;
	                case "6":
	                    continuarPrograma = false;
	                    break;
	                case "7":
	                    data = obtenerDatosUsuario();
	                    ejecutarMenuOrdenamientos(data);
	                    break;
	                default:
	                    System.out.println("Opción no válida. Inténtelo de nuevo.");
	                    break;
	            }
	        }
    }
	static void ejecutarOperacionesPila() {
        System.out.println("Operaciones con Pila:");
        Stack<Integer> pila = new Stack<>();
        operacionesPila(pila, "pila");
    }

    static void ejecutarOperacionesCola() {
        System.out.println("Operaciones con Cola:");
        Queue<String> cola = new LinkedList<>();
        OperacionesCola(cola, "cola");
    }

    static void ejecutarOperacionesLista() {
        System.out.println("Operaciones con Lista:");
        List<Double> lista = new ArrayList<>();
        OperacionesLista(lista, "lista");
    }

    static void ejecutarOperacionesArbol() {
        System.out.println("Operaciones con Árbol:");
        Arbol arbol = new Arbol();
        llenarArbolConPrioridades(arbol);
        
        System.out.println("Recorrido Inorden del árbol con prioridades:");
        arbol.recorridoInordenPrioridad();
    }

    static void ejecutarOperacionesGrafo() {
        System.out.println("Operaciones con Grafo:");
        Grafo grafo = new Grafo();
        llenarGrafo(grafo);
        System.out.println("Representación del Grafo:");
        mostrarGrafo(grafo);
    }

    
    
    
    private static List<Integer> obtenerDatosUsuario() {
        System.out.print("Ingrese datos (separados por espacios): ");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        List<Integer> data = new ArrayList<>();
        for (String item : input) {
            try {
                int num = Integer.parseInt(item);
                data.add(num);
            } catch (NumberFormatException e) {
                System.out.println("'" + item + "' no es un número válido y será ignorado.");
            }
        }

        return data;
    }

    private static void ejecutarMenuOrdenamientos(List<Integer> data) {
        boolean continuarMenu = true;

        while (continuarMenu) {
            System.out.println("\nSorting Menu:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. QuickSort");
            System.out.println("5. Merge Sort");
            System.out.println("6. Heap Sort");
            System.out.println("7. Shell Sort");
            System.out.println("8. Counting Sort");
            System.out.println("9. Radix Sort");
            System.out.println("10. Exit");

            System.out.print("Seleccione una opción (1-10): ");
            Scanner scanner = new Scanner(System.in);
            String sortingOption = scanner.nextLine();

            switch (sortingOption) {
                case "1":
                    bubbleSort(data);
                    mostrarDatos(data);
                    break;
                case "2":
                    selectionSort(data);
                    mostrarDatos(data);
                    break;
                case "3":
                    insertionSort(data);
                    mostrarDatos(data);
                    break;
                case "4":
                    quickSort(data, 0, data.size() - 1);
                    mostrarDatos(data);
                    break;
                case "5":
                    mergeSort(data, 0, data.size() - 1);
                    System.out.println("Datos ordenados con MergeSort: " + data);
                    break;
                case "6":
                    heapSort(data);
                    mostrarDatos(data);
                    break;
                case "7":
                    shellSort(data);
                    mostrarDatos(data);
                    break;
                case "8":
                    countingSort(data);
                    mostrarDatos(data);
                    break;
                case "9":
                    radixSort(data);
                    mostrarDatos(data);
                    break;
                case "10":
                    continuarMenu = false;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }

    private static void mostrarDatos(List<Integer> data) {
        System.out.println("Datos ordenados: " + data);
    }

    private static void bubbleSort(List<Integer> data) {
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data.get(j) > data.get(j + 1)) {
                    // Intercambiar elementos si están en el orden incorrecto
                    int temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                }
            }
        }

        System.out.println("Datos ordenados con Bubble Sort.");
    }

    private static void selectionSort(List<Integer> data) {
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Encontrar el índice del elemento mínimo en el resto del array
            for (int j = i + 1; j < n; j++) {
                if (data.get(j) < data.get(minIndex)) {
                    minIndex = j;
                }
            }

            // Intercambiar el elemento mínimo con el primer elemento sin ordenar
            int temp = data.get(minIndex);
            data.set(minIndex, data.get(i));
            data.set(i, temp);
        }

        System.out.println("Datos ordenados con Selection Sort.");
    }

    private static void insertionSort(List<Integer> data) {
        int n = data.size();
        for (int i = 1; i < n; i++) {
            int key = data.get(i);
            int j = i - 1;

            // Mover los elementos del array que son mayores que key a una posición adelante de su posición actual
            while (j >= 0 && data.get(j) > key) {
                data.set(j + 1, data.get(j));
                j--;
            }

            // Insertar el elemento key en su posición correcta
            data.set(j + 1, key);
        }

        System.out.println("Datos ordenados con Insertion Sort.");
    }

    private static void quickSort(List<Integer> data, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(data, low, high);

            quickSort(data, low, partitionIndex - 1);
            quickSort(data, partitionIndex + 1, high);
        }
    }

    private static int partition(List<Integer> data, int low, int high) {
        int pivot = data.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (data.get(j) < pivot) {
                i++;
                swap(data, i, j);
            }
        }

        swap(data, i + 1, high);
        return i + 1;
    }

    private static void swap(List<Integer> data, int i, int j) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    private static void mergeSort(List<Integer> data, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(data, left, middle);
            mergeSort(data, middle + 1, right);

            merge(data, left, middle, right);
        }
    }

    private static void merge(List<Integer> data, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        List<Integer> leftArray = new ArrayList<>(data.subList(left, left + n1));
        List<Integer> rightArray = new ArrayList<>(data.subList(middle + 1, middle + 1 + n2));

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray.get(i) <= rightArray.get(j)) {
                data.set(k, leftArray.get(i));
                i++;
            } else {
                data.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            data.set(k, leftArray.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            data.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }

    private static void heapSort(List<Integer> data) {
        int n = data.size();

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(data, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = data.get(0);
            data.set(0, data.get(i));
            data.set(i, temp);

            heapify(data, i, 0);
        }
    }

    private static void heapify(List<Integer> data, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && data.get(left) > data.get(largest))
            largest = left;

        if (right < n && data.get(right) > data.get(largest))
            largest = right;

        if (largest != i) {
            int swap = data.get(i);
            data.set(i, data.get(largest));
            data.set(largest, swap);

            heapify(data, n, largest);
        }
    }

    private static void shellSort(List<Integer> data) {
        int n = data.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = data.get(i);
                int j;
                for (j = i; j >= gap && data.get(j - gap) > temp; j -= gap)
                    data.set(j, data.get(j - gap));

                data.set(j, temp);
            }
        }
    }

    private static void countingSort(List<Integer> data) {
        int n = data.size();
        int[] output = new int[n];

        int max = Collections.max(data);
        int min = Collections.min(data);
        int range = max - min + 1;

        int[] count = new int[range];

        for (int i = 0; i < n; i++)
            count[data.get(i) - min]++;

        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[data.get(i) - min] - 1] = data.get(i);
            count[data.get(i) - min]--;
        }

        for (int i = 0; i < n; i++)
            data.set(i, output[i]);
    }

    private static void radixSort(List<Integer> data) {
        int max = Collections.max(data);
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSortRadix(data, exp);
    }
    public static void countingSortRadix(List<Integer> data, int exp) {
        int n = data.size();
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++)
            count[(data.get(i) / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[(data.get(i) / exp) % 10] - 1] = data.get(i);
            count[(data.get(i) / exp) % 10]--;
        }

        for (int i = 0; i < n; i++)
            data.set(i, output[i]);
    }
    
    
    static <T> void MostrarColeccion(Iterable<T> coleccion) {
        for (T elemento : coleccion) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    static void LlenarArbol(Arbol arbol) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese elementos para el árbol (separados por espacio): ");
        String[] elementos = scanner.nextLine().split(" ");

        for (String elemento : elementos) {
            try {
                int num = Integer.parseInt(elemento);
                // Se proporciona una prioridad por defecto (puedes ajustar esto según tus necesidades)
                arbol.insertar(num, "media");
            } catch (NumberFormatException e) {
                // Manejar la entrada no válida (no es un número)
            }
        }
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

    static void LlenarGrafo(Grafo grafo) {
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

    static void MostrarGrafo(Grafo grafo) {
        for (String vertice : grafo.obtenerVertices()) {
            System.out.print(vertice + ": ");
            for (String vecino : grafo.obtenerVecinos(vertice)) {
                System.out.print(vecino + " ");
            }
            System.out.println();
        }
    }

    static void operacionesPila(Stack<Integer> pila, String nombre) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nOperaciones en la " + nombre + ":");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Quitar elemento");
            System.out.println("3. Mostrar contenido");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opción (1-4): ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    agregarElemento(pila);
                    break;
                case "2":
                    QuitarElemento(pila);
                    break;
                case "3":
                    MostrarColeccion(pila);
                    break;
                case "4":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }
    // Método para operaciones específicas de pila
    static void agregarElemento(Stack<Integer> pila) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el elemento a agregar: ");
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            pila.push(num);
            System.out.println("Elemento " + num + " agregado a la pila.");
        } else {
            System.out.println("Entrada no válida. Inténtelo de nuevo.");
        }
    }

    // Método para operaciones específicas de pila
    static void QuitarElemento(Stack<Integer> pila) {
        if (!pila.isEmpty()) {
            int elementoQuitado = pila.pop();
            System.out.println("Elemento " + elementoQuitado + " quitado de la pila.");
        } else {
            System.out.println("La pila está vacía.");
        }
    }

    static void OperacionesCola(Queue<String> cola, String nombre) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nOperaciones en la " + nombre + ":");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Quitar elemento");
            System.out.println("3. Mostrar contenido");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opción (1-4): ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    AgregarElemento(cola, scanner);
                    break;
                case "2":
                    QuitarElemento(cola);
                    break;
                case "3":
                    MostrarColeccion(cola);
                    break;
                case "4":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }

    // Método para operaciones específicas de cola
    static void AgregarElemento(Queue<String> cola, Scanner scanner) {
        System.out.print("Ingrese el elemento a agregar: ");
        String elemento = scanner.nextLine();
        cola.offer(elemento);
        System.out.println("Elemento '" + elemento + "' agregado a la cola.");
    }

    // Método para operaciones específicas de cola
    static void QuitarElemento(Queue<String> cola) {
        if (!cola.isEmpty()) {
            String elementoQuitado = cola.poll();
            System.out.println("Elemento '" + elementoQuitado + "' quitado de la cola.");
        } else {
            System.out.println("La cola está vacía.");
        }
    }

    static void OperacionesLista(List<Double> lista, String nombre) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nOperaciones en la " + nombre + ":");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Quitar elemento");
            System.out.println("3. Mostrar contenido");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opción (1-4): ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    AgregarElemento(lista, scanner);
                    break;
                case "2":
                    QuitarElemento(lista);
                    break;
                case "3":
                    MostrarColeccion(lista);
                    break;
                case "4":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }

    // Método para operaciones específicas de lista
    static void AgregarElemento(List<Double> lista, Scanner scanner) {
        System.out.print("Ingrese el elemento a agregar: ");
        try {
            double num = Double.parseDouble(scanner.nextLine());
            lista.add(num);
            System.out.println("Elemento " + num + " agregado a la lista.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Inténtelo de nuevo.");
        }
    }

    // Método para operaciones específicas de lista
    static void QuitarElemento(List<Double> lista) {
        Scanner scanner = new Scanner(System.in);
        if (!lista.isEmpty()) {
            System.out.print("Ingrese la posición del elemento a quitar: ");
            try {
                int posicion = Integer.parseInt(scanner.nextLine());
                if (posicion >= 0 && posicion < lista.size()) {
                    double elementoQuitado = lista.remove(posicion);
                    System.out.println("Elemento " + elementoQuitado + " quitado de la lista.");
                } else {
                    System.out.println("Posición no válida. Inténtelo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Inténtelo de nuevo.");
            }
        } else {
            System.out.println("La lista está vacía.");
        }
    }
    
    static void llenarGrafo(Grafo grafo) {
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

    static void mostrarGrafo(Grafo grafo) {
        for (String vertice : grafo.obtenerVertices()) {
            System.out.print(vertice + ": ");
            for (String vecino : grafo.obtenerVecinos(vertice)) {
                System.out.print(vecino + " ");
            }
            System.out.println();
        }
    }
    
    
}





