package fil.coo;

import fil.coo.resourcePool.BasketPool;
import fil.coo.resourcePool.CubiclePool;

public class SwimmingPoolMain {
	
	public static void main(String[] args){
		final BasketPool baskets=new BasketPool(6);
		final CubiclePool cubicles=new CubiclePool(3);
		final SwimmingPool s=new SwimmingPool();
		
		s.registerSwimmer(new Swimmer("Camille",baskets,cubicles,6,4,8));
		s.registerSwimmer(new Swimmer("Lois",baskets,cubicles,2,10,4));
		s.registerSwimmer(new Swimmer("Mae",baskets,cubicles,10,18,10));
		s.registerSwimmer(new Swimmer("Ange",baskets,cubicles,3,7,5));
		s.registerSwimmer(new Swimmer("Louison",baskets,cubicles,18,3,3));
		s.registerSwimmer(new Swimmer("Charly",baskets,cubicles,3,6,10));
		s.registerSwimmer(new Swimmer("Alexie",baskets,cubicles,6,5,7));
		
		s.run();
		
	}

}
