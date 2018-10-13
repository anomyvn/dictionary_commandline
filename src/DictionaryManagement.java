



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryManagement {

    public Dictionary dictionary;

    public DictionaryManagement(){
        dictionary = new Dictionary();
    }

    public void InsertfromCommandline(){
        System.out.println("Nhập vào bàn phím số lượng từ vựng");
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        String word=reader.nextLine();
        for (int i=0;i<n;i++){

            word=reader.nextLine();
            word=word.toLowerCase();

            String word_target = word.substring(0,word.indexOf('\t'));
            String word_meaning = word.substring(word.indexOf('\t'),word.length());
            Word word1= new Word(word_target,word_meaning);
            dictionary.insert(word1);

        }
    }
    public void showAllWords(){
        System.out.print(String.format("%1$-20s","NO"));
        System.out.print(String.format("%1$-20s","|English"));
        System.out.print(String.format("%1$-20s","|Vietnammese"));
        System.out.println();
        List<Word> word = dictionary.crawlnode(dictionary.root);
        for (Integer i=0;i<word.size();i++){
            System.out.print(String.format("%1$-20s",i));
            System.out.print(String.format("%1$-20s","|"+word.get(i).word_target));
            System.out.print(String.format("%1$-20s","|"+word.get(i).word_explain));
            System.out.println();
        }
        System.out.println(word.size());
    }

    public void insertFromFile(){
        File file = new File(".\\src\\dictionaries.txt");
        try {
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine()){
                String word=scanner.nextLine();
                word=word.toLowerCase();

                String word_target = word.substring(0,word.indexOf('\t'));
                String word_meaning = word.substring(word.indexOf('\t'),word.length());
                Word word1= new Word(word_target,word_meaning);
                dictionary.insert(word1);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    // suggesttion
    public List<String> autocompele(String word) {
        System.out.println("ok");
        if (word.length()<3) return null;
        List<Word> result = dictionary.Lookup(word);
        List<String> res = new ArrayList<String>();
        if (result==null) return null;
        for (int i=0;i<result.size();i++)
            res.add(result.get(i).word_target);

        return res;
    }

   public Word dictionaryLookup(String target){
        Word word = new Word(target,"");
        if (dictionary.get_node(word)==null) return null;
        return(dictionary.get_node(word).word);
   }

   public void dictionaryExportToFile(){
       try {
           FileWriter file = new FileWriter("export.txt");
           List<Word> lists=dictionary.crawlnode(dictionary.root);

           for (int i=0;i<lists.size();i++){
               file.write(lists.get(i).word_target+'\t'+lists.get(i).word_explain+'\n');
           }
           file.close();


       } catch (IOException e) {
           e.printStackTrace();
       }
   }
    
}
