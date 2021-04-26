package com.kosobanov;

import com.kosobanov.components.*;

public class Configuration {
    public Matherboard math;
    public Processor proc;
    public VideoCard video;
    public SSD ssd;
    public OperMem oper;
    public Hard hard;
    public PowerSup power;
    public Cooler cooler;
    public Housing hous;
    public int price;
    public int rank;

    public Configuration(Matherboard math, Processor proc, VideoCard video, SSD ssd,
                         OperMem oper, Hard hard, PowerSup power, Cooler cooler,
                         Housing hous, Type type, int rank, int price) {
        this.math = math;
        this.proc = proc;
        this.video = video;
        this.ssd = ssd;
        this.oper = oper;
        this.hard = hard;
        this.power = power;
        this.cooler = cooler;
        this.hous = hous;
        this.rank = rank;
        this.price = price;
    }

    public Configuration() {
        this.math = null;
        this.proc = null;
        this.video = null;
        this.ssd = null;
        this.oper = null;
        this.hard = null;
        this.power = null;
        this.cooler = null;
        this.hous = null;
        this.price = 0;
        this.rank = 0;
        this.price = 0;
    }

    @Override
    public String toString() {
        return "Configurations{" +
                "math=" + math.model +
                ", proc=" + proc.model +
                ", video=" + video.model +
                ", ssd=" + ssd.model +
                ", oper=" + oper.memory +
                ", hard=" + hard.model +
                ", power=" + power.model +
                ", cooler=" + cooler.model +
                ", hous=" + hous.model +
                ", price=" + price +
                ", rank=" + rank +
                '}';
    }

    public boolean checkProc(Processor proc, Type type, int sum) {
        int pos = proc.price + this.math.price;
        if (type == Type.W && pos < sum && proc.type != Type.P) {
            price = pos;
            this.proc = proc;
            refRank();
            return true;
        } else if (type == Type.G && pos < sum && proc.type != Type.W) {
            price = pos;
            this.proc = proc;
            refRank();
            return true;
        } else if (type == Type.P && pos < sum && proc.type != Type.W && proc.type != Type.G) {
            price = pos;
            this.proc = proc;
            refRank();
            return true;
        }
        return false;
    }

    public boolean checkMath(Matherboard math, Type type, int sum) {
        if (type == Type.W && math.price < sum && math.type != Type.P) {
            price += math.price;
            this.math = math;
            refRank();
            return true;
        } else if (type == Type.G && math.price < sum && math.type != Type.W) {
            price += math.price;
            this.math = math;
            refRank();
            return true;
        } else if (type == Type.P && math.price < sum && math.type != Type.W && math.type != Type.G) {
            price += math.price;
            this.math = math;
            refRank();
            return true;
        }
        return false;
    }

    public boolean checkVideo(VideoCard video, Type type, int sum) {
        int pos = video.price + this.proc.price + this.math.price;
        if (type == Type.W && pos < sum && video.type != Type.G && video.type != Type.P) {
            price = pos;
            this.video = video;
            refRank();
            return true;
        } else if (type == Type.G && pos < sum && video.type != Type.W) {
            price = pos;
            this.video = video;
            refRank();
            return true;
        } else if (type == Type.P && pos < sum && video.type != Type.W && video.type != Type.G) {
            price = pos;
            this.video = video;
            refRank();
            return true;
        }
        return false;
    }

    public boolean checkSSD(SSD s, Type type, int sum) {
        int pos = this.video.price + this.proc.price + this.math.price + s.price;
        if (type == Type.W && pos < sum && s.type != Type.P) {
            price = pos;
            this.ssd = s;
            refRank();
            return true;
        } else if (type == Type.G && pos < sum && s.type != Type.P) {
            price = pos;
            this.ssd = s;
            refRank();
            return true;
        } else if (type == Type.P && pos < sum && s.type != Type.W && s.type != Type.G) {
            price = pos;
            this.ssd = s;
            refRank();
            return true;
        }
        return false;
    }

    public boolean checkOper(OperMem oper, Type type, int sum) {
        int pos = this.video.price + this.proc.price + this.math.price + this.ssd.price + oper.price;
        if (type == Type.W && pos < sum && oper.type != Type.P) {
            price = pos;
            this.oper = oper;
            refRank();
            return true;
        } else if (type == Type.G && pos < sum && oper.type != Type.W && oper.type != Type.P) {
            price = pos;
            this.oper = oper;
            refRank();
            return true;
        } else if (type == Type.P && pos < sum && oper.type != Type.W) {
            price = pos;
            this.oper = oper;
            refRank();
            return true;
        }
        return false;
    }

    public boolean sravMathProc(Matherboard math, Processor proc) {
        if (math.socket == proc.socket)
            return true;
        return false;
    }

    public boolean sravPow(PowerSup p, int sum) {
        int sumPow = video.tdp + proc.tdp;
        int pos = this.video.price + this.proc.price + this.math.price
                + this.ssd.price + this.oper.price + p.price;
        if (p.power >= sumPow + (((double) (sumPow) / 100) * 10) && (double) p.power <= sumPow + (((double) (sumPow) / 100) * 30) && pos < sum) {
            refRank();
            price = pos;
            this.power = p;
            return true;
        }
        return false;
    }

    public boolean sravCooler(Cooler c, int sum) {
        int pos = this.video.price + this.proc.price + this.math.price
                + this.ssd.price + this.oper.price + this.power.price
                + c.price;
        if (this.proc.type == Type.W && pos < sum && c.powDis >= this.proc.tdp && (double) c.powDis <= this.proc.tdp + (((double) (this.proc.tdp) / 100) * 10)) {
            refRank();
            price = pos;
            this.cooler = c;
            return true;
        }
        if (this.proc.type == Type.G && pos < sum && c.powDis > this.proc.tdp && (double) c.powDis <= this.proc.tdp + (((double) (this.proc.tdp) / 100) * 30)) {
            refRank();
            price = pos;
            this.cooler = c;
            return true;
        }
        if (this.proc.type == Type.P && pos < sum && c.powDis > this.proc.tdp && (double) c.powDis <= this.proc.tdp + (((double) (this.proc.tdp) / 100) * 50)) {
            refRank();
            price = pos;
            this.cooler = c;
            return true;
        }

        return false;
    }

    public int getRank() {
        return rank;
    }

    public int getPrice() {
        return price;
    }

    public boolean sravHard(Hard h, int sum) {
        int pos = this.video.price + this.proc.price + this.math.price
                + this.ssd.price + this.oper.price + this.power.price
                + this.cooler.price + h.price;
        if (pos < sum) {
            price = pos;
            this.hard = h;
            return true;
        }
        return false;
    }

    public boolean sravHousing(Housing h, int sum) {
        int pos = this.video.price + this.proc.price + this.math.price
                + this.ssd.price + this.oper.price + this.power.price
                + this.cooler.price + this.hard.price + h.price;
        if (pos < sum) {
            price = pos;
            this.hous = h;
            return true;
        }
        return false;
    }


    public void refRank() {
        this.rank = 0;
        if (math != null) this.rank += math.getRank();
        if (proc != null) this.rank += proc.getRank();
        if (video != null) this.rank += video.getRank();
        if (ssd != null) this.rank += ssd.getRank();
        if (oper != null) this.rank += oper.getRank();
        if(power != null) this.rank += power.getRank();
        if(cooler != null) this.rank += cooler.getRank();
    }


}
