package zemberek.examples.normalization;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import zemberek.core.logging.Log;
import zemberek.morphology.TurkishMorphology;
import zemberek.normalization.TurkishSpellChecker;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SpellingExamples {

  public static void main(String[] args) throws IOException {
    int dongu=0;
      
 List<String> Liste_2 = new ArrayList<String>();
 List<String> Liste_3 = new ArrayList<String>();
  List<String> Liste_4 = new ArrayList<String>();
  BufferedReader eko_br=  new BufferedReader(new InputStreamReader( new FileInputStream("C:\\Users\\SİNEM\\Desktop\\1150haber\\EğitimMagazinAll.txt"),  "ISO-8859-9"));
  PrintWriter yaz = new PrintWriter("C:\\Users\\SİNEM\\Desktop\\yenisi.txt");
 TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
 TurkishSpellChecker spellChecker = new TurkishSpellChecker(morphology);
StringBuilder stryapici2 = new StringBuilder();
StringBuilder stryapici = new StringBuilder();
 String dizi[]=new String[90000];

String line = eko_br.readLine();
while((line)!=null){
    Liste_2.add(line);
    
//    dizi=line.split(" ");
    line = eko_br.readLine();


}



 for (int i = 0; i < Liste_2.size(); i++) {
     if(Liste_2.get(i)!=null){
     dizi=Liste_2.get(i).toString().split(" ");
  for (int j = 0; j< dizi.length; j++) {
         Liste_3.add(dizi[j].toString());
  }
     }else{
     i++;
     }
         
      }
// for (int i = 0; i <Liste_3.size(); i++) {
//          System.out.println(Liste_3.get(i));
//
// }
      

     


//      for (int i = 0; i < Liste_2.size(); i++) {
//        Liste_3.add(Liste_2.get(i).split(" ").toString());
//     
//      }
//   
//           for (int i = 0; i < Liste_3.size(); i++) {
////        
//System.out.println(Liste_3.get(i).toString());}

      
  
 int deger=Liste_3.size()-1;
    Log.info("KELİMELER DÜZELTİLİYOR");  
 for (String s : Liste_3) {
   
 if(spellChecker.check(s)) {
  
  Liste_4.add(s);
   }
    
     
     
  else {
//          Log.info(s + " -> " +spellChecker.check(s)+"-----" +spellChecker.suggestForWord(s).get(0));
   Liste_4.add(spellChecker.suggestForWord(s).get(0)+" ");
  
        } 
      
       System.out.println(Liste_4);
    }
     
          
      }

  }

    



