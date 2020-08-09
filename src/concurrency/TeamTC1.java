package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TeamTC1 implements Runnable{
    String[] names = {"Aaron", "Caleb", "Cody", "Gotham", "John", "Justin", "Kevin", "Korey", "Mark", "Matthew", "Sarah", "Tyler", "Zach"};
    String[] colors = {ConsoleColors.WHITE, ConsoleColors.RED, ConsoleColors.BLUE, ConsoleColors.GREEN};

    List<String> team = new ArrayList<>();

    //This thread should be created by implementing the Runnable interface, NOT by extending the Thread class.  In the run method of this thread, print out the name of each student in your TA group, (starting with your TA).  There should be a pause of 1 second before each name is printed to the console.The name should then be pushed to the team List  After all the names have been pushed to this List, print out the entire list of all the students in your TA group. Don't forget your TA as well!  All of these steps should be done whenever the thread is started.  (i.e. it can be done directly in the run()method of the thread itself).  Kick off the thread in the Main class of the concurrency package. 
    
    @Override public void run(){
        int j = 0;
        for(int i = 0; i < names.length; i++) {
            if (j >= 4){
                j = j - 4;
            }
            

            System.out.println(colors[j] + names[i]);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            team.add(names[i]);
            j++;
        }
        
        System.out.println(ConsoleColors.RESET + Arrays.toString(team.toArray()).replace("[", "").replace("]", ""));
    }
}

class ConsoleColors{
    public static final String RESET = "\033[0m";
    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String PURPLE_BOLD = "\033[1;35m";
}