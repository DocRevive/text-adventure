import java.util.Set;

/**
 * Provides a controller linking the view and the
 * model.
 *
 * @author Daniel Kim
 * @version 4-27-22
 */
public class TextAdventureController {
    private final Story story;
    private String output;
    private String situationKey;
    private Situation currentSituation;
    private boolean hasEnded = false;

    /**
     * Constructor for a controller object.
     *
     * @param  resourceFile  path to YAML file in resources
     */
    public TextAdventureController(String resourceFile)
    {
        TextAdventureModel model = new TextAdventureModel(resourceFile);
        story = model.getStory();
        situationKey = story.getFirst();
        currentSituation = story.getSituation(situationKey);
        output = story.getIntro() + "\n\n" + currentSituation;

        if (currentSituation.isEndpoint()) hasEnded = true;
    }

    /**
     * Returns the most recently generated output.
     *
     * @return game message
     */
    public String getOutput()
    {
        return output;
    }

    /**
     * Returns whether the game has ended (no more options
     * are available).
     *
     * @return whether the game has ended
     */
    public boolean hasEnded()
    {
        return hasEnded;
    }

    /**
     * Receives and validates input from the view, then it may
     * interact with the model and update states accordingly.
     *
     * @param  input  String input from user
     */
    public void input(String input)
    {
        int option;

        try {
            option = Integer.parseInt(input, 10);
            int limit = currentSituation.getOptions().size();

            if (option < 1 || option > limit) throw new Exception();
        } catch (final Exception e) {
            output = "Please enter a valid number option.\n\n" + output;
            return;
        }

        Set<String> keySet = currentSituation.getOptions().keySet();
        situationKey = currentSituation.getOptions()
                .get(keySet.toArray(new String[0])[option - 1]);
        /*
         * Turn the keys of the LinkedHashMap options into an array,
         * get the option at the index of that, use the key to find
         * the key of the new situation.
         */

        currentSituation = story.getSituation(situationKey);
        output = currentSituation.toString();

        if (currentSituation.isEndpoint()) hasEnded = true;
    }
}
