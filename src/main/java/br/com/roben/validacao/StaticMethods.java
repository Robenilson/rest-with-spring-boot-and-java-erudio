package br.com.roben.validacao;

public class StaticMethods {



    public static    boolean isNumeric( String strNumeric){

        if (strNumeric == null ) return  false;
        String  number= strNumeric.replaceAll(",",".");
        return  number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static   Double covertToDouble( String strNumeric){
        if( strNumeric == null ) return  0D;
        String  number= strNumeric.replaceAll(",",".");
        if (isNumeric(number)) return  Double.parseDouble(number);
        return  0D;
    }





}
