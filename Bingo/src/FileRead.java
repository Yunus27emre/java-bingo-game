
public class FileRead {
	String names;
	String number;
	String[] cards;
	int count;
	FileRead(String name,String number){
		this.names=name;
		this.number=number;
		this.cards=new String[5];
		 this.count=0;
	}
	void addCard(String[] card) {
		this.cards=card;
	}
	void cardchange(FileRead kart,String x) {
		for(int i=0;i<kart.cards.length;i++) {
			if (kart.cards[i].equals(x)) {
				kart.cards[i]=kart.cards[i]+"#";
			}
		}
	}
}
