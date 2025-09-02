public class index {  // Nombre de clase corregido (mayúscula inicial)
    
    public static void main(String[] args) {  // Método main que faltaba
        // SECCIÓN DE RECURSIVIDAD
        System.out.println("\nPruebas recursivas");  // Encabezado de sección recursividad
        System.out.println("Función recursiva para contar números pares:\n");  // Explicación de la función
        
        // Casos de prueba variados para la función recursiva
        int[] arreglo1 = {1, 2, 3, 4, 5, 6};     // Mixto: 3 pares (2, 4, 6)
        int[] arreglo2 = {2, 4, 6, 8, 10};       // Todos pares: 5 pares
        int[] arreglo3 = {1, 3, 5, 7, 9};        // Todos impares: 0 pares
        int[] arreglo4 = {};                      // Vacío: 0 pares
        int[] arreglo5 = {10};                    // Un solo par: 1 par
        int[] arreglo6 = {7};                     // Un solo impar: 0 pares
        int[] arreglo7 = {0, 2, 4, 1, 3};        // Mixto con cero: 3 pares (0, 2, 4)
        
        // Ejecutar y mostrar resultados de todas las pruebas
        System.out.println("Prueba 1 - Arreglo [1,2,3,4,5,6]: " + contarPares(arreglo1, 0) + " números pares");
        System.out.println("Prueba 2 - Arreglo [2,4,6,8,10]: " + contarPares(arreglo2, 0) + " números pares");
        System.out.println("Prueba 3 - Arreglo [1,3,5,7,9]: " + contarPares(arreglo3, 0) + " números pares");
        System.out.println("Prueba 4 - Arreglo vacío []: " + contarPares(arreglo4, 0) + " números pares");
        System.out.println("Prueba 5 - Arreglo [10]: " + contarPares(arreglo5, 0) + " números pares");
        System.out.println("Prueba 6 - Arreglo [7]: " + contarPares(arreglo6, 0) + " números pares");
        System.out.println("Prueba 7 - Arreglo [0,2,4,1,3]: " + contarPares(arreglo7, 0) + " números pares");
        
        System.out.println("\nAnalisis completo");  // Mensaje de finalización
    }  // Cierre correcto del método main
    
    /**
     * Función recursiva para contar números pares en un arreglo
     * @param arreglo El arreglo de enteros a analizar
     * @param indice El índice actual en la recursión
     * @return La cantidad de números pares encontrados
     */
    public static int contarPares(int[] arreglo, int indice) {
        // Caso base: si hemos llegado al final del arreglo
        // Esto detiene la recursión
        if (indice >= arreglo.length) {
            return 0;  // No hay más elementos, retornamos 0
        }
        
        // Verificar si el elemento actual es par
        // Un número es par si el residuo de dividirlo entre 2 es 0
        // Operador ternario: si es par vale 1, sino vale 0
        int contadorActual = (arreglo[indice] % 2 == 0) ? 1 : 0;
        
        // Llamada recursiva: sumamos el resultado actual + el resultado del resto del arreglo
        // La recursión avanza al siguiente índice (indice + 1)
        return contadorActual + contarPares(arreglo, indice + 1);
    }
}  // Cierre correcto de la clase