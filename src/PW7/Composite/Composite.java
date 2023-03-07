package PW7.Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements File {
    private List<File> components = new ArrayList<>();

    public boolean addComponent(File component) {
        return components.add(component);
    }

    public boolean removeComponent(File component) {
        return components.remove(component);
    }

    @Override
    public void printType() {
        for (File component : components) {
            component.printType();
        }
    }
}
