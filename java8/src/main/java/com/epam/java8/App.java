package com.epam.java8;

import java.util.ArrayList;

import java.util.function.Predicate;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Hello world!
 *
 */
@FunctionalInterface
interface Pallin{
	List<String> getPallindromes(List<String> list);
}
public class App implements Pallin
{
	private static final Logger LOGGER=LogManager.getLogger(App.class);
	private static Scanner in;
	public static double getAverage(int[] arr) {
		IntStream stream = IntStream.of(arr); 
        OptionalDouble obj = stream.average(); 
        if (obj.isPresent()) { 
        	return (obj.getAsDouble()); 
        } 
        else { 
            return -1.0; 
        } 
	}
	public static List<String> getrequiredresult(List<String>listWords){
		return listWords.stream().filter(s -> s.startsWith("a")).filter(s -> s.length() == 3).collect(Collectors.toList());
	}
	static boolean pallin(String s)
	{
		return IntStream.range(0, s.length() / 2).noneMatch(i -> s.charAt(i) != s.charAt(s.length() - i - 1));
	}
	public  List<String> getPallindromes(List<String> s) {
		List<String>finalList=new ArrayList<String>();
			Predicate<String> p = (str)->pallin(str);
			for (String st:s) 
			{
	            if (p.test(st)) 
	                finalList.add(st); 
	        } 
		return finalList;
	}
    public static void main( String[] args )
    {
    	in =new Scanner(System.in);
    	LOGGER.debug("Enter size of array");
    	int n = in.nextInt();
    	int[] arr=new int[n];
    	LOGGER.debug("Enter elements ");
    	for(int i=0;i<n;i++) {
    		arr[i]=in.nextInt();
    	}
    	LOGGER.debug("Average is");
    	LOGGER.debug(getAverage(arr));
    	LOGGER.debug("Number of words");
    	int sizeWordsList=in.nextInt();
    	in.nextLine();
    	LOGGER.debug("Enter the words");
    	List<String>listWords=new ArrayList<>();
    	for(int i=0;i<sizeWordsList;i++) {
    		listWords.add(in.nextLine());
    	}
    	List<String>wordsStartWitha=getrequiredresult(listWords);
    	if(wordsStartWitha.size()==0)
    		LOGGER.debug("There is no word starting with a and having length of 3");
    	else {
    	LOGGER.debug("List of words starts with a and having length 3 ");
    	for(int i=0;i<wordsStartWitha.size();i++) {
    		LOGGER.debug(wordsStartWitha.get(i));
    	}
    	}
    	LOGGER.debug("Enter the Number of words");
    	
    	int sizeofList=in.nextInt();
    	in.nextLine();
    	LOGGER.debug("Enter the words");
    	List<String>SecondlistWords=new ArrayList<>();
    	for(int i=0;i<sizeofList;i++) {
    		SecondlistWords.add(in.nextLine());
    	}
    	App p=new App();
    	List<String>PallindromeStringList=p.getPallindromes(SecondlistWords);
    	if(PallindromeStringList.size()==0)
    		LOGGER.debug("There is no pallindrome  word ");
    	else {
    	LOGGER.debug("List of Pallindrome words");
    	for(int i=0;i<PallindromeStringList.size();i++) {
    		LOGGER.debug(PallindromeStringList.get(i));
    	}
    	}
    }
}
