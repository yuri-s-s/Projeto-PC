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

	public synchronized void embarcar(String universidade) throws InterruptedException {

		while (this.totalAlunos == this.capacidade) {
			wait();
		}

		this.totalAlunos++;

		notifyAll();
		
		if (this.totalAlunos == this.capacidade) {

			System.out.println("Capacidade máxima atingida. Algum aluno pode remar");
			this.podeRemar = true;
			
			this.rema(universidade);
		}

	}

	public synchronized void rema( String universidade) throws InterruptedException {

		while (!this.podeRemar) {
			wait();
		}

		System.out.println("O aluno da Universidade " + universidade +  " começou a remar.");

		this.podeRemar = false;

		Thread.sleep(1000);
		System.out.println("O barco está remando. BORA BORA.");
		Thread.sleep(5000);
		System.out.println("O barco chegou ao seu destino");

		this.alunosUEPB = 0;
		this.alunosUFCG = 0;
		this.totalAlunos = 0;

		Thread.sleep(3000);
		System.out.println("O barco está pronto para uma nova viagem.");
		Thread.sleep(2000);

		notifyAll();
	}

	public synchronized void embarcarUFCG() throws InterruptedException {
		while (!this.podeEmbarcarUFCG() || podeRemar) {
			System.out.println("UFCG foi bloqueado");
			wait();
		}

		this.alunosUFCG++;

		System.out.println("O aluno " + String.valueOf(alunosUFCG) + " da UFCG embarcou.");
		Thread.sleep(1000);

		this.embarcar("UFCG");
	}

	public synchronized void embarcarUEPB() throws InterruptedException {
		while (!this.podeEmbarcarUEPB() || podeRemar) {
			System.out.println("UEPB foi bloqueado");
			wait();
		}

		this.alunosUEPB++;

		System.out.println("O aluno " + String.valueOf(alunosUEPB) + " da UEPB embarcou.");
		Thread.sleep(1000);

		this.embarcar("UEPB");
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
