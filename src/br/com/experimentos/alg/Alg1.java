package br.com.experimentos.alg;

public final class Alg1 {
    private Alg1() {}
    public static long run(int n) {
        long cont = 0L;
        int res = 0;
        for (int i = 1; i <= n * n; i += 1) {
            for (int j = 1; j <= i; j += 2) {
                long step = (long) i * (long) j;
                if (step <= 0) break; // proteção contra overflow
                for (long k = n + 1L; k <= 2L * i; k += step) {
                    res = res + (int) (k + 1);
                    cont++;
                }
            }
        }
        return cont;
    }
}
