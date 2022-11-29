import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main
{
    static ArrayList<String> myArrList = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        boolean done = false;
        boolean quitList= false;
        String cmd;
        String userInput;
        int deleteNum;
        do
        {

            cmd = SafeInput.getRegExString(in, "\nA - Add\nD - Delete\nP - Print\nQ - Quit\n","[AaDdPpQq]");
            cmd = cmd.toUpperCase(Locale.ROOT);

            switch (cmd)
            {
                case "A":
                    userInput = SafeInput.getNonZeroLenString(in, "Enter item to add to the list");
                    myArrList.add(userInput);
                    System.out.println("\nSuccessfully added \"" + userInput + "\" to the list...");
                    break;
                case "D":
                    if (myArrList.size() > 0)
                    {
                        deleteNum = SafeInput.getRangedInt(in, "Enter the item you wish to delete: ", 1, myArrList.size());
                        deleteNum = deleteNum - 1;
                        System.out.println("\nSuccessfully deleted \"" + myArrList.get(deleteNum) + "\" from the list...");
                        myArrList.remove(deleteNum);
                    }
                    else
                    {
                        System.out.println("\nThere is nothing to delete...");
                    }
                    break;
                case "P":
                    System.out.println();
                    displayList();
                    break;
                case "Q":
                    //Add confirmation loop ("Are you sure?")
                    quitList = SafeInput.getYNConfirm(in, "\nAre you sure you want to quit?");
                    if (quitList)
                    {
                        System.out.println("Quitting...");
                        System.exit(0);
                    }
                    break;
            }
        }while(!done);
    }
    private static void displayList()
    {
        int counter = 0;
        if (myArrList.size() == 0)
        {
            System.out.println("\nThe list is currently empty...");
        }
        else
        {
            for (String l : myArrList)
            {
                counter++;
                System.out.println(counter + ". " + l);
            }
        }
    }
}