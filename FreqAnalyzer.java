
// Frequency analysis program

import java.io.*;

public class FreqAnalyzer {

	public static void main(String[] args) {
		FreqAnalyzer analyzer = new FreqAnalyzer();

	}// main

	FreqAnalyzer() {
		String fileContents = new String();
		String currLine = new String();
		File input = new File("testInput");
		try {
			BufferedReader buffReader = new BufferedReader(new FileReader(input));

			// Reads input file into string and removes whitespace
			while ((currLine = buffReader.readLine()) != null) {
				fileContents += currLine;
			}
			fileContents = fileContents.replaceAll("\\s", "");

			// Adds the alphabet to the array
			Letter charArr[] = new Letter[26];
			for (int i = 0; i < charArr.length; i++) {
				charArr[i] = new Letter();
				charArr[i].letter = (char) (i + 97);
			}

			// Adds the frequency of each letter to the array
			char currChar;
			for (int i = 0; i < fileContents.length(); i++) {
				currChar = fileContents.charAt(i);
				charArr[findLetter(charArr, currChar)].freq += 1;
			}

			// Insertion sort to sort the letters by frequency in descending
			// order
			Letter tempLetter = new Letter();
			for (int i = 1; i < charArr.length; i++) {
				int j = i;
				while (j > 0 && charArr[j].freq > charArr[j - 1].freq) {
					tempLetter = charArr[j - 1];
					charArr[j - 1] = charArr[j];
					charArr[j] = tempLetter;
					j--;
				}
			}

			// Array to hold most common letters in descending order
			char freqArr[] = new char[26];
			freqArr[0] = 'e';
			freqArr[1] = 't';
			freqArr[2] = 'a';
			freqArr[3] = 'o';
			freqArr[4] = 'i';
			freqArr[5] = 'n';
			freqArr[6] = 's';
			freqArr[7] = 'h';
			freqArr[8] = 'r';
			freqArr[9] = 'd';
			freqArr[10] = 'l';
			freqArr[11] = 'c';
			freqArr[12] = 'u';
			freqArr[13] = 'm';
			freqArr[14] = 'w';
			freqArr[15] = 'f';
			freqArr[16] = 'g';
			freqArr[17] = 'y';
			freqArr[18] = 'p';
			freqArr[19] = 'b';
			freqArr[20] = 'v';
			freqArr[21] = 'k';
			freqArr[22] = 'j';
			freqArr[23] = 'x';
			freqArr[24] = 'q';
			freqArr[25] = 'z';

			// Display the frequencies of each letter
			System.out.println("Actual \tInput");
			System.out.println("Freq \tFreq");
			for (int i = 0; i < charArr.length; i++) {
				System.out.println(freqArr[i] + "\t" + charArr[i].letter + "- " + charArr[i].freq);
			}

			buffReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// FreqAnalyzer constructor

	public int findLetter(Letter arr[], char target) {
		int letterIndex = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].letter == target) {
				letterIndex = i;
			}
		}

		return letterIndex;
	}
}// FreqAnalyzer

class Letter {
	char letter;
	int freq;
}