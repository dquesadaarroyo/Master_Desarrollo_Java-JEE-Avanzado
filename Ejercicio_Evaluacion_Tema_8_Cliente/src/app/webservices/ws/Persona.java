/**
 * Persona.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package app.webservices.ws;

public class Persona  implements java.io.Serializable {
    private long idPersona;

    private java.lang.String nombPerso;

    public Persona() {
    }

    public Persona(
           long idPersona,
           java.lang.String nombPerso) {
           this.idPersona = idPersona;
           this.nombPerso = nombPerso;
    }


    /**
     * Gets the idPersona value for this Persona.
     * 
     * @return idPersona
     */
    public long getIdPersona() {
        return idPersona;
    }


    /**
     * Sets the idPersona value for this Persona.
     * 
     * @param idPersona
     */
    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }


    /**
     * Gets the nombPerso value for this Persona.
     * 
     * @return nombPerso
     */
    public java.lang.String getNombPerso() {
        return nombPerso;
    }


    /**
     * Sets the nombPerso value for this Persona.
     * 
     * @param nombPerso
     */
    public void setNombPerso(java.lang.String nombPerso) {
        this.nombPerso = nombPerso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Persona)) return false;
        Persona other = (Persona) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idPersona == other.getIdPersona() &&
            ((this.nombPerso==null && other.getNombPerso()==null) || 
             (this.nombPerso!=null &&
              this.nombPerso.equals(other.getNombPerso())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += new Long(getIdPersona()).hashCode();
        if (getNombPerso() != null) {
            _hashCode += getNombPerso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Persona.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.webservices.app/", "persona"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPersona");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPersona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombPerso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombPerso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
