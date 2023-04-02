package test;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Write a function that capitalizes a text. Example: "this is not capitalized" -> "This Is Not Capitalized"
 * */
public class CapitalizeLetter {

	public static void main(String[] args) {		

		System.out.println(capitalizeText("this is not capitalized"));

		String s1 = new String("kaka");
		String s2 = "kaka";
		System.out.println(s2.hashCode());
		s2 = "kaka2";
		System.out.println(s1.intern().hashCode() == s2.hashCode());
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());

	}

	public static String capitalizeText(String str) {

		String[] strArray = str.split(" ");
		String[] strCapitalizedArray = new String[str.split(" ").length];
		for (int i = 0; i < strArray.length; i++) {
			strCapitalizedArray[i] = strArray[i].substring(0, 1).toUpperCase() + strArray[i].substring(1);
		}

//		return String.join(" ", strCapitalizedArray);


		System.out.println("Arrays.stream");
		var strCapitalized = Arrays.stream(str.split(" "))
				.map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
				.collect(Collectors.joining());
		System.out.println(strCapitalized);

		return String.join(" ", strCapitalizedArray);
	}

}
