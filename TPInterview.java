import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TPInterview {
    public static void main(String[] args) {
        System.out.println(reverseWords("Ramesh is playing cricket")); // Question 1
        fileReaderQuestion("C:/Name_address.txt"); // Question 2
    }



    // Question 1 - Reverse the words in a string

    //Input: Ramesh is playing cricket
    //Output: Cricket playing is Ramesh
    public static String reverseWords(String s){
        String[] wordsArray = s.split(" ");
        String answer = "";
        for (int i = 0; i < wordsArray.length; i++){
            answer += wordsArray[wordsArray.length - i - 1]+" ";
        }
        return answer;
    }




    // Question 2 - Read text given from "C:/Name_address.txt" which shows data as:

    //Ramesh-Bangalore, Hyderabad, Lao
    //Pradeep-Chennai,Qaok
    //Ramesh-kerala,Buning
    //Pradeep-delhi
    //Ramesh-Hyderabad

    //Return above data back as :-
    //Ramesh: Bangalore, Hyderabad, Lao, kerala, Buning, Hyderabad
    //Pradeep: Chennai, Qaok, delhi
    public static void fileReaderQuestion(String fileLocation){


        String thisLine = null;
        try {
            FileReader fr=new FileReader(fileLocation);
            BufferedReader br = new BufferedReader(fr);

            Map<String, List<String>> personDataMap = new HashMap<>();
            while ((thisLine = br.readLine()) != null) {
                String[] stringArray = thisLine.split("-");
                if(personDataMap.containsKey(stringArray[0])){
                    String[] locationArray = stringArray[1].split(",");
                    for(int i =0; i < locationArray.length; i++){
                        personDataMap.get(stringArray[0]).add(locationArray[i].trim());
                    }
                }else{
                    List<String> locationList = new ArrayList<>();
                    String[] locationArray = stringArray[1].split(",");
                    for(int i =0; i < locationArray.length; i++){
                        locationList.add(locationArray[i].trim());
                    }
                    personDataMap.put(stringArray[0], locationList);
                }
            }
            for (String s: personDataMap.keySet()){
                System.out.print(s+": ");
                for(String sl : personDataMap.get(s)){
                    System.out.print(sl+", ");
                }
                System.out.println();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }



    // Question 3 - SQL verbal questions
}