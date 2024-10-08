package ProjDev1;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ApplicationJava extends Application{
private Label labelMatricule;
private static TextField inputMatricule;
private Button buttonValider;
private Button buttonDetails;
private static Label labelDecision;
private HBox buttonContainer;
private static Label labelDetails;




	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root=new VBox(10);

		labelMatricule=new Label("Veuillez entrer votre Matricule");
		inputMatricule=new TextField();
		buttonValider=new Button("VALIDER");
		buttonDetails=new Button("DETAILS");
		labelDecision=new Label();
		labelDetails=new Label();
		buttonContainer=new HBox(20);
		//	buttonDetails.setDisable(true);
		
				
		
		
		// TODO Auto-generated method stub

		buttonContainer.getChildren().addAll(buttonValider,buttonDetails);
		root.getChildren().addAll(labelMatricule,inputMatricule,buttonContainer,labelDecision,labelDetails);
		

		buttonValider.setOnAction(e->{
			verificationResultat();
		});

		buttonDetails.setOnAction(e->{
			detailsResultat();
		});



		
		
		
		
		Scene scene=new Scene(root);
 		scene.getStylesheets().add(getClass().getResource("/ressources/style").toString());
		root.setAlignment(Pos.CENTER);//centrer les elments de la scene
		buttonContainer.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(25));//ajouter un adding interne
		primaryStage.setScene(scene);
		primaryStage.setTitle("Matricule");
		primaryStage.show();
		primaryStage.setHeight(400);//taille de la fenetre
		primaryStage.setWidth(400);
		primaryStage.setResizable(false);
		primaryStage.centerOnScreen();//mettre la fenetre au centre de notre ecran


			}

	
    public  void verificationResultat() {
    	DbConnexion.seConnecter();
        String matricule = inputMatricule.getText();
        String requete = "SELECT * FROM ETUDIANT  WHERE matricule = ?";

        try {
            PreparedStatement pst =DbConnexion.connexion.prepareStatement(requete);
            pst.setString(1, matricule);
            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                Double moyenne = resultSet.getDouble("moyenne");
                		
                if( moyenne >= 10 ) {
                    labelDecision.setText("Succès");
                    labelDecision.setTextFill(Color.GREEN);
                	
                }else {
                    labelDecision.setText("Échec");
                    labelDecision.setTextFill(Color.RED);
                }
                
                buttonDetails.setDisable(false);
            } else {
            	labelDecision.setText("Aucun résultat trouvé");
                labelDecision.setTextFill(Color.RED);       	
                buttonDetails.setDisable(true);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public  void detailsResultat() {
    	DbConnexion.seConnecter();
        String matricule = inputMatricule.getText();
        String requete = "SELECT * FROM ETUDIANT  WHERE matricule = ?";

        try {
            PreparedStatement pst =DbConnexion.connexion.prepareStatement(requete);
            pst.setString(1, matricule);
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
                String matriculeEtudiant = resultSet.getString("matricule");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String dateNaissance = resultSet.getString("dateNaissance");
                String ecole = resultSet.getString("ecole");
                Double moyenne = resultSet.getDouble("moyenne");
                
                if( matricule != " ") {
                     labelDetails.setText(
                    			"Matricule: " + matriculeEtudiant +
                                "\nNom: " + nom +
                                "\nPrénom: " + prenom +
                                "\nDate de naissance: " + dateNaissance +
                                "\nEtablissement: " + ecole +
                                "\nMoyenne: " + moyenne
                    		 ); 
                     	
		                     if( moyenne >= 10 ) {
		                         labelDecision.setText("Succès");
		                         labelDecision.setTextFill(Color.GREEN);
		                     	
		                     }else {
		                         labelDecision.setText("Échec");
		                         labelDecision.setTextFill(Color.RED);
		                     }    
			                
	                }else {
	                	labelDecision.setText("Veuillez entrer un matricule correct");
	                }

               	
           
        } 
    }catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
	
    public static void main(String[] args) {
        launch(args);
    }

	
	
	
}
