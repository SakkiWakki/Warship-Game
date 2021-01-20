package com.sakkiwakki.warshipgame.resource;

import java.util.Arrays;

import com.sakkiwakki.warshipgame.view.SelectScreen;

public class NoteShipsStatsCalc {
	
	//joke
	private int ants = 6;
	private static NoteShipsStatsCalc bob = new NoteShipsStatsCalc();
	//
	
	public static int refreshCount = 0;
	
	public static int[] FP = {SelectScreen.whichShip.getFP(), 0, 0, 0};
	public static int[] AA = {SelectScreen.whichShip.getAA(), 0, 0, 0};
	public static int[] TRP = {SelectScreen.whichShip.getTRP(), 0, 0, 0};
	public static int[] LCK = {SelectScreen.whichShip.getLCK(), 0, 0, 0};
	
	public static void refreshNums() {
		refreshCount++;
		System.out.println(refreshCount);
		try {
			FP[0] = SelectScreen.whichShip.getFP();
			AA[0] = SelectScreen.whichShip.getAA();
			TRP[0] = SelectScreen.whichShip.getTRP();
			LCK[0] = SelectScreen.whichShip.getLCK();
		for (int i = 1; i-1 < 3; i++) {
			try {
			FP[i] = SelectScreen.equipList.get(i-1).getFP();
			AA[i] = SelectScreen.equipList.get(i-1).getAA();
			TRP[i] = SelectScreen.equipList.get(i-1).getTRP();
			} catch (Exception e) {
				FP[i] = 0;
				AA[i] = 0;
				TRP[i] = 0;
			}
		}
		} catch (NullPointerException e) {
			FP[0] = 0;
			AA[0] = 0;
			TRP[0] = 0;
			LCK[0] = 0;
			for (int i = 1; i < 0; i++) {
				FP[i] = SelectScreen.equipList.get(i-1).getFP();
				AA[i] = SelectScreen.equipList.get(i-1).getAA();
				TRP[i] = SelectScreen.equipList.get(i-1).getTRP();
				System.out.println(FP[i]);
				return;
			}
		}
		try {
			if (refreshCount%2==0) System.out.println("Nice");
			} catch (Exception eh){
				System.out.println("sad");
			}
		System.out.println(containsArg(FP,0));
		System.out.println(allDivByInt(FP,2));
		System.out.println(containsDupe(FP));
		System.out.println(countDivByInt(FP,2));
		System.out.println(Arrays.toString(moveRight(FP)));
		System.out.println(bob);
	}
	
	@Override
	public String toString() {
		return Integer.toString(ants);
	}
	
	public int getAnts() {
		return ants;
	}
	
	public void changeAnts(int ants) {
		this.ants = ants;
	}
	
	public static int calculateHEALTH() {
		int total = 0;
		for (int i: LCK) {
			total += i;
		}
		while (true) {
			return total/LCK.length;
		}
	}
	
	
	
	public static int calculateTotalFP() {
		int total = 0;
		for (int i: FP) {
			total += i;
		}
		return total;
	}
	
	public static int calculateTotalAA() {
		int total = 0;
		for (int i: AA) {
			total += i;
		}
		return total;
	}
	
	public static int calculateTotalTRP() {
		int total = 0;
		for (int i: TRP) {
			total += i;
		}
		return total;
	}
	
	public static int calculateTotalLCK() {
		int total = 0;
		for (int i: LCK) {
			total += i;
		}
		return total;
	}


//array stuff
	public static int maxNum(int[] arr) {
	    if (arr.length == 0) return 0;
	    int max = arr[0];
	    for (int i = 0; i < arr.length; i++) {
	      if (arr[i] > max) {
	        max = arr[i];
	      }
	    }
	    return max;
	  }
	
