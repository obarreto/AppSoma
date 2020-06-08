package com.example.appsoma.entities;

public class OperacoesInSitu {
   // private double determinacao; //scc 064
    private double volumeCilindro; //998;
    private double pesoCilindro;//997;
    private double pesoCilindroSoloUmido;
    private double soloUmido;
    private double densidadeUmida;
    private double densidadeSeca;


    public OperacoesInSitu(double volumeCilindro, double pesoCilindro, double pesoCilindroSoloUmido, double soloUmido, double densidadeUmida, double densidadeSeca) {
       // this.determinacao = determinacao;
        this.volumeCilindro = volumeCilindro;
        this.pesoCilindro = pesoCilindro;
        this.pesoCilindroSoloUmido = pesoCilindroSoloUmido;
        this.soloUmido = soloUmido;
        this.densidadeUmida = densidadeUmida;
        this.densidadeSeca = densidadeSeca;
    }

   /* public double getDeterminacao() {
        return determinacao;
    }

    public void setDeterminacao(double determinacao) {
        this.determinacao = determinacao;
    }*/

    public double getVolumeCilindro() {
        return volumeCilindro;
    }

    public void setVolumeCilindro(double volumeCilindro) {
        this.volumeCilindro = volumeCilindro;
    }

    public double getPesoCilindro() {
        return pesoCilindro;
    }

    public void setPesoCilindro(double pesoCilindro) {
        this.pesoCilindro = pesoCilindro;
    }

    public double getPesoCilindroSoloUmido() {
        return pesoCilindroSoloUmido;
    }

    public void setPesoCilindroSoloUmido(double pesoCilindroSoloUmido) {
        this.pesoCilindroSoloUmido = pesoCilindroSoloUmido;
    }

    public double getSoloUmido() {
        return soloUmido;
    }

    public void setSoloUmido(double soloUmido) {
        this.soloUmido = soloUmido;
    }

    public double getDensidadeUmida() {
        return densidadeUmida;
    }

    public void setDensidadeUmida(double densidadeUmida) {
        this.densidadeUmida = densidadeUmida;
    }

    public double getDensidadeSeca() {
        return densidadeSeca;
    }

    public void setDensidadeSeca(double densidadeSeca) {
        this.densidadeSeca = densidadeSeca;
    }
}
