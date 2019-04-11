import edu.duke.StorageResource;

public class Part1 {

    public int findStopCodon(String dna, int startIndex, String stopCodon){
        String tempDna = dna.toUpperCase();
        int currIndex = tempDna.indexOf(stopCodon, startIndex+3);
        while(currIndex != -1){
            int diff = currIndex-startIndex;
            if(diff % 3 == 0){
                return currIndex;
            } else {
                currIndex = tempDna.indexOf(stopCodon,currIndex+1);
            }
        }
        return -1;
    }


    public String findGene(String dna, int where){
        String tempDna = dna.toUpperCase();
        int startIndex = 0;


        startIndex = tempDna.indexOf("ATG", where);
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(tempDna, startIndex, "TAA");
        int tagIndex = findStopCodon(tempDna, startIndex,"TAG");
        int tgaIndex = findStopCodon(tempDna, startIndex, "TGA");
        int minIndex = Math.min(taaIndex, Math.min(tagIndex,tgaIndex));
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

    public StorageResource getAllGenes(String dna){
        String tempDna = dna.toUpperCase();
        StorageResource sr = new StorageResource();
        int startIndex = 0;
        while(true){
            String currentGene = findGene(tempDna,startIndex);
            if(currentGene.isEmpty()){
                break;
            }
            sr.add(currentGene);
            startIndex = dna.indexOf(currentGene,startIndex)+currentGene.length();
        }

        return sr;
    }


    public void testFIndStopCodon() {
        String dna1 = "CATGCCAAATGATAAGC";
        String dna2 = "CACCCGATCCAATAGAATAA";
        String dna3 = "CGCGATGGGGACTACATGA";
        String dna4 = "ATATGGCGAATAGAACG";
        String dna5 = "ACATGCCATAGATAAGC";
        int codon1 = findStopCodon(dna1,0,"TGA");
        int codon2 = findStopCodon(dna2,0,"TAG");
        int codon3 = findStopCodon(dna3,0,"TAA");
        int codon4 = findStopCodon(dna4, 0, "TAG");
        int codon5 = findStopCodon(dna5,0,"TAA");
        System.out.println("Stop codons found: ");
        System.out.println(codon1);
        System.out.println(codon2);
        System.out.println(codon3);
        System.out.println(codon4);
        System.out.println(codon5);

    }

    public void testFindGene(){
        String dna1 = "ACATGCCATGATAAGC";
        String dna2 = "CGCGATCCAATAGAATAA";
        String dna3 = "CGCGATGGGGACTACATGA";
        String dna4 = "ATATGGCGAATCCCAAYG";
        String dna5 = "ACATGCCATAGATAAGC";
        String gene1 = findGene(dna1,0);
        String gene2 = findGene(dna2, 0);
        String gene3 = findGene(dna3, 0);
        String gene4 = findGene(dna4, 0);
        String gene5 = findGene(dna5,0);
        System.out.println("Genes found: ");
        System.out.println("Gene 1 "+gene1);
        System.out.println("Gene 2 " +gene2);
        System.out.println("Gene 3 " +gene3);
        System.out.println("Gene 4 " +gene4);
        System.out.println("Gene 5 " +gene5);

    }

    public void testPrintAllGenes(){
        System.out.println("Printing genes...");
        printAllGenes("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        printAllGenes("");



    }

    public void testGetAllGenes() {
        System.out.println("Getting all genes..");
        StorageResource sr = getAllGenes("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        for(String s : sr.data()){
            System.out.println(s);
        }
    }


    public static void main(String[] args) {
        Part1 p1 = new Part1();
        p1.testFindGene();
        p1.testPrintAllGenes();
        p1.testGetAllGenes();

    }

}
