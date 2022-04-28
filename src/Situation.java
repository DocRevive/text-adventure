import java.util.LinkedHashMap;

/**
 * Represents individual situations. This custom class
 * allows for easy traversal through the YAML data.
 *
 * @author Daniel Kim
 * @version 4-27-22
 */
public class Situation {
    private String description;
    private LinkedHashMap<String, String> options;

    /**
     * Returns the text representation of this situation
     * including its description and options.
     *
     * @return text representation
     */
    public String toString()
    {
        StringBuilder result = new StringBuilder(description + "\n");
        int i = 1;

        if (options != null) {
            for (String key : options.keySet()) {
                result.append("\n[").append(i).append("] ").append(key);
                i++;
            }
        }

        return result.toString();
    }

    /**
     * Returns whether this situation is an endpoint
     * of the story.
     *
     * @return whether it is an endpoint
     */
    public boolean isEndpoint()
    {
        return options == null;
    }

    /**
     * Returns choices mapped to their next situations.
     *
     * @return Map of option:situation
     */
    public LinkedHashMap<String, String> getOptions()
    {
        return options;
    }

    /**
     * Sets the description.
     *
     * @param  description  description of the situation
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Sets choices mapped to their next situations.
     *
     * @param  options  Map of option:situation
     */
    public void setOptions(LinkedHashMap<String, String> options)
    {
        this.options = options;
    }
}
