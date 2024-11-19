import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int carNum = Integer.parseInt(br.readLine());
        LinkedHashMap<String, Integer> inCar = new LinkedHashMap<>();

        for(int i=1; i<=carNum; i++) inCar.put(br.readLine(), i);

        int pass = 0;
        for(int i=1; i<=carNum; i++){
            String outCar = br.readLine();

            Iterator<String> it = inCar.keySet().iterator();
            while(it.hasNext()){
                if(inCar.get(outCar) > inCar.get(it.next())){
                    pass++; break;
                }
            }

            inCar.remove(outCar);
        }

        System.out.println(pass);
    }
}