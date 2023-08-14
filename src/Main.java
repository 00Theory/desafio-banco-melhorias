public class Main {
    public static void main(String[] args) {
        Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirInfosComuns();
		poupanca.imprimirInfosComuns();

		Cliente marco = new Cliente();
		marco.setNome(("Marco"));

		Conta cm = new ContaCorrente(marco);
		cm.imprimirInfosComuns();

		System.out.println(cc.getNumeroCartao());
		System.out.println(cm.getNumeroCartao());
    }

}
