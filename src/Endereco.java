public class Endereco {

    private String rua, cep, bairro, cidade;
    private int numero;

    public Endereco() {
    }

    public Endereco(String rua, String cep, String bairro, String cidade, int numero) {
        this.rua = rua;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "-Endereço-\n" +
                "[RUA: " + rua +
                ", CEP: " + cep +
                ", BAIRRO: " + bairro +
                ", CIDADE: " + cidade +
                ", NÚMERO: " + numero+"]";
    }
}
