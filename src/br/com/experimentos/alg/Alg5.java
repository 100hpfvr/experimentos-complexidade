package br.com.experimentos.alg;

public final class Alg5 {
    private Alg5() {}
    public static long run(int n) {
        long cont = 0L;
        int res = 0;
        for (int i = n / 2; i <= n; i += 3) {
            for (long j = i; j <= 1L * i * i; j += 2) {
                for (long k = i; k <= 2L * j; k += 1L) {
                    res = res + (n + (int) j);
                    cont++;
                }
            }
        }
        return cont;
    }
}
