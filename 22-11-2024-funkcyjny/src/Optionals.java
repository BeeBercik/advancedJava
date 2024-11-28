import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

// Chce znalezc jedynke w liscie

public class Optionals {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 12, 23, 6, 7, 3, 10, 13, 8, 25);

        if(findOne(integers).isPresent()) System.out.println("Success");
        else if(findOne(integers).isEmpty()) System.out.println("Failed");

        Stream<Integer> stream = integers.stream();
        Optional<Integer> optOne = stream.filter(i -> i == 1).findFirst();
        if(optOne.isPresent()) System.out.println(optOne.get());
        else System.out.println(optOne);
    }

    public static Optional<Integer> findOne(List<Integer> list) {
        for(Integer i : list) {
            if(i == 1) return Optional.of(i);
        }

        return Optional.empty();
    }
}
