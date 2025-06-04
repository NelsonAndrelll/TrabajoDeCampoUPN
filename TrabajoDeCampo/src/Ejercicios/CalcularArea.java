package Ejercicios;


public abstract class CalcularArea { // clase definida como abstracta
    protected double base, altura, radio;
    protected static final double PI = 3.1416;
    abstract double calcular(); // Método abstracto

    // Sobrecarga para diferentes áreas
    double calcular(double radio) {
        return PI * radio * radio; // Área del círculo
    }

    double calcular(double base, double altura) {
        return base * altura; // Área del rectángulo
    }

    double calcularTriangulo(double base, double altura) {
        return (base * altura) / 2; // Área del triángulo
    }
}

// Clase hija Circulo
class Circulo extends CalcularArea {
    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    double calcular() {
        return PI * radio * radio;
    }
}

// Clase hija Triangulo
class Triangulo extends CalcularArea {
    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    double calcular() {
        return (base * altura) / 2;
    }
}

// Clase hija Rectangulo
class Rectangulo extends CalcularArea {
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    double calcular() {
        return base * altura;
    }
}

