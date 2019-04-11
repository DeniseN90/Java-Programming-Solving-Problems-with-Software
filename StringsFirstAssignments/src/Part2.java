public class Part2 {

    public String findSimpleGene(String dna, String start, String stop){
        String tempDna = dna.toUpperCase();
        String result = "";
        int startIndex = tempDna.indexOf(start);
        if(startIndex==-1){
            return result;
        }
        int stopIndex = tempDna.indexOf(stop,startIndex+3);
        if(stopIndex==-1){
            return result;
        }
        String s = tempDna.substring(startIndex,stopIndex+3);
        int len = s.length();
        if(len%3==0){
            result = dna.substring(startIndex,stopIndex+3);
        }
        return result;
    }


    public void testSimpleGene(){
        String dna1 = "acatgccatgataagc";
        String dna2 = "CGCGATCCAATAGAATAA";
        String dna3 = "CGCGATGGGGACTACATGA";
        String dna4 = "ATATCGCGAATCCCAAYG";
        String dna5 = "ACATGCCATAGATAAGC";
        System.out.println("First sequence: "+dna1);
        System.out.println("Gene: "+findSimpleGene(dna1,"ATG", "TAA"));
        System.out.println("Second sequence: "+dna2);
        System.out.println("Gene: "+findSimpleGene(dna2, "ATG", "TAA"));
        System.out.println("Third sequence: "+dna3);
        System.out.println("Gene: "+findSimpleGene(dna3, "ATG", "TAA"));
        System.out.println("Fourth sequence: "+dna4);
        System.out.println("Gene: "+findSimpleGene(dna4, "ATG", "TAA"));
        System.out.println("Fifth sequence: "+dna5);
        System.out.println("Gene: "+findSimpleGene(dna5, "ATG", "TAA"));

    }

    public static void main(String[] args) {
        Part2 p2 = new Part2();
        p2.testSimpleGene();
    }
}
