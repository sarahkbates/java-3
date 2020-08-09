package concurrency;

public class Main {
   
    public static void main(String[] args) {
         //run all of your threads from this main class.
         Reasoning reasoning = new Reasoning();
         reasoning.start();

         TeamTC1 teamTC1 = new TeamTC1();
         Thread codeConnoisseurs = new Thread(teamTC1);
         codeConnoisseurs.setName("Code Connoisseurs");
         codeConnoisseurs.start();
    }
}