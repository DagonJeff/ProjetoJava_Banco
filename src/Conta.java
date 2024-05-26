import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Exceptions.DesativadaException;
import Exceptions.SaldoInsuficienteException;

public class Conta implements IExtrato {

	private long numero;
	private String senha;
	private LocalDate dataAbertura, dataEncerramento;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private int situacao = 1;
	private double saldo;
	private Pessoa pessoa;
	private List<Movimento> movimentos;

	public Conta() {

		this.movimentos = new ArrayList<Movimento>();
	}
	
	

public Conta(long numero, String senha, LocalDate dataAbertura, LocalDate dataEncerramento, int situacao,
			double saldo, Pessoa pessoa) {
		super();
		
		this.numero = numero;
		this.senha = senha;
		this.dataAbertura = dataAbertura;
		this.dataEncerramento = dataEncerramento;
		this.situacao = situacao;
		this.saldo = saldo;
		this.pessoa = pessoa;
		this.movimentos = new ArrayList<Movimento>();
	}


	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getDataAbertura() {
		return dataAbertura.format(formatter);
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getDataEncerramento() {
		return dataEncerramento.format(formatter);
	}

	public void setDataEncerramento(LocalDate dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public double getSaldo() {
		return saldo;
	}


	public void sacar(double valor) throws DesativadaException, SaldoInsuficienteException {


		if (this.pessoa.getSituacao() == 0 || this.situacao == 0) {

			throw new DesativadaException("\nOPERAÇÃO NEGADA! Conta ou Cliente desativado.\n");
		}

		if (valor > 0) {
			if (valor > saldo) {

				throw new SaldoInsuficienteException("\nOPERAÇÃO NEGADA! Saldo Insuficiente.\n");

			}

			saldo -= valor;
			System.out.println("Saque realizado com sucesso. Novo saldo: " + saldo);

			LocalDate data = LocalDate.now();
			LocalTime hora = LocalTime.now();

			this.movimentos.add(new Movimento(1, data, hora, valor));
		} else
			System.out.println("Valor inválido!");

//            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso. Novo saldo: " + saldo, "Saque", JOptionPane.INFORMATION_MESSAGE);

	}

	public void depositar(double valor) throws DesativadaException {

		if (this.pessoa.getSituacao() == 0 || this.situacao == 0) {

			throw new DesativadaException("\nOPERAÇÃO NEGADA! Conta ou Cliente desativado!\n");
		}

		if (valor > 0) {
			saldo += valor;

			System.out.println("Depósito realizado com sucesso. Novo saldo: " + saldo);

			LocalDate data = LocalDate.now();
			LocalTime hora = LocalTime.now();

			this.movimentos.add(new Movimento(2, data, hora, valor));

//            JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso. Novo saldo: " + saldo, "Depósito", JOptionPane.INFORMATION_MESSAGE);

		} else {
			System.out.println("Valor inválido.");
		}
	}

	public void transferir(double valor, Conta contaDestino) throws DesativadaException, SaldoInsuficienteException {

		if (contaDestino.pessoa.getSituacao() == 0 || contaDestino.getSituacao() == 0) {

			throw new DesativadaException("\nOPERAÇÃO NEGADA! Cliente ou conta de destino desativada.\n");
		}

		this.sacar(valor);

		contaDestino.depositar(valor);

		System.out.println("Transferência realizada com sucesso.");
		this.movimentos.remove(this.movimentos.size() - 1);

		LocalDate data = LocalDate.now();
		LocalTime hora = LocalTime.now();

		this.movimentos.add(new Movimento(3, data, hora, valor));

//            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso.", "Transferência", JOptionPane.INFORMATION_MESSAGE);

		// System.out.println("Transferência não realizada. Saldo insuficiente ou valor
		// inválido.");
	}

	@Override
	public String toString() {
		return "-Conta-\n" + "Número: " + numero + ", Data de Abertura: " + dataAbertura.format(formatter) + ", Data de Encerramento: "
				+ dataEncerramento.format(formatter) +", Situação: " + situacao + ", Saldo: " + saldo
				+ "\nTitular da conta:\n" + pessoa+"\n";
	}

	@Override
	public void imprimir() {

		System.out.println("------------------------------------------------------");
		System.out.println("-EXTRATO-");
		System.out.println("Conta:" + this.numero);
		System.out.println(this.pessoa);
		this.movimentos.forEach(m -> System.out.println(m));
		System.out.println("SALDO: " + this.getSaldo());
		System.out.println("------------------------------------------------------");
	}
}
