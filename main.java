package lab5;

import java.util.Random;
import java.util.Scanner;

import lab5.Rational;

public class main {
	public void Sort(Rational[] arr) 
	{
        int i = 0;
        int goodPairsCounter = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("1. Compare by numenator\n2. Compare by denominator\n3. Compare all fraction: ");
        int k=in.nextInt();
        	switch(k)
        	{
        	case 1:
        	{
        		while (true) 
                {
        		 if (arr[i].compareA(arr[i + 1]) ==1)
                 {
                     Rational q = arr[i];
                     arr[i] = arr[i + 1];
                     arr[i + 1] = q;
                     goodPairsCounter = 0;
                 } else 
                 {
                     goodPairsCounter++;
                 }
                 i++;
                 if (i == arr.length - 1) 
                 {
                     i = 0;
                 }
                 if (goodPairsCounter == arr.length - 1) break;
                 }
        		break;
        		}
        	case 2:
        	{
        		while (true) 
                {
        		 if (arr[i].compareB(arr[i + 1]) ==1) 
                 {
                     Rational q = arr[i];
                     arr[i] = arr[i + 1];
                     arr[i + 1] = q;
                     goodPairsCounter = 0;
                 } else 
                 {
                     goodPairsCounter++;
                 }
                 i++;
                 if (i == arr.length - 1) 
                 {
                     i = 0;
                 }
                 if (goodPairsCounter == arr.length - 1) break;
                }
        		break;
        	}
        	case 3:
        	{
        		while (true) 
                {
        		 if (arr[i].compareTo(arr[i + 1]) ==1) 
                 {
                     Rational q = arr[i];
                     arr[i] = arr[i + 1];
                     arr[i + 1] = q;
                     goodPairsCounter = 0;
                 } else 
                 {
                     goodPairsCounter++;
                 }
                 i++;
                 if (i == arr.length - 1) 
                 {
                     i = 0;
                 }
                 if (goodPairsCounter == arr.length - 1) break;
                }
        		break;
        	}
        }
}
	public static void main(String[] args) 
	{
		Random rnd=new Random();
		Scanner in=new Scanner(System.in);
		Rational f = new Rational(1,4);
		Rational g = new Rational(1,2);
		int n;
		System.out.println("First fraction");
		System.out.println(f.toString());
		System.out.println("Second fraction");
		System.out.println(g.toString());
		System.out.println("Fraction made by copy constuctor");
		Rational l=new Rational(f);
		System.out.println(l.toString());
		System.out.print("Summ of fractions: ");
		f=f.add(g);
		System.out.println(f.toString());
		System.out.print("Summ of fraction and digit: ");
		f=f.addInt(5);
		System.out.println(f.toString());
		System.out.print("Sub of fractions: ");
		f=f.sub(g);
		System.out.println(f.toString());
		System.out.print("Sub of fraction and digit: ");
		f=f.subInt(6);
		System.out.println(f.toString());
		System.out.print("Multiply of fractions: ");
		f=f.mult(g);
		System.out.println(f.toString());
		System.out.print("Multiply of fraction and digit: ");
		f=f.multInt(5);
		System.out.println(f.toString());
		System.out.print("Divide of fractions: ");
		f=f.div(g);
		System.out.println(f.toString());
		System.out.print("Divide of fraction and digit: ");
		f=f.divInt(3);
		System.out.println(f.toString());
		System.out.println("Using next: ");
		System.out.println("a = "+f.next());
		System.out.println("b = "+f.next());
		System.out.print("Reverse of fraction: ");
		System.out.println(f.reverse());
		System.out.println("Pick size of massive");
		n=in.nextInt();
		Rational []j=new Rational[n];
		System.out.println("1.Make massive randomly or 2.Fill it manually?");
		int k=in.nextInt();
		System.out.println("Massive of fractions");
		if(k==1)
		{
		for(int i=0;i<n;i++)
		{
			int a=rnd.nextInt(10)+1,b=rnd.nextInt(10)+1;
			j[i]=new Rational(a,b);
			System.out.print(j[i].toString()+" ");
		}
		System.out.println("");
		}
		else
		{
			for(int i=0;i<n;i++)
			{
				System.out.println("Enter numenator, then denominator");
				int a=in.nextInt();
				int b=in.nextInt();
				j[i]=new Rational(a,b);
			}
			for(int i=0;i<n;i++)
			{
				System.out.print(j[i].toString()+" ");
			}
			System.out.println("");
		}
		main Main=new main();
		Main.Sort(j);
		for(int i=0;i<n;i++)
		{
			System.out.print(j[i].toString()+" ");
		}
		System.out.println("");
		in.close();
		System.exit(0);
	}
}
