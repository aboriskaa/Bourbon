// Bourbon ingredient calculator look like a Jack Daniels
// Russian version
// Aboriskaa: 9600929@gmail.com

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;
public class bourbon {
    public static void main(String[] args) {
        System.out.println("Привет! Расчитаем ингредиенты для Jack Daniels!");
        System.out.println("(Следует говорить: кукурузный самогон, напоминающий Jack Daniels!)");
        System.out.println();
        call();
        repeat();
    }
    public static void call() {
        try {
            double varMaxKg = enterData();
            if (varMaxKg>0){prnt(counting(varMaxKg));}
            else {System.out.println("Даные отсутсвуют...");}
        }
        catch (InputMismatchException e){
            System.out.println("Оу! Это не цифры, увы(((");
            call();
        }
    }
    public static double enterData(){
        Scanner entrDat = new Scanner(System.in);
        System.out.print("Введите желаемый объем засыпки в кг ");
        double varMaxKg = entrDat.nextDouble();
        return varMaxKg;
    }
    public static double[] counting (double count){
        double[] res = new double[6];
        res[0] = count * 0.8;
        res[1] = count * 0.08;
        res[2] = count * 0.12;
        res[3] = res[0] * 0.025;
        res[4] = count * 4.0;
        res[5] = count + res[4];
        for (int i=0; i < res.length; i++){
            res[i] = new BigDecimal(res[i]).setScale(2, RoundingMode.UP).doubleValue();
        }
        return res;
    }
    public static void prnt (double[] count){
        double[] res = count;
        System.out.println("Необходимо кукурузной муки или крупы: "+ res[0]+ " кг.");
        System.out.println("Необходимо ржаной муки: "+ res[1]+ " кг.");
        System.out.println("Необходимо ячменного солода: "+ res[2]+ " кг.");
        System.out.println("Необходимо дрожжей: "+ res[3]+ " кг.");
        System.out.println("Необходимо воды: "+ res[4]+ " литров");
        System.out.println("Общий объем браги: "+ res[5]+ " кг.");
    }
    public static void repeat(){
        System.out.println();
        System.out.print("Желаете - ли Вы повторить подсчет ингредиентов? Y/N: ");
        Scanner entrVar = new Scanner(System.in);
        String var = entrVar.nextLine();
        if (var.equals("Y") || var.equals("y")){
            call();
            repeat();
        } else {
            System.out.print("Спасибо! До новых встреч! =)))");
        }
    }
}
