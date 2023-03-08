package AdventureTime;

public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;
	protected boolean fin;

	BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award = award;
	}

	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("Şu an buradasınız : " + this.getName());
		System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + obstacle.getoName() + " yaşıyor");
		System.out.print("<S>avaş veya <K>aç");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		if (selCase.equals("S")) {
			if (combat(obsCount)) {
				if (fin) {
					System.out.println();
					System.out.println(this.getName() + " Bölgesinde hiç " + obstacle.getoName() + " kalmadı :))");
					if (this.award.equals("Food") && player.getInv().isFood() == false) {
						System.out.println(this.award + " Kazandınız !");
						player.getInv().setFood(true);
					} else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
						System.out.println(this.award + " Kazandınız !");
						player.getInv().setFirewood(true);
					} else if (this.award.equals("Water") && player.getInv().isWater() == false) {
						System.out.println(this.award + " Kazandınız !");
						player.getInv().setWater(true);
					}
					return true;
				}
			} else {
				System.out.println("Öldünüz !");
				System.out
						.println("\n:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(EZİK:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(");
				System.out.println();
				return false;
			}
		}
		return true;
	}

	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			fin = false;
			int defObsHealt = obstacle.getObsHlt();
			playerStats();
			enemyStats();
			System.out.println();
			while (player.getrHealty() > 0 && obstacle.getObsHlt() > 0) {
				System.out.print("<V>ur veya <K>aç  ");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				System.out.println();
				if (selCase.equals("V")) {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
					System.out.println("Baammm Vurdun Moruq !");
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
					obstacle.setObsHlt(obstacle.getObsHlt() - player.getTotalDamage());
					afterHit();
					if (obstacle.getObsHlt() > 0) {
						System.out.println();
						System.out.println("<<<<<<<<<<<<<<<<<<<<<<<");
						System.out.println("Hasiktir ! Sana Sağlam Yapıştırdı !!!!");
						System.out.println("<<<<<<<<<<<<<<<<<<<<<<<");
						System.out.println();
						if (player.getTotalArmor() <= obstacle.getObsDmg()) {
							player.setHealty(player.getHealty() - (obstacle.getObsDmg() - player.getTotalArmor()));
							afterHit();
							System.out.println();
							if (player.getHealty() < 0) {
								System.out.println(
										"Sana öyle bi koydu ki meftalıksın GG İZİ ezik insan evladı seni Şu oyunda bile öldün pü senin kafana sıçayım");
								return false;
							}
						} else {
							afterHit();
							System.out.println();
							System.out.println("Okadar Kaslısın Ki İşlemedi Moruk :) ");
							System.out.println();
							if (player.getInv().isMakina() == false) {
								player.getInv().setMakina(true);
								System.out.println("<<<<< Sen Makinasın Ödülünü Kazandınız >>>>> ");
								System.out.println();
							}
						}
					}
				} else {
					System.out.println("Kaçtın Korkak XD :) :D ");
					return true;
				}
			}
			if (obstacle.getObsHlt() <= 0 && player.getHealty() > 0) {
				System.out.println();
				System.out.println("Bir düşmanı yendiniz !");
				player.setMoney(player.getMoney() + obstacle.getObsMny());
				System.out.println("Güncel paranız : " + player.getMoney());
				obstacle.setObsHlt(defObsHealt);

			} else {
				return false;
			}
		}

		fin = true;
		return true;
	}

	public void playerStats() {
		System.out.println("--------------------");
		System.out.println("Oyuncu Değerleri");
		System.out.println("Can: " + player.getHealty());
		System.out.println("Hasar: " + player.getTotalDamage());
		System.out.println("Zırh: " + player.getTotalArmor());
		System.out.println("Para: " + player.getMoney());
		if (player.getInv().getDamage() > 0) {
			System.out.println("Silah: " + player.getInv().getwName());
		}
		if (player.getInv().getArmor() > 0) {
			System.out.println("Zırh: " + player.getInv().getaName());
		}
	}

	public void enemyStats() {
		System.out.println("--------------------");
		System.out.println(obstacle.getoName() + " Değerleri");
		System.out.println("Can: " + obstacle.getObsHlt());
		System.out.println("Hasar: " + obstacle.getObsDmg());
		System.out.println("Para: " + obstacle.getObsMny());
	}

	public void afterHit() {

		System.out.println("Oyuncu canı: " + player.getHealty());
		System.out.println(obstacle.getoName() + " Canı:" + obstacle.getObsHlt());
	}

}
