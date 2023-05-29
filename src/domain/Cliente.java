package domain;

import javax.sound.midi.Soundbank;

public class Cliente {
    public Cliente(int id, String nome, int agencia, int conta, double saldo) {
        Id = id;
        Nome = nome;
        Agencia = agencia;
        Conta = conta;
        Saldo = saldo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getAgencia() {
        return Agencia;
    }

    public void setAgencia(int agencia) {
        Agencia = agencia;
    }

    public int getConta() {
        return Conta;
    }

    public void setConta(int conta) {
        Conta = conta;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }


    public void Transferir(double valor){
        if(valor>Saldo || valor < 0){
            System.out.println("Não foi possível realizar a transferência. Verifique seu saldo ou valor a ser transferido.");
        }
        else {
            Saldo -= valor;
        }
    }
    public void Depositar(double valor){
        if(valor<0){
            System.out.println("Não foi possível realizar o depósito. Valor incompatível com a operação.");
        }
        else {
            Saldo += valor;
        }
    }
    public void Sacar(double valor){
        if(valor <0){
            System.out.println("Não foi possível realizar o saque. Valor incompatível com a operação.");
        }
        else if(valor > Saldo){
            System.out.println("Não foi possível realizar o depósito. Saldo insulficiente.");
        }
        else {
            Saldo -= valor;
        }
    }
    private int Id;
    private String Nome;
    private int Agencia;
    private int Conta;
    private double Saldo;



}
