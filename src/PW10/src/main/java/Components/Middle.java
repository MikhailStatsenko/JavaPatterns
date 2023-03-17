package Components;

import Interfaces.Programmer;
import org.springframework.stereotype.Component;

@Component("Middle")
public class Middle implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Middle is coding");
    }
}
