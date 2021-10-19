/*
 * Game Purchasing System.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEndpoint;


import Service.AccountService;
import com.mycompany.midtermprojectrd.MemberAccount;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author Relix Daniels
 */
public class AccountEndpoint {
  private final AccountService service = new AccountService();
   
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
            @WebMethod(operationName= "All Members")
    @WebResult(name="AccountEndpoint")
    public MemberAccount getAll() throws InterruptedException, ExecutionException{
        return service.all();
    }
    
    //retrieve by identifier
    @WebResult(name="AccountEndpoint")
    public ArrayList <MemberAccount> getByFname(@WebParam(name = "MemberAccount") String fname) throws InterruptedException, ExecutionException{
      return service.findByFname(fname);
    }

    
    
    //
    @WebResult(name="AccountEndpoint")
    public ArrayList <MemberAccount> getByMemberid(@WebParam(name = "MemberAccount") int memberid ) throws InterruptedException, ExecutionException{
      return service.findByMemberid(memberid);
    }   
}
