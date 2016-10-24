import java.io.*;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Evgenia on 08.10.2016.
 */
public class CodingClass {
    private Map<Byte[], Double> byteFreqMap = new HashMap<>();
    private Map<Byte[], Double> byteFreqMap2 = new HashMap<>();
    private Map<Byte, ArrayList<Integer>> resultBytesCode = new HashMap<>();
    private String fileName;


    public void readFromFile(String filePath){

        fileName = new File(filePath).getName();

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        InputStream input = null;
        try {
            input = new BufferedInputStream(new FileInputStream(filePath));
            int data = 0;
            while ((data = input.read()) != -1) {
                byteStream.write(data);
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        if(byteStream.size()!= 0){
            countDelRepeats(byteStream.toByteArray());

        }else{
            System.out.println("empty File");
        }
    }


    public void countDelRepeats(byte[] byteArr){

        ArrayList<Byte> chars = new ArrayList<>();

        for(int i = 0; i < byteArr.length; i++){
            chars.add(byteArr[i]);
        }
        for(int i = 0; i < chars.size(); i++){
            int countSym = 1;
            Byte b = chars.get(i);
            for(int j = i+1; j < chars.size(); j++){
                if(b == chars.get(j)){
                    chars.remove(j--);
                    countSym++;
                }
            }
            byteFreqMap.put(new Byte[]{b}, (double)countSym);
        }
        byteFreqMap2.putAll(byteFreqMap);
    }

    public void printFreqTable(){
        System.out.println("freq table");

        int sum = 0;
        for (Map.Entry<Byte[], Double> entry : byteFreqMap2.entrySet()){
            sum+=entry.getValue();
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File("C:\\Users\\Evgenia\\IdeaProjects\\OTIKLab2_3\\symFreq\\" + fileName), true);
        } catch (IOException e) {
            e.printStackTrace();
        }


        while (!byteFreqMap2.isEmpty()) {

            double maxVal = Double.MIN_VALUE;
            Byte[] b = null;

            for (Map.Entry<Byte[], Double> entry : byteFreqMap2.entrySet()) {
                if (entry.getValue() > maxVal) {
                    maxVal = entry.getValue();
                    b = entry.getKey();
                }
            }
            try {
                fileWriter.append(Integer.toHexString(Byte.toUnsignedInt(b[0])) + "---" + maxVal/sum + "\n");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byteFreqMap2.remove(b);
        }

    }


}
