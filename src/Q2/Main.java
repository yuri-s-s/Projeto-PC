package Q2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		Barco b = new Barco();
		
		AlunoUEPB uepb1 = new AlunoUEPB(b);
		AlunoUEPB uepb2 = new AlunoUEPB(b);
		AlunoUEPB uepb3 = new AlunoUEPB(b);
		AlunoUEPB uepb4 = new AlunoUEPB(b);
		AlunoUEPB uepb5 = new AlunoUEPB(b);
		AlunoUEPB uepb6 = new AlunoUEPB(b);
		AlunoUEPB uepb7 = new AlunoUEPB(b);
		AlunoUFCG ufcg1 = new AlunoUFCG(b);
		AlunoUFCG ufcg2 = new AlunoUFCG(b);
		AlunoUFCG ufcg3 = new AlunoUFCG(b);
		AlunoUFCG ufcg4 = new AlunoUFCG(b);
		AlunoUFCG ufcg5 = new AlunoUFCG(b);
		AlunoUFCG ufcg6 = new AlunoUFCG(b);
		AlunoUFCG ufcg7 = new AlunoUFCG(b);
		
		
		ExecutorService executor = Executors.newFixedThreadPool(25);

		executor.execute(ufcg1);
		executor.execute(uepb2);
		executor.execute(uepb3);
		executor.execute(uepb4);
		executor.execute(ufcg6);
		executor.execute(uepb5);
		executor.execute(ufcg5);
		executor.execute(uepb1);
		executor.execute(ufcg2);
		executor.execute(uepb7);
		executor.execute(ufcg3);
		executor.execute(ufcg4);
		executor.execute(uepb6);
		executor.execute(ufcg7);
		
	}
}
