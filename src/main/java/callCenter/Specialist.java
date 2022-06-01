package callCenter;

import log.Log;

public class Specialist extends Thread {
    private final static int CALL_HANDLING_TIME = 3500;
    private static final Log log = new Log();
    private final CallBase callBase;

    public Specialist(CallBase callBase) {
        this.callBase = callBase;
    }

    @Override
    public void run() {
        Call call = callBase.takeCall();
        Thread currThread = Thread.currentThread();
        String currSubscriber = call.getSubscriber();
        log.log("Оператор " + currThread + " принял звонок от " + currSubscriber);
        try {
            Thread.sleep(CALL_HANDLING_TIME);
        } catch (InterruptedException ignore) {
        }
        log.log("Оператор " + currThread + " завершил звонок c " + currSubscriber);
    }
}
