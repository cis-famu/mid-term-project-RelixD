/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEndpoint;

import Service.ConsoleService;
import com.mycompany.midtermprojectrd.Consoles;
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
public class ConsolesEndpoint {
    private final ConsoleService service = new ConsoleService();
   
// Create a new record
    @WebResult(name="Consoles")
    public String createGame
           (@WebParam(name="Type") String type,
            @WebParam(name="ID") int consoleid,   
            @WebParam(name="Storage in GB") int storage,            
            @WebParam(name="Condition") String condition
             )//(String type, int consoleid, int storage, String condition)
            throws ParseException, InterruptedException, ExecutionException{
        return  service.createConsole( type,  consoleid,  storage , condition );
}
            
       // show all records     
            @WebMethod(operationName= "ALL Consoles")
    @WebResult(name="ConsoleEndpoint")
    public Consoles getAll() throws InterruptedException, ExecutionException{
        return service.all();
    }
    
    //retrieve by identifier
    @WebResult(name="ConsoleEndpoint")
    public ArrayList <Consoles> getByConsoleid(@WebParam(name = "ConsoleID") int consoleid) throws InterruptedException, ExecutionException{
      return service.findByconsoleid(consoleid);
    }
 
}
