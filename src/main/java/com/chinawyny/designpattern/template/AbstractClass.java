package com.chinawyny.designpattern.template;

public abstract class AbstractClass {

    final void cookProcess () {
        this.pourOil();
        this.HeatOil();
        this.pourVegetable();
        this.pourSauce();
        this.fry();
        
    }

    protected abstract void pourSauce();

    protected abstract void pourVegetable();

    void fry() {
        System.out.println("fry");
    }

    void HeatOil() {
        System.out.println("热油");
    }

    void pourOil() {
        System.out.println("倒油");
    }

    public static void main(String[] args) {
        AbstractClass baocai = new ZuoBaoCai();
        baocai.cookProcess();
        AbstractClass caixin = new ZuoCaiZin();
        caixin.cookProcess();
    }
}

class ZuoBaoCai extends AbstractClass {
    @Override
    protected void pourSauce() {
        System.out.println("蒜蓉");
    }

    @Override
    protected void pourVegetable() {
        System.out.println("放包菜");
    }
}

class ZuoCaiZin extends AbstractClass {
    @Override
    protected void pourSauce() {
        System.out.println("酱油");
    }

    @Override
    protected void pourVegetable() {
        System.out.println("放菜心");
    }

}
