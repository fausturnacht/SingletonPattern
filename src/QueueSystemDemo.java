public class QueueSystemDemo {
    public static void main(String[] args){

        //The queue system is applied through Singleton Pattern on clas QueueSystem.
        QueueSystem queueSystem = QueueSystem.getInstance();

        //Each helpdesk has its own queue with the same functions.
        //This can be refactored into using a command pattern.
        HelpDesk helpDesk1 = new HelpDesk(1);
        HelpDesk helpDesk2 = new HelpDesk(2);
        HelpDesk helpDesk3 = new HelpDesk(3);

        //for standard queueing purposes
        for (int i = 1; i < 10; i++) {
            helpDesk1.add(i);
        }

        helpDesk1.add(15); //adding custom entries to queue
        helpDesk1.remove(6); //removing queue entries
        helpDesk1.reset(); //for rearranging and customizing the queue entirely

        //displays next in queue and removes it
        helpDesk1.announce();
        helpDesk1.announce();
        helpDesk1.announce();

        helpDesk1.clear(); //remove queue
    }
}
