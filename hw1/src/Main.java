public class Main {

    public static int[] bubbleSort(int[] array) {

        int length = array.length;
        for (int i = 0; i < length - 2; i++) {
            for (int j = 0; j < length - i - 2; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }

        return array;
    }

    public static float toFahrenheitConverter(float degrees) {
        return (degrees * 9) / 5 + 32;
    }

    public static void main(String[] args) {
        int[] ar = {0, 2, -1, 6, 4, 7, -4, 1};

        int[] sorted = bubbleSort(ar);

        for (int elem: sorted) {
            System.out.printf("%d ", elem);
        }
        System.out.println();

        float degrees = 25;
        System.out.printf("%5.2f celsius degrees -> %5.2f fahrenheit degrees\n", degrees, toFahrenheitConverter(degrees));
    }
}
