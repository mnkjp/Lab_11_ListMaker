import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        String command ;
        do {
            command = displayMenu();
            switch (command.toUpperCase()) {
                case "A":
                    add(scanner);
                    break;

                case "D":
                    deleteItem();
                    break;

                case "I":
                    insertItem();
                    break;

                case "P":
                    printList();
                    break;

                case "Q":
                    if (confirmQuit()) {
                        System.out.println("Exiting program...");
                    }
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        } while (!command.equalsIgnoreCase("Q"));

    }

    private static String displayMenu() {
        System.out.println("Menu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print (display) the list");
        System.out.println("Q - Quit the program");
        System.out.print("Enter your command: ");
        return scanner.nextLine();
    }
    public static String add(Scanner pipe){
        String retVal = "";
        boolean done = false;
        do {
            System.out.println(" Enter the item to add");
            retVal = pipe.nextLine();
            list.add(retVal);
            System.out.println(":" + retVal + "has been added to the list");
            done = true;
        }while (!done);
        return retVal;
    }


    private static void deleteItem() {
        printList();
        int index = SafeInput.getRangedInt(scanner,"Enter the index of the item to delete (0 - " + (list.size() - 1) + "): ", 0, list.size() - 1);
        String removedItem = list.remove(index);
        System.out.println("Item deleted: " + removedItem);
    }

    private static void insertItem() {
        printList();
        int index = SafeInput.getRangedInt(scanner,"Enter the index to insert the item at (0 - " + (list.size()) + "): ", 0, list.size());
        String item = SafeInput.getString("Enter the item to insert: ");
        scanner.nextLine();
        list.add(index, item);
        System.out.println("Item inserted at index " + index + ": " + item);
    }

    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("The list is currently empty.");
        } else {
            System.out.println("Current List:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i  + ": " + list.get(i));
            }
        }
    }

    private static boolean confirmQuit() {
        boolean done = SafeInput.getYNConfirm(scanner, "Are you finished? ");

        return done;
    }
}
