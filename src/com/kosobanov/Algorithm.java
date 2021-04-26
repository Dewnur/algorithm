package com.kosobanov;

import com.kosobanov.components.*;

import java.io.IOException;
import java.util.ArrayList;

public class Algorithm {
    public ArrayList<Matherboard> matherboards;
    public ArrayList<Processor> processors;
    public ArrayList<Cooler> coolers;
    public ArrayList<VideoCard> videoCards;
    public ArrayList<Hard> hards;
    public ArrayList<SSD> ssds;
    public ArrayList<PowerSup> powerSups;
    public ArrayList<OperMem> operMems;
    public ArrayList<Housing> housings;
    public ArrayList<Configuration> configurations;

    public Algorithm() throws IOException {
        this.matherboards = Data.getMatherboard();
        this.processors = Data.getProcessor();
        this.coolers = Data.getCooler();
        this.videoCards = Data.getVideoCard();
        this.hards = Data.getHard();
        this.ssds = Data.getSSD();
        this.powerSups = Data.PowerSup();
        this.operMems = Data.getOperMem();
        this.housings = Data.getHousing();
    }

    public void setConfiguration(Type type, int sum) {
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
}
