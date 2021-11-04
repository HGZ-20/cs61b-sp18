import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> result = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> good = new ArrayDequeSolution<>();
        String message = "";


        for (int i = 0; i < 15; i++) {

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

            if (result.size() != 0 && seed <0.4) {
                Integer ans1 = result.removeFirst();
                Integer ans2 = good.removeFirst();
                message += "removeFirst(" + ")\n";
                if (ans1 != ans2) {
                    break;
                }
            }

            if (result.size() != 0 && seed >0.6) {
                Integer ans1 = result.removeLast();
                Integer ans2 = good.removeLast();
                message += "removeLast(" + ")\n";
                if (ans1 != ans2) {
                    break;
                }
            }
        }


        ArrayDequeSolution<Integer> resultA = new ArrayDequeSolution<>();
        for (int i = 0; i < result.size(); i++) {
            resultA.addLast(result.removeFirst());
        }

        assertEquals(message, good, resultA);
    }
}
