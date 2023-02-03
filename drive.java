import java.util.*;
public class drive {
    public static void main(String[] args) {
        Scanner sg=new Scanner(System.in);
        HashMap<String,Integer>com=new HashMap<>();
        ArrayList<String>order=new ArrayList<>();
        ArrayList<String>repeat=new ArrayList<>();
        HashMap<String,ArrayList<String>>connect=new HashMap<>();
        HashMap<String,Integer>rep=new HashMap<>();
        String tree[][]=new String[10][10];
        while(sg.hasNext())
        {
            String inp[]=sg.nextLine().split(" ");
            if(inp.length<3)
            {
                System.out.println("Invalid command systax");
            }
            else
            {

            if(inp[0].equals("ADD"))
            {
            if(inp[1].equals("COMPUTER"))
            {
                if(!com.containsKey(inp[2]))
                {
                    com.put(inp[2],0);
                    order.add(inp[2]);
                    connect.put(inp[2],new ArrayList<>());
                    System.out.println("Successfully added "+inp[2]);
                }
                else
                {
                    System.out.println("That name already exists");
                }
            }
            else if(inp[1].equals("REPEATER"))
            {
                if(!com.containsKey(inp[2]))
                {
                    com.put(inp[2],0);
                    order.add(inp[2]);
                    connect.put(inp[2],new ArrayList<>());
                    repeat.add(inp[2]);
                    System.out.println("Successfully added "+inp[2]);
                }
                else
                {
                    System.out.println("That name already exists");
                }
            }
            else
            {
                System.out.println("Invalid command systax");
            }
    }


        else if(inp[0].equals("SET_DEVICE_STRENGTH"))
        {
            try{
                com.put(inp[1],Integer.parseInt(inp[2]));
                System.out.println("Successfully defined strength");
            }
            catch (Exception e)
            {
                System.out.println("Invalid command systax");
            }

        }

        else if(inp[0].equals("CONNECT"))
        {
            Collections.sort(order);
            int i=order.indexOf(inp[1]);
            int j=order.indexOf(inp[2]);
            if(i>=0&&j>=0)
            {
            if(inp[1].equals(inp[2]))
            {
                System.out.println("Cannot connect device to itself");
            }
            else if(tree[i][j]!=null)
            {
                
                System.out.println("Devices are already connected");
            }
            
            else
            {
               
                tree[i][j]=inp[2]+"";
                System.out.println("Successfully connected");
                System.out.println(Arrays.asList(tree));
                for(String arr[]:tree)
                {
                    System.out.println(Arrays.deepToString(arr));
                }

            }
        }
    }
        else if(inp[0].equals("INFO_ROUTE"))
        {
            if(repeat.contains(inp[2]))
            {
                System.out.println("Route cannot be calculated with a repeater");
            }
            else if(!order.contains(inp[1])||!order.contains(inp[1]))
            {
                System.out.println("Node not found");
            }
            else{
            int check=0;
            String res="";
            int i=order.indexOf(inp[1]);
            for(int j=0;j<order.size();j++)
            {
                if(tree[i][j]!=null)
                {
                    res+=tree[i][j]+"->";
                    if(tree[i][j].equals(inp[2]))
                    {
                        check=1;
                    break;
                    }
                }
            }
            if(check==0)
            {
                System.out.println("Route not found!");
            }
            else
            {
            String ans=inp[1]+"->"+res.substring(0,res.length()-2);
            System.out.println(ans);


           }
        }
    }
    }

    }
}
}
    

