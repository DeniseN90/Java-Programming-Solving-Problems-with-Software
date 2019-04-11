import edu.duke.FileResource;

public class Part2 {


    public float cgRatio(String dna){
        String tempDna = dna.toLowerCase();
        float ratio = 0.0f;
        char c = 'c';
        char g = 'g';
        int count = 0;
        int stringLength = dna.length();
        char [] charArray = tempDna.toCharArray();
        for(char ch : charArray){
            if(ch == c || ch == g){
                count += 1;
            }
        }
        ratio = ((float)count)/stringLength;
        return ratio;
    }


    public void testCgRatio(){
        System.out.println(cgRatio("ATGCTGCAACGGTGA"));
    }

    public int counCTG (String dna) {
        int startIndex = 0;
        int count = 0;
        while(true) {
            int currentIndex = dna.indexOf("CTG", startIndex);
            if (currentIndex > dna.length() - 1 || currentIndex == -1) {
                break;
            } else {
                count +=1;
                startIndex = currentIndex+3;
            }
        }
        return count;
    }

    public void testCountCTG(){
        String dna = getFile("GRch38dnapart.fa");
        int x = counCTG(dna);
        System.out.println(x);
    }

    public String getFile (String file){
        FileResource fr = new FileResource(file);
        String dna = fr.asString();
        return dna;
    }



    public static void main(String[] args) {
        Part2 p2 = new Part2();
        p2.testCgRatio();
        p2.testCountCTG();

    }





}
