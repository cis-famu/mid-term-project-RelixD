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
import com.mycompany.midtermprojectrd.MemberAccount;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Relo's PC
 */
public class AccountService {
     private final ArrayList<MemberAccount> list = new ArrayList<>();

public AccountService (){
}
MemberAccount account1 = new MemberAccount("David","Weslen", 20, "Yes", null, 850-123-2312);
MemberAccount account2 = new MemberAccount("Timothy","Duncan", 21, "Yes", null, 850-312-3312);

// Create A New Record 
public String createMemberAccount(String fname, String lname, int memberid, String premiumMember, Date birthday, int phonenumber) throws ParseException, InterruptedException, ExecutionException{

SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	//get the current date as a string
	String now = formatter.format(new Date(System.currentTimeMillis()));
	
//create new Account
	MemberAccount newAccount = new MemberAccount(fname, lname, memberid, premiumMember, birthday, phonenumber);
        
	//save values to database
	ApiFuture<DocumentReference> future = db.collection("GameCompany").add(newAccount);
	
	//retrieve newly created document(row)
	DocumentReference doc = future.get();
   
    //return the document id;
	return doc.getId();
	
}
// Retrieve All 
public MemberAccount all() throws InterruptedException, ExecutionException {
      List<MemberAccount> resultList = new ArrayList<>();
      
      ApiFuture<QuerySnapshot> query = db.collection("GameCompany").get();
      
      QuerySnapshot querySnapshot = query.get();
      
      List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
      
      //loop over result set
      for(QueryDocumentSnapshot document : documents)
          resultList.add(document.toObject (MemberAccount.class));
      
       return (MemberAccount) resultList;
   }
// retrieve 1 record using an identifier
 public ArrayList<MemberAccount> findByFname(String fname){
    
    ArrayList<MemberAccount> resultList = new ArrayList<>();
    
    for(MemberAccount member : list){
         if(member.getFname() == fname)
             resultList.add(member);
}
    return resultList;
}

    public ArrayList<MemberAccount> findByMemberid(int memberid) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
