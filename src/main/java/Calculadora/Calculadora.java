package Calculadora;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Calculadora {

    static IntBinaryOperator Suma= (a, b) -> a + b;

    static IntBinaryOperator Resta= (a, b)-> a - b;

    static IntBinaryOperator Multiplicacion= (a, b)->{
        return IntStream.range(0, Math.abs(b) + 1)
                .reduce((acumulado, number) -> Suma.applyAsInt(acumulado, a))
                .getAsInt();
    };



    static BiFunction<Integer,Integer,Integer> division = (numero, denominador) ->{
        return IntStream.range(0, denominador + 1)
                .reduce((acumulador, num) -> {
                    if (Multiplicacion.applyAsInt(num, denominador) <= numero) {
                        return acumulador = acumulador + 1;
                    }
                    return acumulador;
                }).getAsInt();
    };


    public static void main(String[] args) {

        System.out.println("Suma: " + Suma.applyAsInt(3,5));
        System.out.println("Resta: " + Resta.applyAsInt(5,2));
        System.out.println("Multiplicación: " + Multiplicacion.applyAsInt(2, 6));
        System.out.println("División: " + division.apply(20,5));

    }

}
