package com.kosobanov;

import com.kosobanov.components.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Data {
    public static ArrayList<Matherboard> getMatherboard() throws IOException {
        String file = "Matherboards.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<Matherboard> obj = new ArrayList<>();
        ArrayList<String[]> N = new ArrayList<>();
        try{
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while((line = reader.readLine()) != null)
                N.add(line.split(";"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            for(String[] n : N)
                obj.add(new Matherboard(n[0], Socket.formString(n[1]), Chipset.formString(n[2]), Integer.parseInt(n[3]), Integer.parseInt(n[4])
                        , FormFactor.formString(n[5]), Integer.parseInt(n[6]), Integer.parseInt(n[7]))); //Создаем объекты
            reader.close();
        }
        return obj;
    }


    public static ArrayList<Processor> getProcessor() throws IOException {
        String file = "Processors.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<Processor> obj = new ArrayList<>();
        ArrayList<String[]> N = new ArrayList<>();
        try{
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while((line = reader.readLine()) != null)
                N.add(line.split(";"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            for(String[] n : N)
                obj.add(new Processor(n[0], Socket.formString(n[1]), Integer.parseInt(n[2]), Integer.parseInt(n[3]), Integer.parseInt(n[4]),
                        Integer.parseInt(n[5]), Integer.parseInt(n[6]), Integer.parseInt(n[7]))); //Создаем объекты
            reader.close();
        }
        return obj;
    }

    public static ArrayList<VideoCard> getVideoCard() throws IOException {
        String file = "VideoCards.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<VideoCard> obj = new ArrayList<>();
        ArrayList<String[]> N = new ArrayList<>();
        try{
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while((line = reader.readLine()) != null)
                N.add(line.split(";"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            for(String[] n : N)
                obj.add(new VideoCard(n[0], Integer.parseInt(n[1]), Integer.parseInt(n[2]), Integer.parseInt(n[3]), Integer.parseInt(n[4]), Integer.parseInt(n[5]))); //Создаем объекты
            reader.close();
        }

        return obj;
    }

    public static ArrayList<SSD> getSSD() throws IOException {
        String file = "SSD.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<SSD> obj = new ArrayList<>();
        ArrayList<String[]> N = new ArrayList<>();
        try{
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while((line = reader.readLine()) != null)
                N.add(line.split(";"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            for(String[] n : N)
                obj.add(new SSD(n[0], Integer.parseInt(n[1]), Integer.parseInt(n[2]), Integer.parseInt(n[3]), Integer.parseInt(n[4]), Integer.parseInt(n[5]))); //Создаем объекты
            reader.close();
        }
        return obj;
    }

    public static ArrayList<OperMem> getOperMem() throws IOException {
        String file = "OperMem.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<OperMem> obj = new ArrayList<>();
        ArrayList<String[]> N = new ArrayList<>();
        try{
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while((line = reader.readLine()) != null)
                N.add(line.split(";"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            for(String[] n : N)
                obj.add(new OperMem(n[0], Integer.parseInt(n[1]), Integer.parseInt(n[2]), Integer.parseInt(n[3]), Integer.parseInt(n[4]))); //Создаем объекты
            reader.close();
        }
        return obj;
    }

    public static ArrayList<Hard> getHard() throws IOException {
        String file = "Hard.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<Hard> obj = new ArrayList<>();
        ArrayList<String[]> N = new ArrayList<>();
        try{
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while((line = reader.readLine()) != null)
                N.add(line.split(";"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            for(String[] n : N)
                obj.add(new Hard(n[0], Integer.parseInt(n[1]), Integer.parseInt(n[2]))); //Создаем объекты
            reader.close();
        }
        return obj;
    }

    public static ArrayList<PowerSup> PowerSup() throws IOException {
        String file = "PowerSup.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<PowerSup> obj = new ArrayList<>();
        ArrayList<String[]> N = new ArrayList<>();
        try{
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while((line = reader.readLine()) != null)
                N.add(line.split(";"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            for(String[] n : N)
                obj.add(new PowerSup(n[0], Integer.parseInt(n[1]), Integer.parseInt(n[2]))); //Создаем объекты
            reader.close();
        }
        return obj;
    }

    public static ArrayList<Cooler> getCooler() throws IOException {
        String file = "Cooler.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<Cooler> obj = new ArrayList<>();
        ArrayList<String[]> N = new ArrayList<>();
        try{
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while((line = reader.readLine()) != null)
                N.add(line.split(";"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            for(String[] n : N)
                obj.add(new Cooler(n[0], Integer.parseInt(n[1]), Integer.parseInt(n[2]))); //Создаем объекты
            reader.close();
        }
        return obj;
    }

    public static ArrayList<Housing> getHousing() {
        ArrayList<Housing> obj= new ArrayList<>();
        obj.add(new Housing("DEXP DC-101B",1799));
//        obj.add(new Housing("Cougar MX330-F",3999));
//        obj.add(new Housing("DEEPCOOL MATREXX 50 ADD-RGB 3F",4599));
//        obj.add(new Housing("ZALMAN i3 Edge",3799));
//        obj.add(new Housing("DEEPCOOL MATREXX 70 3F",8299));

        return obj;
    }

}
