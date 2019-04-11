import edu.duke.*;

import java.util.ArrayList;

public class Part4 {

    private String path;

    public URLResource setUrlLink (String path){
        return new URLResource(path);
    }


    public ArrayList<String> getLinks (URLResource rs){
        ArrayList<String> linkArr = new ArrayList<>();
        for(String line : rs.lines()){
            if(line.contains("youtube.com")){
                linkArr.add(line);
            }
        }
        return linkArr;
    }

    public ArrayList<String>  findSubString (ArrayList<String> linkArr, String start, String stop){
        ArrayList<String> stringArr = new ArrayList<>();
        for(String item : linkArr){
            String itemTemp = item.toLowerCase();
            int startIndex = itemTemp.indexOf(start);
            int stopIndex = itemTemp.indexOf(stop,startIndex);
            stringArr.add(item.substring(startIndex,stopIndex));

        }

        return stringArr;
    }

    public void printELements (ArrayList<String> list){
        for(String item: list){
            System.out.println(item);
        }
    }
    public void testing(){
        URLResource rs = setUrlLink("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        ArrayList<String> linkArr = new ArrayList<>(getLinks(rs));
        ArrayList<String> linkList = new ArrayList<>(findSubString(linkArr,"\"http",">"));
        printELements(linkList);


    }

    public static void main(String[] args) {
        Part4 p4 = new Part4();
        p4.testing();
    }
}
