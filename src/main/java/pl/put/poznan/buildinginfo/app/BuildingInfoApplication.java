package pl.put.poznan.buildinginfo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The {@code BuildingInfoApplication} class is the main entry point of the Building Info application.
 * <p>
 * It initializes and starts the Spring Boot application by scanning the specified base packages
 * for components, configurations, and services.
 * </p>
 * <p>
 * This class is annotated with {@link SpringBootApplication}, which combines the functionalities of
 * {@link org.springframework.context.annotation.Configuration}, {@link org.springframework.context.annotation.ComponentScan},
 * and {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration}.
 * </p>
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.buildinginfo"})
public class BuildingInfoApplication {

    /**
     * The main method that serves as the entry point to the application.
     * <p>
     * It invokes the {@link SpringApplication#run(Class, String...)} method to launch the Spring Boot application.
     * </p>
     *
     * @param args the command-line arguments passed during application startup
     */
    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);
    }
}
