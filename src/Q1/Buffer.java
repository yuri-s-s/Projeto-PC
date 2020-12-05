package Q1;

/*
 * Nessa questão, utilizei um buffer para controlar a thread Carro e as threads
 * Passageiro. O buffer possui valores iniciais gerados pelo construtor, e vão
 * sendo alterados ao longo do programa, como é o caso do método carregar,
 * chamado pelo Carro.
 * 
 * A variavel c foi iniciada com -1, porque com essa informação, a Thread Carro vai
 * saber que o carro ainda não foi carregado.
 * 
 * Os sleeps foram colocados apenas para vizualizar os prints, não tendo impacto
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
	 * No carregar, é onde é passado a capacidade de pessoas dentro do carro, além
	 * de setar dois booleans, informando que a thread Passageiro pode começar a
	 * embarcar pessoas, e bloquendo o método de desembarcar.
	 */
	public synchronized void carregar(int c) throws InterruptedException {

		while (isFull() || this.c > -1) {
			wait();
		}

		this.c = c;

		this.carregar = true;
		this.descarregar = false;

		Thread.sleep(1000);
		System.out.println("O carro está parado e pronto para carregar");
		Thread.sleep(1000);

		notifyAll();
	}

	/*
	 * No embarcar, enquanto a capacidade de passageiros no carro não estiver
	 * esgotada e a thread Carro estiver parado para carregar, as threads Passageiro
	 * podem embarcar pessoas.
	 * 
	 * Ao fim do método, é chamado um notifyAll(), onde a thread Carro sai do wait e
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
	 * impossível de carregar, e não são mais permitidos embarcarem passageiros.
	 * 
	 * Ao fim do método, é chamado um notifyAll(), onde a thread Carro sai do wait e
	 * fica pronto para descarregar.
	 */
	public synchronized void correr() throws InterruptedException {
		while (!isFull()) {
			wait();
		}

		this.carregar = false;

		System.out.println("O carro está correndo, aperte os cintos");
		Thread.sleep(5000);

		notifyAll();
	}

	/*
	 * No descarregar, informa que a thread Passageiro pode começar a desembarcar
	 * pessoas.
	 */
	public synchronized void descarregar() throws InterruptedException {

		while (isEmpty() && c != 0) {
			wait();
		}

		System.out.println("O carro parou e está pronto para descarregar");
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
