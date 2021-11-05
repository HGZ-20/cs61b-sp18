package synthesizer;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
//        arb.peek();
//        arb.dequeue();
        for (int i = 0; i < 50; i++) {
            double seed = StdRandom.uniform();
            if (seed < 0.5) {
                if (!arb.isFull()) {
                    arb.enqueue(i);
                }
            } else if (seed < 0.6) {
                if (!arb.isEmpty()) {
                    arb.dequeue();
                }
            } else {
                if (!arb.isEmpty()) {
                    System.out.println(arb.peek());
                }
            }
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
