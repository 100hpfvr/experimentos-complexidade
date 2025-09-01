package br.com.experimentos.alg;

public final class Alg3 {
    private Alg3() {}
    public static long run(int n) {
        long cont = 0L;
        int res = 0;
        for (int i = 1; i <= n * n; i += 2) {
            long jStart = i / 2L;
            long jStep = i / 2L + 1L;
            for (long j = jStart; j <= 2L * i; j += jStep) {
                // k tem passo dependente de k (k/2 + 1), sempre cresce
                for (long k = j + 1L; k <= n + j; k += (k / 2L + 1L)) {
                    res = res + (int) Math.abs(j - i);
                    cont++;
                }
            }
        }
        return cont;
    }
}
