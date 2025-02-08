import java.time.LocalDate;

import javax.swing.JOptionPane;
import Exceptions.DesativadaException;
import Exceptions.SaldoInsuficienteException;

public class Work {

	public static void main(String[] args) {

		Endereco e1 = new Endereco("rua 1", "55693-666", "Novo", "Coxixola", 69);
		Endereco e2 = new Endereco("rua 6", "56982-690", "Velho", "linhares", 6);

		Pessoa pf = new PessoaFisica("João", 2000, 1, e1, "22536336", "555555");
		Pessoa pj = new PessoaJuridica("Claudemir", 6000, 1, e2, "5569.6966.99966-96");


		Conta c1 = new Conta(96696, "25265", LocalDate.now(), LocalDate.of(2030, 12, 31), 1, 150, pf);

		Conta c2 = new Conta(89652, "69875", LocalDate.now(), LocalDate.of(2027, 5, 25), 1, 1000, pj);

		try {
			c1.depositar(500);
		} catch (DesativadaException e) {
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "FALHA", JOptionPane.ERROR_MESSAGE);
		}

		try {
			c1.depositar(500);
		} catch (DesativadaException e) {

			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "FALHA", JOptionPane.ERROR_MESSAGE);

		}

		try {
			c1.sacar(200);
		} catch (DesativadaException | SaldoInsuficienteException e) {

			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "FALHA", JOptionPane.ERROR_MESSAGE);

		}

		try {
			c1.sacar(200);
		} catch (DesativadaException | SaldoInsuficienteException e) {

			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "FALHA", JOptionPane.ERROR_MESSAGE);

		}

		try {
			c2.depositar(1000);
		} catch (DesativadaException e) {

			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "FALHA", JOptionPane.ERROR_MESSAGE);

		}
		try {
			c2.depositar(1000);
		} catch (DesativadaException e) {

			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "FALHA", JOptionPane.ERROR_MESSAGE);

		}

		try {
			c2.transferir(500, c1);
		} catch (DesativadaException | SaldoInsuficienteException e) {

			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "FALHA", JOptionPane.ERROR_MESSAGE);


		}
		try {
			c2.transferir(500, c1);
		} catch (DesativadaException | SaldoInsuficienteException e) {

			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "FALHA", JOptionPane.ERROR_MESSAGE);


		}

		c1.imprimir();
		c2.imprimir();
		
		
		 try {
			c1.transferir(6666666.90, c2);
		} catch (DesativadaException | SaldoInsuficienteException e) {

			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage(), "FALHA", JOptionPane.ERROR_MESSAGE);

		}

//		System.out.println(c1);
//		System.out.println(c2);
		 
		 System.out.println(pf.getEndereco());
		 System.out.println(pj.getEndereco());

	}

}
