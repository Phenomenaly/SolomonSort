import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> Array = List.of(30, 55, 21, 17, 82, 46, 79, 63, 94, 108);
        List<Integer> sortedArray = solomonSort(Array);

        System.out.println(sortedArray);
    }

    public static List<Integer> solomonSort(List<Integer> array) {
        // Находим минимальное и максимальное значения в списке
        int min = array.get(0), max = array.get(0);
        for (int el : array) {
            if (el > max) max = el;
            if (el < min) min = el;
        }

        int n = array.size() - 1;
        int delta = (max - min) / n;

        // Создаем массив списков для хранения элементов
        List<Integer>[] newArray = new List[n + 1];
        for (int i = 0; i < n + 1; i++)
            newArray[i] = new ArrayList<>();

        // Распределяем элементы по спискам в массиве
        for (int i = 0; i < n + 1; i++) {
            int newIndex = (array.get(i) - min) / delta;

            newArray[newIndex].add(array.get(i));
        }

        // Сортируем элементы в результирующий список
        List<Integer> sortedArray = new ArrayList<>();
        for (List<Integer> list : newArray) {
            if (!list.isEmpty()) {
                while (!list.isEmpty()) {
                    int minValue = list.get(0);
                    for (int el : list) if (el < minValue) minValue = el;

                    list.remove((Integer) minValue);
                    sortedArray.add(minValue);
                }
            }
        }

        return sortedArray;
    }
}