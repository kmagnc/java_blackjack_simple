/**
 * Blackjack
 * KD
 * October 2012
 **/


import java.util.Scanner;
public class mainProject {
    public static void main(String[] args) {
        
        Scanner kbd=new Scanner(System.in);
        int cardArr[][]=new int[52][2];
        System.out.println("Proceed? Press anything other than 'n' to continue.");
        String proceed=kbd.next();
        if(proceed.toLowerCase().equals("n") ){
            System.exit(0);
        }
        else{
            for (int a=0;a<cardArr.length;a++){
                cardArr[a][0]=a;
                cardArr[a][1]=0;
                //Array of 52 unique card integers (0-51) has been declared and populated. 2nd dim pos 0 has the card ID, 2nd dim pos 1 has that card's count.
            }
        
            //variables
            boolean draw;
            int count=0;
            int sum=0;
            int ace=0;
            int cardInt=0;
            int currentHand[]=new int[22];
            //int backHand[]=new int[22];
            String suit=new String();
            String cardName=new String();            
            String user = new String();
            String cont = new String();
                
            for(int k=0;k<22;k++){ //new draw phase. Assuming a maximum of 21 one-point aces, no more than 22 draws for a single player.
                draw=false;
                count=0;
                //Logic: select&store random number 0-51 (unique id per card in deck). Check variable vs 2nd array pos ([x][1]). If 0, continue, else loop to select.
                while(!draw){
                                        
                    if (count>30){System.exit(0);}//fail-safe if a duplicate card is drawn back-to-back more than 30 times, exit program.
                    cardInt=(int)(Math.random()*52); //draw
                    if (cardArr[cardInt][1]<1){ //"<#" signifies # of decks of cards - if this card hasn't been drawn # of times, add a 'draw' count. else draw
                        cardArr[cardInt][1]++; // "This card has been drawn one more time than it had been before."
                    }    
                    else{
                        System.out.println("Duplicate. -- (cardInt="+cardInt+")");
                        count++;
                        k=k-1; // Checker such that duplicates do not placehold a card being drawn. 22 non-duplicates are drawn.
                        draw=true;
                        break; //stop here. draw again.
                    }
                    //determine card value
                    int tempValue=cardInt%13;
                    // 0 ace, 1 two, 2 three... 9 ten, 10 jack, 11 queen, 12 king
                    if (tempValue==0){
                        cardName="Ace";
                        if (sum+11>21||ace==1){
                            sum+=1;
                            }
                        else {
                            ace=1;
                        }
                        
                        //ace algorithm - sum + 11 > 21? Y - +1. N - exist ace used already? Y - +1. N? ace used true, temporary 1 delayed value 
                    }else if (tempValue>0 && tempValue<10){
                        sum+=(tempValue+1);
                        cardName=Integer.toString(tempValue+1);
                    }else{
                        sum+=10;
                        if(tempValue==10){cardName="Jack";}
                        else if(tempValue==11){cardName="Queen";}
                        else {cardName="King";}
                    }
                    if (cardInt<13){suit="Diamonds";}
                    else if (cardInt<26){suit="Hearts";}
                    else if (cardInt<39){suit="Spades";}
                    else{suit="Clubs";}
                    System.out.print("You drew the "+cardName+" of "+suit+". Your total is "+sum+"(Unless you have an ace and your sum+11<21).");
                    /**
                    System.out.println(" -- (sum="+sum+", tempValue="+tempValue+", cardInt="+cardInt+")");
                    **/
                    draw=true;
                }//while current draw
                currentHand[k]=cardInt;
                /**if (sum>21){
                    System.out.println("Bust!");
                    break;
                }
                else{
                    System.out.println("Draw again? Y/N");
                    cont=kbd.next();
                    if(cont.toLowerCase().equals("n") ){
                        System.out.println("Stopping here.");
                        break;
                    }    **/
                }
            }//for drawing loop
            System.out.println("What's your name?");
            user = kbd.next();
            char[] user2 = user.toCharArray();
            char[] backUser = new char[user2.length];
            for (int p=0; p<user.length();p++){
                backUser[p]=user2[user2.length-1-p];
            }
            String backwardsUser= new String(backUser);
            System.out.println("Your name is: "+user+" | Your name backwards is: "+backwardsUser);
            /**for(int l=0;l<cardArr.length;l++){
                System.out.print(l+","+cardArr[l][1]+"|");    
            }
            System.out.println("");
            System.out.println("Current hand:");
            for(int o=0;o<currentHand.length;o++){
                System.out.print(currentHand[o]+",");
            }
            System.out.println("");
            System.out.println("Back hand:");
            for(int e=0;e<backHand.length;e++){
                System.out.print(backHand[e]+",");
            }
            System.out.println("");
            for (int q=0;q<currentHand.length;q++){
                backHand[q]=currentHand[currentHand.length-1-q];
                System.out.print(backHand[q]+",");
            }**/
        
        kbd.close();
        System.exit(0);
        }//if !'n'

    }//main
        
}//mainProject
