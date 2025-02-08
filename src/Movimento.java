import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import Enums.Enums.Tipos;

public class Movimento {


	private LocalDate dataMovimentacao;
	private LocalTime horaMovimentacao;
	private double valor;
	private Tipos tipoEnum;
	static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"),
			timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	static DecimalFormat decimalFormat = new DecimalFormat("#.00");


	public Movimento() {
		super();
	}

	public Movimento(int tipo, LocalDate dataMovimentacao, LocalTime horaMovimentacao, double valor) {
		super();
		try {
			this.setTipoEnum(tipo);
		} catch (IllegalArgumentException e) {

			System.err.println("Erro: "+e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		this.dataMovimentacao = dataMovimentacao;
		this.horaMovimentacao = horaMovimentacao;
		this.valor = valor;
	}


	public double getValor() {
		return valor;
	}

	public Tipos getTipoEnum() {
		return tipoEnum;
	}

	public void setTipoEnum(int tipo){

		if (tipo == Tipos.SAQUE.getValor()) {

			this.tipoEnum = Tipos.SAQUE;

		} else if (tipo == Tipos.DEPOSITO.getValor()) {

			this.tipoEnum = Tipos.DEPOSITO;

		} else if (tipo == Tipos.TRANSFERENCIA.getValor()) {

			this.tipoEnum = Tipos.TRANSFERENCIA;
		} else

			throw new IllegalArgumentException("Valor inválido para atributo 'Tipo'");
	}

	@Override
	public String toString() {
		return "Tipo: " + tipoEnum + ", Data: " + dataMovimentacao.format(dateFormatter) + ", Hora: "
				+ horaMovimentacao.format(timeFormatter) + ", Valor: " + decimalFormat.format(valor);
	}

}
