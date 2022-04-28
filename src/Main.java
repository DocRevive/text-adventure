import java.util.Scanner;

/**
 * A text adventure game directly in a terminal.
 * This class provides the view for the game.
 *
 * @author Daniel Kim
 * @version 4-27-22
 */
public class Main {

    private static final String resourceFile = "/story.yaml";

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        TextAdventureController controller =
                new TextAdventureController(resourceFile);

        System.out.println(controller.getOutput());
        while (!controller.hasEnded()) {
            controller.input(input.nextLine());
            System.out.println(controller.getOutput());
        }
    }
}
