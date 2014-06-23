package org.bitcoinmonitor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

@ComponentScan
@EnableIntegration
@ImportResource("integration.xml")
public class Main {

		    public static void main(String[] args) {
		    	System.out.println("Hello world");
		        new AnnotationConfigApplicationContext(Main.class);
		    }
}
