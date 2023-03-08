package AdventureTime;

public class Toolstore extends NormalLoc{
	
	Toolstore(Player player) {
		super(player, "Mağaza");
	}

	@Override
	public boolean getLocation() {
		System.out.println("Şu an "+name+" adlı yerdesiniz. Paranız : "+player.getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Zırhlar");
		System.out.println("3. Çıkış");
		System.out.print("Seçiminiz : ");
		int selTool = scan.nextInt();
		System.out.println();
		System.out.println("===============");
		System.out.println();
		int selItemID;
		switch(selTool) {
		case 1 :
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2 : 
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
		case 3 : 
			System.out.println("Çıkış yaptınız !!");
			break;
		default :
			System.out.println("Geçersiz işlem !!");
			break;
		}
			
		return true ;
	}
	public int weaponMenu() {
		System.out.println("1. Tabanca\t<Para : 25 - Hasar : 2>");
		System.out.println("2. Kılıç  \t<Para : 35 - Hasar : 3>");
		System.out.println("3. Tüfek  \t<Para : 45 - Hasar : 7>");
		System.out.println("4. ÇIKIŞ ");
		System.out.print("Silah seçiminiz : ");
		int selWeapon = scan.nextInt();
		System.out.println();
		System.out.println("===============");
		System.out.println();
		return selWeapon ;
	}
	public int armorMenu() {
		System.out.println("1. Hafif Zırh\t<Para : 15 - Hasar Engelleme : 1>");
		System.out.println("2. Orta Zırh \t<Para : 25 - Hasar Engelleme : 3>");
		System.out.println("3. Ağır Zırh \t<Para : 40 - Hasar Engelleme : 5>");
		System.out.println("4. ÇIKIŞ ");
		System.out.print("Zırh seçiminiz : ");
		int selArmor = scan.nextInt();
		System.out.println();
		System.out.println("===============");
		System.out.println();
			return selArmor ;
	}
	public void buyWeapon(int itemID) {
		int damage = 0, price = 0;
		String wName = null ;
		switch (itemID) {
		case 1:
			damage = 2 ;
			wName = "Tabanca";
			price = 25 ;
					break;
		case 2:
			damage = 3 ;
			wName = "Kılıç";
			price = 35 ;
					break;
		case 3:		
			damage = 7 ;
			wName = "Tüfek";
			price = 45 ;
					break;		
		case 4 : 
			System.out.println("Çıkış Yapılıyor !!");
					break;
		default:
			System.out.println("Geçersiz işlem yaptınız !!");
					break;
		}
		if (price > 0) {
			if(player.getMoney() >= price) {
				player.getInv().setDamage(damage);
				player.getInv().setwName(wName);
				player.setMoney(player.getMoney() - price);
				System.out.println(wName + " satın aldınız ! Önceki Hasar : "+ player.getDamage()+" Yeni Hasar : "+player.getTotalDamage() );
				System.out.println("Kalan Paranız : "+ player.getMoney());
				}else {
					System.out.println("Paranız yetersiz !!");
				}
		}
	}
	
	public void buyArmor(int itemID) {
		int dmgRed = 0 , price = 0;
		String aName = null;
		
		switch(itemID) {
		case 1:
			dmgRed = 1 ;
			aName = "Hafif Zırh";
			price = 15 ;
					break;
		case 2:
			dmgRed = 3 ;
			aName = "Orta Zırh";
			price = 25 ;
					break;
		case 3:		
			dmgRed = 5 ;
			aName = "Ağır Zırh";
			price = 40 ;
					break;		
		case 4 : 
			System.out.println("Çıkış Yapılıyor !!");
					break;
		default:
			System.out.println("Geçersiz işlem yaptınız !!");
					break;
		}
		if (price > 0) {
			if(player.getMoney() >= price) {
				player.getInv().setArmor(dmgRed);
				player.getInv().setaName(aName);
				player.setMoney(player.getMoney() - price);
				System.out.println(aName + " satın aldınız ! Önceki Hasar Azaltma : "+ player.getArmor()+" Yeni Hasar Azaltma : "+player.getTotalArmor() );
				System.out.println("Kalan Paranız : "+ player.getMoney());
				}else {
					System.out.println("Paranız yetersiz !!");
				}
		}
				
				
	}
	
	
	
	public void menu() {
		
	}
}
