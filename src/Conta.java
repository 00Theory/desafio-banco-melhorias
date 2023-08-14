import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	protected long numeroCartao;

	Random rnd = new Random();

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.numeroCartao = ThreadLocalRandom.current().nextLong((long) Math.pow(10, 15), (long) Math.pow(10, 16) - 1);
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public long getNumeroCartao(){
		return numeroCartao;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println("Numero do Cartao: " + this.numeroCartao);
	}

	@Override
	public void imprimirExtrato() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'imprimirExtrato'");
	}
}
