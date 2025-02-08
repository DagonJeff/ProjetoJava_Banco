import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Enums.Enums.Situacao;
import Exceptions.DesativadaException;
import Exceptions.SaldoInsuficienteException;

public class Conta implements IExtrato {

	private long numero;
	private String senha;
	private LocalDate dataAbertura, dataEncerramento;
	private Situacao situacao;
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
		try {
			this.setSituacao(situacao);
		} catch (IllegalArgumentException e) {

			System.err.println("Erro: " + e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}

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
		return dataAbertura.format(Movimento.dateFormatter);
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getDataEncerramento() {
		return dataEncerramento.format(Movimento.dateFormatter);
	}

	public void setDataEncerramento(LocalDate dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {

		if (situacao == Situacao.ATIVA.getValor()) {

			this.situacao = Situacao.ATIVA;

		} else if (situacao == Situacao.INATIVA.getValor()) {

			this.situacao = Situacao.INATIVA;

		} else
			throw new IllegalArgumentException("Valor inválido para atributo 'Situação'");
	}

	public double getSaldo() {
		return saldo;
	}

//-------------------SACAR----------------------------------------------------------//
	public void sacar(double valor) throws DesativadaException, SaldoInsuficienteException {

		if (this.dataEncerramento.isBefore(LocalDate.now())) {

			this.situacao = Situacao.INATIVA;
		}

		if (this.pessoa.getSituacao() == Situacao.INATIVA || this.situacao == Situacao.INATIVA) {

			throw new DesativadaException("\nOPERAÇÃO NEGADA! Cliente ou Conta inativa.\n");
		}

		if (valor > 0) {
			if (valor > saldo) {

				throw new SaldoInsuficienteException("\nOPERAÇÃO NEGADA! Saldo Insuficiente.\n");

			}

			this.saldo -= valor;
			System.out
					.println("Saque realizado com sucesso. Novo saldo: " + Movimento.decimalFormat.format(this.saldo));

			LocalDate data = LocalDate.now();
			LocalTime hora = LocalTime.now();

			this.movimentos.add(new Movimento(1, data, hora, valor));
		} else
			System.out.println("Valor inválido!");

	}

//-------------------DEPOSITAR----------------------------------------------------------//
	public void depositar(double valor) throws DesativadaException {

		if (this.dataEncerramento.isBefore(LocalDate.now())) {

			this.situacao = Situacao.INATIVA;
		}

		if (this.pessoa.getSituacao() == Situacao.INATIVA || this.situacao == Situacao.INATIVA) {

			throw new DesativadaException("\nOPERAÇÃO NEGADA! Cliente ou Conta inativa.\n");
		}

		if (valor > 0) {
			saldo += valor;

			System.out.println(
					"Depósito realizado com sucesso. Novo saldo: " + Movimento.decimalFormat.format(this.saldo));

			LocalDate data = LocalDate.now();
			LocalTime hora = LocalTime.now();

			this.movimentos.add(new Movimento(2, data, hora, valor));

		} else {
			System.out.println("Valor inválido.");
		}
	}

//-------------------TRANSFERIR----------------------------------------------------------//
	public void transferir(double valor, Conta contaDestino) throws DesativadaException, SaldoInsuficienteException {

		if (contaDestino.dataEncerramento.isBefore(LocalDate.now())) {

			contaDestino.setSituacao(0);
		}

		if (contaDestino.pessoa.getSituacao() == Situacao.INATIVA || contaDestino.getSituacao() == Situacao.INATIVA) {

			throw new DesativadaException("\nOPERAÇÃO NEGADA! Cliente ou conta de destino inativa.\n");
		}

		this.sacar(valor);

		contaDestino.depositar(valor);

		System.out.println("Transferência realizada com sucesso.");
		this.movimentos.remove(this.movimentos.size() - 1);

		LocalDate data = LocalDate.now();
		LocalTime hora = LocalTime.now();

		this.movimentos.add(new Movimento(3, data, hora, valor));

	}

	@Override
	public String toString() {
		return "-Conta-\n" + "Número: " + numero + ", Data de Abertura: " + dataAbertura.format(Movimento.dateFormatter)
				+ ", Data de Encerramento: " + dataEncerramento.format(Movimento.dateFormatter) + ", Situação: "
				+ situacao + ", Saldo: " + Movimento.decimalFormat.format(this.saldo) + "\nTitular da conta:\n" + pessoa
				+ "\n";
	}

	@Override
	public void imprimir() {

		System.out.println("------------------------------------------------------");
		System.out.println("-EXTRATO-");
		System.out.println(toString());
		this.movimentos.forEach(m -> System.out.println(m));
		System.out.println("SALDO: " + Movimento.decimalFormat.format(saldo));
		System.out.println("------------------------------------------------------");
	}
}
