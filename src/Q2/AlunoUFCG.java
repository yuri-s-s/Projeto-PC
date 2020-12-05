package Q2;

/*
 * Thread AlunoUFCG que possui uma chamada ao Barco (embarcarUFCG)
 */
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

			this.embarcar();

		} catch (Exception e) {
			System.out.println("ERRO");
		}

	}

	public void embarcar() throws InterruptedException {
		this.barco.embarcarUFCG(aluno);
	}

}
