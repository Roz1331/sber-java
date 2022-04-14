package part2;

public class TerminalImpl implements Terminal {

    private final TerminalServer server;
    private final PinValidator pinValidator;
    public boolean isAuthorised = false;

    public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }

    public void authenticate() {
        pinValidator.tryGetIn();
    }

    @Override
    public int getCardState() {
        return server.getCount();
    }

    @Override
    public boolean takeMoney(int money) {
        int curCount = server.getCount();

        if (curCount >= money) {
            server.setCount(curCount - money);
            return true;
        }

        return false;
    }

    @Override
    public boolean putMoney(int money) {
        int curCount = server.getCount();
        server.setCount(curCount + money);
        return false;
    }
}
