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
import com.mycompany.midtermprojectrd.GamingCompany;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Relo's PC
 */
public class CompanyService {
    private ArrayList<GamingCompany> list = new ArrayList<>();

public CompanyService (){
}
GamingCompany company1 = new GamingCompany("Gamestop", 3, "Atlanta", "Georgia", 404);
GamingCompany company2 = new GamingCompany("BestBuy", 1, "Madison", "Florida", 850);

// Create A New Record 
public String createGamingCompany(String companyName, int companyid, String city, String state, int areacode) throws ParseException, InterruptedException, ExecutionException{

	//create new Company
	GamingCompany newCompany = new GamingCompany(companyName, companyid, city, state, areacode);
        
	//save values to database
	ApiFuture<DocumentReference> future = db.collection("GameCompany").add(newCompany);
	
	//retrieve newly created document(row)
	DocumentReference doc = future.get();
   
    //return the document id;
	return doc.getId();
	
}
// Retrieve All 
public GamingCompany all() throws InterruptedException, ExecutionException {
      List<GamingCompany> resultList = new ArrayList<>();
      
      ApiFuture<QuerySnapshot> query = db.collection("GameCompany").get();
      
      QuerySnapshot querySnapshot = query.get();
      
      List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
      
      //loop over result set
      for(QueryDocumentSnapshot document : documents)
          resultList.add(document.toObject (GamingCompany.class));
      
       return (GamingCompany) resultList;
   }
// retrieve 1 record using an identifier
 public ArrayList<GamingCompany> findByCompanyName(String companyName){
    
    ArrayList<GamingCompany> resultList = new ArrayList<>();
    
    for(GamingCompany comp : list){
         if(comp.getCompanyName() == companyName)
             resultList.add(comp);
}
    return resultList;
}

    public ArrayList<GamingCompany> findByCompanyid(int companyid) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
