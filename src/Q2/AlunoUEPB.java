package Q2;

public class AlunoUEPB implements Runnable {

	private Barco barco;
		
	public AlunoUEPB(Barco barco) {
		super();
		this.barco = barco;
	}
	
	@Override
	public void run() {
		try {
			
			while(true) {
				
				this.embarcar();
				
			}
			
		} catch (Exception e) {
			System.out.println("ERRO");
		}
		
	}
	
	public void embarcar() throws InterruptedException {
		this.barco.embarcarUEPB();
	}
	
}
