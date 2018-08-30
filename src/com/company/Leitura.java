package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leitura <T>
{
    private Arquivo arquivo;
    private String separador = ";";
    private BufferedReader buffer;

    public Leitura(Arquivo a) throws IOException {
        this.arquivo = a;
        this.buffer = arquivo.Obter();
    }

    public T getDeputityInfos(int description) throws IOException {

        Boolean header = true;
        String line;

        try
        {
            while((line = buffer.readLine()) != null)
            {
                if (header || line.trim().isEmpty())
                {
                    header = false;
                    continue;
                }

                String[] columns = line.split(separador, 10);

                if(!this.columnsLengthIsInvalid(columns.length, 10))
                {
                    if(description == 1)
                    {
                        int id = Integer.parseInt(columns[2]);
                        Registro r = new Registro(columns, id);
                    }
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

        return null;
    }

    /**
     * getReceiptValues recebe como parametro a quantidade de colunas que um arquivo pode ter
     * @type int
     * @return ArrayList<Integer>
     * */

    public Integer[] getReceiptValues(int columnsQuantityInALine) throws IOException {
        Boolean header = true;
        String line;

        ArrayList<Integer> values = new ArrayList<Integer>();

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

        return values.toArray(new Integer[values.size()]);
    }

    private boolean columnsLengthIsInvalid(int quantityColumns, int originalQuantityColumnsInALine)
    {
        if (quantityColumns > originalQuantityColumnsInALine)
            return true;

        else if(quantityColumns < originalQuantityColumnsInALine)
            return true;

        return false;
    }

}
