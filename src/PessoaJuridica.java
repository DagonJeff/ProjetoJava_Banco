public class PessoaJuridica extends Pessoa {
	
    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, double renda, int situacao, Endereco endereco, String cnpj) {
        super(nome, renda, situacao, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

	@Override
	public String toString() {
		return "-Pessoa Jurídica-\n["
				+ super.toString()+
				", CNPJ: " + cnpj +"]";	
	}
}
