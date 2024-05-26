import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Movimento {

//	private Tipo tipo;
	private int tipo;
	private LocalDate dataMovimentacao;
	private LocalTime horaMovimentacao;
	private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"), timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	private double valor;

//	public enum Tipo {
//
//		SAQUE(1), DEPOSITO(2), TRANSFERENCIA(3);
//
//		private final int valor;
//
//		private Tipo(int valor) {
//			this.valor = valor;
//
//		}
//
//		public int getValor() {
//			return valor;
//		}
//
//	}

	public Movimento() {
		super();
	}


	public Movimento(int tipo, LocalDate dataMovimentacao , LocalTime horaMovimentacao, double valor) {
		super();
		this.tipo = tipo;
		this.dataMovimentacao = dataMovimentacao;
		this.horaMovimentacao = horaMovimentacao;
		this.valor = valor;
	}

	public int getTipo() {
		return tipo;
	}


//	public Movimento(Movimento.Tipo tipo, String dataMovimentacao, String horaMovimentacao, double valor) {
//		super();
//		this.tipo = tipo;
//		this.dataMovimentacao = dataMovimentacao;
//		this.horaMovimentacao = horaMovimentacao;
//		this.valor = valor;
//	}


	public double getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Tipo: " + tipo + ", Data: " + dataMovimentacao.format(dateFormatter)
				+ ", Hora: " + horaMovimentacao.format(timeFormatter) + ", Valor: " + valor;
	}
	
//	public static void main(String[] args) {
//		Movimento mov = new Movimento(1, LocalDate.of(2023, 0, 0), null, 0);
//	}

}
