import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static  Map<String,Integer> map=new HashMap<>();
 static  Integer destination=0;
    public static void main(String args[])
    {
        Set<String> cityName=new TreeSet<>();
        Graph g = new Graph(6);
        System.out.println("Enter the number of cities--");
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        System.out.println("Enter the Cities ");
        String city="";
        int s,d=0;
        int km=0;
        int j=0;
        int k=0;
        for(int i=0;i<N;i++){
          city=sc.next();
          map.put(city,j);
          j++;
        }
        System.out.println(map.toString());
        for(int i=0;i<N;i++) {
    //        System.out.println("Enter the route path - "+i);
            s=sc.nextInt();
            d=sc.nextInt();
            km=sc.nextInt();
            g.addEdge(s,d,km);
        }
        System.out.println(map.toString());
       String src,desti="";
        System.out.print("Enter the source and des  "+ " \n" );
        src=sc.next();
        desti=sc.next();
        destination=map.get(desti);
        g.longestPath(map.get(src),map.get(desti));
    }
}
