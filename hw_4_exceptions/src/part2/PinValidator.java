package part2;

import java.util.Scanner;

public class PinValidator {
    private int pin;

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void tryGetIn() {

        for (int i = 0; i < 3; i++) {
            try {
                Scanner scan = new Scanner(System.in);
                int pas = scan.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

}
