package pl.edu.wszib.car.rent.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.edu.wszib.car.rent.jdbc.config.AppConfiguration;
import pl.edu.wszib.car.rent.jdbc.core.ICore;

public class App {
    public static void main(String[] args) {
//        new Core().run(); // bo musimy z kontekstu
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ICore core = context.getBean(ICore.class);
        core.run();
    }
}