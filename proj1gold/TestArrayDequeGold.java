import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TestArrayDequeGold {

    @Test
    public void testStudentArrayDequeRadomly() {
        for (int j = 0; j < 10; j++) {
            String errorMsg = "";
            StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < 10; i++) {
                double uniform1 = StdRandom.uniform();
                if (uniform1 > 0.75) {
                    sad1.addFirst(i);
                    list.add(i);
                    errorMsg += "addFirst(" + i + ")\n";
                } else if (uniform1 > 0.5) {
                    sad1.addLast(i);
                    list.add(i);
                    errorMsg += "addLast(" + i + ")\n";
                } else if (uniform1 > 0.25) {
                    Integer first = sad1.removeFirst();
                    errorMsg += "removeFirst(): " + first + "\n";
                    Integer remove = null;
                    if (list.size() > 0) {
                        remove = list.remove(0);
                    }
                    assertEquals(errorMsg, first, remove);
                } else {
                    Integer last = sad1.removeLast();
                    errorMsg += "removeLast(): " + last + "\n";
                    Integer remove = null;
                    if (list.size() > 0) {
                        remove = list.removeLast();
                    }
                    assertEquals(errorMsg, last, remove);
                }
            }
        }
    }

    @Test
    public void testArrayDequeSolutionRadomly() {
        for (int j = 0; j < 10; j++) {
            String errorMsg = "";
            ArrayDequeSolution<Integer> sad1 = new ArrayDequeSolution<>();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < 10; i++) {
                double uniform1 = StdRandom.uniform();
                if (uniform1 > 0.75) {
                    sad1.addFirst(i);
                    list.add(i);
                    errorMsg += "addFirst(" + i + ")\n";
                } else if (uniform1 > 0.5) {
                    sad1.addLast(i);
                    list.add(i);
                    errorMsg += "addLast(" + i + ")\n";
                } else if (uniform1 > 0.25) {
                    Integer first = sad1.removeFirst();
                    errorMsg += "removeFirst(): " + first + "\n";
                    Integer remove = null;
                    if (list.size() > 0) {
                        remove = list.remove(0);
                    }
                    assertEquals(errorMsg, first, remove);
                } else {
                    Integer last = sad1.removeLast();
                    errorMsg += "removeLast(): " + last + "\n";
                    Integer remove = null;
                    if (list.size() > 0) {
                        remove = list.removeLast();
                    }
                    assertEquals(errorMsg, last, remove);
                }
            }
        }
    }

}
