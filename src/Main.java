import java.io.File;

public class Main {

    public static void main(String[] args) {
        File fileDir = new File("C:\\Users\\Evgenia\\IdeaProjects\\OTIKLab2_3\\Тексты");
        File[] files = fileDir.listFiles();
        for(File f : files){
            CodingClass mwc = new CodingClass();
            mwc.readFromFile(f.getPath());
            mwc.printFreqTable();
        }
    }
}
