package com.example.appsoma.entities;

import java.io.Serializable;

public class OperacoesSolib implements Serializable {

    private double pesoCapsula;
    private double pesoCapsulaSoloUmido;
    private double pesoCapsulaSoloSeco;
    private double pesoAguaMa;
    private double pesoSoloSecoMs;
    private double umidade;
    private double fatorConversao;

    public OperacoesSolib(
                double pesoCapsula,
                double pesoCapsulaSoloUmido,
                double pesoCapsulaSoloSeco,
                double pesoAguaMa,
                double pesoSoloSecoMs,
                double umidade,
                double fatorConversao
    ){
        this.pesoCapsula          = pesoCapsula;
        this.pesoCapsulaSoloUmido = pesoCapsulaSoloUmido;
        this.pesoCapsulaSoloSeco  = pesoCapsulaSoloSeco;
        this.pesoAguaMa           = pesoAguaMa;
        this.pesoSoloSecoMs       = pesoSoloSecoMs;
        this.umidade              = umidade;
        this.fatorConversao       = fatorConversao;
    }

    public double getPesoCapsula() {
        return pesoCapsula;
    }

    public void setPesoCapsula(double pesoCapsula) {
        this.pesoCapsula = pesoCapsula;
    }

    public double getPesoCapsulaSoloUmido() {
        return pesoCapsulaSoloUmido;
    }

    public void setPesoCapsulaSoloUmido(double pesoCapsulaSoloUmido) {
        this.pesoCapsulaSoloUmido = pesoCapsulaSoloUmido;
    }

    public double getPesoCapsulaSoloSeco() {
        return pesoCapsulaSoloSeco;
    }

    public void setPesoCapsulaSoloSeco(double pesoCapsulaSoloSeco) {
        this.pesoCapsulaSoloSeco = pesoCapsulaSoloSeco;
    }

    public double getPesoAguaMa() {
        return pesoAguaMa;
    }

    public void setPesoAguaMa(double pesoAguaMa) {
        this.pesoAguaMa = pesoAguaMa;
    }

    public double getPesoSoloSecoMs() {
        return pesoSoloSecoMs;
    }

    public void setPesoSoloSecoMs(double pesoSoloSecoMs) {
        this.pesoSoloSecoMs = pesoSoloSecoMs;
    }

    public double getUmidade() {
        return umidade;
    }

    public void setUmidade(double umidade) {
        this.umidade = umidade;
    }

    public double getFatorConversao() {
        return fatorConversao;
    }

    public void setFatorConversao(double fatorConversao) {
        this.fatorConversao = fatorConversao;
    }
}

