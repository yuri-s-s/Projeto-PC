package Q3;

/*
 * Thread Aluno que possui tres chamadas ao Auri (entra, bebe, sai),
 * executadas nessa ordem, pois nao é possível sair sem beber.
 */
public class Aluno implements Runnable {

	private Auri auri;

	private String aluno;

	public Aluno(Auri auri, String aluno) {
		super();
		this.auri = auri;
		this.aluno = aluno;
	}

	@Override
	public void run() {
		try {
			while (true) {

				this.entra();

				this.bebe();

				this.sai();

			}
		} catch (Exception e) {
			System.out.println("Erro");
		}
	}

	public void entra() throws InterruptedException {
		this.auri.entra(aluno);
	}

	public void bebe() throws InterruptedException {
		this.auri.bebe(aluno);
	}

	public void sai() throws InterruptedException {
		this.auri.sai(aluno);
	}

}
