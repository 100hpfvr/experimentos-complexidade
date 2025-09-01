package br.com.experimentos.alg;

public final class Alg4 {
    private Alg4() {}
    public static long run(int n) {
        long cont = 0L;
        int res = 0;
        for (int i = 1; i <= n * n; i += 2) {
            for (long j = 2; j <= n + 1L; j += i + 1L) {
                long kStart = j / 2L;
                long kStep  = j / 2L + 1L;
                for (long k = kStart; k <= i + 1L; k += kStep) {
                    res = res + (int) (j + 1);
                    cont++;
                }
            }
        }
        return cont;
    }
}
