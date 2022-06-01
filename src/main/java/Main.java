import callCenter.CallBase;
import callCenter.CallGenerator;
import callCenter.Specialist;
import log.Log;

public class Main {
    private final static int TIME_FOR_FIRST_SUBSCRIBER = 3500;
    private final static int ANSWERING_TIME_ABOUT = 500;
    private final static int END_WORKDAY_WAITING = 500;
    private static CallBase callBase = new CallBase();
    private static Log log = new Log();

    public static void main(String[] args) throws InterruptedException {
        log.log("Колл-центр начал свою работу");
        Thread callGenerator = new CallGenerator(callBase);
        callGenerator.start();

        Thread.sleep(TIME_FOR_FIRST_SUBSCRIBER);

        while (callBase.getCalls().size() > 0) {
            new Specialist(callBase).start();
            Thread.sleep(ANSWERING_TIME_ABOUT);
        }

        Thread.sleep(END_WORKDAY_WAITING);
        log.log("Колл-центр завершил работу на сегодня");
    }
}
