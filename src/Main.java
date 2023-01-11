import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        //age();
        //System.out.println(fahrenheit(32));
        //System.out.println(perimeter(12,6));
        //System.out.println(air(12,6));
        //System.out.println(authentification("2uh53or", "Louis"));
        //System.out.println(parc(18, 9, 15)+"€");
        //System.out.println(categorie(20));
        //System.out.println(carresParfaits(300));
        //multiplications(7);
        //System.out.println(factorielle(-5));
        //System.out.println(estPremier(15));
        //civilite();
        //guess();
        int[] ex = {1,5,9,7,7};
        float[] notes = {10,15};
        int[] coeff = {2,2};
        String[] ADN1 = {"A","A","T","G","G","C"};
        String[] ADN2 = {"A","G","C","G","A","C"};
        int[][] multiples = new int[3][3];

        //showTable(inverser(ex));
        //System.out.println(egaux(ex,ex));
        //System.out.println(carreMagique(multiples));
        //System.out.println(moyenne(coeff, notes));
        System.out.println(taux_concordance(ADN1,ADN2)+"%");
        System.out.println(jourMois(2023,60));
    }

    public static String jourMois(int annee, int jour){
        int mois = 0;
        int lastDays = jour;
        System.out.println(lastDays);
        int[] stat = {31,-1,31,30,31,30,31,31,30,31,30,31};
        for(int m = 0; m <= stat.length;m++){
            if(stat[m] == -1){
                stat[m] = estBissextile(annee) ? 29 : 28;
            }
            mois=m+1;
            if(stat[m] >= lastDays){
                System.out.println(stat[m]+" > "+lastDays);
                break;
            }
            System.out.println(lastDays+" - "+stat[m]);

            lastDays = lastDays-stat[m];
        }
        return "Le "+jour+"e jour tombe "+(estBissextile(annee) ? "une annee bissextile" : "une annee non bissextile")+" et tombe le "+lastDays+"/"+mois;
    }
    public static boolean estBissextile(int year){
        if((year%4==0 && year%100 != 0) || (year%400==0 && year%4000 != 0)  ){
            return true;
        }
        return false;
    }
    public static float taux_concordance(String[] ADN1,String[] ADN2){
        float rate = ADN1.length;
        if(ADN1.length != ADN2.length){
            return -1;
        }
        for(int a=0; a < ADN1.length;a++){
            if(!ADN1[a].equals(ADN2[a])){
                rate--;
            }
        }
        return (rate*100)/ADN1.length;
    }
    public static float moyenne(int[] coeff, float[] notes){
        int sumcoeff = 0;
        float sum = 0;
        for(int i = 0; i < notes.length;i++){
            sum+=notes[i]*coeff[i];
            sumcoeff+=coeff[i];
        }

        return sum/sumcoeff;
    }


    public static boolean carreMagique(int[][] A){
        int sumCol = 0;
        int sumRow = 0;
        int sumDiag= 0;
        int[] sumColTab = new int[A.length];
        int[] sumRowTab = new int[A.length];;
        int[] sumDiagTab = new int[2];

        for(int i=0; i < A.length;i++){
            Arrays.fill(A[i], 10);
            for(int y=0; y < A[i].length;y++){
                sumRow+=A[i][y];
                sumCol+=A[y][i];
                if(y == i){
                    sumDiag+=A[i][y];
                    sumDiagTab[i] = sumDiag;
                }
            }
            sumColTab[i] = sumCol;
            sumRowTab[i] = sumRow;

            sumRow=0;
            sumCol=0;
            sumDiag=0;
        }
        showTable(A[0]);
        showTable(A[1]);
        showTable(A[2]);
        return true;
    }
    public static boolean egaux(int[] A,int[] B){
        for(int i=0; i < A.length;i++){
            if (A[i] != B[i]){
                return false;
            }
        }
        return true;
    }
    //ex 1
    public static void showTable(int[] tab){
        for(int i : tab) {
            System.out.print(" "+i+" ");
        }
        System.out.println("");
    }

    public static void age()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Entrez votre prénom : ");
        String surname = input.nextLine();

        System.out.println("Entrez votre nom : ");
        String name = input.nextLine();

        System.out.println("Entrez l'année a laquelle vous souhaitez savoir l'age :");
        int date = input.nextInt();

        System.out.println("Entrez votre année de naissance : ");
        int birthday = input.nextInt();

        System.out.format("Prénom : %s - Nom : %s - Age en %d : %d ans", surname, name,date,(date-birthday));
    }

    //ex 2
    public static float fahrenheit(float temp){
        return temp*9/5+32;
    }

    public static float perimeter(int l, int L){
        return (l+L)+2;
    }

    public static float air(int l, int L){
        return l*L;
    }

    public static boolean estPair(int nb){
        return nb%2 == 0;
    }

    public static boolean authentification(String password, String auth){
        String passCheck = "2uh53or";
        String authCheck = "Louis";
        return (passCheck.equals(password) && Objects.equals(auth, authCheck));
    }

    public static float parc(int age, int arrival, int departures){

        int spendTime = departures-arrival;
        int opening = 9;
        int closing = 19;
        int entries = 6;
        int pricePerHour = 2;
        if(age <= 5){
            return 0;
        }
        else{
            return entries + spendTime*pricePerHour;
        }
    }
    public static String categorie(int age){
        if(age < 8){
            return "Petits poussins";
        }
        else if(age == 8 || age == 9){
            return "Poussins";
        }
        else if(age == 11 || age == 10){
            return "Pupilles";
        }
        else if(age == 12 || age == 13){
            return "Benjamins";
        }
        else if(age == 14 || age == 15){
            return "Minimes";
        }
        else if(age == 16 || age == 17){
            return "Cadets";
        }
        else if(age == 18 || age == 19){
            return "Juniors";
        }
        else if(age >= 20 && age <= 49){
            return "Seniors";
        }
        else if(age >= 50 && age <= 64){
            return "Seniors +";
        }
        else if(age >= 65){
            return "Vétérans";
        }
        return "Vous n'etes pas dans une catégorie d'age adéquate";
    }

    public static boolean carresParfaits(int c){
        int r = 0;
        int temp = 1;
        while(c >= r){
            r+=temp;
            temp+=2;
            System.out.println(r);
        }
        return true;
    }

    public static void multiplications(int table){
        for(int a=1; a <= table;a++){
            System.out.println(a+" x "+table+" = "+a*table);
        }
    }

    public static float factorielle(int n){
        int res = 1;
        if(n < 0){
            System.out.println("Erreur : la valeur passée en argument doit être positive.");
            return -1;
        }
        for(int b=1; b <= n; b++){
            res*=b;
        }
        return res;
    }

    public static boolean estPremier(int p){
        for(int i=2; i <= p-1;i++){
            if(p%i == 0){
                System.out.println(i);
                return false;
            }
        }
        return true;
    }

    public static String civilite(){
        Scanner input = new Scanner(System.in);
        String sexe="";
        do{
            System.out.println("Entez un homme(H) ou une femme(F)  : ");
            sexe = input.nextLine();
        }
        while(!(sexe).equalsIgnoreCase("H") && !sexe.equalsIgnoreCase("F"));
        return sexe;
    }

    public static void guess(){
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int s = random.nextInt((1000 - 1) + 1) + 1;
        System.out.println(s);
        int p = 0;
        do{
            System.out.println("Devinez ? :  ");
            p = input.nextInt();
            if(p < s){
                System.out.println("Trop petit ! ");
            }
            else if(p > s){
                System.out.println("Trop grand ! ");
            }
            else{
                System.out.println("BRAVO ! ");

            }
        }
        while(s != p);

    }

    public static int[] inverser(int[] tab){
        int temp;
        for (int y=0;y < tab.length/2;y++){
            temp = tab[y];
            tab[y]=tab[tab.length-y-1];
            tab[tab.length-y-1]=temp;
        }
        return tab;
    }





}