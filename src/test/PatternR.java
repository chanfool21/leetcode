package test;

public class PatternR {

         public static void main(String[] args) {
             int col = 10;
             int spaceSize = 2;
                for(int j = 0; j < 10; j++) {
                    System.out.print("*" );
                    for(int i = 0; i < spaceSize; i++) {
                        System.out.print(" ");
                    }
                }

                System.out.println();
                int lastRow = col/2 - 2;

                for(int itr = 0; itr < lastRow; itr++) {
                    System.out.print("*");

                    for(int j = 0; j < col-1; j++) {
                        for(int i = 0; i < spaceSize; i++) {
                            System.out.print(" ");
                        }
                        if(j != col-2)
                            System.out.print(" ");
                    }
                    System.out.print("*");
                    System.out.println();
                }


             for(int j = 0; j < 10; j++) {
                 System.out.print("*" );
                 for(int i = 0; i < spaceSize; i++) {
                     System.out.print(" ");
                 }
             }

             System.out.println();
            for(int row = 3; row <= col; row++) {
                int spaceCounter = 2 * (row-1) + (row-2);
                System.out.print("*");
                for(int i = 0; i < spaceCounter; i++) {
                         System.out.print(" ");
                 }
                System.out.print("*");
                System.out.println();
            }
         }
     }






