package AdventureTime;

import java.util.Scanner;

public class Game {
	Player player;
	Location location; 
	Scanner scan = new Scanner(System.in);
	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Macera oyununa hoşgeldiniz !");
		System.out.println("Oyunu Kazanmak için Water, Food ve Firewood Eşyalarıyla Birlikte Güvenli Evinize Gelin !!");
		System.out.print("Oyuna başlamadan önce isminizi giriniz :");
		String playerName = scan.nextLine();
		player = new Player(playerName);
		player.selectCha();
		start();
	}
	public void start() {
		while(true) {
			System.out.println();
			System.out.println("===============");
			System.out.println();
			System.out.println("Eylem gerçekleştirmek için bir yer seçiniz :");
			System.out.println("1. Güvenli ev --> Size ait güvenli bir mekan , düşman yok !");
			System.out.println("2. Mağara --> Karşınıza belki zombi çıkabilir");
			System.out.println("3. Orman --> Karşınıza belki vampir çıkabilir");
			System.out.println("4. Nehir --> Karşınıza belki ayı çıkabilir");
			System.out.println("5. Mağaza --> Silah veya Zırh alabilirsiniz !");
			System.out.println("6. --> Karakter Bilgilerini Görüntüle :");
			System.out.print("Gitmek istediğiniz yer : ");
			int selLoc = scan.nextInt();
			System.out.println();
			System.out.println("\n===============");
			System.out.println();
			
			while (selLoc < 1 || selLoc > 6) {
				System.out.print("Lütfen geçerli bir yer seçiniz !! : ");
				selLoc = scan.nextInt();
				}
			switch(selLoc) {
			case 1:
					location = new SafeHouse(player);
					break ;
			case 2:
					location = new cave(player);
					break ;
			case 3:
					location = new Forest(player);
					break ;
			case 4:
					location = new river(player);
					break ;
			case 5:
					location = new Toolstore(player);
					break ;
			case 6:
					System.out.println(" Karakterin \n>>"+ player.getcName() +"<< Hasar:"+player.getTotalDamage()+" Sağlık:"+player.getHealty()+" Para:"+player.getMoney()+" Zırh:"+player.getTotalArmor());
					start();
					break;
			default : 
					location = new SafeHouse(player);
					break ;
			}
			if(location.name == "Güvenli Ev") {
				if(player.getInv().isFirewood()&& player.getInv().isFood()&& player.getInv().isWater()) {
					System.out.println("Oyun bitti ! Bütün Gereçleri Topladınız Artık Hayatta Kalabilirsiniz !");
					break;
				}
			}
			if(!location.getLocation()) {
				System.out.println("Oyun Bitti Öldün Moruk! ");
				break ; 
			}
		}
	}
}
