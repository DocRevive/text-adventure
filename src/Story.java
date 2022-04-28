import java.util.Map;

/**
 * Represents a loaded story. This custom class allows for
 * easy traversal through the YAML data.
 *
 * @author Daniel Kim
 * @version 4-27-22
 */
public class Story {
    private Map<String, Situation> situations;
    private String intro;
    private String first;

    /**
     * Returns a Situation with information about a certain
     * situation.
     *
     * @param  key  unique situation key
     * @return      Situation object
     */
    public Situation getSituation(String key)
    {
        return situations.get(key);
    }

    /**
     * Gets the introduction of the story.
     *
     * @return first monologue player sees
     */
    public String getIntro()
    {
        return intro;
    }

    /**
     * Returns the key of the first situation.
     *
     * @return first situation that should appear
     */
    public String getFirst()
    {
        return first;
    }

    /**
     * Sets the Map of situations, each unique situation
     * key mapping to its situation.
     *
     * @param  situations  key:Situation Map
     */
    public void setSituations(Map<String, Situation> situations)
    {
        this.situations = situations;
    }

    /**
     * Sets the introduction of the story.
     *
     * @param  intro  first monologue player sees
     */
    public void setIntro(String intro)
    {
        this.intro = intro;
    }

    /**
     * Sets the first situation of the story.
     *
     * @param  first  first situation
     */
    public void setFirst(String first)
    {
        this.first = first;
    }
}
