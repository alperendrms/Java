package AdventureTime;

import java.util.Scanner;

public class Player {
	private int damage, healty, money,rHealty,armor ;
	private String name, cName;
	private Inventory inv ;
	Scanner scan = new Scanner(System.in);
	public Player(String name) {
		super();
		this.name = name;
		this.inv = new Inventory();
	}
	
	public void selectCha() {
		switch(chaMenu()){
		case 1 :
			initPlayer("Samuray",5,21,15,0);	
				break;
		case 2 : 
			initPlayer("Okçu",7,18,20,0);
				break;
		case 3 :
			initPlayer("Şövayle",8,24,5,0);
				break;
		default :
			initPlayer("Samuray",5,21,15,0);
				break;			
		}
		System.out.println("Hoşgeldin "+getName() +" Karakterin \n>>"+ getcName() +"<< Hasar:"+getDamage()+" Sağlık:"+getHealty()+" Para:"+getMoney());
	}
	
	public int chaMenu() {
		System.out.println("Lütfen karakter seçiniz :");
		System.out.println("1-Samurai\t Hasar :5 \tSağlık :21\t Para :15");
		System.out.println("2-Okçu   \t Hasar :7 \tSağlık :18\t Para :20");
		System.out.println("3-Şövalye\t Hasar :8 \tSağlık :24\t Para :5");
		System.out.print("Karakter Seçiminiz : ");
		int chaID = scan.nextInt();
		
		while(chaID < 1 || chaID > 3) {
			System.out.print("Lütfen geçerli bir karakter seçiniz !! : ");
			chaID = scan.nextInt();
		}
		return chaID;
	}
	
	public int getTotalDamage() {
		return this.getDamage() + this.getInv().getDamage();
	}
	public int getTotalArmor() {
		return this.armor + this.getInv().getArmor();
	}
	
	public void initPlayer(String cName, int dmg,int hlty, int mny,int arm) {
		setcName(cName);
		setDamage(dmg);
		setHealty(hlty);
		setMoney(mny);
		setrHealty(hlty);
		setArmor(arm); 
	}
	

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealty() {
		return healty;
	}

	public void setHealty(int healty) {
		this.healty = healty;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public int getrHealty() {
		return rHealty;
	}

	public void setrHealty(int rHealty) {
		this.rHealty = rHealty;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	
}
