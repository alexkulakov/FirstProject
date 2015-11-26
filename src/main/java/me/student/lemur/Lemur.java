package me.student.lemur;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lemur {

    private static Logger logger = LoggerFactory.getLogger(Lemur.class);
    private Set<String> fruits = new HashSet<>();
    private List<String> food = new ArrayList<>();

    {
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("guava");
    }

    public void setFood(List<String> food) {
        this.food = food;
    }

    public List<String> getFood() {
        return food;
    }

    public void eat(String smth) {
        if (fruits.contains(smth)) {
            fruits.add(smth);
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
