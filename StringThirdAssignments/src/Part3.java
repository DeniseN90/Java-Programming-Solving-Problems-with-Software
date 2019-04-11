import edu.duke.FileResource;
import edu.duke.StorageResource;

public class Part3 {

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

       public StorageResource getAllGenes(String dna){
           StorageResource sr = new StorageResource();
           int startIndex = 0;
           while(true){
               String currentGene = findGene(dna,startIndex);
               if(currentGene.isEmpty()){
                   break;
               }
               sr.add(currentGene);
               int increment = dna.indexOf(currentGene, startIndex)+currentGene.length();
               startIndex += increment;
           }
           return sr;
       }

       public void processGenes (StorageResource sr){
           int countLonger = 0;
           int countCGratio = 0;
           String longestString = "";
           for(String i : sr.data()){
               if (i.length()>60){
                   System.out.println("Gene longer than 60: "+i);
                   countLonger += 1;
               }

               if (cgRatio(i)>0.35){
                   System.out.println("Gene wih CG ratio > 0.35: "+i);
                   System.out.println("Ratio is: "+cgRatio(i));
                   countCGratio +=1 ;
               }

               if(i.length()>longestString.length()) {
                   longestString = i;
               }
           }

           System.out.println("Longest gene: "+longestString);
           System.out.println("Longest gene's length: "+longestString.length());
           System.out.println("Number of genes with high cg Ratio: "+countCGratio);

       }

       public void testProcessGene(){
           String dna = getFile("GRch38dnapart.fa");
           StorageResource sr = getAllGenes(dna);
           processGenes(sr);
       }




    public int findStopCodon(String dna, int startIndex, String stopCodon){
        String tempDna = dna.toUpperCase();
        int currIndex = tempDna.indexOf(stopCodon, startIndex+3);
        while(currIndex != -1){
            int diff = currIndex-startIndex;
            int modulo = diff % 3;
            if (modulo == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon,(currIndex+1));
            }
        }
        return -1;
    }


    public String findGene(String dna, int where){
        String tempDna = dna.toUpperCase();
        int minIndex = 0;
        int startIndex = tempDna.indexOf("ATG", where);
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(tempDna, startIndex, "TAA");
        int tagIndex = findStopCodon(tempDna, startIndex,"TAG");
        int tgaIndex = findStopCodon(tempDna, startIndex, "TGA");
        if (taaIndex == - 1 || tgaIndex != -1 && tgaIndex < taaIndex) {
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }
        if (minIndex == -1 || tagIndex != -1 && tagIndex < minIndex) {
            minIndex = tagIndex;
        }

        if (minIndex == -1) {
            return "";
        }
        return tempDna.substring(startIndex,minIndex+3);
    }


    public String getFile (String file){
        FileResource fr = new FileResource(file);
        String dna = fr.asString();
        return dna;
    }


    public static void main(String[] args) {
        Part3 p3 = new Part3();
        String dna = p3.getFile("GRch38dnapart.fa");
        p3.testProcessGene();

    }

}
