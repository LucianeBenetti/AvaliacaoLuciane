package com.example.avaliacaoluciane.Model;

public class ConfigBO {

    public static boolean valida(Config c){
        return c.getMinimo()!=null && c.getMaximo()!=null && c.getMaximo()>=c.getMinimo();
    }
    public Integer media (Config c){

        Integer media = (c.getMinimo() + c.getMaximo())/2;

        return media;
    }


}
