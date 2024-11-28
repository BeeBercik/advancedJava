import java.util.function.Consumer;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
//        App.getSomethingAndSetSomething();
//        App.getSomebodyAndSetSomebody();  NIE MA SENSU POWIELAC KODU DLA ROZNYCH KOMBINACJI

//        CYKLE/MOZLIWOSCI WYWOLANIA
//        App.getAndSet(new Supplier<>() {
//            @Override
//            public Integer get() {
//                return App.getSomething();
//            }
//        }, new Consumer<>() {
//            @Override
//            public void accept(Integer i) {
//                App.setSomething(i);
//            }
//        });
//        App.getAndSet(() -> App.getSomething(), i -> App.setSomething(i));
        App.getAndSet(App::getSomething, App::setSomething);
        App.getAndSet(App::getSomebody, App::setSOmebody);
    }

//    public static void getSomethingAndSetSomething() {
//        App.setSomething(App.getSomething());
//    }
//
//    public static void getSomebodyAndSetSomebody() {
//        App.setSOmebody(App.getSomebody());
//    }

//    Zamiast metod dla roznych operacji zrobic JEDNA uniwersalan
    public static void getAndSet(Supplier<Integer> getter, Consumer<Integer> setter) {
        setter.accept(getter.get());
    }

    public static int getSomething() {
        return 10;
    }

    public static int getSomebody() {
        return 69;
    }

    public static void setSomething(int x) {
        System.out.println("Ustawiam something na " + x);
    }

    public static void setSOmebody(int x) {
        System.out.println("Ustawiam somebody na " + x);
    }
}
