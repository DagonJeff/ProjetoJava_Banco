import javax.swing.JOptionPane;

import Enums.Enums.Situacao;

abstract class Pessoa {

	private String nome;
	private double renda;
	private Endereco endereco;
	private Situacao situacao;

	public Pessoa() {
	}

	public Pessoa(String nome, double renda, int situacao, Endereco endereco) {

		this.nome = nome;
		this.renda = renda;
		this.endereco = endereco;
		try {
			this.setSituacao(situacao);
		} catch (IllegalArgumentException e) {
			System.err.println("Erro: "+e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	@Override
	public String toString() {
		return "Nome: " + nome + ", Renda: " + Movimento.decimalFormat.format(renda) + ", Situação: " + situacao;
	}
}