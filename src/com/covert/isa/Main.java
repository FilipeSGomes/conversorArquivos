package com.covert.isa;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    static String nomeArq;
    static int posicaoInicial = 0, posicaoFinal = 0, index = 0, indexD = 0;
    static String nomeTabelaFilha = "";
    static String caminhoSaida = "";
    static String titulo = "Conversion Txt -> Excel";

    public static void main(String[] args) throws FileNotFoundException {
        JOptionPane.showMessageDialog(null, "Seja bem vinda", titulo, 1);
        escolherArquivos(nomeArq);
        PrintStream saida = new PrintStream(new File(caminhoSaida));
        System.setOut(saida);

        try {
            FileReader arq = new FileReader(nomeArq);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha;
            JOptionPane.getRootFrame();


            while (lerArq.ready()) {
                String text = new String(lerArq.readLine().getBytes(), StandardCharsets.UTF_8);
                System.out.println(text);
            }
            arq.close();
            JOptionPane.showMessageDialog(null, "Muito Obrigado, Concluído com Sucesso", titulo, 1);
        } catch (IOException e) {
            JOptionPane.showInputDialog("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }
    public static String escolherArquivos(String entrada) {
        File[] arquivos = null;
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Escolha o arquivo para Conversão");
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setApproveButtonText("Ok");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(true);
        int resultado = fc.showOpenDialog(fc);
        if (resultado == JFileChooser.CANCEL_OPTION) {
            System.exit(1);
        }
        arquivos = fc.getSelectedFiles();
        for (File f : arquivos) {
            nomeArq = (f.getParentFile() + "\\" + f.getName());
            String nameFile = f.getName().replace(".", "")+".xslx";
            caminhoSaida = (f.getParentFile() + "\\Modificado_" + nameFile );
        }
        return null;
    }

}
