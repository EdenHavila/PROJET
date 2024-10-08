package ProjDev1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnexion {
	static Connection connexion;

	public static void main(String[] args) {
		String url ="jdbc:mysql://ls-0f19f4268096a452a869b6f8467bc299c51da519.cz6cgwgke8xd.eu-west-3.rds.amazonaws.com:3306/db0075847"; // URL de connexion
		String utilisateur = "user0075847"; // Remplacez par votre nom d'utilisateur
		String motDePasse = "Yf3IgyBsOPa34WR"; // Remplacez par votre mot de passe
		try {
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			if (connexion != null) {
                System.out.println("Connexion à la base de données db0075847 réussie !");
            } else {
                System.out.println("Échec de la connexion.");
            }
		} catch (SQLException e) {
			e.printStackTrace(); 
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
	}



	public static void seConnecter() {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://ls-0f19f4268096a452a869b6f8467bc299c51da519.cz6cgwgke8xd.eu-west-3.rds.amazonaws.com:3306/db0075847"; // URL de connexion
		String utilisateur = "user0075847"; // Remplacez par votre nom d'utilisateur
		String motDePasse = "Yf3IgyBsOPa34WR"; // Remplacez par votre mot de passe


		try {
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	}

}