import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * Stores and allows access to story situations in the
 * YAML file.
 *
 * @author Daniel Kim
 * @version 4-27-22
 */
public class TextAdventureModel {
    private final Story story;

    /**
     * Constructor for an object of the model. Loads
     * and parses a YAML file.
     *
     * @param  resourceFile  path to YAML file in resources
     */
    public TextAdventureModel(String resourceFile)
    {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(
                        this.getClass().getResourceAsStream(resourceFile))));

        /*
         * SnakeYAML accepts a custom class that mimics the
         * data (properties as instance variables) and will
         * store the data in an instance of that class.
         */
        Yaml yaml = new Yaml(new Constructor(Story.class));
        story = yaml.load(reader);
    }

    /**
     * Returns an object with story data.
     *
     * @return Story object
     */
    public Story getStory()
    {
        return story;
    }
}
