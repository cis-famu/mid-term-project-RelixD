/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import static Service.DBConnection.db;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.mycompany.midtermprojectrd.Game;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Relo's PC
 */
public class GameService {
private ArrayList<Game> list = new ArrayList<>();

public GameService (){
}
Game game1 = new Game("Madden 19", 3, "Used", 2019, "Available for all Consoles");
Game game2 = new Game("NBA 2k22", 1, "New", 2021,"Available for PS4/5");

// Create A New Record 
public String createGame(String title, int quantity, String quality, int year, String description) throws ParseException, InterruptedException, ExecutionException{

	//create new Game stock
	Game newGame = new Game(title, quantity, quality, year, description);
	//save values to database
	ApiFuture<DocumentReference> future = db.collection("GameCompany").add(newGame);
	
	//retrieve newly created document(row)
	DocumentReference doc = future.get();
   
    //return the document id;
	return doc.getId();
	
}
// Retrieve All 
public Game all() throws InterruptedException, ExecutionException {
      List<Game> resultList = new ArrayList<>();
      
      ApiFuture<QuerySnapshot> query = db.collection("GameCompany").get();
      
      QuerySnapshot querySnapshot = query.get();
      
      List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
      
      //loop over result set
      for(QueryDocumentSnapshot document : documents)
          resultList.add(document.toObject (Game.class));
      
       return (Game) resultList;
   }
// retrieve 1 record using an identifier
 public ArrayList<Game> findBytitle(String title){
    
    ArrayList<Game> resultList = new ArrayList<>();
    
    for(Game games : list){
         if(games.getTitle() == title)
             resultList.add(games);
}
    return resultList;
}

    public String createMemberAccount(String fname, String lname, int memberid, String premiumMember, Date birthday, int phonenumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
