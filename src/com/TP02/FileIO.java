package com.TP02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public void writeFile() {
        try {
            FileOutputStream fos = new FileOutputStream("Onibus.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Main.getOnibusVet());
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try {
            File file = new File("Onibus.bin");
            file.createNewFile();
            if (file.length() > 0) {
                FileInputStream fis = new FileInputStream("Onibus.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);
                Main.setOnibusVet((ArrayList<Onibus>) ois.readObject());
                ois.close();
            }else
                Main.onibusVet = new ArrayList<>();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}