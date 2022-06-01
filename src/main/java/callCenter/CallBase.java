package callCenter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CallBase {
    private final Queue<Call> calls = new ConcurrentLinkedQueue<>();

    public void addCall(Call call) {
        calls.offer(call);
    }

    public Call takeCall() {
        return calls.poll();
    }

    public Queue<Call> getCalls() {
        return calls;
    }
}
