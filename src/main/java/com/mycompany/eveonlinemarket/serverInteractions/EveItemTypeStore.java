package com.mycompany.eveonlinemarket.serverInteractions;

import com.mycompany.eveonlinemarket.types.typeItem;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;




public class EveItemTypeStore {
    HashMap<Integer, typeItem> types = new HashMap<Integer, typeItem>();

    public int compteTypes (String nom_fichier){
        int cpt=0;
        try
        {
            FileInputStream file = new FileInputStream(nom_fichier);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine())
            {
                cpt++;
                scanner.nextLine();
            }
            scanner.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return cpt;
    }

    public typeItem[] chargerTypes (){
        String nom_fichier = "invtTypes_nodesc.csv";
        typeItem[] tab = new typeItem[compteTypes(nom_fichier)];
        try
        {
            FileInputStream file = new FileInputStream(nom_fichier);
            Scanner scanner = new Scanner(file);
            int i = 0;
            String cour=scanner.nextLine();
            while(scanner.hasNextLine())
            {
                cour=scanner.nextLine();
                String[] split_cour=cour.split(";");
                // 0typeID; 1groupID; 2typeName; 3description; 4mass; 5volume; 6capacity; 7portionSize; 8raceID; 9basePrice; 10published; 11marketGroupID; 12iconID; 13soundID; 14graphicID
                this.types.put(parseIntn(split_cour[0]),new typeItem(parseIntn(split_cour[0]),parseIntn(split_cour[1]),split_cour[2],split_cour[3]
                        ,parseDoublen(split_cour[4]),parseDoublen(split_cour[5]),parseDoublen(split_cour[6])
                        ,parseIntn(split_cour[7]),parseIntn(split_cour[8]),parseDoublen(split_cour[9])
                        ,parseIntn(split_cour[10]),parseIntn(split_cour[11]),parseIntn(split_cour[12])
                        ,parseIntn(split_cour[13]),parseIntn(split_cour[14])));
                i++;
            }
            scanner.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return tab;
    }

    public EveItemTypeStore() {
        this.chargerTypes();
    }

    public String getItemNameByTypeId(int id){
        typeItem t = types.get((Integer) id);
        if(t==null){
            return "0";
        }
        return t.getTypeName();
    }

    public typeItem gettypeItembyId(int id){
        return types.get((Integer) id);
    }

    private int parseIntn(String s){
        try{   // Fuck around
            int a = Integer.parseInt(s);
            return a;

        }
        catch(NumberFormatException nfe){   // Find out
            return 0;
        }
    }

    private double parseDoublen(String s){
        try{
            double a = Double.parseDouble(s);
            return a;

        }
        catch(Exception e){
            return 0.0;
        }
    }
}
