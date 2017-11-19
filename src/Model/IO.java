package Model;

import View.Board;

import java.io.*;

public class IO {
    public String str = "";
    private World world;

    public IO(World world) {
        this.world = world;
    }

    public int toINT(String str){
        int ans = 0;
        for(char ch : str.toCharArray())
            ans = ans * 10 + (ch - '0');
        return ans;
    }

    public void read() throws IOException{
        FileReader in = null;

        try {
            in = new FileReader("src/Model/map.txt");
            char ch;
            while((ch = (char)in.read()) != '%')
                str += ch;
            World.N = toINT(str);
            str = "";
            while((ch = (char)in.read()) != '%')
                str += ch;
            World.M = toINT(str);
            for(int i = 0; i < World.N; i ++) {
                in.read();
                for (int j = 0; j < World.M; j++) {
                   world.setElement(new Element(new Point(i, j), (char)in.read(), world));
                }
            }


        }
        finally {
            if (in != null) {
                in.close();
            }
        }
        //System.out.print(str);
    }

}