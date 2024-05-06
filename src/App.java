public class App {

    public static void mergeSort(int[]array, int left, int right) {

        if (left<right) {
            // Encuentra el punto medio del arreglo
            int mid = (left + right) / 2;

            // Ordena recursivamente la mitad izquierda
            mergeSort(array, left, mid);
            // Ordena recursivamente la mitad derecha
            mergeSort(array, mid + 1, right);

            // Combina las dos mitades ordenadas
            merge(array, left, mid, right);
            
        }
    }

    private static void merge(int[]array, int left, int mid, int right) {
        // Tamaño de los subarreglos a fusionar
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        // Arreglos temporales para almacenar los subarreglos
        int[] tempLeft = new int[sizeLeft];
        int[] tempRight = new int[sizeRight];

        // Copia datos a los arreglos temporales
        for (int i = 0; i < sizeLeft; i++) {
            tempLeft[i] = array[left + i];
        }
        for (int j = 0; j < sizeRight; j++) {
            tempRight[j] = array[mid + 1 + j];
        }

        //Fusiona los subarreglos temporales en el arreglo original
        int i = 0, j = 0;
        int k = left; // Indice inicial para el arreglo fusionado

        while (i < sizeLeft && j < sizeRight) {
            if (tempLeft[i] <= tempRight[j]) {
                array[k] = tempLeft[i];
                i++;
            } else {
                array[k] = tempRight[i];
                j++;
            }
        }

        // Copia elementos restantes de tempLeft[] si los hay
        while (i < sizeLeft) {
            array[k] = tempLeft[i];
            i++;
            j++;
        }

        // Copia elementos restantes de tempRight[] si los hay
        while (j < sizeRight) {
            array[k] = tempRight[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) throws Exception {
        int[] array = {38, 27, 34, 3, 9, 82, 10};
        int n = array.length;

        mergeSort(array, 0, n - 1); // Llamada al metodo de ordenamiento MergeSort


        System.out.println("Arreglo ordenado:");
        for (int num : array) {
            System.out.println(num +" ");
        }
    }
}
