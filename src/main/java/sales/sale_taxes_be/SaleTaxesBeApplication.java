package sales.sale_taxes_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaleTaxesBeApplication {

    public static void main(String[] args) {
        System.out.println("Sales taxes started");
        SpringApplication.run(SaleTaxesBeApplication.class, args);
    }

}
