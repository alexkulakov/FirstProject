package me.student.lemur;

import com.google.common.collect.Lists;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Lemur {

    private static Logger logger = LoggerFactory.getLogger(Lemur.class);
    private Set<String> fruits = new HashSet<>();
    private List<String> food = new ArrayList<>();

    {
        try {
            PropertiesConfiguration conf = new PropertiesConfiguration(Lemur.class.getResource("Lemur.properties"));
            Collections.addAll(fruits, conf.getStringArray("foods"));

        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void setFood(List<String> food) {
        this.food = food;
    }

    public List<String> getFood() {
        return food;
    }

    public void eat(String smth) {
        if (fruits.contains(smth)) {
            getFood().add(smth);
        } else {
            throw new RuntimeException("I don't eat " + smth + "!");
        }
    }

    public void live() {
        List<String> stuff = Lists.newArrayList("book", "meat", "apple", "cake");
        for (String meal : stuff) {
            try {
                eat(meal);
            }
            catch (RuntimeException ex){
                logger.error(ex.getMessage());
            }
        }
    }
}
