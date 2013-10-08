
package Webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetStrichelnResponse_QNAME = new QName("http://Webservice/", "getStrichelnResponse");
    private final static QName _GetBenutzerResponse_QNAME = new QName("http://Webservice/", "getBenutzerResponse");
    private final static QName _SendNeuesPasswort_QNAME = new QName("http://Webservice/", "sendNeuesPasswort");
    private final static QName _Login_QNAME = new QName("http://Webservice/", "login");
    private final static QName _GetOEResponse_QNAME = new QName("http://Webservice/", "getOEResponse");
    private final static QName _GetBenutzer_QNAME = new QName("http://Webservice/", "getBenutzer");
    private final static QName _AnzeigeResponse_QNAME = new QName("http://Webservice/", "anzeigeResponse");
    private final static QName _SendOEResponse_QNAME = new QName("http://Webservice/", "sendOEResponse");
    private final static QName _SendStrichelnResponse_QNAME = new QName("http://Webservice/", "sendStrichelnResponse");
    private final static QName _SendPasswortzuruecksetzen_QNAME = new QName("http://Webservice/", "sendPasswortzuruecksetzen");
    private final static QName _SendStrichelartResponse_QNAME = new QName("http://Webservice/", "sendStrichelartResponse");
    private final static QName _SendBenutzer_QNAME = new QName("http://Webservice/", "sendBenutzer");
    private final static QName _Anzeige_QNAME = new QName("http://Webservice/", "anzeige");
    private final static QName _GetStrichelarten_QNAME = new QName("http://Webservice/", "getStrichelarten");
    private final static QName _GetStatistik_QNAME = new QName("http://Webservice/", "getStatistik");
    private final static QName _SendStrichelart_QNAME = new QName("http://Webservice/", "sendStrichelart");
    private final static QName _SendPasswortzuruecksetzenResponse_QNAME = new QName("http://Webservice/", "sendPasswortzuruecksetzenResponse");
    private final static QName _SendOE_QNAME = new QName("http://Webservice/", "sendOE");
    private final static QName _GetStrichelartenResponse_QNAME = new QName("http://Webservice/", "getStrichelartenResponse");
    private final static QName _GetStricheln_QNAME = new QName("http://Webservice/", "getStricheln");
    private final static QName _SendBenutzerResponse_QNAME = new QName("http://Webservice/", "sendBenutzerResponse");
    private final static QName _GetStatistikResponse_QNAME = new QName("http://Webservice/", "getStatistikResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://Webservice/", "loginResponse");
    private final static QName _SendNeuesPasswortResponse_QNAME = new QName("http://Webservice/", "sendNeuesPasswortResponse");
    private final static QName _SendStricheln_QNAME = new QName("http://Webservice/", "sendStricheln");
    private final static QName _GetOE_QNAME = new QName("http://Webservice/", "getOE");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendPasswortzuruecksetzen }
     * 
     */
    public SendPasswortzuruecksetzen createSendPasswortzuruecksetzen() {
        return new SendPasswortzuruecksetzen();
    }

    /**
     * Create an instance of {@link SendNeuesPasswortResponse }
     * 
     */
    public SendNeuesPasswortResponse createSendNeuesPasswortResponse() {
        return new SendNeuesPasswortResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link SendStrichelnResponse }
     * 
     */
    public SendStrichelnResponse createSendStrichelnResponse() {
        return new SendStrichelnResponse();
    }

    /**
     * Create an instance of {@link GetStatistikResponse }
     * 
     */
    public GetStatistikResponse createGetStatistikResponse() {
        return new GetStatistikResponse();
    }

    /**
     * Create an instance of {@link GetOE }
     * 
     */
    public GetOE createGetOE() {
        return new GetOE();
    }

    /**
     * Create an instance of {@link SendStrichelartResponse }
     * 
     */
    public SendStrichelartResponse createSendStrichelartResponse() {
        return new SendStrichelartResponse();
    }

    /**
     * Create an instance of {@link SendStricheln }
     * 
     */
    public SendStricheln createSendStricheln() {
        return new SendStricheln();
    }

    /**
     * Create an instance of {@link GetStrichelarten }
     * 
     */
    public GetStrichelarten createGetStrichelarten() {
        return new GetStrichelarten();
    }

    /**
     * Create an instance of {@link SendBenutzer }
     * 
     */
    public SendBenutzer createSendBenutzer() {
        return new SendBenutzer();
    }

    /**
     * Create an instance of {@link Anzeige }
     * 
     */
    public Anzeige createAnzeige() {
        return new Anzeige();
    }

    /**
     * Create an instance of {@link GetStrichelnResponse }
     * 
     */
    public GetStrichelnResponse createGetStrichelnResponse() {
        return new GetStrichelnResponse();
    }

    /**
     * Create an instance of {@link GetBenutzerResponse }
     * 
     */
    public GetBenutzerResponse createGetBenutzerResponse() {
        return new GetBenutzerResponse();
    }

    /**
     * Create an instance of {@link GetStatistik }
     * 
     */
    public GetStatistik createGetStatistik() {
        return new GetStatistik();
    }

    /**
     * Create an instance of {@link SendNeuesPasswort }
     * 
     */
    public SendNeuesPasswort createSendNeuesPasswort() {
        return new SendNeuesPasswort();
    }

    /**
     * Create an instance of {@link SendStrichelart }
     * 
     */
    public SendStrichelart createSendStrichelart() {
        return new SendStrichelart();
    }

    /**
     * Create an instance of {@link SendPasswortzuruecksetzenResponse }
     * 
     */
    public SendPasswortzuruecksetzenResponse createSendPasswortzuruecksetzenResponse() {
        return new SendPasswortzuruecksetzenResponse();
    }

    /**
     * Create an instance of {@link SendOE }
     * 
     */
    public SendOE createSendOE() {
        return new SendOE();
    }

    /**
     * Create an instance of {@link GetOEResponse }
     * 
     */
    public GetOEResponse createGetOEResponse() {
        return new GetOEResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link GetStrichelartenResponse }
     * 
     */
    public GetStrichelartenResponse createGetStrichelartenResponse() {
        return new GetStrichelartenResponse();
    }

    /**
     * Create an instance of {@link GetStricheln }
     * 
     */
    public GetStricheln createGetStricheln() {
        return new GetStricheln();
    }

    /**
     * Create an instance of {@link SendOEResponse }
     * 
     */
    public SendOEResponse createSendOEResponse() {
        return new SendOEResponse();
    }

    /**
     * Create an instance of {@link SendBenutzerResponse }
     * 
     */
    public SendBenutzerResponse createSendBenutzerResponse() {
        return new SendBenutzerResponse();
    }

    /**
     * Create an instance of {@link AnzeigeResponse }
     * 
     */
    public AnzeigeResponse createAnzeigeResponse() {
        return new AnzeigeResponse();
    }

    /**
     * Create an instance of {@link GetBenutzer }
     * 
     */
    public GetBenutzer createGetBenutzer() {
        return new GetBenutzer();
    }

    /**
     * Create an instance of {@link Strichbezeichnung }
     * 
     */
    public Strichbezeichnung createStrichbezeichnung() {
        return new Strichbezeichnung();
    }

    /**
     * Create an instance of {@link Statistik }
     * 
     */
    public Statistik createStatistik() {
        return new Statistik();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStrichelnResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getStrichelnResponse")
    public JAXBElement<GetStrichelnResponse> createGetStrichelnResponse(GetStrichelnResponse value) {
        return new JAXBElement<GetStrichelnResponse>(_GetStrichelnResponse_QNAME, GetStrichelnResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBenutzerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getBenutzerResponse")
    public JAXBElement<GetBenutzerResponse> createGetBenutzerResponse(GetBenutzerResponse value) {
        return new JAXBElement<GetBenutzerResponse>(_GetBenutzerResponse_QNAME, GetBenutzerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendNeuesPasswort }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "sendNeuesPasswort")
    public JAXBElement<SendNeuesPasswort> createSendNeuesPasswort(SendNeuesPasswort value) {
        return new JAXBElement<SendNeuesPasswort>(_SendNeuesPasswort_QNAME, SendNeuesPasswort.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOEResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getOEResponse")
    public JAXBElement<GetOEResponse> createGetOEResponse(GetOEResponse value) {
        return new JAXBElement<GetOEResponse>(_GetOEResponse_QNAME, GetOEResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBenutzer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getBenutzer")
    public JAXBElement<GetBenutzer> createGetBenutzer(GetBenutzer value) {
        return new JAXBElement<GetBenutzer>(_GetBenutzer_QNAME, GetBenutzer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnzeigeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "anzeigeResponse")
    public JAXBElement<AnzeigeResponse> createAnzeigeResponse(AnzeigeResponse value) {
        return new JAXBElement<AnzeigeResponse>(_AnzeigeResponse_QNAME, AnzeigeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendOEResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "sendOEResponse")
    public JAXBElement<SendOEResponse> createSendOEResponse(SendOEResponse value) {
        return new JAXBElement<SendOEResponse>(_SendOEResponse_QNAME, SendOEResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendStrichelnResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "sendStrichelnResponse")
    public JAXBElement<SendStrichelnResponse> createSendStrichelnResponse(SendStrichelnResponse value) {
        return new JAXBElement<SendStrichelnResponse>(_SendStrichelnResponse_QNAME, SendStrichelnResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendPasswortzuruecksetzen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "sendPasswortzuruecksetzen")
    public JAXBElement<SendPasswortzuruecksetzen> createSendPasswortzuruecksetzen(SendPasswortzuruecksetzen value) {
        return new JAXBElement<SendPasswortzuruecksetzen>(_SendPasswortzuruecksetzen_QNAME, SendPasswortzuruecksetzen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendStrichelartResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "sendStrichelartResponse")
    public JAXBElement<SendStrichelartResponse> createSendStrichelartResponse(SendStrichelartResponse value) {
        return new JAXBElement<SendStrichelartResponse>(_SendStrichelartResponse_QNAME, SendStrichelartResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendBenutzer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "sendBenutzer")
    public JAXBElement<SendBenutzer> createSendBenutzer(SendBenutzer value) {
        return new JAXBElement<SendBenutzer>(_SendBenutzer_QNAME, SendBenutzer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Anzeige }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "anzeige")
    public JAXBElement<Anzeige> createAnzeige(Anzeige value) {
        return new JAXBElement<Anzeige>(_Anzeige_QNAME, Anzeige.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStrichelarten }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getStrichelarten")
    public JAXBElement<GetStrichelarten> createGetStrichelarten(GetStrichelarten value) {
        return new JAXBElement<GetStrichelarten>(_GetStrichelarten_QNAME, GetStrichelarten.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatistik }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getStatistik")
    public JAXBElement<GetStatistik> createGetStatistik(GetStatistik value) {
        return new JAXBElement<GetStatistik>(_GetStatistik_QNAME, GetStatistik.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendStrichelart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "sendStrichelart")
    public JAXBElement<SendStrichelart> createSendStrichelart(SendStrichelart value) {
        return new JAXBElement<SendStrichelart>(_SendStrichelart_QNAME, SendStrichelart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendPasswortzuruecksetzenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "sendPasswortzuruecksetzenResponse")
    public JAXBElement<SendPasswortzuruecksetzenResponse> createSendPasswortzuruecksetzenResponse(SendPasswortzuruecksetzenResponse value) {
        return new JAXBElement<SendPasswortzuruecksetzenResponse>(_SendPasswortzuruecksetzenResponse_QNAME, SendPasswortzuruecksetzenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendOE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "sendOE")
    public JAXBElement<SendOE> createSendOE(SendOE value) {
        return new JAXBElement<SendOE>(_SendOE_QNAME, SendOE.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStrichelartenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getStrichelartenResponse")
    public JAXBElement<GetStrichelartenResponse> createGetStrichelartenResponse(GetStrichelartenResponse value) {
        return new JAXBElement<GetStrichelartenResponse>(_GetStrichelartenResponse_QNAME, GetStrichelartenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStricheln }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getStricheln")
    public JAXBElement<GetStricheln> createGetStricheln(GetStricheln value) {
        return new JAXBElement<GetStricheln>(_GetStricheln_QNAME, GetStricheln.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendBenutzerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "sendBenutzerResponse")
    public JAXBElement<SendBenutzerResponse> createSendBenutzerResponse(SendBenutzerResponse value) {
        return new JAXBElement<SendBenutzerResponse>(_SendBenutzerResponse_QNAME, SendBenutzerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatistikResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getStatistikResponse")
    public JAXBElement<GetStatistikResponse> createGetStatistikResponse(GetStatistikResponse value) {
        return new JAXBElement<GetStatistikResponse>(_GetStatistikResponse_QNAME, GetStatistikResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendNeuesPasswortResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "sendNeuesPasswortResponse")
    public JAXBElement<SendNeuesPasswortResponse> createSendNeuesPasswortResponse(SendNeuesPasswortResponse value) {
        return new JAXBElement<SendNeuesPasswortResponse>(_SendNeuesPasswortResponse_QNAME, SendNeuesPasswortResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendStricheln }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "sendStricheln")
    public JAXBElement<SendStricheln> createSendStricheln(SendStricheln value) {
        return new JAXBElement<SendStricheln>(_SendStricheln_QNAME, SendStricheln.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Webservice/", name = "getOE")
    public JAXBElement<GetOE> createGetOE(GetOE value) {
        return new JAXBElement<GetOE>(_GetOE_QNAME, GetOE.class, null, value);
    }

}
