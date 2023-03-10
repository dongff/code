package com.open.design.adapter;

//通过Adapter类从而调用所需要的方法
public class ImportedTV {
    public static void main(String[] args){
        Target mAdapter220V = new Adapter220V();
        ImportedTV mImportedMachine = new ImportedTV();
        //用户拿着进口机器插上适配器（调用Convert_110v()方法）
        //再将适配器插上原有插头（Convert_110v()方法内部调用Output_220v()方法输出220V）
        //适配器只是个外壳，对外提供110V，但本质还是220V进行供电
        mAdapter220V.Convert_110v();
        mImportedMachine.Work();
    }

    public void Work() {
        System.out.println("TV正常运行");
    }
}