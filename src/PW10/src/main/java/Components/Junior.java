package Components;

import Interfaces.Programmer;
import org.springframework.stereotype.Component;

@Component("Junior")
public class Junior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Junior is coding");
    }
}
