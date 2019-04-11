import edu.duke.FileResource;

public class Part3 {

    public int findStopCodon(String dna, int startIndex, String stopCodon){
        String tempDna = dna.toUpperCase();
        int currIndex = tempDna.indexOf(stopCodon, startIndex+3);
        while(currIndex != -1){
            int diff = currIndex-startIndex;
            if(diff % 3 == 0){
                return currIndex;
            } else {
                currIndex = tempDna.indexOf(stopCodon,currIndex+1); //CHECK THIS IN CASE NIT DOESNT WORK
            }
        }
        return -1;
    }





    public String findGene(String dna, int where){
        String tempDna = dna.toUpperCase();
        int startIndex = tempDna.indexOf("ATG", where);
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(tempDna, startIndex, "TAA");
        int tagIndex = findStopCodon(tempDna, startIndex,"TAG");
        int tgaIndex = findStopCodon(tempDna, startIndex, "TGA");

        int minIndex = Math.min(taaIndex, Math.min(tagIndex,tgaIndex));
        if(minIndex == -1){
            return "";
        }
        return dna.substring(startIndex,minIndex+3);
    }

    public void printAllGenes(String dna){
        int startIndex = 0;
        while(true){
            String currentGene = findGene(dna,startIndex);
            if(currentGene.isEmpty()){
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene,startIndex)+currentGene.length();
        }
    }

    public int countGenes(String dna) {
        int startIndex = 0;
        int count = 0;
        while(true){
            String currentGene = findGene(dna,startIndex);
            if(currentGene.isEmpty()){
                break;
            }
            count += 1;
            startIndex = dna.indexOf(currentGene,startIndex)+currentGene.length();

        }
        return count;
    }


    public void testCountGenes(){
        System.out.println(countGenes(getFile("GRch38dnapart.fa")));
    }

    public String getFile (String file){
        FileResource fr = new FileResource(file);
        String dna = fr.asString();
        return dna;
    }

    public static void main(String[] args) {
        Part3 p3 = new Part3();
        p3.testCountGenes();




    }




}
