import java.util.LinkedList;
import java.util.Queue;

public final class QueueSystem {
    private static QueueSystem queueSystem;
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    private Queue<Integer> queue3 = new LinkedList<>();

    private QueueSystem(){
    }

    public static synchronized QueueSystem getInstance(){
        if(queueSystem == null){
            queueSystem = new QueueSystem();
        }
        return queueSystem;
    }

    public Queue<Integer> getQueue(int queueId){
        return switch(queueId){
            case 1 -> queue1;
            case 2 -> queue2;
            case 3 -> queue3;
            default ->
                throw new IllegalArgumentException("Invalid queue ID: " + queueId);
        };
    }
}
