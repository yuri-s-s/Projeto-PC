package Q2;

/*
 * Nessa questão, o Barco seria o proprio buffer para controlar as threads dos
 * alunos, O barco terá sempre a capacidade 4, e foram definidas as variaveis
 * (alunosUEPB, alunosUFCG e totalAlunos) sempre começando em 0.
 * 
 * A variavel podeRemar, foi definida, para controlar a função rema.
 * 
 * Foram feitos dois embarcar separados, (embarcarUFCG, embarcarUEPB) porém eles
 * chamam o mesmo método embarcar.
 */
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

	/*
	 * No embarcar, é onde é feita a adição de alunos no barco, além disso, esse
	 * método é responsável de chamar o metodo rema, alocando sempre o ultimo aluno
	 * para remar.
	 */
	public synchronized void embarcar(String universidade, String aluno) throws InterruptedException {

		while (this.totalAlunos == this.capacidade) {
			wait();
		}

		this.totalAlunos++;

		if (this.totalAlunos == this.capacidade) {

			System.out.println("Capacidade máxima atingida. Algum aluno pode remar");
			Thread.sleep(500);
			this.podeRemar = true;
			this.rema(universidade, aluno);
		}

	}

	/*
	 * No método rema, os outros métodos são travados, não sendo mais permitido que
	 * um aluno entre no barco, é usado um sleep para simular que o barco ta
	 * navegando, e apois isso, o barco volta para o estado inicial.
	 */
	public synchronized void rema(String universidade, String aluno) throws InterruptedException {

		while (!this.podeRemar) {
			wait();
		}

		System.out.println("O aluno " + aluno + " da Universidade " + universidade + " começou a remar.");

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

	/*
	 * No embarcarUFCG, é checado se o aluno dessa universidade pode embarcar, caso
	 * positivo, é chamado o metodo embarcar, inserindo o aluno no barco.
	 */
	public synchronized void embarcarUFCG(String aluno) throws InterruptedException {

		while (!this.podeEmbarcarUFCG() || podeRemar) {
			System.out.println("O aluno " + aluno + " da UFCG foi bloqueado");
			wait();
		}

		this.alunosUFCG++;

		System.out.println("O aluno " + aluno + " da UFCG embarcou.");
		Thread.sleep(1000);

		this.embarcar("UFCG", aluno);
	}

	/*
	 * No embarcarUEPB, é checado se o aluno dessa universidade pode embarcar, caso
	 * positivo, é chamado o metodo embarcar, inserindo o aluno no barco.
	 */
	public synchronized void embarcarUEPB(String aluno) throws InterruptedException {

		while (!this.podeEmbarcarUEPB() || podeRemar) {
			System.out.println("O aluno " + aluno + " da UEPB foi bloqueado");
			wait();
		}

		this.alunosUEPB++;

		System.out.println("O aluno " + aluno + " da UEPB embarcou.");
		Thread.sleep(1000);

		this.embarcar("UEPB", aluno);
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
