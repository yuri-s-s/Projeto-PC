package Q1;

public class Buffer {
	
	private int c;
	
	private int valor;
	
	private boolean descarregar = false;
	private boolean carregar = false;
	
	public Buffer() {
		super();
		this.valor = 0;
		this.c = -1;
	}
	
	public synchronized void carregar(int c) throws InterruptedException {

		while(isFull()  || this.c > -1 ) {
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
	
	public synchronized void embarcar() throws InterruptedException {

		while(isFull() || !carregar) {
			wait();
		}
		
		this.valor ++;
		
		System.out.println("Um passageiro embarcou");
		Thread.sleep(1000);
		
		notifyAll();
	}
	
	public synchronized void correr() throws InterruptedException {
		while(!isFull()) {
			wait();
		}
		
		this.carregar = false;
		
		System.out.println("O carro está correndo, aperte os cintos");
		Thread.sleep(5000);

		notifyAll();
	}
	
	public synchronized void descarregar() throws InterruptedException {

		while(isEmpty() ) {
			wait();
		}

		System.out.println("O carro parou e está pronto para descarregar");
		Thread.sleep(2000);
		
		this.descarregar = true;

		notifyAll();
	}
	
	public synchronized void desembarcar() throws InterruptedException {

		while(isEmpty() || !descarregar) {
			wait();
		}
		
		this.valor --;
		
		System.out.println("Um passageiro desembarcou");
		Thread.sleep(1000);
		
		if(isEmpty()) {
			this.c = -1;
		}
		
		notifyAll();
	}
	
	
	public synchronized boolean isEmpty() {
		return this.valor == 0;
	}
	
	public synchronized boolean isFull() {
		return this.valor == this.c;
	}
	
	
}
