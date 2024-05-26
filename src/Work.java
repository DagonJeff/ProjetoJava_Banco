import java.time.LocalDate;

import Exceptions.DesativadaException;
import Exceptions.SaldoInsuficienteException;

public class Work {
	
	public static void main(String[] args) {
		
		Pessoa p1 = new PessoaFisica("aaa", 2000, 1, null, "22536336", "555555");
	
		
		System.out.println(p1);
		
		Conta c1 = new Conta(96696, "25265", LocalDate.now(), LocalDate.of(2030, 12, 31), 1, 66690, p1);
		
		Conta c2 = new Conta(89652, "69875", LocalDate.now(), LocalDate.of(2027, 3, 15), 1, 1000, p1);
		try {
			c1.sacar(60);
		} catch (DesativadaException | SaldoInsuficienteException e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
		}
		try {
			c1.depositar(1000);
		} catch (DesativadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println(e.getMessage());
		}
		try {
			c1.sacar(9666);
		} catch (DesativadaException | SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println(e.getMessage());
		}
		try {
			c1.transferir(6666666.90, c2);
		} catch (DesativadaException | SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		try {
			c1.sacar(1000);
		} catch (DesativadaException | SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println(e.getMessage());
		}
		try {
			c1.depositar(666);
		} catch (DesativadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println(e.getMessage());
		}
		try {
			c1.transferir(60, c2);
		} catch (DesativadaException | SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		c1.imprimir();
		c2.imprimir();
		
		System.out.println(c1);
		System.out.println(c2);
		
	}

}
