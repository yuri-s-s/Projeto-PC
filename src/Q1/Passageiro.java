package Q1;

/*
 * Thread Passageiro que possui duas chamadas ao Buffer, (embarcar, desembarcar)
 */
public class Passageiro implements Runnable {

	private Buffer buffer;

	private String nomePassageiro;

	public Passageiro(Buffer buffer, String nomePassageiro) {
		super();
		this.buffer = buffer;
		this.nomePassageiro = nomePassageiro;
	}

	@Override
	public void run() {

		try {
			while (true) {

				this.embarcar();

				this.desembarcar();

			}
		} catch (Exception e) {
			System.out.println("ERRO");
		}

	}

	public void embarcar() throws InterruptedException {

		this.buffer.embarcar(nomePassageiro);
	}

	public void desembarcar() throws InterruptedException {

		this.buffer.desembarcar(nomePassageiro);

	}

}
