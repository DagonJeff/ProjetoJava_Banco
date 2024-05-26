abstract class Pessoa {

	private String nome;
	private double renda;
	private int situacao;
	private Endereco endereco;

	public Pessoa() {
	}

	public Pessoa(String nome, double renda, int situacao, Endereco endereco) {
		this.nome = nome;
		this.renda = renda;
		this.situacao = situacao;
		this.setEndereco(endereco);
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

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", Renda: " + renda + ", Situacao: " + situacao;
	}
}