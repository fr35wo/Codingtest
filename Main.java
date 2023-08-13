import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        //변의 방향에서 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4로 나타낸다.
        int[] direction = new int[6];
        int[] length = new int[6];
        int final_high=0;
        int final_width=0;
        int no_area=0;
        Scanner sc = new Scanner(System.in);
        int korea_melon = sc.nextInt();
        for(int i=0;i<6;i++ ){
            direction[i] = sc.nextInt();
            length[i] = sc.nextInt();

        }
        for(int i=0;i<6;i++) {

            if (direction[i] == 1) {
                final_high += length[i];

            } else if (direction[i] == 3) {
                final_width += length[i];
            }
        }
        for(int i=0;i<6;i++){
            if((direction[0] == direction[2]) && (direction[1]!=direction[3])) {
                no_area=length[0]*length[1];
                System.out.println("1");
                break;

            }else if(direction[i] == direction[i+2] ) {
                no_area= length[i+1]*length[i+2];
                System.out.println("2");
                break;
            }else if(direction[1] == direction[5]){
                no_area=length[0]*length[5];
                System.out.println("3");
                break;
            }
        }
        System.out.println(((final_high*final_width)-no_area)*korea_melon);





    }
}