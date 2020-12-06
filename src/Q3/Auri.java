package Q3;

/*
 * Nesta quest�o, Utilizei o Auri como buffer para controlar a thread Aluno.
 */
public class Auri {

	private int pessoasBebendo;

	private int pessoasMesa;

	public Auri() {
		this.pessoasBebendo = 0;
		this.pessoasMesa = 0;
	}

	/*
	 * No m�todo entra, uma pessoa pode entrar na mesa sem nenhuma restri��o.
	 * 
	 * No fim do m�todo, � chamado um notifyAll() para ver se tem alguem querendo
	 * sair da mesa.
	 */
	public synchronized void entra(String pessoa) throws InterruptedException {

		this.pessoasMesa++;

		System.out.println("O aluno " + pessoa + " entrou na mesa, existe " + String.valueOf(pessoasBebendo)
				+ " alunos remediados e " + String.valueOf(pessoasMesa) + " alunos na mesa.");

		notifyAll();
	}

	/*
	 * No m�todo bebe, uma pessoa pode beber sem nenhuma restri��o.
	 * 
	 * No fim do m�todo, � chamado um notifyAll() para ver se tem alguem querendo
	 * sair da mesa.
	 */
	public synchronized void bebe(String pessoa) throws InterruptedException {

		this.pessoasBebendo++;

		System.out.println("O aluno " + pessoa + " Est� bebendo...");

		System.out.println("O aluno " + pessoa + " Est� remediado, existe " + String.valueOf(pessoasBebendo)
				+ " alunos remediados e " + String.valueOf(pessoasMesa) + " alunos na mesa.");

		notifyAll();
	}

	/*
	 * No m�todo entra, uma pessoa pode tentar sair da mesa, e s� conseguir� sair se
	 * forem atendidas as restri��es do m�todo pode sair.
	 * 
	 * No fim do m�todo, � chamado um notifyAll() para ver se tem mais alguem
	 * querendo sair da mesa.
	 */
	public synchronized void sai(String pessoa) throws InterruptedException {

		while (!podeSair()) {

			System.out.println("O aluno " + pessoa + " n�o conseguiu sair da mesa");

			wait();
		}

		this.pessoasMesa--;
		this.pessoasBebendo--;

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
