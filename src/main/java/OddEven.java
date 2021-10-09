public class OddEven {

    public  String oddEven(int number){

        if (number%2!=0){
            return "Odd";
        }
        if (number%2==0){
            return "Even";
        }
        if (number > Integer.MAX_VALUE ){
            return "Undefined";
        } else {
            return "Undefined";
        }
    }

//    public static void main(String[] args) {
//        System.out.println(oddEven(-345));
//        System.out.println(oddEven(0));
//        System.out.println(oddEven(222_222));
//        System.out.println(oddEven((11)));
//    }

}
