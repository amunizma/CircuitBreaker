package com.nttdata.circuitbreaker;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.circuitbreaker.clase.Estado;

@SpringBootApplication
public class CircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerApplication.class, args);
		
		String [] paquetes1 = {"ko","ko","ok","ok","ko","ko","ok","ok","ko"};
		String [] paquetes2 = {"ok","ok","ok","ok","ok","ok","ok","ok","ko"};
		String [] paquetes3 = {"ko","ok","ko","ko","ko","ko","ko","ok","ko"};
		
		Estado estado1=new Estado(paquetes1, 20, 10, 3);
		Estado estado2=new Estado(paquetes2, 25, 10, 3);
		Estado estado3=new Estado(paquetes3, 50, 5, 3);
		
		
		System.out.println("El estado de paquete 1 es: " + estado1.getEstado().toString());
		System.out.println("El estado de paquete 2 es: " + estado2.getEstado().toString());
		System.out.println("El estado de paquete 3 es: " + estado3.getEstado().toString());
	}

}
