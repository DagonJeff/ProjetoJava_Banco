package Enums;

public class Enums {

	public enum Tipos {

		SAQUE(1), DEPOSITO(2), TRANSFERENCIA(3);

		private final int valor;

		private Tipos(int valor) {
			this.valor = valor;

		}

		public int getValor() {
			return valor;
		}

	}

	public enum Situacao {

		ATIVA(1), INATIVA(0);

		private final int valor;

		private Situacao(int valor) {
			this.valor = valor;
		}
		
		public int getValor() {
			return valor;
		}

	}
	

}
