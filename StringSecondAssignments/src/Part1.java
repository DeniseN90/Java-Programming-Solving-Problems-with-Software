import java.sql.SQLOutput;

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
        return dna.length();
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
        if(minIndex == dna.length()){
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
        System.out.println(gene1);
        System.out.println(gene2);
        System.out.println(gene3);
        System.out.println(gene4);
        System.out.println(gene5);
    }

    public void testPrintAllGenes(){
        System.out.println("Pinting genes...");
        printAllGenes("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        printAllGenes("");
    }




    public static void main(String[] args) {
        Part1 p1 = new Part1();
        p1.testFIndStopCodon();
        p1.testFindGene();
        p1.testPrintAllGenes();
    }



}
