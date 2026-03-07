package br.com.carlossantos.model;

public class Endereco {

    private Integer id;
    private String rua;
    private int numero;
    private String bairro;

    public Endereco() {
        this.id = 0;
        this.rua = "";
        this.numero = 0;
        this.bairro = "";
    }

    public Endereco(String rua, int numero, String bairro) {
        this.id = 0;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}