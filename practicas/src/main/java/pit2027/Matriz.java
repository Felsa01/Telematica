package pit2027;

/**
 * Representa una matriz rectangular de números reales.
 */
public class Matriz {

    private double[][] datos;
    private int filas;
    private int columnas;

    /**
     * Construye una matriz a partir de un array bidimensional.
     *
     * Si las filas tienen distinta longitud, la matriz resultante tendrá
     * tantas columnas como la fila más larga. Las posiciones que falten
     * se rellenan con ceros.
     *
     * @param valores datos iniciales de la matriz
     */
    public Matriz(double[][] valores) {

        if (valores == null || valores.length == 0) {
            throw new IllegalArgumentException(
                    "La matriz debe tener al menos una fila");
        }

        // Buscamos la longitud de la fila más larga.
        // Si alguna fila es null, lanzamos una excepción.
        columnas = 0;

        for (int i = 0; i < valores.length; i++) {
            if (valores[i] == null) {
                throw new IllegalArgumentException(
                        "Las filas no pueden ser null");
            }

            if (valores[i].length > columnas) {
                columnas = valores[i].length;
            }
        }

        if (columnas == 0) {
            throw new IllegalArgumentException(
                    "La matriz debe tener al menos una columna");
        }

        filas = valores.length;

        /*
         * Los elementos de un array de double recién creado
         * valen 0.0. Por tanto, basta copiar los elementos que
         * existen en cada fila; los restantes ya quedan a cero.
         */
        datos = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < valores[i].length; j++) {
                datos[i][j] = valores[i][j];
            }
        }
    }

    /**
     * Devuelve las dimensiones de la matriz.
     *
     * @return un array {numeroDeFilas, numeroDeColumnas}
     */
    public int[] getDimension() {
        return new int[] { filas, columnas };
    }

    /**
     * Devuelve un elemento de la matriz.
     */
    public double getElemento(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            throw new IllegalArgumentException(
                    "Argumento fuera de rango: " + fila + ", " + columna + " (dimensiones: " + filas + "x" + columnas + ")");
        }

        return datos[fila][columna];
    }

    /**
     * Devuelve una representación textual de la matriz.
     */
    @Override
    public String toString() {

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < filas; i++) {

            resultado.append("[");

            for (int j = 0; j < columnas; j++) {

                resultado.append(datos[i][j]);

                if (j < columnas - 1) {
                    resultado.append(", ");
                }
            }

            resultado.append("]");

            if (i < filas - 1) {
                resultado.append(System.lineSeparator());
            }
        }

        return resultado.toString();
    }    


/**
     * Suma la matriz actual con otra pasada como argumento.
     * Devuelve null si el argumento es null o no tienen la misma dimensión.
     */
    public Matriz sumar(Matriz otra) {
        if (otra == null) {
            return null;
        }
        if (this.filas != otra.filas || this.columnas != otra.columnas) {
            return null;
        }
        
        double[][] resultado = new double[this.filas][this.columnas];
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                resultado[i][j] = this.datos[i][j] + otra.datos[i][j];
            }
        }
        return new Matriz(resultado);
    }

    /**
     * Versión estática que suma dos matrices.
     */
    public static Matriz sumar(Matriz m1, Matriz m2) {
        if (m1 == null) {
            return null;
        }
        return m1.sumar(m2);
    }

/**
     * Devuelve la matriz traspuesta de la actual.
     */
    public Matriz traspuesta() {
        double[][] resultado = new double[this.columnas][this.filas];
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                resultado[j][i] = this.datos[i][j];
            }
        }
        return new Matriz(resultado);
    }

    /**
     * Versión estática que devuelve la matriz traspuesta de la dada.
     */
    public static Matriz traspuesta(Matriz m) {
        if (m == null) {
            return null;
        }
        return m.traspuesta();
    }


    public static void main(String[] args) {
        double[][] valores = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };

        Matriz matriz = new Matriz(valores);
        System.out.println("Dimensiones: " + matriz.getDimension()[0] + "x" + matriz.getDimension()[1]);
        System.out.println("Matriz:");
        System.out.println(matriz);

        double[][] datos = {
            { 1.0, 2.0 },
            { }
        };

        matriz = new Matriz(datos);
        System.out.println("Dimensiones: " + matriz.getDimension()[0] + "x" + matriz.getDimension()[1]);
        System.out.println("Matriz:");
        System.out.println(matriz);
    } 
}
