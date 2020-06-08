package com.example.appsoma.entities;

public class OperacoesSolmef {
    private double pesoInicialFrasco;
    private double pesoFinalFrasco;
    private double diferenca;
    private double pesoAreiaFunil;
    private double pesoFinal;
    private double densidadeAparenteAreia; //1330;
    private double volumeFuro;
    private double pesoSoloUmido;
    private double densidadeUmida;
    private double densidadeSeca;

    public OperacoesSolmef(double pesoInicialFrasco,
                           double pesoFinalFrasco,
                           double diferenca,
                           double pesoAreiaFunil,
                           double pesoFinal,
                           double densidadeAparenteAreia,
                           double volumeFuro,
                           double pesoSoloUmido,
                           double densidadeUmida,
                           double densidadeSeca) {

        this.pesoInicialFrasco = pesoInicialFrasco;
        this.pesoFinalFrasco = pesoFinalFrasco;
        this.diferenca = diferenca;
        this.pesoAreiaFunil = pesoAreiaFunil;
        this.pesoFinal = pesoFinal;
        this.densidadeAparenteAreia = densidadeAparenteAreia;
        this.volumeFuro = volumeFuro;
        this.pesoSoloUmido = pesoSoloUmido;
        this.densidadeUmida = densidadeUmida;
        this.densidadeSeca = densidadeSeca;
    }

    public double getPesoInicialFrasco() {
        return pesoInicialFrasco;
    }

    public void setPesoInicialFrasco(double pesoInicialFrasco) {
        this.pesoInicialFrasco = pesoInicialFrasco;
    }

    public double getPesoFinalFrasco() {
        return pesoFinalFrasco;
    }

    public void setPesoFinalFrasco(double pesoFinalFrasco) {
        this.pesoFinalFrasco = pesoFinalFrasco;
    }

    public double getDiferenca() {
        return diferenca;
    }

    public void setDiferenca(double diferenca) {
        this.diferenca = diferenca;
    }

    public double getPesoAreiaFunil() {
        return pesoAreiaFunil;
    }

    public void setPesoAreiaFunil(double pesoAreiaFunil) {
        this.pesoAreiaFunil = pesoAreiaFunil;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public double getDensidadeAparenteAreia() {
        return densidadeAparenteAreia;
    }

    public void setDensidadeAparenteAreia(double densidadeAparenteAreia) {
        this.densidadeAparenteAreia = densidadeAparenteAreia;
    }

    public double getVolumeFuro() {
        return volumeFuro;
    }

    public void setVolumeFuro(double volumeFuro) {
        this.volumeFuro = volumeFuro;
    }

    public double getPesoSoloUmido() {
        return pesoSoloUmido;
    }

    public void setPesoSoloUmido(double pesoSoloUmido) {
        this.pesoSoloUmido = pesoSoloUmido;
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
