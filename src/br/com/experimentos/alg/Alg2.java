package br.com.experimentos.alg;

public final class Alg2 {
    private Alg2() {}
    public static long run(int n) {
        long cont = 0L;
        int res = 0;
        for (int i = n; i <= n; i += i / 2 + 1) {
            for (long j = i / 2L; j <= 1L * i * i; j += i + 1L) {
                for (long k = n; k <= 2L * n; k += i + 1L) {
                    res = res + n;
                    cont++;
                }
            }
        }
        return cont;
    }
}
