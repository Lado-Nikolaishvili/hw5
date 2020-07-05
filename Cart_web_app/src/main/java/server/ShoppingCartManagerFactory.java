package server;

public class ShoppingCartManagerFactory {

	private static ShoppingCartManager shoppingCartManager;


	public static ShoppingCartManager getInstance() {
		if (shoppingCartManager == null) {
			synchronized (ShoppingCartManagerFactory.class) {
				if (shoppingCartManager == null) {
					shoppingCartManager = new ShoppingCartManagerImpl();
				}
			}
		}

		return shoppingCartManager;
	}

}
