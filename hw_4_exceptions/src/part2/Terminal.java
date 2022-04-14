package part2;

public interface Terminal {

    // получение состояние счета
    int getCardState();

    // снять деньги со счета
    boolean takeMoney(int x);

    // положить деньги на счет
    boolean putMoney(int x);

}
