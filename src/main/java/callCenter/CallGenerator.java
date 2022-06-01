package callCenter;

import log.Log;

public class CallGenerator extends Thread {
    private static final int WAITING_TINE = 5000;
    private static final int CALLS_LIMITED_COUNT = 100;
    private static final Log log = new Log();
    private final CallBase callBase;

    public CallGenerator(CallBase callBase) {
        this.callBase = callBase;
    }

    @Override
    public void run() {
        for (int subscriberNum = 1; subscriberNum <= CALLS_LIMITED_COUNT; subscriberNum++) {
            String subscriber = "Абонент" + subscriberNum;
            callBase.addCall(new Call(subscriber));
            log.log("Добавлен " + subscriber);
            if (subscriberNum % 10 == 0) {
                try {
                    Thread.sleep(WAITING_TINE);
                } catch (InterruptedException ignore) {
                }
            }
        }
    }
}
