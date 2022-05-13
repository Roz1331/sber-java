public class MyMultithreading implements Runnable{

    private int num;

    MyMultithreading(int num) {
        this.num = num;
    }

    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName() + " id = " + Thread.currentThread().getId());
        System.out.printf("fact of %d is %d\n", num, getFact(num));
    }

    private int getFact(int x) {
        int res = 1;

        for (int i = 1; i <= x; i++) {
            res *= i;
        }

        return res;
    }
}
