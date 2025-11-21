import java.io.*;
import java.util.*;

public class BingoMain {

	public static void main(String[] args) throws IOException {
		File file = new File("Bilgiler.txt");
		BufferedReader Breader = new BufferedReader(new FileReader(file));
		String line;
		Map<String, String[]> car = new HashMap<>();
		String[] names = new String[4];
		String[] numbers = new String[4];
		int sayac = -1;
		while ((line = Breader.readLine()) != null) {
			String[] spint = line.split(" ");
			if (sayac >= 0 && sayac < 4) {
				names[sayac] = spint[0];
				numbers[sayac] = spint[1];
			}
			if (sayac > 4) {
				String[] MultiCard = Arrays.copyOfRange(spint, 1, spint.length);
				String cardsname = spint[0];

				car.put(cardsname, MultiCard);
			}
			sayac++;
		}
		FileRead name1 = new FileRead(names[0], numbers[0]);
		FileRead name2 = new FileRead(names[1], numbers[1]);
		FileRead name3 = new FileRead(names[2], numbers[2]);
		FileRead name4 = new FileRead(names[3], numbers[3]);

		for (String cardname : car.keySet()) {
			if (name1.number.equals(cardname)) {
				name1.addCard(car.get(cardname));
			} else if (name2.number.equals(cardname)) {
				name2.addCard(car.get(cardname));
			} else if (name3.number.equals(cardname)) {
				name3.addCard(car.get(cardname));
			} else if (name4.number.equals(cardname)) {
				name4.addCard(car.get(cardname));
			}

		}
		BingoWrite temp = new BingoWrite();
		temp.bingoWrite(name1, name2, name3, name4);
	}

}
