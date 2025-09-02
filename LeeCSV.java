// Importar las clases necesarias para entrada/salida y estructuras de datos
import java.io.BufferedReader;    // Para leer texto de una entrada de caracteres
import java.io.FileReader;         // Para leer archivos de texto
import java.io.IOException;        // Para manejar excepciones de entrada/salida
import java.util.ArrayList;        // Para usar listas dinámicas
import java.util.List;             // Para usar la interfaz List

// Definición de la clase principal
public class LeeCSV {
    
    // Clase interna para almacenar los datos de cada estudiante
    // Esta clase actúa como un modelo de datos para representar a cada estudiante
    static class Estudiante {
        String nombre;  // Campo para almacenar el nombre del estudiante
        int edad;       // Campo para almacenar la edad del estudiante
        int nota;       // Campo para almacenar la nota del estudiante
        
        // Constructor de la clase Estudiante
        // Se ejecuta cuando se crea una nueva instancia de Estudiante
        public Estudiante(String nombre, int edad, int nota) {
            this.nombre = nombre;  // Asigna el nombre recibido al campo nombre
            this.edad = edad;      // Asigna la edad recibida al campo edad
            this.nota = nota;      // Asigna la nota recibida al campo nota
        }
        
        // Método para convertir el objeto Estudiante a una representación en String
        // Útil para imprimir información del estudiante
        @Override
        public String toString() {
            return "Estudiante{nombre='" + nombre + "', edad=" + edad + ", nota=" + nota + "}";
        }
    }
    
    // Método principal, punto de entrada del programa
    public static void main(String[] args) {
        String rutaArchivo = "datos.csv";  // Ruta del archivo CSV a leer
        List<Estudiante> estudiantes = new ArrayList<>();  // Lista para almacenar objetos Estudiante
        
        // Imprimir encabezado del programa
        System.out.println("Analisis y comparacion de operacion\n");
        
        // Leer y procesar el archivo CSV usando try-with-resources
        // Esto asegura que el BufferedReader se cierre automáticamente
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;  // Variable para almacenar cada línea leída del archivo
            boolean primeraLinea = true;  // Bandera para identificar la primera línea (cabecera)
            
            System.out.println("Leyendo archivo datos.CSV");  // Mensaje de inicio de lectura
            
            // Bucle para leer cada línea del archivo hasta llegar al final (null)
            while ((linea = br.readLine()) != null) {
                // 1. Ignorar la primera línea (cabecera)
                if (primeraLinea) {
                    System.out.println("Cabecera ignorada: " + linea);  // Mostrar la cabecera que se ignora
                    primeraLinea = false;  // Cambiar bandera para no ignorar las siguientes líneas
                    continue;  // Saltar al siguiente ciclo del bucle
                }
                
                // Dividir la línea en partes usando la coma como separador
                String[] columnas = linea.split(",");
                
                // Verificar que la línea tenga exactamente 3 columnas
                if (columnas.length == 3) {
                    try {
                        String nombre = columnas[0];  // Extraer nombre de la primera columna
                        int edad = Integer.parseInt(columnas[1]);  // Convertir segunda columna a entero (edad)
                        int nota = Integer.parseInt(columnas[2]);  // Convertir tercera columna a entero (nota)
                        
                        estudiantes.add(new Estudiante(nombre, edad, nota));  // Crear y agregar nuevo estudiante a la lista
                        System.out.println("Estudiante agregado: " + nombre + ", " + edad + " años, nota: " + nota);  // Mensaje de confirmación
                    } catch (NumberFormatException e) {
                        // Manejar error si no se puede convertir edad o nota a número
                        System.out.println("Error al convertir número en línea: " + linea);
                    }
                }
            }
            
            System.out.println("\nResultados de de los estudiantes");  // Encabezado de resultados
            
            // 2. Contar cuántos estudiantes tienen Nota mayor o igual a 90
            int contadorNotasAltas = 0;  // Contador para estudiantes con nota alta
            System.out.println("\nEstudiantes con nota >= 90:");  // Encabezado de lista
            // Recorrer todos los estudiantes en la lista
            for (Estudiante e : estudiantes) {
                if (e.nota >= 90) {  // Verificar si la nota es mayor o igual a 90
                    contadorNotasAltas++;  // Incrementar contador
                    System.out.println("- " + e.nombre + ": " + e.nota);  // Mostrar estudiante con nota alta
                }
            }
            
            // 3. Calcular el promedio de Edad
            int sumaEdades = 0;  // Acumulador para sumar todas las edades
            // Recorrer todos los estudiantes para sumar sus edades
            for (Estudiante e : estudiantes) {
                sumaEdades += e.edad;  // Agregar edad al acumulador
            }
            // Calcular promedio, evitando división por cero si la lista está vacía
            double promedioEdad = estudiantes.isEmpty() ? 0 : (double) sumaEdades / estudiantes.size();
            
            // Mostrar resultados finales
            System.out.println("\nEstadisticas finales");  // Encabezado de estadísticas
            System.out.println("Total de estudiantes procesados: " + estudiantes.size());  // Cantidad total de estudiantes
            System.out.println("Estudiantes con nota >= 90: " + contadorNotasAltas);  // Resultado del contador de notas altas
            System.out.println("Promedio de edad: " + promedioEdad + " años");  // Promedio edad
            
        } catch (IOException e) {
            // Manejar error si hay problemas al leer el archivo
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        
    }
}