	public static int minNum(int[] arr) {
	    if (arr.length == 0) return 0;
	    int min = arr[0];
	    for (int i = 0; i < arr.length; i++) {
	      if (arr[i] < min) {
	        min = arr[i];
	      }
	    }
	    return min;
	  }

	public static int arrIntMode(int[] arr) {
		if (arr.length == 0) return 0;
		if (arr.length == 1) return arr[0];
		int mode = arr[1];
		int trueCount = 0;
		int tempCount;
		for (int i = 0; i < arr.length; i++) {
			tempCount = 0;
			for (int j = 0; j < arr.length; j++) {
    		if (arr[j] == arr[i]) tempCount++;
			}
    	if (tempCount > trueCount) {
	        trueCount = tempCount;
	        mode = arr[i];
    	}
		}
		return mode;
	}
	
	public static int[] eachDigitInInt(int num) {
		int count = 0;
		int temp = num;
		while (temp > 0) {
			temp/=10;
			count++;
		}
		int[] arr = new int[count];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = num % 10;
			num/=10;
		}
		return reverseArr(arr);
	}
	
	public static int[] reverseArr(int[] arr) {
	    if(arr.length<=1) return arr;
	    int[] result = new int[arr.length];
	    for (int i = 0; i < result.length; i++)
	      result[i] = arr[arr.length-1-i];
	    return result;
	  }

	public static boolean containsArg(int[] arr, int arg) {
	    for (int i = 0; i < arr.length; i++) {
	      if (String.valueOf(arr[i]).equals(String.valueOf(arg))) {
	       return true; 
	      }
	    }
	    return false;
	  }
	  
	  public static boolean containsArg(String[] arr, String arg) {
	    for (int i = 0; i < arr.length; i++) {
	      if ((arr[i]).toString().equals(arg.toString())) {
	       return true; 
	      }
	    }
	    return false;
	  }
	  
	  public static boolean containsArg(double[] arr, double arg) {
	    for (int i = 0; i < arr.length; i++) {
	      if (String.valueOf(arr[i]).equals(String.valueOf(arg))) {
	       return true; 
	      }
	    }
	    return false;
	  }
	  
	  public static boolean anyDivByInt(int[] arr, int n) {
		    for (int i: arr) {
		     if (i % n == 0) return true;
		    }
		    return false;
		  }
		  
	  	public static boolean allDivByInt(int[] arr, int n) {
		    if (arr.length == 0) return false;
		    int count = 0;
		    for (int i: arr) {
		     if (i % n == 0) count++;
		    }
		    if (count == arr.length) return true;
		    return false;
		  }
	    public static boolean containsDupe(int[] arr) {
	        if (arr.length == 0) return false;
	        for (int i = 0; i < arr.length; i++)
	          for (int j = 0; j < arr.length; j++)
	            if (arr[j] == arr[i] && i != j) return true;
	        return false;
	      }
	      
	      public static boolean containsDupe(double[] arr) {
	        if (arr.length == 0) return false;
	        for (int i = 0; i < arr.length; i++)
	          for (int j = 0; j < arr.length; j++)
	            if (arr[j] == arr[i] && i != j) return true;
	        return false;
	      }
	      
	      public static boolean containsDupe(String[] arr) {
	        if (arr.length == 0) return false;
	        for (int i = 0; i < arr.length; i++)
	          for (int j = 0; j < arr.length; j++)
	            if (arr[j] == arr[i] && i != j) return true;
	        return false;
	      }
	      public static int countDivByInt(int[] arr, int n) {
	    	  	int count = 0;
			    for (int i: arr) {
			     if (i % n == 0) count++;
			    }
			    return count;
			  }
	      public static int[] moveRight(int[] arr) {
	    	    if(arr.length<=1) return arr;
	    	    int[] result = new int[arr.length];
	    	    result[0] = arr[arr.length-1]; 
	    	    for (int i = 1; i < result.length; i++)
	    	      result[i] = arr[i-1];
	    	    return result; 
	    	  }
	
	
}