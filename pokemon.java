import java.util.Scanner;




public class pokemon {
  //declares a list of variables so all methods can use it
  public String[] nameData;
  public String[] type1Data;
  public String[] type2Data;
  public int[] totalData;
  public String[] legData;
  private eheh[] answers;
  private boolean legResponse;
  public eheh[] tempAnswers;
  public eheh[] temp;



  //assigns the information of a singular pokemon into the "answers" variable
  public pokemon(String nameFile, String type1File, String type2File, String totalFile, String legFile) {
    answers = create(nameFile, type1File, type2File, totalFile, legFile);
  }


// puts the text files into array variables
  public eheh[] create(String nameFile, String type1File, String type2File, String totalFile, String legFile) {
    nameData = FileReader.toStringArray(nameFile);
    type1Data = FileReader.toStringArray(type1File);
    type2Data = FileReader.toStringArray(type2File);
    totalData = FileReader.toIntArray(totalFile);
    legData = FileReader.toStringArray(legFile);
    tempAnswers = new eheh[nameData.length];

    
    for (int i = 0; i < tempAnswers.length; i++) {
      legResponse = convertToBoolean(legData[i]);
      tempAnswers[i] = new eheh(nameData[i], type1Data[i], type2Data[i], totalData[i], legResponse);
    }
    
    return tempAnswers;
  }
  




  //converts the "legendary" to a true/false instead of yes/no
  public boolean convertToBoolean(String response) {
    boolean result = false;

    if (response.equals("yes")) {
      result = true;
    }

    return result;
}





/*Traverses the list of pokemon,
  If that pokemon is said type, count goes up by 1
  */
 public String countType(String targetType) {
    int count = 0;

    for (eheh response : answers) {
      if (response.getType1().equals(targetType)) {
        count++;
      }
      if (response.getType2().equals(targetType)) {
        count++;
      }
    }

   return "Number of " + targetType + " types: " + count;
  }




  
/* Traverses list of pokemon
   If said Pokemon has the Legendary variable as true, count goes up by one
  */
public String countLegend() {
    int count = 0;


    for (eheh response : answers) {
      if (response.getLeg() == true) {
        count++;
      }
    }

    return "Number of Legendary Pokemon: " + count;
  }



/* A combination of the preivous two methods

  Checks to see if the Pokemon is said type, and then it check to see
  if it is a legendary. If both of these requirements are met, count
  goes up by 1.
  */
  public String countLegendType(String targetType) {
    int count = 0;
    for (eheh type : answers) {
      if (type.getType1().equals(targetType)) {
         if (type.getLeg() == true) {
           count++;
         }
      }
      else if (type.getType2().equals(targetType)) {
         if (type.getLeg() == true) {
           count++;
        }
      }
    }
    return "Number of " + targetType + "-type Legendary Pokemon: " + count;
  }







// A method to return all the information of a specific Pokemon
  
  public String getInfo(String name) {
    for (int i = 0; i < nameData.length; i++) {
      if (name.equals(nameData[i])){
        if (type2Data[i].equals("none")){
          return "Pokemon: " + nameData[i] + "\nType: " + type1Data[i] + "\nBase Stat Total " + totalData[i] + "\nLegendary?: " + legData[i];
        }
          return "Pokemon: " + nameData[i] + "\nType: " + type1Data[i] + "/" + type2Data[i] + "\nBase Stat Total: " + totalData[i] + "\nLegendary: " + legData[i];
      }
    }
    
    return "That is not a Pokemon!! try again :(";
  }
  









// This toString method also serves as the user input
  public String toString() {
    Scanner input = new Scanner(System.in);
    System.out.println("\n\n\n\n\n");
    System.out.println("------------------------------------------------");
    System.out.println("Enter the name of the Pokemon you'd like to know more about.");
    System.out.println("------------------------------------------------");
    //Puts the user input into a varialbe
    String choice = input.next();
    for (int i = 0; i < nameData.length; i++) {
      //Code only proceeds if the user input is valid
      if (choice.equals(nameData[i])) {
        System.out.println("------------------------------------------------");
        System.out.println("What would you like to know about " + choice + "?");
        System.out.println("------------------------------------------------");
        System.out.println("1: Type");
        System.out.println("2: Base stat total");
        System.out.println("3: Legendary if");
        System.out.println("4: Quit");
        System.out.print("Enter your choice (1, 2, 3, or 4): \n");     
        int crab = input.nextInt();
        String result = "";
        //Takes the user unput and proceeds with the codea ccordingly
        if (crab == 1) {
          /*If the Pokemon only has one type, instead of displaying [Type]/none,
            it will display just [Type].
          */
          if (type2Data[i].equals("none")) {
            result = "\nType: " + type1Data[i];
          }
          else {
            result = "\nType: " + type1Data[i] + "/" + type2Data[i];
          }
        }
          
        if (crab == 2) {
          result = "\nBase Stat Total: " + totalData[i];
        }


        if (crab == 3) {
          result = "\nLegendary?: " + legData[i];
        }
        return "\n" + result;
      }
    }
    input.close();
    //Only if the user input is not valid
    return "That is not a Pokemon!! Check your spelling and try again :("; 
  }
  
}