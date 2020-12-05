package Q3;

public class Auri {

	private int pessoasBebendo;

	private int pessoasMesa;

	public Auri() {
		this.pessoasBebendo = 0;
		this.pessoasMesa = 0;
	}

	public synchronized void entra(String pessoa) throws InterruptedException {

		this.pessoasMesa++;

		Thread.sleep(1300);

		System.out.println("O aluno " + pessoa + " entrou na mesa, existe " + String.valueOf(pessoasBebendo)
				+ " alunos remediados e " + String.valueOf(pessoasMesa) + " alunos na mesa.");

		notifyAll();
	}

	public synchronized void bebe(String pessoa) throws InterruptedException {

		this.pessoasBebendo++;
		
		Thread.sleep(1300);
		System.out.println("O aluno " + pessoa + " Está bebendo...");
		
		Thread.sleep(1300);
		System.out.println("O aluno " + pessoa + " Está remediado, existe " + String.valueOf(pessoasBebendo)
				+ " alunos remediados e " + String.valueOf(pessoasMesa) + " alunos na mesa.");

		notifyAll();
	}

	public synchronized void sai(String pessoa) throws InterruptedException {

		while (!podeSair()) {
			
			Thread.sleep(1300);
			System.out.println("O aluno " + pessoa + " não conseguiu sair da mesa");
			
			wait();
		}

		this.pessoasMesa--;
		this.pessoasBebendo--;

		Thread.sleep(1300);

		System.out.println("O aluno " + pessoa + " saiu da mesa.");
		System.out.println("Existe " + String.valueOf(pessoasBebendo) + " remediadas e " + String.valueOf(pessoasMesa)
				+ " alunos na mesa.");

		notifyAll();
	}

	public synchronized boolean podeSair() {

		if (this.pessoasMesa < 3 && this.pessoasBebendo == 2) {
			return false;
		}

		return true;
	}

}
