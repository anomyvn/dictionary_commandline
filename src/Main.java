public class Main {
    static public void main(String[] args){
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();

        //dictionaryCommandline.dictionaryBasic(dictionaryManagement);
        dictionaryManagement.insertFromFile();
        dictionaryManagement.dictionaryExportToFile();
    }
}
