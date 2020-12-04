package Q1;

public class Carro implements  Runnable {
	
	private Buffer buffer;
	private int c;
	
	public Carro(Buffer buffer, int c) {
		super();
		this.buffer = buffer;
		this.c = c;
	}
	
	@Override
	public void run() {
		
		try {
			while(true) {
				
				this.carregar();
				
				this.correr();
				
				this.descarregar();
				
			}	
		} catch (Exception e) {
			System.out.println("ERRO");
		}
		
	}
	public void carregar() throws InterruptedException {
		
		this.buffer.carregar(c);
		
	}
		
	public void correr() throws InterruptedException {
		
		this.buffer.correr();
		
	}
		
	public void descarregar() throws InterruptedException {
		
		this.buffer.descarregar();
		
	}
		
}
