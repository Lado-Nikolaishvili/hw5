import java.util.HashMap;

public class AccountsManager {

	private final HashMap<String, String> accounts = new HashMap<>();

	public static AccountsManager instance;

	private AccountsManager() {
		addTestAccounts();
	}

	public static AccountsManager getInstance() {
		if (instance == null) {
			synchronized (AccountsManager.class) {
				if (instance == null) {
					instance = new AccountsManager();
				}
			}
		}
		return instance;
	}

	public void addTestAccounts() {
		addAccount("Patrick", "1234");
		addAccount("Molly", "Flopup");
	}


	public void addAccount(String name, String password) {
		accounts.put(name, password);
	}


	public boolean existsAccount(String name) {
		if (accounts.containsKey(name)) {
			return true;
		} else return false;
	}

	public boolean isPasswordCorrect(String name, String password) {
		return accounts.get(name).equals(password);
	}

}
