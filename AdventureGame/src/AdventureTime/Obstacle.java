package AdventureTime;

import java.util.Random;

public class Obstacle {
	private String oName ;
	private int obsDmg, obsHlt,obsMny,maxNumber;
	public Obstacle(String oName, int obsDmg, int obsHlt, int obsMny,
			int maxNumber) {
		this.oName = oName;
		this.obsDmg = obsDmg;
		this.obsHlt = obsHlt;
		this.obsMny = obsMny;
		this.maxNumber = maxNumber;
	}
	
	public int count() {
		Random r = new Random();
		return r.nextInt(this.maxNumber)+ 1 ;
	}
	
	
	public String getoName() {
		return oName;
	}
	public void setoName(String oName) {
		this.oName = oName;
	}
	public int getObsDmg() {
		return obsDmg;
	}
	public void setObsDmg(int obsDmg) {
		this.obsDmg = obsDmg;
	}
	public int getObsHlt() {
		return obsHlt;
	}
	public void setObsHlt(int obsHlt) {
		this.obsHlt = obsHlt;
	}
	public int getObsMny() {
		return obsMny;
	}
	public void setObsMny(int obsMny) {
		this.obsMny = obsMny;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	
	
	
}
