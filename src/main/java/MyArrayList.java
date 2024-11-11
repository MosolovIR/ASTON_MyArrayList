/**
 * MyArrayList - Класс, представляющий реализацию динамического массива, аналогичного стандартному ArrayList.
 * Поддерживает основные операции добавления, удаления, получения и изменения элементов.
 * @param <T> Тип данных, которые будут храниться в списке.
 */
public class MyArrayList<T> {
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private T[] elements;

    /**
     * Конструктор, который инициализирует массив с размером 10 элементов (по умолчанию)
     */
    public MyArrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Метод, который добавляет элемент в конец списка (при необходимости увеличивает размер массива).
     * @param element элемент для добавления в список.
     */
    public void add(T element) {
        if (size == elements.length) {
            resize(element);
        }

        elements[size++] = element;
    }

    /**
     * Метод, который возвращает размер массива.
     * @return Размер массива.
     */
    public int getSize() {
        return elements.length;
    }

    /**
     * Метод, который возвращает элемент под указанным индексом.
     * @param index индекс искомого элемента.
     * @throws IndexOutOfBoundsException Если индекс вне допустимого диапазона.
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        } else {
            return elements[index];
        }
    }

    /**
     * Метод, который заменяет элемент по заданному индексу новым элементом.
     * @param index индекс по которому необходимо заменить элемент.
     * @param element новый элемент для замены.
     * @throws IndexOutOfBoundsException Если индекс вне допустимого диапазона.
     */
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        } else {
            elements[index] = element;
        }
    }

    /**
     * Метод, который увеличивает размер массива для поддержки большего количества элементов.
     * @param element массив, размер которого будет увеличен.
     */
    public void resize(T element) {
        int newCapacity = (int) (elements.length * 1.5 + 1);
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }

    /**
     * Метод, который удаляет элемент по заданному индексу из списка, смещая оставшиеся элементы.
     * @param index индекс элемента для удаления.
     * @throws IndexOutOfBoundsException Если индекс не соответствует размеру списка.
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        } else {
            T[] arrayWithoutElement = (T[]) new Object[DEFAULT_CAPACITY];
            T removedElement = elements[index];

            if (index == 0) {
                System.arraycopy(elements, 1, arrayWithoutElement, 0, size - 1);
                arrayWithoutElement[size - 1] = null;
            } else if (index == size - 1) {
                elements[index] = null;
            } else {
                System.arraycopy(elements, 0, arrayWithoutElement, 0, size - index - 1);
                System.arraycopy(elements, index + 1, arrayWithoutElement, index, size - index - 1);
                arrayWithoutElement[size - 1] = null;
            }

            System.out.println("Element: " + removedElement + " with index: " + index + " was removed from the array");
        }
    }
}
