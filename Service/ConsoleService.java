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
import com.mycompany.midtermprojectrd.Consoles;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Relo's PC
 */
public class ConsoleService {
   private ArrayList<Consoles> list = new ArrayList<>();

public ConsoleService (){
}//
Consoles console1 = new Consoles("PS5", 1, 500, "New");
Consoles console2 = new Consoles("XBOX ONE", 1, 350,"Used");

// Create A New Record 
public String createConsole(String type, int consoleid, int storage, String condition) throws ParseException, InterruptedException, ExecutionException{

	//create new console in database
	Consoles newConsole = new Consoles(type, consoleid, storage, condition);
	//save values to database
	ApiFuture<DocumentReference> future = db.collection("GameCompany").add(newConsole);
	
	//retrieve newly created document(row)
	DocumentReference doc = future.get();
   
    //return the document id;
	return doc.getId();
	
}
// Retrieve All 
public Consoles all() throws InterruptedException, ExecutionException {
      List<Consoles> resultList = new ArrayList<>();
      
      ApiFuture<QuerySnapshot> query = db.collection("GameCompany").get();
      
      QuerySnapshot querySnapshot = query.get();
      
      List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
      
      //loop over result set
      for(QueryDocumentSnapshot document : documents)
          resultList.add(document.toObject (Consoles.class));
      
       return (Consoles) resultList;
   }
// retrieve 1 record using an identifier
 public ArrayList<Consoles> findByconsoleid(int consoleid){
    
    ArrayList<Consoles> resultList = new ArrayList<>();
    
    for(Consoles console : list){
         if(console.getConsoleid() == consoleid)
             resultList.add(console);
}
    return resultList;
}
 
}
