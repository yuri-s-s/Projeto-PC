package Q1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	
	public static void main(String[] args) {
		
		Buffer b = new Buffer();
		
		Carro c = new Carro(b, 6);
		
		Passageiro p = new Passageiro(b);
		Passageiro p2 = new Passageiro(b);
		Passageiro p3 = new Passageiro(b);
		Passageiro p4 = new Passageiro(b);
		Passageiro p5 = new Passageiro(b);
		Passageiro p6 = new Passageiro(b);
		Passageiro p7 = new Passageiro(b);
		
		ExecutorService executor = Executors.newFixedThreadPool(8);
		
		executor.execute(c);
		executor.execute(p);
		executor.execute(p2);
		executor.execute(p3);
		executor.execute(p4);
		executor.execute(p5);
		executor.execute(p6);
		executor.execute(p7);
	
	}

}
