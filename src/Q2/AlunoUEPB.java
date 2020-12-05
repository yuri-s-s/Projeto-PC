package Q2;

/*
 * Thread AlunoUEPB que possui uma chamada ao Barco (embarcarUEPB)
 */
public class AlunoUEPB implements Runnable {

	private Barco barco;
	private String aluno;

	public AlunoUEPB(Barco barco, String aluno) {
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
		this.barco.embarcarUEPB(aluno);
	}

}
