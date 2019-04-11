public class Part1 {

    public String findSimpleGene(String dna){
        String result = "";
        int startIndex = dna.indexOf("ATG");
            if(startIndex==-1){
                return result;
            }
        int stopIndex = dna.indexOf("TAA",startIndex+3);
        if(stopIndex==-1){
            return result;
        }
        String s = dna.substring(startIndex,stopIndex+3);
        int len = s.length();
        if(len%3==0){
            result = s;
        }
        return result;
    }


    public void testSimpleGene(){
        String dna1 = "ACATGCCATGATAAGC";
        String dna2 = "CGCGATCCAATAGAATAA";
        String dna3 = "CGCGATGGGGACTACATGA";
        String dna4 = "ATATCGCGAATCCCAAYG";
        String dna5 = "ACATGCCATAGATAAGC";
        System.out.println("First sequence: "+dna1);
        System.out.println("Gene: "+findSimpleGene(dna1));
        System.out.println("Second sequence: "+dna2);
        System.out.println("Gene: "+findSimpleGene(dna2));
        System.out.println("Third sequence: "+dna3);
        System.out.println("Gene: "+findSimpleGene(dna3));
        System.out.println("Fourth sequence: "+dna4);
        System.out.println("Gene: "+findSimpleGene(dna4));
        System.out.println("Fifth sequence: "+dna5);
        System.out.println("Gene: "+findSimpleGene(dna5));

    }

    public static void main(String[] args) {

        Part1 p1 = new Part1();
        p1.testSimpleGene();

    }
}
