import Components.BeanConfig;
import Interfaces.Programmer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        String[] programmers = new String[]{"Junior", "Middle", "Senior"};
        for (String p : programmers) {
            Programmer programmer = (Programmer) context.getBean(p);
            programmer.doCoding();
        }
    }
}
