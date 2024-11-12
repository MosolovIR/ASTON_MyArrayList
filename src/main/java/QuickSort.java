import java.util.Comparator;
/**
 * QuickSort - Класс для сортировки списка элементов типа MyArrayList с использованием алгоритма быстрой сортировки.
 */
public class QuickSort {
    /**
     * Метод, который выполняет быструю сортировку на переданном списке с использованием компаратора.
     * @param <T> Тип элементов в списке.
     * @param list Список, который нужно отсортировать.
     * @param comparator Компаратор для определения порядка элементов.
     */
    public static <T> void quickSort(MyArrayList<T> list, Comparator<? super T> comparator) {
        quickSort(list, 0, list.getSize() - 1, comparator);
    }

    /**
     * Метод, который выполняет быструю сортировку на переданном списке с использованием компаратора.
     * @param <T> Тип элементов в списке.
     * @param list Список, который нужно отсортировать.
     */
    public static <T extends Comparable> void quickSort(MyArrayList<T> list) {
        quickSort(list, 0, list.getSize() - 1, Comparable::compareTo);
    }

    /**
     * Рекурсивный метод быстрой сортировки для сортировки подмассивов.
     * @param list Список, который нужно отсортировать.
     * @param low Начальный индекс подмассива.
     * @param high Конечный индекс подмассива.
     * @param comparator Компаратор для определения порядка элементов.
     * @param <T> Тип элементов в списке.
     */
    private static <T> void quickSort(MyArrayList<T> list, int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, comparator);

            quickSort(list, low, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Метод, который выполняет разделение списка вокруг выбранного опорного элемента.
     * @param list Список, который нужно отсортировать.
     * @param low Начальный индекс подмассива.
     * @param high Конечный индекс подмассива.
     * @param comparator Компаратор для определения порядка элементов.
     * @param <T> Тип элементов в списке.
     * @return Индекс опорного элемента.
     */
    private static <T> int partition(MyArrayList<T> list, int low, int high, Comparator<? super T> comparator) {
        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) < 0) {
                i++;
                swapElements(list, i, j);
            }
        }
        swapElements(list, i + 1, high);

        return i + 1;
    }

    /**
     * Метод, который меняет местами два элемента в списке.
     * @param list Список, в котором происходит обмен.
     * @param i Индекс первого элемента.
     * @param j Индекс второго элемента.
     * @param <T> Тип элементов в списке.
     */
    private static <T> void swapElements(MyArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
