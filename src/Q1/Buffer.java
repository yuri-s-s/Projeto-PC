package Q1;

/*
 * Nessa quest�o, utilizei um buffer para controlar a thread Carro e as threads
 * Passageiro. O buffer possui valores iniciais gerados pelo construtor, e v�o
 * sendo alterados ao longo do programa, como � o caso do m�todo carregar,
 * chamado pelo Carro.
 * 
 * A variavel c foi iniciada com -1, porque com essa informa��o, a Thread Carro vai
 * saber que o carro ainda n�o foi carregado.
 * 
 * Os sleeps foram colocados apenas para vizualizar os prints, n�o tendo impacto
 * no andamento das threads
 */
public class Buffer {

	private int c;

	private int passageirosEmbarcado;

	private boolean descarregar = false;
	private boolean carregar = false;

	public Buffer() {
		super();
		this.passageirosEmbarcado = 0;
		this.c = -1;
	}

	/*
	 * No carregar, � onde � passado a capacidade de pessoas dentro do carro, al�m
	 * de setar dois booleans, informando que a thread Passageiro pode come�ar a
	 * embarcar pessoas, e bloquendo o m�todo de desembarcar.
	 */
	public synchronized void carregar(int c) throws InterruptedException {

		while (isFull() || this.c > -1) {
			wait();
		}

		this.c = c;

		this.carregar = true;
		this.descarregar = false;

		Thread.sleep(1000);
		System.out.println("O carro est� parado e pronto para carregar");
		Thread.sleep(1000);

		notifyAll();
	}

	/*
	 * No embarcar, enquanto a capacidade de passageiros no carro n�o estiver
	 * esgotada e a thread Carro estiver parado para carregar, as threads Passageiro
	 * podem embarcar pessoas.
	 * 
	 * Ao fim do m�todo, � chamado um notifyAll(), onde a thread Carro sai do wait e
	 * fica pronto para correr.
	 */
	public synchronized void embarcar(String nome) throws InterruptedException {

		while (isFull() || !carregar) {
			wait();
		}

		this.passageirosEmbarcado++;

		System.out.println("O passageiro " + nome + " embarcou.");
		Thread.sleep(1000);

		notifyAll();
	}

	/*
	 * No correr, quando a capacidade maxima do carro for atingida, o carro fica
	 * imposs�vel de carregar, e n�o s�o mais permitidos embarcarem passageiros.
	 * 
	 * Ao fim do m�todo, � chamado um notifyAll(), onde a thread Carro sai do wait e
	 * fica pronto para descarregar.
	 */
	public synchronized void correr() throws InterruptedException {
		while (!isFull()) {
			wait();
		}

		this.carregar = false;

		System.out.println("O carro est� correndo, aperte os cintos");
		Thread.sleep(5000);

		notifyAll();
	}

	/*
	 * No descarregar, informa que a thread Passageiro pode come�ar a desembarcar
	 * pessoas.
	 */
	public synchronized void descarregar() throws InterruptedException {

		while (isEmpty() && c != 0) {
			wait();
		}

		System.out.println("O carro parou e est� pronto para descarregar");
		Thread.sleep(2000);

		this.descarregar = true;
		
		if (isEmpty()) {
			this.c = -1;
		}

		notifyAll();
	}

	/*
	 * No desembarcar, enquanto tiver passageiros e a thread Carro estiver parado
	 * para descarregar, as threads Passageiro podem desembarcar pessoas.
	 * 
	 * Quando todo mundo for descarregado, a capacidade do carro volta ao estado
	 * inicial, liberando a thread Carro para poder carregar.
	 */
	public synchronized void desembarcar(String nome) throws InterruptedException {

		while (isEmpty() || !descarregar) {
			wait();
		}

		this.passageirosEmbarcado--;

		System.out.println("O passageiro " + nome + " desembarcou.");
		Thread.sleep(1000);

		if (isEmpty()) {
			this.c = -1;
		}

		notifyAll();
	}

	public synchronized boolean isEmpty() {
		return this.passageirosEmbarcado == 0;
	}

	public synchronized boolean isFull() {
		return this.passageirosEmbarcado == this.c;
	}

}
