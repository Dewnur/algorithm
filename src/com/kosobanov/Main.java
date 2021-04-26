package com.kosobanov;

import com.kosobanov.components.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Matherboard> matherboards = Data.getMatherboard();
        ArrayList<Processor> processors = Data.getProcessor();
        ArrayList<Cooler> coolers = Data.getCooler();
        ArrayList<VideoCard> videoCards = Data.getVideoCard();
        ArrayList<Hard> hards = Data.getHard();
        ArrayList<SSD> ssds = Data.getSSD();
        ArrayList<PowerSup> powerSups = Data.PowerSup();
        ArrayList<OperMem> operMems = Data.getOperMem();
        ArrayList<Housing> housings = Data.getHousing();
        ArrayList<Configuration> configurations = new ArrayList<>();

        ///Параметры///
        Type type = Type.G;
        int sum = 70000;
        //////////////

        setConfiguration(matherboards, processors, videoCards, ssds, operMems,
                coolers, hards, powerSups, housings, configurations, type, sum);
        Collections.sort(configurations, Comparator.comparing(Configuration::getRank));
//        for (Configuration cn : configurations) {
//            System.out.println(String.format("{Math: %s, proc: %s, video: %s, ssd: %s, oper: %s}\n" +
//                            "{power: %s, cooler: %s, hard: %s, housing: %s,  rank: %s, price: %s}\n", cn.math.model,
//                    cn.proc.model, cn.video.model, cn.ssd.model, cn.oper.memory,
//                    cn.power.model, cn.cooler.model, cn.hard.model, cn.hous.model, cn.rank, cn.price));
//        }
        int priceMin = configurations.stream().min(Comparator.comparing(Configuration::getPrice)).get().price;
        int R = 0;
        int size = 0;
        for (Configuration cn : configurations) {
            if(cn.rank != R && cn.price >= sum - ((cn.price)/100)*10) {
                System.out.println(String.format("{Math: %s, proc: %s, video: %s, ssd: %s, oper: %s}\n" +
                                "{power: %s, cooler: %s, hard: %s, housing: %s,  rank: %s, price: %s}\n", cn.math.model,
                        cn.proc.model, cn.video.model, cn.ssd.memory, cn.oper.freq,
                        cn.power.model, cn.cooler.model, cn.hard.model, cn.hous.model, cn.rank, cn.price));
                R = cn.rank;
                size++;
            }

        }
        System.out.println("Всего : " + configurations.size());
        System.out.println(size);
        System.out.println("Price min : " + priceMin);

        //Configurator(configurations, matherboards, processors, coolers);
        //Collections.sort(configurations, Comparator.comparing(Configurations::getPrice));
        //Collections.sort(configurations, (a, b) -> a.math.compareTo(b.math));

    }


    public static void setConfiguration(ArrayList<Matherboard> matherboards,
                                        ArrayList<Processor> processors,
                                        ArrayList<VideoCard> videoCards,
                                        ArrayList<SSD> ssds,
                                        ArrayList<OperMem> operMems,
                                        ArrayList<Cooler> coolers,
                                        ArrayList<Hard> hards,
                                        ArrayList<PowerSup> powerSups,
                                        ArrayList<Housing> housings,
                                        ArrayList<Configuration> configurations, Type type, int sum) {
        for (Matherboard m : matherboards) {
            Configuration cn = new Configuration();
            if (cn.checkMath(m, type, sum))
                for (Processor pr : processors)
                    if (cn.sravMathProc(m, pr) && cn.checkProc(pr, type, sum))
                        for (VideoCard v : videoCards)
                            if (cn.checkVideo(v, type, sum))
                                for (SSD s : ssds)
                                    if (cn.checkSSD(s, type, sum))
                                        for (OperMem o : operMems)
                                            if (cn.checkOper(o, type, sum))
                                                for (PowerSup p : powerSups)
                                                    if (cn.sravPow(p, sum))
                                                        for (Cooler c : coolers)
                                                            if (cn.sravCooler(c, sum))
                                                                for (Hard hd : hards)
                                                                    if (cn.sravHard(hd, sum))
                                                                        for (Housing h : housings)
                                                                            if (cn.sravHousing(h, sum)) {
                                                                                Configuration cnNew = new Configuration(cn.math, cn.proc, cn.video, cn.ssd, cn.oper, cn.hard,
                                                                                        cn.power, cn.cooler, cn.hous, null, cn.rank, cn.price); //Почему-то переназначает предыдущий объект
                                                                                configurations.add(cnNew);
                                                                            }
        }
    }

