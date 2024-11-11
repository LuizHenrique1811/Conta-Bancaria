ContaNormal.java

package banco;

public class ContaNormal extends Conta {

	 public void debitar (double valor) { 

	   if ((saldo-valor) >= 0) {

	     saldo = saldo - valor;

	   }

	 }

}