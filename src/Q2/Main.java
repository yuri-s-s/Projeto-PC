package Q2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		Barco b = new Barco();
		
		AlunoUEPB uepb1 = new AlunoUEPB(b, "UEPB - 1");
		AlunoUEPB uepb2 = new AlunoUEPB(b, "UEPB - 2");
		AlunoUEPB uepb3 = new AlunoUEPB(b, "UEPB - 3");
		AlunoUEPB uepb4 = new AlunoUEPB(b, "UEPB - 4");
		AlunoUEPB uepb5 = new AlunoUEPB(b, "UEPB - 5");
		AlunoUEPB uepb6 = new AlunoUEPB(b, "UEPB - 6");
		AlunoUEPB uepb7 = new AlunoUEPB(b, "UEPB - 7");
		AlunoUFCG ufcg1 = new AlunoUFCG(b, "UFCG - 1");
		AlunoUFCG ufcg2 = new AlunoUFCG(b, "UFCG - 2");
		AlunoUFCG ufcg3 = new AlunoUFCG(b, "UFCG - 3");
		AlunoUFCG ufcg4 = new AlunoUFCG(b, "UFCG - 4");
		AlunoUFCG ufcg5 = new AlunoUFCG(b, "UFCG - 5");
		AlunoUFCG ufcg6 = new AlunoUFCG(b, "UFCG - 6");
		AlunoUFCG ufcg7 = new AlunoUFCG(b, "UFCG - 7");
		
		
		ExecutorService executor = Executors.newFixedThreadPool(14);

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
