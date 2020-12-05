package Q2;

public class AlunoUFCG implements Runnable {

	private Barco barco;
	private String aluno;

	public AlunoUFCG(Barco barco, String aluno) {
		super();
		this.barco = barco;
		this.aluno = aluno;
	}

	@Override
	public void run() {
		try {

			while (true) {

				this.embarcar();

				this.destinoFinal();
				
			}

		} catch (Exception e) {
			System.out.println("ERRO");
		}

	}

	public void embarcar() throws InterruptedException {
		this.barco.embarcarUFCG(aluno);
	}
	
	public void destinoFinal() throws InterruptedException {
		this.barco.destinoFinal();
	}

}
