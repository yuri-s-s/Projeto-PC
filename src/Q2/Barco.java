package Q2;

public class Barco {

	final private int capacidade = 4;

	private int alunosUEPB;

	private int alunosUFCG;

	private int totalAlunos;

	private boolean podeRemar = false;

	public Barco() {
		this.alunosUEPB = 0;
		this.alunosUFCG = 0;
		this.totalAlunos = 0;
		this.podeRemar = false;
	}

	public synchronized boolean embarcar() throws InterruptedException {

		while (this.totalAlunos == this.capacidade) {
			wait();
		}

		this.totalAlunos++;
		
		if (this.totalAlunos == this.capacidade) {

			System.out.println("Capacidade máxima atingida. Algum aluno pode remar");
			Thread.sleep(500);
			this.podeRemar = true;
		}
		
		return true;

	}

	public synchronized void rema( String universidade, String aluno) throws InterruptedException {

		while (!this.podeRemar) {
			wait();
		}

		System.out.println("O aluno " + aluno + " da Universidade " + universidade +  " começou a remar.");

		this.podeRemar = false;

		Thread.sleep(1000);
		System.out.println("O barco está remando. BORA BORA.");
		Thread.sleep(5000);
		System.out.println("O barco chegou ao seu destino");

		this.alunosUEPB = 0;
		this.alunosUFCG = 0;
		this.totalAlunos = 0;

		Thread.sleep(1500);
		System.out.println("O barco está pronto para uma nova viagem.");
		Thread.sleep(1000);

		notifyAll();
	}

	public synchronized boolean embarcarUFCG(String aluno) throws InterruptedException {
		
		while (!this.podeEmbarcarUFCG() || podeRemar) {
			System.out.println("O aluno " +aluno + " da UFCG foi bloqueado");
			wait();
		}

		this.alunosUFCG++;

		System.out.println("O aluno " + aluno + " da UFCG embarcou.");
		Thread.sleep(1000);

		return this.embarcar();
	}

	public synchronized boolean embarcarUEPB(String aluno) throws InterruptedException {
		
		while (!this.podeEmbarcarUEPB() || podeRemar) {
			System.out.println("O aluno " +aluno + " da UEPB foi bloqueado");
			wait();
		}

		this.alunosUEPB++;

		System.out.println("O aluno " +aluno + " da UEPB embarcou.");
		Thread.sleep(1000);

		return this.embarcar();
	}

	public synchronized boolean podeEmbarcarUFCG() {

		if (this.totalAlunos == 3) {

			if (this.alunosUFCG == 2 || this.alunosUFCG == 0) {
				return false;
			} else {
				return true;
			}
		} else if (this.totalAlunos == 4) {
			return false;
		}

		return true;
	}

	public synchronized boolean podeEmbarcarUEPB() {

		if (this.totalAlunos == 3) {

			if (this.alunosUEPB == 2 || this.alunosUEPB == 0) {
				return false;
			} else {
				return true;
			}
		} else if (this.totalAlunos == 4) {
			return false;
		}

		return true;
	}

}
