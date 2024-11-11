abstract public class Conta {

 protected String numero; 

 protected double saldo;

 protected String getNumero ( ) {

     return numero;

 }

 protected void setNumero ( String value ) {

     numero = value;

 }

 protected double getSaldo ( ) {

    return saldo;

 }

 protected void setSaldo ( double value ) {

    saldo = value;

 }

 abstract void creditar (double valor);

 abstract void debitar (double valor);

}

ContaNormal.java

public class ContaNormal extends Conta {

 public void creditar (double valor) {

     saldo = saldo + valor;

 }

 public void debitar (double valor) { 

     if ((saldo-valor) >= 0) {

         saldo = saldo - valor;

     }

 }

}

ContaEspecial.java

abstract public class ContaEspecial extends Conta {

 protected double limite;

 protected void setLimite ( double value ) {

     limite = value;

 }

 protected double getLimite () {

     return limite;

 }

 public void creditar ( double valor) {

     saldo = saldo + valor;

 }

}

ContaDebEspecial.java

public class ContaDebEspecial extends ContaEspecial{

 ContaDebEspecial() {

    super();

 }

 ContaDebEspecial(String n,double s, double l){

     numero = n;

     saldo = s;

     limite = l;

 }

 void debitar (double valor) {

     if ((limite + saldo - valor) >= 0) {

         saldo = saldo - valor;

     }

 }

}

Banco.java

import java.util.*;

public class Banco {

   public static void main (String[] args) {

      Conta c1;

      c1 = new ContaNormal();

      c1.setNumero(new String("1654-3"));

      c1.setSaldo(500);

      ContaDebEspecial c2 = new ContaDebEspecial();

      ContaDebEspecial c3 = new ContaDebEspecial(new String("4067-6"),2500,5050);

      c2.setNumero(new String("4067-6"));

      c2.setSaldo(2500);

      c2.setLimite(1000.67);

      System.out.println("A conta número " + c1.getNumero() + " possui saldo " + c1.getSaldo());

      c1.creditar(1000);

      System.out.println("Após o credito de R$ 1000,00, a conta número " + c1.getNumero() + " passou a ter saldo " + c1.getSaldo());

      c1.debitar(100);

      System.out.println("Após o débito de R$ 100,00, a conta número " + c1.getNumero() + " passou a ter saldo " + c1.getSaldo());

      System.out.println("");

      System.out.println("A conta número " + c2.getNumero() + " possui saldo " + c2.getSaldo());

      c2.debitar(500);

      System.out.println("A conta número " + c2.getNumero() + " possui saldo " + c2.getSaldo() + " Após débito de R$ 500");

      System.out.println("A conta número " + c2.getNumero() + " possui saldo " + c2.getSaldo() + " e Limite de " + c2.getLimite());

      c2.setLimite(10000);

      System.out.println("A conta número " + c2.getNumero() + " possui saldo " + c2.getSaldo() + " e novo Limite de " + c2.getLimite());

   }

}