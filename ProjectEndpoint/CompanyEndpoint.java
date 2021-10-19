/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEndpoint;

import Service.CompanyService;
import com.mycompany.midtermprojectrd.GamingCompany;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author Relo's PC
 */
@WebService
public class CompanyEndpoint {
  private final CompanyService service = new CompanyService();
   
// Create a new record
    @WebResult(name="CompanyEndpoint")
    public String createGamingCompany
           (@WebParam(name="Company Name") String companyName,
            @WebParam(name="Company Id") int companyid,                 
            @WebParam(name="City") String city,
            @WebParam(name="State") String state,
            @WebParam(name="Areacode") int areacode
             )
            throws ParseException, InterruptedException, ExecutionException{
        return  service.createGamingCompany( companyName,  companyid,  city , state, areacode);
}
            
       // show all records     
            @WebMethod(operationName= "ALL Company")
    @WebResult(name="CompanyEndpoint")
    public GamingCompany getAll() throws InterruptedException, ExecutionException{
        return service.all();
    }
    
    //retrieve by identifier
    @WebResult(name="CompanyEndpoint")
    public ArrayList <GamingCompany> getByCompanyName(@WebParam(name = "CompanyName") String companyName) throws InterruptedException, ExecutionException{
      return service.findByCompanyName(companyName);
    }

    
    
    //
    @WebResult(name="CompanyEndpoint")
    public ArrayList <GamingCompany> getByCompanyid(@WebParam(name = "CompanyID") int companyid ) throws InterruptedException, ExecutionException{
      return service.findByCompanyid(companyid);
    }
    
}
