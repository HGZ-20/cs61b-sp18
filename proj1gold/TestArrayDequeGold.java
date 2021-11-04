import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> result = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> good = new ArrayDequeSolution<>();
        String message = "";


        for (int i = 0; i < 20; i++) {

            double seed = StdRandom.uniform();
            if (seed < 0.4) {
                result.addFirst(i);
                good.addFirst(i);
                message += "addFist("+ i + ")\n";
            } else if (seed < 0.7){
                result.addLast(i);
                good.addLast(i);
                message += "addLast("+ i + ")\n";
            } else {
                assertEquals(message + "size()", good.size(), result.size());
                if (result.size() != 0 && seed <0.8) {
                    message += "removeFirst(" + ")\n";
                    assertEquals(message, good.removeFirst(), result.removeFirst());
                }
                assertEquals(message + "size()", good.size(), result.size());
                if (result.size() != 0 && seed >0.8) {
                    message += "removeLast(" + ")\n";
                    assertEquals(message, good.removeLast(), result.removeLast());
                }
            }
        }
    }
}
