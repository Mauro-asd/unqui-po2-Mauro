package ar.edu.unq.po2.tp3;

public class Multiplos {

	public int multiploDe(int x, int y) {
		int max = x>y?x:y;
		int result = -1;
		for(int i = 1000; i>=max; i = restaSiEsMilSiNoModifica(i, max)) {
			if(ambosTienenMismoMultiplo(x, y, i) && i <= 1000) {
				result = i;
				break;
			}
		}
		return result;
	}
	
	private boolean ambosTienenMismoMultiplo(int x, int y, int i) {
		x = i % x;
		x += i % y;
		return x == 0;
	}

	private int restaSiEsMilSiNoModifica(int x, int y) {
		if(x == 1000) {
			x = multiploCercanoAMilDe(y);
			return x;
		}
		else {
			x = x - y;
			return x; 
		}
	}

	private int multiploCercanoAMilDe(int x) {
		int c = (1000 / x) +1;
		return (x*c);
	}
}