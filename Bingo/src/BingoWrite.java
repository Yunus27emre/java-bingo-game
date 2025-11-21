import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.Collections;

public class BingoWrite {
	FileRead person;

	void bingoWrite(FileRead x, FileRead y, FileRead z, FileRead t) {
		String[] cardnumber=cardss();
		
		cardnumber = Shuffle(cardnumber);
		for (int i = 0; i < cardnumber.length; i++) {
			System.out.print("Çekilen Sayı: " + cardnumber[i] + "\n");
			for (int j = 0; j < x.cards.length; j++) {

				EQUALS(x,y,z,t,i,j,cardnumber);

			}
			writers(x);
			writers(y);
			writers(z);
			writers(t);
			System.out.println();
			timespeed();

			if (control(x, y, z, t)) {
				break;
			}
		}
	}
	void EQUALS(FileRead x, FileRead y, FileRead z, FileRead t,int i,int j,String[] cardnumber) {
		if (x.cards[j].equals(cardnumber[i])) {
			x.cardchange(x, cardnumber[i]);
			x.count++;
		}
		if (y.cards[j].equals(cardnumber[i])) {
			y.cardchange(y, cardnumber[i]);
			y.count++;
		}
		if (z.cards[j].equals(cardnumber[i])) {
			z.cardchange(z, cardnumber[i]);
			z.count++;
		}
		if (t.cards[j].equals(cardnumber[i])) {
			t.cardchange(t, cardnumber[i]);
			t.count++;
		}
	}
	String[] cardss() {
		String[] cardnumber = new String[20];
		for (int i = 0; i < 20; i++) {
			cardnumber[i] = String.valueOf(i + 1);
		}
		return cardnumber;
	}
	void timespeed() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}
	boolean control(FileRead x, FileRead y, FileRead z, FileRead t) {
		if (Counter(x)) {
			System.out.println("Oyun Bitti.");
			System.out.print("Kazanan : " + x.names);
			return true;
		} else if (Counter(y)) {
			System.out.println("Oyun Bitti.");
			System.out.print("Kazanan : " + y.names);
			return true;
		} else if (Counter(z)) {
			System.out.println("Oyun Bitti.");
			System.out.print("Kazanan : " + z.names);
			return true;
		} else if (Counter(t)) {
			System.out.println("Oyun Bitti.");
			System.out.print("Kazanan : " + t.names);
			return true;
		} else
			return false;
	}

	void writers(FileRead cikti) {
		System.out.print(cikti.names);
		for (int i = 0; i < cikti.cards.length; i++) {
			System.out.print(" " + cikti.cards[i]);
		}
		System.out.println();
	}

	String[] Shuffle(String[] rand) {
		List<String> list = Arrays.asList(rand);
		Collections.shuffle(list);
		String[] random = list.toArray(new String[0]);
		return random;
	}

	boolean Counter(FileRead antep) {
		return antep.count == 5;
	}
}
