package Q2;

public class AlunoUEPB implements Runnable {

	private Barco barco;
	private String aluno;
	
	public AlunoUEPB(Barco barco, String aluno) {
		super();
		this.barco = barco;
		this.aluno = aluno;
	}
	
	@Override
	public void run() {
		try {
			
			while(true) {
				
				boolean podeRemar = this.embarcar();
				
				if(podeRemar) {
					this.rema();
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("ERRO");
		}
		
	}
	
	public boolean embarcar() throws InterruptedException {
		return this.barco.embarcarUEPB(aluno);
	}
	
	public void rema() throws InterruptedException {
		 this.barco.rema("UEPB", aluno);
	}
}
