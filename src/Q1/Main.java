package Q1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		Buffer b = new Buffer();
		
		Carro c = new Carro(b, 4);
		
		Passageiro p1 = new Passageiro(b, "P1");
		Passageiro p2 = new Passageiro(b, "P2");
		Passageiro p3 = new Passageiro(b, "P3");
		Passageiro p4 = new Passageiro(b, "P4");
		Passageiro p5 = new Passageiro(b, "P5");
		Passageiro p6 = new Passageiro(b, "P6");
		Passageiro p7 = new Passageiro(b, "P7");
		
		ExecutorService executor = Executors.newFixedThreadPool(6);
		
		executor.execute(c);
		executor.execute(p1);
		executor.execute(p2);
		executor.execute(p3);
		executor.execute(p4);
		executor.execute(p5);
		executor.execute(p6);
		executor.execute(p7);
	
	}

}
