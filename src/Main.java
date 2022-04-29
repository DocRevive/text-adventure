import java.util.Scanner;

/**
 * A text adventure game directly in a terminal.
 * This class provides the view for the game.
 *
 * @author Daniel Kim
 * @version 4-27-22
 */
public class Main {

    private static final String resourceFile = "/example.yaml";

    public static void main(String[] args)
    {
        // Initialize scanner and controller
        Scanner input = new Scanner(System.in);
        TextAdventureController controller =
                new TextAdventureController(resourceFile);

        // Print initial message (intro and first situation)
        System.out.println(controller.getOutput());

        while (!controller.hasEnded()) {
            // Pass user input into controller
            controller.input(input.nextLine());
            // Get output and print
            System.out.println(controller.getOutput());
        }

        input.close();
    }
}
