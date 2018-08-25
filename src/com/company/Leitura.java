package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leitura
{

    private Arquivo arquivo;

    public Leitura(Arquivo a)
    {
        this.arquivo = a;
    }

    public ArrayList<Integer> getColumnValueInBufferFile(int columnsQuantityInALine) throws IOException {
        String line;
        String separador = ";";
        Boolean header = true;
        ArrayList<Integer> values = new ArrayList<Integer>();
        BufferedReader buffer = arquivo.Ler();

        try
        {
            while((line = buffer.readLine()) != null)
            {
                if (header || line.trim().isEmpty())
                {
                    header = false;
                    continue;
                }

                String[] columns = line.split(separador, columnsQuantityInALine);

                if(!this.columnsLengthIsInvalid(columns.length, columnsQuantityInALine))
                {
                    values.add(Integer.parseInt(columns[9]));
                }
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        finally
        {
            arquivo.Fecha();
        }

        return values;
    }

    private void setHeaderExists(boolean header, String line)
    {
        if (header || line.trim().isEmpty())
        {
            header = false;
        }
    }

    private boolean columnsLengthIsInvalid(int quantityColumns, int originalQuantityColumnsInALine)
    {
        if (quantityColumns > originalQuantityColumnsInALine)
            return true;

        else if(quantityColumns < originalQuantityColumnsInALine)
            return true;

        return false;
    }

//    try
//    {
//        //Recibo recibo = new Recibo(colunas[1], colunas[6], colunas[8], colunas[7], Integer.parseInt(colunas[9]));
//        //Deputado deputado = new Deputado(colunas[5], colunas[3], colunas[4], Integer.parseInt(colunas[2]),  Integer.parseInt(colunas[0]), recibo);
//        //deputados.add(deputado);
//    }
//                catch (Exception e)
//    {
//        e.getMessage();
//    }
}
