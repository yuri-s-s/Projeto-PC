package Q2;

public class AlunoUFCG implements Runnable {
	
	private Barco barco;

	public AlunoUFCG(Barco barco) {
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
		this.barco.embarcarUFCG();
	}
	

}
