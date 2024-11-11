import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {
    @Test
    void testQuickSort() {
        //Given:
        MyArrayList<Integer> listOfInteger = new MyArrayList<>();
        listOfInteger.add(28);
        listOfInteger.add(-15);
        listOfInteger.add(77);
        listOfInteger.add(2);
        listOfInteger.add(17);

        //When:
        QuickSort.quickSort(listOfInteger,Integer::compareTo);

        //Then:
        assertEquals(-15, listOfInteger.get(0));
        assertEquals(2, listOfInteger.get(1));
        assertEquals(17, listOfInteger.get(2));
        assertEquals(28, listOfInteger.get(3));
        assertEquals(77, listOfInteger.get(4));

        //Given:
        MyArrayList<Character> listOfCharacter = new MyArrayList<>();
        listOfCharacter.add('A');
        listOfCharacter.add('S');
        listOfCharacter.add('T');
        listOfCharacter.add('O');
        listOfCharacter.add('N');

        //When:
        QuickSort.quickSort(listOfCharacter,Character::compareTo);

        //Then:
        assertEquals('A', listOfCharacter.get(0));
        assertEquals('N', listOfCharacter.get(1));
        assertEquals('O', listOfCharacter.get(2));
        assertEquals('S', listOfCharacter.get(3));
        assertEquals('T', listOfCharacter.get(4));
    }
}