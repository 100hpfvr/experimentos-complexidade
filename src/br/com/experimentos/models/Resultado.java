package br.com.experimentos.models;

public final class Resultado {
    public final String algoritmo;
    public final int n;
    public final long contOp;
    public final long tempoMs;
    public Resultado(String algoritmo, int n, long contOp, long tempoMs) {
        this.algoritmo = algoritmo;
        this.n = n;
        this.contOp = contOp;
        this.tempoMs = tempoMs;
    }
    public String toCsv() {
        return algoritmo + ";" + n + ";" + contOp + ";" + tempoMs;
    }
}
