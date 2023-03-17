package Components;

import Interfaces.Programmer;
import org.springframework.stereotype.Component;

@Component("Senior")
public class Senior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Senior is coding");
    }
}
