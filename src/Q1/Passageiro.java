package Q1;

public class Passageiro implements Runnable {

	private Buffer buffer;
	
	
	public Passageiro(Buffer buffer) {
		super();
		this.buffer = buffer;
	}

	@Override
	public void run() {

		try {
			while(true) {
		
				this.embarcar();
				
				this.desembarcar();
				
			}	
		} catch (Exception e) {
			System.out.println("ERRO");
		}
		
	}

	public void embarcar() throws InterruptedException {
		
		this.buffer.embarcar();
	}
	
	public void desembarcar() throws InterruptedException {
		
		this.buffer.desembarcar();
		
	}

}
