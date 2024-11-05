import java.util.Scanner;


public class DataRunner {
  public static void main(String[] args) {
    pokemon ado = new pokemon("name.txt", "type1.txt", "type2.txt", "total.txt", "legendary.txt");

    //Demonstrating the outputs
    System.out.println(ado.countType("Fire"));
    System.out.println("------------------------------------------------");
    System.out.println(ado.countLegend());
    System.out.println("------------------------------------------------");
    System.out.println(ado.countLegendType("Normal"));
    System.out.println("------------------------------------------------");
    System.out.println(ado.getInfo("RayquazaMega"));

    System.out.println(ado);

    

    
  }
}