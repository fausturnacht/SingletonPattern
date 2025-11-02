import java.util.Queue;
import java.util.Scanner;

public class HelpDesk {
    private final int queueId;
    private final QueueSystem queueSystem;

    HelpDesk(int queueId){
        this.queueId = queueId;
        queueSystem = QueueSystem.getInstance();
    }

    public void announce(){
        System.out.println("[ANNOUNCE] Calling up no. " + queueSystem.getQueue(queueId).poll()  + " on Help Desk #" + queueId + ".");
    }
    public void add(int n){
        queueSystem.getQueue(queueId).add(n);
        System.out.println("[QUEUED] Successfully queued no. " + n + " on Help Desk #" + queueId + ".");
    }
    public void remove(int n){
        queueSystem.getQueue(queueId).remove(n);
        System.out.println("[REMOVED] Successfully removed no. " + n  + " from Help Desk #" + queueId + ".");
    }
    public void print(){
        Queue<Integer> temp = queueSystem.getQueue(queueId);
        System.out.println("[PRINT] Queue of Help Desk #" + queueId + " currently consists of the following:");

        while(!temp.isEmpty()){
            System.out.print(temp.poll());
            if (!temp.isEmpty()){
                System.out.print(", ");
            }
            else{
                System.out.println();
            }
        }
    }
    public void clear(){
        while(!queueSystem.getQueue(queueId).isEmpty()){
            System.out.println(queueSystem.getQueue(queueId).poll());
        }
        System.out.println("[CLEAR] Successfully cleared queue #" + queueId + ".");
    }

    public void reset(){
        Scanner scanner = new Scanner(System.in);

        print();
        System.out.print("[RESET] Please enter a new queue separated by spaces: ");
        String input = scanner.nextLine();
        String[] inputSplit = input.split("\\s+");
        int[] inputArray = new int[inputSplit.length];

        for (int i = 0; i < inputSplit.length; i++) {
            try{
                inputArray[i] = Integer.parseInt(inputSplit[i]);
            }
            catch (NumberFormatException e){
                System.out.println("Invalid input: "+ inputSplit[i]+". Please try again.");
                return;
            }
        }

        clear();
        for (int j : inputArray) {
            add(j);
        }
    }
}


