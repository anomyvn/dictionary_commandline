import java.util.List;
import java.util.Scanner;

class DictionaryCommandline{
    public void showAllWords(DictionaryManagement dictionaryManagement){
        dictionaryManagement.showAllWords();
    }

    public void dictionaryBasic(DictionaryManagement dictionaryManagement){
        dictionaryManagement.InsertfromCommandline();
        dictionaryManagement.showAllWords();
    }
    public void dictionaryAdvanced(DictionaryManagement dictionaryManagement){
        dictionaryManagement.insertFromFile();
        dictionaryManagement.showAllWords();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your word to lookup:");
        String word = scanner.nextLine();
        dictionaryManagement.dictionaryLookup(word);
    }
    public void dictionarySearcher(DictionaryManagement dictionaryManagement){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your word to search:");
        String word = scanner.nextLine();
        List<String> lists = dictionaryManagement.autocompele(word);
        for (int i=0;i<lists.size();i++){
            System.out.println(lists.get(i));
        }

    }
}
