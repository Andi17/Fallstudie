
package Webservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Webservice", targetNamespace = "http://Webservice/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Webservice {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://Webservice/", className = "Webservice.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://Webservice/", className = "Webservice.LoginResponse")
    @Action(input = "http://Webservice/Webservice/loginRequest", output = "http://Webservice/Webservice/loginResponse")
    public boolean login(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sendPasswortzuruecksetzen", targetNamespace = "http://Webservice/", className = "Webservice.SendPasswortzuruecksetzen")
    @ResponseWrapper(localName = "sendPasswortzuruecksetzenResponse", targetNamespace = "http://Webservice/", className = "Webservice.SendPasswortzuruecksetzenResponse")
    @Action(input = "http://Webservice/Webservice/sendPasswortzuruecksetzenRequest", output = "http://Webservice/Webservice/sendPasswortzuruecksetzenResponse")
    public boolean sendPasswortzuruecksetzen(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.Integer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "anzeige", targetNamespace = "http://Webservice/", className = "Webservice.Anzeige")
    @ResponseWrapper(localName = "anzeigeResponse", targetNamespace = "http://Webservice/", className = "Webservice.AnzeigeResponse")
    @Action(input = "http://Webservice/Webservice/anzeigeRequest", output = "http://Webservice/Webservice/anzeigeResponse")
    public List<Integer> anzeige(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<Webservice.Statistik>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStatistik", targetNamespace = "http://Webservice/", className = "Webservice.GetStatistik")
    @ResponseWrapper(localName = "getStatistikResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetStatistikResponse")
    @Action(input = "http://Webservice/Webservice/getStatistikRequest", output = "http://Webservice/Webservice/getStatistikResponse")
    public List<Statistik> getStatistik(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<Webservice.Strichbezeichnung>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStricheln", targetNamespace = "http://Webservice/", className = "Webservice.GetStricheln")
    @ResponseWrapper(localName = "getStrichelnResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetStrichelnResponse")
    @Action(input = "http://Webservice/Webservice/getStrichelnRequest", output = "http://Webservice/Webservice/getStrichelnResponse")
    public List<Strichbezeichnung> getStricheln(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sendStricheln", targetNamespace = "http://Webservice/", className = "Webservice.SendStricheln")
    @ResponseWrapper(localName = "sendStrichelnResponse", targetNamespace = "http://Webservice/", className = "Webservice.SendStrichelnResponse")
    @Action(input = "http://Webservice/Webservice/sendStrichelnRequest", output = "http://Webservice/Webservice/sendStrichelnResponse")
    public boolean sendStricheln(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        XMLGregorianCalendar arg4);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBenutzer", targetNamespace = "http://Webservice/", className = "Webservice.GetBenutzer")
    @ResponseWrapper(localName = "getBenutzerResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetBenutzerResponse")
    @Action(input = "http://Webservice/Webservice/getBenutzerRequest", output = "http://Webservice/Webservice/getBenutzerResponse")
    public List<String> getBenutzer(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg5
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sendBenutzer", targetNamespace = "http://Webservice/", className = "Webservice.SendBenutzer")
    @ResponseWrapper(localName = "sendBenutzerResponse", targetNamespace = "http://Webservice/", className = "Webservice.SendBenutzerResponse")
    @Action(input = "http://Webservice/Webservice/sendBenutzerRequest", output = "http://Webservice/Webservice/sendBenutzerResponse")
    public boolean sendBenutzer(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        int arg5);

    /**
     * 
     * @param arg5
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @param arg6
     * @param arg7
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sendOE", targetNamespace = "http://Webservice/", className = "Webservice.SendOE")
    @ResponseWrapper(localName = "sendOEResponse", targetNamespace = "http://Webservice/", className = "Webservice.SendOEResponse")
    @Action(input = "http://Webservice/Webservice/sendOERequest", output = "http://Webservice/Webservice/sendOEResponse")
    public boolean sendOE(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        int arg5,
        @WebParam(name = "arg6", targetNamespace = "")
        int arg6,
        @WebParam(name = "arg7", targetNamespace = "")
        int arg7);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sendNeuesPasswort", targetNamespace = "http://Webservice/", className = "Webservice.SendNeuesPasswort")
    @ResponseWrapper(localName = "sendNeuesPasswortResponse", targetNamespace = "http://Webservice/", className = "Webservice.SendNeuesPasswortResponse")
    @Action(input = "http://Webservice/Webservice/sendNeuesPasswortRequest", output = "http://Webservice/Webservice/sendNeuesPasswortResponse")
    public boolean sendNeuesPasswort(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStrichelarten", targetNamespace = "http://Webservice/", className = "Webservice.GetStrichelarten")
    @ResponseWrapper(localName = "getStrichelartenResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetStrichelartenResponse")
    @Action(input = "http://Webservice/Webservice/getStrichelartenRequest", output = "http://Webservice/Webservice/getStrichelartenResponse")
    public List<String> getStrichelarten(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sendStrichelart", targetNamespace = "http://Webservice/", className = "Webservice.SendStrichelart")
    @ResponseWrapper(localName = "sendStrichelartResponse", targetNamespace = "http://Webservice/", className = "Webservice.SendStrichelartResponse")
    @Action(input = "http://Webservice/Webservice/sendStrichelartRequest", output = "http://Webservice/Webservice/sendStrichelartResponse")
    public boolean sendStrichelart(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        int arg4);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOE", targetNamespace = "http://Webservice/", className = "Webservice.GetOE")
    @ResponseWrapper(localName = "getOEResponse", targetNamespace = "http://Webservice/", className = "Webservice.GetOEResponse")
    @Action(input = "http://Webservice/Webservice/getOERequest", output = "http://Webservice/Webservice/getOEResponse")
    public List<String> getOE(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

}
