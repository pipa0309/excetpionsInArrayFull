//for check
package exceptionsTraningTwo;

public class WorkClass {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        int sizeY = 4;
        int sizeX = 4;
        String[][] arrStr = createArr();
        int[][] arrInt = checkSizeStrArrAndConvertedToIntArr(sizeY, sizeX, arrStr);
        printArr(arrInt);
        System.out.println("\nSumma elements = " + sumElementsOfArr(arrInt));
    }

    private static String[][] createArr() {
        return new String[][]{
                {"1", "2", "3", "4"},
                {"5", "8", "7", "8"},
                {"9", "1", "2", "3"},
                {"4", "5", "6", "7"}
        };
    }

    private static int[][] checkSizeStrArrAndConvertedToIntArr(int sizeY, int sizeX, String[][] arrStr) throws MyArraySizeException, MyArrayDataException {
        int[][] arrInt = new int[sizeY][sizeX];
        for (int i = 0; i < arrStr.length; i++) {
            for (int j = 0; j < arrStr[i].length; j++) {
                if ((arrStr[i].length != sizeY) || (arrStr.length != sizeX)) {
                    throw new MyArraySizeException("Size array don't 4 x 4!");
                }
                try {
                    arrInt[i][j] = Integer.parseInt(arrStr[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException("\nIllegal format data in array.\nIndex incorrect cell = " + i + " " + j);
                }
            }
        }
        return arrInt;
    }

    private static void printArr(int[][] arrInt) {
        for (int[] ints : arrInt) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int sumElementsOfArr(int[][] arrInt) {
        int sum = 0;
        for (int[] ints : arrInt) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        return sum;
    }
}

















/*
1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
подаче массива другого размера необходимо бросить исключение MyArraySizeException.

2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

3 В методе main() вызвать полученный метод, обработать возможные исключения
MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов,
при условии что подали на вход корректный массив).
 */
