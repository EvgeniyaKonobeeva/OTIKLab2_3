import java.io.File;

/*рограмма принимает на вход папку с файлами

* в каждом файле она подсчитывает относительные частоты символов (частота символа/ количество символов в файле),
* колво информации каждого  символа
*
* в конце файла-результата программа записывает количество информации для всего файла
*
* формат файла-результата :
* символ ---- относ. част. inf : колво информации символа*/
public class Main {

    public static void main(String[] args) {

//        указать папку файлы из которой нужно обработать
        File fileDir = new File("C:\\Users\\Evgenia\\IdeaProjects\\OTIKLab2_3\\texts");
        File[] files = fileDir.listFiles();
        for(File f : files){
            CodingClass mwc = new CodingClass();
            mwc.readFromFile(f.getPath());
//            указать путь к существующей папке, в которую надо сохранить результаты подсчетов
            mwc.printFreqTable("C:\\Users\\Evgenia\\IdeaProjects\\OTIKLab2_3\\symFreq");
        }
    }
}
