package Ejercicios;
import java.util.ArrayList;
import java.util.Scanner;

public class Calcular {
    // Clase anidada estática para decoraciones
    static class Decorador {
        static void imprimirCabecera(String titulo) {
            System.out.println("\n==============================");
            System.out.println("    " + titulo.toUpperCase());
            System.out.println("==============================");
        }

        static void imprimirLinea() {
            System.out.println("------------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<String> areas = new ArrayList<>();
        String continuar;

        Decorador.imprimirCabecera("Bienvenido al Calculador de Áreas");

        do {
            Decorador.imprimirCabecera("Menú Principal");
            System.out.println("1. Triángulo");
            System.out.println("2. Rectángulo");
            System.out.println("3. Círculo");
            System.out.println("Ingrese 's' para salir.");
            Decorador.imprimirLinea();

            continuar = teclado.next();

            if (continuar.equalsIgnoreCase("s")) { 
                Decorador.imprimirCabecera("Saliendo del programa...");
                break; 
            }

            int opcion;
            try {
                opcion = Integer.parseInt(continuar);
            } catch (NumberFormatException e) {
                Decorador.imprimirCabecera("Entrada inválida. Intente nuevamente.");
                continue;
            }

            switch (opcion) {
                case 1:
                    Decorador.imprimirCabecera("Cálculo del Triángulo");
                    double baseTri, alturaTri;
                    do {
                        System.out.print("Ingrese la base del triángulo (positiva): ");
                        baseTri = teclado.nextDouble();
                    } while (baseTri <= 0);

                    do {
                        System.out.print("Ingrese la altura del triángulo (positiva): ");
                        alturaTri = teclado.nextDouble();
                    } while (alturaTri <= 0);

                    Triangulo miTriangulo = new Triangulo(baseTri, alturaTri);
                    double areaTriangulo = miTriangulo.calcular();
                    areas.add("Triángulo | Área: " + areaTriangulo);
                    System.out.println("Área del triángulo: " + areaTriangulo);
                    break;

                case 2:
                    Decorador.imprimirCabecera("Cálculo del Rectángulo");
                    double baseRect, alturaRect;
                    do {
                        System.out.print("Ingrese la base del rectángulo (positiva): ");
                        baseRect = teclado.nextDouble();
                    } while (baseRect <= 0);

                    do {
                        System.out.print("Ingrese la altura del rectángulo (positiva): ");
                        alturaRect = teclado.nextDouble();
                    } while (alturaRect <= 0);

                    Rectangulo miRectangulo = new Rectangulo(baseRect, alturaRect);
                    double areaRectangulo = miRectangulo.calcular();
                    areas.add("Rectángulo | Área: " + areaRectangulo);
                    System.out.println("Área del rectángulo: " + areaRectangulo);
                    break;

                case 3:
                    Decorador.imprimirCabecera("Cálculo del Círculo");
                    double radio;
                    do {
                        System.out.print("Ingrese el radio del círculo (positivo): ");
                        radio = teclado.nextDouble();
                    } while (radio <= 0);

                    Circulo miCirculo = new Circulo(radio);
                    double areaCirculo = miCirculo.calcular();
                    areas.add("Círculo | Área: " + areaCirculo);
                    System.out.println("Área del círculo: " + areaCirculo);
                    break;

                default:
                    Decorador.imprimirCabecera("Opción no válida.");
            }
        } while (!continuar.equalsIgnoreCase("s"));

        // Mostrar todas las áreas calculadas antes de salir
        Decorador.imprimirCabecera("Resumen de Cálculos");
        for (String registro : areas) {
            System.out.println("- " + registro);
        }

        Decorador.imprimirCabecera("Gracias por usar el programa.");
        teclado.close();
    }
}
