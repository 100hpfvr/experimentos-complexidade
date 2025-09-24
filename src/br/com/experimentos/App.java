package br.com.experimentos;

import br.com.experimentos.core.AlgFn;
import br.com.experimentos.models.Resultado;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class App {

    public static Resultado medir(String nome, AlgFn fn, int n) {
        long t0 = System.nanoTime();
        long ops = fn.run(n);
        long t1 = System.nanoTime();
        long ms = (t1 - t0) / 1_000_000;
        return new Resultado(nome, n, ops, ms);
    }

    public static void main(String[] args) {
        List<Integer> nsAlg1 = Arrays.asList(5, 10, 20, 30, 40);
        List<Integer> nsAlg2 = Arrays.asList(100, 500, 1000, 2000, 5000);
        List<Integer> nsAlg3 = Arrays.asList(4, 6, 8, 10, 12);
        List<Integer> nsAlg4 = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> nsAlg5 = Arrays.asList(5, 10, 15, 20, 25);


        Map<String, AlgFn> algs = new LinkedHashMap<>();
        algs.put("alg1", br.com.experimentos.alg.Alg1::run);
        algs.put("alg2", br.com.experimentos.alg.Alg2::run);
        algs.put("alg3", br.com.experimentos.alg.Alg3::run);
        algs.put("alg4", br.com.experimentos.alg.Alg4::run);
        algs.put("alg5", br.com.experimentos.alg.Alg5::run);

        Map<String, List<Integer>> nsPorAlg = new LinkedHashMap<>();
        nsPorAlg.put("alg1", nsAlg1);
        nsPorAlg.put("alg2", nsAlg2);
        nsPorAlg.put("alg3", nsAlg3);
        nsPorAlg.put("alg4", nsAlg4);
        nsPorAlg.put("alg5", nsAlg5);

        String outFile = null;
        for (int i = 0; i < args.length; i++) {
            if ("--out".equals(args[i]) && i + 1 < args.length) {
                outFile = args[i + 1];
                break;
            }
        }

        java.io.File dadosDir = new java.io.File("dados");
        if (!dadosDir.exists()) {
            boolean created = dadosDir.mkdirs();
            if (!created) {
                System.err.println("Não foi possível criar a pasta 'dados'. Os resultados serão impressos no console e/ou no caminho passado em --out.");
            }
        }
        String defaultCsvPath = new java.io.File(dadosDir, "resultados.csv").getPath();

        PrintWriter out = null;
        PrintWriter outDados = null;
        try {
            if (outFile != null) {
                out = new PrintWriter(outFile);
            } else {
                out = new PrintWriter(System.out);
            }
            outDados = dadosDir.exists() ? new PrintWriter(defaultCsvPath) : null;

            // Cabeçalho CSV
            String header = "algoritmo;n;cont_op;tempo_ms";
            out.println(header);
            if (outDados != null) outDados.println(header);

            for (Map.Entry<String, AlgFn> e : algs.entrySet()) {
                String nome = e.getKey();
                AlgFn fn = e.getValue();
                for (int n : nsPorAlg.get(nome)) {
                    Resultado r = medir(nome, fn, n);
                    String line = r.toCsv();
                    out.println(line);
                    if (outDados != null) outDados.println(line);
                }
            }

            if (!(out == null) && (out != new PrintWriter(System.out))) {
                System.out.println("Arquivo gerado: " + (outFile != null ? outFile : "(stdout)"));
            }
            if (outDados != null) {
                System.out.println("Arquivo gerado na pasta 'dados': " + defaultCsvPath);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Erro ao abrir arquivo de saída: " + ex.getMessage());
        } finally {
            if (out != null && out != new PrintWriter(System.out)) {
                out.flush();
                out.close();
            }
            if (outDados != null) {
                outDados.flush();
                outDados.close();
            }
        }
    }
}
