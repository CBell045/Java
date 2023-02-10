public class projectEuler1 {
    public static void main(String[] args){
        int sum = 0;
        // sum = 0;
        for(int i = 3; i<1000; i+=3) {
            if(i % 5 == 0){
                continue;
            }
        sum += i;
        }
        for(int j = 5; j<1000; j+=5) {
            sum += j;
        }
        System.out.println(sum);
    }
}

