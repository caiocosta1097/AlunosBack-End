package br.com.senaijandira.alunos.util;

public class DateUtil {

    public int convertToInt(String data){

        String[] dataSplit = data.split("/");

        String dia = dataSplit[0];
        String mes = dataSplit[1];
        String ano = dataSplit[2];

        String dataFormatada = ano + mes + dia;



        return Integer.parseInt(dataFormatada);
    }

    public int convetDate(String data){

        String[] datadataSplit;

        String dia = data.substring(6, 7);
        String mes = data.substring(4, 5);
        String ano = data.substring(0, 3);

        String dataFormatada = dia + "/" + mes + "/" + ano;

        return Integer.parseInt(dataFormatada);

    }

}
