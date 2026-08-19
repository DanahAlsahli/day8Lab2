import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Q1:
        String[] words = {"cat", "dog", "red", "is", "am"};
        // نخلي طول اول كلمة هو الاطول عشان يسهل عليا المقارنة
        int longest = words[0].length();
        // نشوف اذا فيه كلمة اطول
        for (String word : words) {
            if (word.length() > longest) {
                longest = word.length();
            }
        }
        System.out.println("Q1- the longest words:");
        for (String word : words) {
            if (word.length() == longest) {
                System.out.println(word);
            }
        }

        // Q2:
        int[] numbers = {1, 1, 1, 3, 3, 5};
        int count3 = 0;
        int count1 = 0;
        int count9 = 0;

        for (int number : numbers) {
            if (number == 3) {
                count3++;
            }
            if (number == 1) {
                count1++;
            }
            if (number == 9) {
                count9++;
            }
        }
        System.out.println("3 occurs "+count3 +" times");
        System.out.println("1 occurs "+count1+" times");
        System.out.println("9 occurs "+ count9+" time");

        // Q3:
        int[] num = {1, 4, 17, 7, 25, 3, 100};
        int k = 3;
        Arrays.sort(num);
        for (int i = num.length - 1; i >= num.length - k; i--) {
            System.out.println(num[i]);
        }

        // Q4:
        int[] x = {5, 4, 3, 2, 1};
        reverse(x);
        System.out.println(Arrays.toString(x));


        // Q5:
        System.out.println("enter a size of array:");
        int size = input.nextInt();
        int[] arr = new int[size];
        int choice;
        do { //عندي مشكله فيها لازم ارجع اراجعها**

            System.out.println("1-accept elements");
            System.out.println("2-display elements");
            System.out.println("3-search element");
            System.out.println("4-sort array");
            System.out.println("5-stop");

            System.out.println("please enter ur choice:");
            choice = input.nextInt();
            // ندخل جوا ال array
            if (choice == 1) {
                for (int i = 0; i < arr.length; i++) {
                    System.out.println("enter a number:");
                    arr[i] = input.nextInt();
                }

            } else if (choice == 2) {
                System.out.println("array: " + Arrays.toString(arr));

            } else if (choice == 3) {
                System.out.println("enter a number 2 search:");
                int search = input.nextInt();
                boolean fou = false;
                for (int number : arr) { //الفور ايتش كمان لازم مراجعه
                    if (number == search) {
                        fou = true;
                    }
                }
                if (fou) {
                    System.out.println("number found");
                } else {
                    System.out.println("number not found");
                }

            }else if(choice== 4) {
                Arrays.sort(arr);
                System.out.println("array sorted: " + Arrays.toString(arr));
            }else if(choice == 5) {
                System.out.println("stopped");
            }else{
                System.out.println("invalid choice");
            }

        } while (choice != 5);
        // Q6:
        Random random = new Random();
        System.out.println("enter min value:");
        int min = input.nextInt();
        System.out.println("enter max value:");
        int max= input.nextInt();
        System.out.println("enter the number of random numbers:");
        int n =input.nextInt();
        System.out.println("random numbers:");
        for (int i=0; i <n; i++) {
            int randomNumber =random.nextInt(max - min + 1) + min;
            System.out.print(randomNumber + " ");
        }
        // Q7:
        System.out.println("enter a password:");
        String pass = input.next();
        int s1= checkLength(pass);
        int s2= checkSpecialCharacters(pass);
        int s3= checkUpperCaseLowerCase(pass);
        int totalScore =s1+s2 +s3;

        // عشان نشوف قوة الباس
        if (totalScore>= 8) {
            System.out.println("password is strong");
        } else if (totalScore>= 5) {
            System.out.println("password is a moderately strong");
        } else {
            System.out.println("password is weak");
        }

        // Q8:
        System.out.println("enter the number of fibonacci terms:");
        int terms = input.nextInt();
        fibonacci(terms);
    }


//قسم الميثود:


    //Q4 method:
    public static void reverse(int[] x) {
        for (int i=0; i< x.length/2;i++) {
            int temp =x[i];
            x[i]= x[x.length - 1 - i];
            x[x.length -1 -i] =temp;
        }
    }

    //Q7: نحسب طول الباس
    public static int checkLength(String pass) {
        if (pass.length()>=8) {
            return 3;
        } else if (pass.length()>= 6) {
            return 2;
        } else {
            return 0;
        }
    }

    //Q7: نشوف اذا في سبيشال كاريكتر
    public static int checkSpecialCharacters(String pass) {
        for (int i=0; i<pass.length(); i++) {
            char c=pass.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return 2;
            }
        }
        return 0;
    }

    //Q: تشييك الحروف لازم كبير وصغير
    public static int checkUpperCaseLowerCase(String pass) {
        boolean upper=false;
        boolean lower=false;
        for (int i=1; i < pass.length(); i++) {
            char c= pass.charAt(i);
            if (Character.isUpperCase(c)) {
                upper= true;
            }
            if (Character.isLowerCase(c)) {
                lower= true;
            }
        }
        if (upper && lower) {
            return 3;
        }
        return 0;
    }

    //Q8: fibonacci
    public static void fibonacci(int n) {
        int first=0;
        int second=1;
        System.out.println("fibonacci sequence:");
        for (int i=1; i<n; i++) {
            System.out.print(first+ " ");
            int next= first + second;
            first=second;
            second= next;
        }
    }
}