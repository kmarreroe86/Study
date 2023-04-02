package questions;

// https://www.youtube.com/watch?v=FB6RsHx7S6A&index=4&list=WL&t=0s
public class TalentSprintTrickyQuestions {
	
	static int a = 1111;
	static {
		a = a-- - --a;
	}

	public static void main(String[] args) {
		/*
		 *  \u000d => new line unicode character
		 */
		 
		// \u000d System.out.println("command executed");
		
		String s = "one"+1+2+"three"+"five"+5;
		System.out.println(s);
		
		int i = 10+ +11- -12+ +13- -14+ +15;
		
		String one = "Random";
		String two = "RAndom";
		if(one == two) {
			System.out.println("one is equal two");
		} else {
			System.out.println("one is not equal two");
		}
		
		System.out.println(Fruit.Type);
		
		Integer i1 = 127;
		Integer i2 = 127;
		System.out.println(i1 == i2);
		
		Integer i3 = 128;
		Integer i4 = 128;
		System.out.println(i3 == i4);
		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Double.MIN_VALUE);
		System.out.format("Min Double.MIN_VALUE, 0.0d: %f%n", Math.min(Double.MIN_VALUE, 0.0d));
		System.out.format("Min Integer.MIN_VALUE, 0.0d: %f%n", Math.min(Integer.MIN_VALUE, 0.0d));
		System.out.println("static a value: " + a);
	}
	
	

}

interface IFruit{
	public String Type = "Apple";
}
class Fruit implements IFruit {
	
}
