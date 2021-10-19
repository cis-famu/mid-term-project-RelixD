/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEndpoint;

import Service.GameService;
import com.mycompany.midtermprojectrd.Game;
import com.mycompany.midtermprojectrd.MemberAccount;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author Relix Daniels
 */
@WebService
public class GameEndpoint {
  private final GameService service = new GameService();
   
// Create a new record
    @WebResult(name="AccountEndpoint")
    public String createMemberAccount
           (@WebParam(name="First Name") String fname,
            @WebParam(name="Last Name") String lname,                 
            @WebParam(name="Member ID") int memberid,
            @WebParam(name="Premium Member:") String premiumMember,
            @WebParam(name="Birthday") Date birthday,
            @WebParam(name="Phone #") int phonenumber
             )
            throws ParseException, InterruptedException, ExecutionException{
        return  service.createMemberAccount( fname, lname,  memberid , premiumMember, birthday, phonenumber);
}
     // show all records     
    @WebMethod(operationName= "ALL Games")
    @WebResult(name="GameEndpoint")
    public Game getAll() throws InterruptedException, ExecutionException{
        return service.all();
    }
                
  
    //retrieve by identifier

    /**
     *
     * @param title
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @WebMethod(operationName= "Game Identifiers")
    @WebResult(name="GameEndpoint")
    public ArrayList <Game> getBytitle(@WebParam(name = "Title") String title) throws InterruptedException, ExecutionException{
      return service.findBytitle(title);
    }
 
    // find all by Member 
    public ArrayList<MemberAccount> getByLname(@WebParam(name = "LastName") String lname) throws InterruptedException, ExecutionException{
       return service.findByLname(lname); 
    }   
}   
