package com.company;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static int COLUNAS = 10;

    public static void main(String[] args) throws IOException
    {
        Arquivo arquivo = new Arquivo();
        Leitura leitura = new Leitura(arquivo);

        //BufferedReader buffer = arquivo.Ler();
        //ArrayList<Deputado> deputados = new ArrayList<Deputado>();
        Sort sort = new Sort();
        //sort.InsertionSort(leitura.getColumnValueInBufferFile(10));

    }
}
