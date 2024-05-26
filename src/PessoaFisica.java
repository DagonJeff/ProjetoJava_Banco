public class PessoaFisica extends Pessoa {
	
    private String cpf, rg;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, double renda, int situacao, Endereco endereco, String cpf, String rg) {
        super(nome, renda, situacao, endereco);
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

	@Override
	public String toString() {
		return "-Pessoa Fisica-\n["
				+ super.toString()+
				", CPF: " + cpf +
				", RG: " + rg +"]";	
	}
    
    
}
