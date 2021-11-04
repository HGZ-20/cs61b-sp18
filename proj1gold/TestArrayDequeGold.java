import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> result = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> good = new ArrayDequeSolution<>();
        String message = "";


        for (int i = 0; i < 10; i++) {

            double seed = StdRandom.uniform();
            if (seed < 0.5) {
                result.addFirst(i);
                good.addFirst(i);
                message += "addFist("+ i + ")\n";
            } else {
                result.addLast(i);
                good.addLast(i);
                message += "addLast("+ i + ")\n";
            }

            if (result.size() != 0 && seed <0.1) {
                result.removeFirst();
                good.removeFirst();
                message += "removeFirst(" + ")\n";
            }

            if (result.size() != 0 && seed >0.9) {
                result.removeLast();
                good.removeLast();
                message += "removeLast(" + ")\n";
            }
        }

        while (result.size() > 5) {
            result.removeLast();
        }

        ArrayDequeSolution<Integer> resultA = new ArrayDequeSolution<>();
        for (int i = 0; i < result.size(); i++) {
            resultA.addLast(result.removeFirst());
        }

        while (good.size() > 5) {
            good.removeLast();
        }

        assertEquals(message, good, resultA);
    }
}
