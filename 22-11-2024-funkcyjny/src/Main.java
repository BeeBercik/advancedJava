import java.util.function.*;

// Najpierw tworzymy klasy anonimowe, czyli w 'locie': tworzymy obiekty klas anonimowych o typie interfejsu ktore domyslnie beda implementowac, a ze to anonimowa klasa to od razu podajemy cialo (w tym przypadku implementacje metody z interfejsu)

public class Main {
    public static void main(String[] args) {
//        FUNKCJA
        Function<Integer, Integer> func = new Function<>() {
            @Override
            public Integer apply(Integer i) {
                return i * 2;
            }
        }; // moga byc te same typy ale w takim przypadku lepiej unaryOperator
        System.out.println(func.apply(5));

//        zamiast tego moge lambda (bo impl. ten obiekt klasy anonimoej interfejs funkcyjny
//        lmabda za nas pod spodem tworzy tak samo obiekt klasy anonimowej, dlateog my piszac ja skupiamy sie na implementacji metody tego interfejsu (ktory ts klasa implementuje)
        Function<Integer, Integer> funcL = i -> i * 2;
        System.out.println(funcL.apply(5));

//        UNARY-OPERATOR
        UnaryOperator<String> unary = new UnaryOperator<>() {
            @Override
            public String apply(String s) {
                return "Witaj " + s;
            }
        };
        System.out.println(unary.apply("Robert"));

        UnaryOperator<String> unaryL = s -> "Witaj " + s;
        System.out.println(unaryL.apply("Robert"));

//        BI-FUNKCJA
        BiFunction<Integer, Double, String> biFunc = new BiFunction<>() {
            @Override
            public String apply(Integer i, Double d) {
                return i * d + "";
            }
        };
        System.out.println(biFunc.apply(5, 2.4));
    BiFunction<Integer, Double, String> biFuncL = (i, d) -> i * d + "";
    System.out.println(biFuncL.apply(5, 2.4));

//        PREDICAT
        Predicate<String> predicate = new Predicate<>() {
            @Override
            public boolean test(String s) {
                return s.length() > 5;
            }
        };
        System.out.println(predicate.test("Robert"));
        Predicate<String> predicateL = s -> s.length() > 5;
        System.out.println(predicateL.test("Robert"));

//        CONSUMER
        Consumer<Integer> consumer = new Consumer<>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("Liczba: " + integer);
            }
        };
        consumer.accept(5);

        Consumer<Integer> consumerL = i -> System.out.println("Liczba: " + i);
        consumerL.accept(5);

//        SUPPLIER
        Supplier<String> supplier = new Supplier<>() {
            @Override
            public String get() {
                return "Tu kurier - mam paczke";
            }
        };
        System.out.println(supplier.get());

        Supplier<String> supplierL = () -> "Tu kurier - mam paczke";
        System.out.println(supplierL.get());

//        MOJ INTERFACE TRIFUNCTION
        TriFunction<Integer, Double, Integer, String> triFuncL = (i1, d, i2) -> i1 * d * i2 + "";
        System.out.println(triFuncL.apply(2, 3.5, 1));

//        OPERATOR :: REFERENCJA DO FUNKCJI
        Function<String, Integer> funcRef1 = s -> s.length();
        Function<String, Integer> funcRef2 = String::length;
    }
}