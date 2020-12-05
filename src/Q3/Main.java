package Q3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		Auri auri = new Auri();
		
		Aluno a1 = new Aluno(auri, "Tiltado");
		Aluno a2 = new Aluno(auri, "Pernambucano");
		Aluno a3 = new Aluno(auri, "Fofoqueiro");
		Aluno a4 = new Aluno(auri, "Chorão");
		Aluno a5 = new Aluno(auri, "Azulzinho");
		Aluno a6 = new Aluno(auri, "Terrorista");
		Aluno a7 = new Aluno(auri, "Fininnnn");
		Aluno a8 = new Aluno(auri, "Toxico");
		
		ExecutorService executor = Executors.newFixedThreadPool(8);
		
		executor.execute(a1);
		executor.execute(a2);
		executor.execute(a3);
		executor.execute(a4);
		executor.execute(a5);
		executor.execute(a6);
		executor.execute(a7);
		executor.execute(a8);
		
	}
}
