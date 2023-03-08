package AdventureTime;

public class SafeHouse extends NormalLoc{

	SafeHouse(Player player) {
		super(player, "Güvenli Ev");
	}

	@Override
	public boolean getLocation() {
		player.setHealty(player.getrHealty());
		System.out.println("İyileştiniz...");
		System.out.println("Şu an Güvenli Ev adlı yerdesiniz.");
		return true ;
	}
}
