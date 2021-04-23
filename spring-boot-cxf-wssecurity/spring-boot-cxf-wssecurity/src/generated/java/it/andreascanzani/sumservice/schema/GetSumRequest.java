
package it.andreascanzani.sumservice.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="addendOne" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="addendTwo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "addendOne",
    "addendTwo"
})
@XmlRootElement(name = "GetSumRequest")
public class GetSumRequest {

    protected int addendOne;
    protected int addendTwo;

    /**
     * Recupera il valore della proprietà addendOne.
     * 
     */
    public int getAddendOne() {
        return addendOne;
    }

    /**
     * Imposta il valore della proprietà addendOne.
     * 
     */
    public void setAddendOne(int value) {
        this.addendOne = value;
    }

    /**
     * Recupera il valore della proprietà addendTwo.
     * 
     */
    public int getAddendTwo() {
        return addendTwo;
    }

    /**
     * Imposta il valore della proprietà addendTwo.
     * 
     */
    public void setAddendTwo(int value) {
        this.addendTwo = value;
    }

}
