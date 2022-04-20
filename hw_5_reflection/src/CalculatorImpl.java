public class CalculatorImpl implements Calculator{
    @Override
    public int calc(int number) {
        int res = 1;
        for (int i = 1; i <= number; i++) {
            res *= i;
        }
        return res;
    }
}
