import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter var X :");
        int x = in.nextInt();
        System.out.println("var X :"+x);

        Scanner iny = new Scanner(System.in);
        System.out.println("Enter var Y :");
        int y = iny.nextInt();
        System.out.println("var Y :"+y);


        Scanner ind = new Scanner(System.in);
        System.out.println("Enter deriction ' N - S - E - O ' :");
        String deriction = ind.next();
        System.out.println("var Y :"+deriction);

        List<String> allLines = Files.readAllLines(Paths.get("src/carte.txt"));


        for(int i=0;i<deriction.length();i++){
            int a =x;
            int b =y;

            if(VerifieBorder(allLines ,a,b)){

                if(deriction.charAt(i)=='O' && x>1){
                    if(VerifiedBois(allLines ,a--,b)){
                        x--;
                    };
                }
                if(deriction.charAt(i)=='N'){
                    if(VerifiedBois(allLines,a,b--)){
                        y--;
                    };
                }
                if(deriction.charAt(i)=='E' && y>1){

                    if(VerifiedBois(allLines,a,b++)){
                        x++;
                    };
                }
                if(deriction.charAt(i)=='S'){

                    if(VerifiedBois(allLines,a,b++)){
                        y++;
                    };
                }

            }

        }
        System.out.println("Résultat attendu  ("+x+","+y+")");

    }

    // this method fot verified position de obj is empty or not  '#'
    private static boolean VerifiedBois(List<String> allLines ,int x , int y) throws IOException {
        String cas = allLines.get(y);
        if(cas.charAt(x)=='#'){
            System.out.println("#");
            return false;
        }
        return true;
    }
    // this method fot verified Border
    private static boolean VerifieBorder(List<String> allLines ,int x , int y){
        int numberLinse = allLines.size();
        String cas = allLines.get(y);
        if(y<numberLinse && x <cas.length())
        return  true;
        return false;
    }
}