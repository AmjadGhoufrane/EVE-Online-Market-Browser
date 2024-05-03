package com.mycompany.eveonlinemarket;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;




public class EveItemTypeStore {

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
        String nom_fichier = "";
        typeItem[] tab = new typeItem[compteTypes(nom_fichier)];
        try
        {
            FileInputStream file = new FileInputStream(nom_fichier);
            Scanner scanner = new Scanner(file);
            int i = 0;
            while(scanner.hasNextLine())
            {
                String cour=scanner.nextLine();
                String[] split_cour=cour.split(";");
                // 0typeID; 1groupID; 2typeName; 3description; 4mass; 5volume; 6capacity; 7portionSize; 8raceID; 9basePrice; 10published; 11marketGroupID; 12iconID; 13soundID; 14graphicID
                tab[i]=new typeItem(Integer.parseInt(split_cour[0]),Integer.parseInt(split_cour[1]),split_cour[2],split_cour[3]
                        ,Double.parseDouble(split_cour[4]),Double.parseDouble(split_cour[5]),Double.parseDouble(split_cour[6])
                        ,Integer.parseInt(split_cour[7]),Integer.parseInt(split_cour[8]),Double.parseDouble(split_cour[9])
                        ,Integer.parseInt(split_cour[10]),Integer.parseInt(split_cour[11]),Integer.parseInt(split_cour[12]),Integer.parseInt(split_cour[13]),Integer.parseInt(split_cour[14]));
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

}