//    public void setConfiguration2(ArrayList<Matherboard> matherboards,
//                                  ArrayList<Processor> processors,
//                                  ArrayList<VideoCard> videoCards,
//                                  ArrayList<SSD> ssds,
//                                  ArrayList<OperMem> operMems,
//                                  ArrayList<Cooler> coolers,
//                                  ArrayList<Hard> hards,
//                                  ArrayList<PowerSup> powerSups,
//                                  ArrayList<Housing> housings,
//                                  ArrayList<Configuration> configurations, Type type, int sum) {
//        for (Matherboard m : matherboards) {
//            Configuration cn1 = new Configuration();
//            if (cn1.checkMath(m, type, sum)) {
//                Configuration cn2 = new Configuration(cn1.math, null, null, null, null, null,
//                        null, null, null, null, cn1.rank, cn1.price); //Почему-то переназначает предыдущий объект
//                for (Processor pr : processors)
//                    if (cn2.sravMathProc(m, pr) && cn2.checkProc(pr, type, sum)) {
//                        Configuration cn3 = new Configuration(cn2.math, cn2.proc, null, null, null, null,
//                                null, null, null, null, cn2.rank, cn2.price); //Почему-то переназначает предыдущий объект
//                        for (VideoCard v : videoCards)
//                            if (cn3.checkVideo(v, type, sum)) {
//                                Configuration cn4 = new Configuration(cn3.math, cn3.proc, cn3.video, null, null, null,
//                                        null, null, null, null, cn3.rank, cn3.price); //Почему-то переназначает предыдущий объект
//                                for (SSD s : ssds)
//                                    if (cn4.checkSSD(s, type, sum)) {
//                                        Configuration cn5 = new Configuration(cn4.math, cn4.proc, cn4.video, cn4.ssd, null, null,
//                                                null, null, null, null, cn4.rank, cn4.price); //Почему-то переназначает предыдущий объект
//                                        for (OperMem o : operMems)
//                                            if (cn5.checkOper(o, type, sum)) {
//                                                Configuration cn6 = new Configuration(cn5.math, cn5.proc, cn5.video, cn5.ssd, cn5.oper, null,
//                                                        null, null, null, null, cn5.rank, cn5.price); //Почему-то переназначает предыдущий объект
//                                                for (PowerSup p : powerSups)
//                                                    if (cn6.sravPow(p, sum)) {
//                                                        Configuration cn7 = new Configuration(cn6.math, cn6.proc, cn6.video, cn6.ssd, cn6.oper, null,
//                                                                cn6.power, null, null, null, cn6.rank, cn6.price); //Почему-то переназначает предыдущий объект
//                                                        for (Cooler c : coolers)
//                                                            if (cn7.sravCooler(c, sum)) {
//                                                                Configuration cn8 = new Configuration(cn7.math, cn7.proc, cn7.video, cn7.ssd, cn7.oper, null,
//                                                                        cn7.power, cn7.cooler, null, null, cn7.rank, cn7.price); //Почему-то переназначает предыдущий объект
//                                                                for (Hard hd : hards)
//                                                                    if (cn8.sravHard(hd, sum)) {
//                                                                        Configuration cn9 = new Configuration(cn8.math, cn8.proc, cn8.video, cn8.ssd, cn8.oper, cn8.hard,
//                                                                                cn8.power, cn8.cooler, null, null, cn8.rank, cn8.price); //Почему-то переназначает предыдущий объект
//                                                                        for (Housing h : housings)
//                                                                            if (cn9.sravHousing(h, sum)) {
//                                                                                Configuration cn10 = new Configuration(cn9.math, cn9.proc, cn9.video, cn9.ssd, cn9.oper, cn9.hard,
//                                                                                        cn9.power, cn9.cooler, cn9.hous, null, cn9.rank, cn9.price); //Почему-то переназначает предыдущий объект
//                                                                                configurations.add(cn10);
//                                                                            }
//                                                                    }
//                                                            }
//                                                    }
//                                            }
//                                    }
//                            }
//                    }
//            }
//        }
//    }

}
