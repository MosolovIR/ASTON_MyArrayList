import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyArrayListTest {
    @Test
    void testAdd() {
        //Given:
        MyArrayList<Integer> list = new MyArrayList<>();

        //When:
        list.add(5);

        //Then:
        assertEquals(5, list.get(0));
    }

    @Test
    void testGetSize() {
        //Given:
        MyArrayList<Integer> list = new MyArrayList<>();

        //When:
        list.add(5);

        //Then:
        assertEquals(1, list.getSize());
    }

    @Test
    void testGet() {
        //Given:
        MyArrayList<Integer> list = new MyArrayList<>();

        //When:
        list.add(5);
        list.add(15);
        list.add(1);
        list.add(8);

        //Then:
        assertEquals(8, list.get(3));
    }

    @Test
    void testSet() {
        //Given:
        MyArrayList<Integer> list = new MyArrayList<>();

        //When:
        list.add(5);
        list.add(15);
        list.add(1);
        list.add(8);
        list.set(3, 888);

        //Then:
        assertEquals(888, list.get(3));
    }

    @Test
    void testResize() {
        //Given:
        MyArrayList<Integer> list = new MyArrayList<>();

        //When:
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.getCapacity(); // размер 10 по умолчанию
        list.add(11);
        list.getCapacity(); // 10 * 1,5 + 1

        //Then:
        assertEquals(16, list.getCapacity());

    }

    @Test
    void testRemove() {
        //Given:
        MyArrayList<Integer> list = new MyArrayList<>();

        //When:
        list.add(5);
        list.add(15);
        list.add(1);
        list.add(8);
        list.remove(0);

        //Then:
        assertEquals(15, list.get(0));
    }
}
