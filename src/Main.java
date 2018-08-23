package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static int COLUNAS = 10;

    public static void main(String[] args) throws IOException
    {
        Arquivo arquivo = new Arquivo();
        BufferedReader buffer = arquivo.Ler("C:\\GIT\\deputies_dataset.csv");
        ArrayList<Deputado> deputados = new ArrayList<Deputado>();
        Recibo recibo;
        String separador = ",", linha;
        int deputyId;
        Boolean header = true;

        while((linha = buffer.readLine()) != null)
        {
            if (header || linha.trim().isEmpty())
            {
                header = false;
                continue;
            }

            String[] colunas = linha.split(separador, COLUNAS);

            if (colunas.length != COLUNAS)
            {
                try
                {
                    throw new Exception("Colunas a mais !");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            try
            {
                //if(deputyId == Integer.parseInt(colunas[2]))
                    recibo = new Recibo(colunas[1], colunas[6], colunas[8], colunas[7], Integer.parseInt(colunas[9]));
                deputados.add(new Deputado(colunas[5], colunas[3], colunas[4], Integer.parseInt(colunas[2]),  Integer.parseInt(colunas[0]), recibo));

                deputyId = Integer.parseInt(colunas[2]);
            }
            catch (Exception e)
            {

            }
        }
    }
}
