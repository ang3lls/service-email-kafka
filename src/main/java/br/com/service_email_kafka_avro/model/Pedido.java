package br.com.service_email_kafka_avro.model;

public class Pedido {

    private Integer id;
    private String nome;
    private String email;
    private String cpf;
    private Float valorTotal;

    public Pedido() {
    }

    public Pedido(Integer id, String nome, String email, String cpf, Float valorTotal) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
