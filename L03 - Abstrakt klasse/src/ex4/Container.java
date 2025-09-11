package ex4;

import ex1.Foreman;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private static final int MAX_WEIGHT = 10;
    private List<Integer> objects = new ArrayList<>();

    public boolean addObject(int weight) {
        if (getTotalWeight() + weight <= MAX_WEIGHT) {
            objects.add(weight);
            return true;
        }
        return false;
    }

    public int getTotalWeight() {
        int sum = 0;
        for (int w : objects) {
            sum += w;
        }
        return sum;
    }

    public List<Integer> getObjects() {
        return objects;
    }

    @Override
    public String toString() {
        return "Container { total weight: " + getTotalWeight() +
                "objects: " + objects +
                " }";
    }
}
