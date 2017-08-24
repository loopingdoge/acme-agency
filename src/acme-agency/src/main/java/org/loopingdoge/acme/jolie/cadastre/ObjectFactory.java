
package org.loopingdoge.acme.jolie.cadastre;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.loopingdoge.acme.jolie.cadastre package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.loopingdoge.acme.jolie.cadastre
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CadastrialCoordinatesResponse }
     * 
     */
    public CadastrialCoordinatesResponse createCadastrialCoordinatesResponse() {
        return new CadastrialCoordinatesResponse();
    }

    /**
     * Create an instance of {@link Coordinate }
     * 
     */
    public Coordinate createCoordinate() {
        return new Coordinate();
    }

    /**
     * Create an instance of {@link CadastrialCoordinates }
     * 
     */
    public CadastrialCoordinates createCadastrialCoordinates() {
        return new CadastrialCoordinates();
    }

}
