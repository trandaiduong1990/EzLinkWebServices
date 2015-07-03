
package com.ezlinkwebservices.service.tranxhistory;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import com.ezlinkwebservices.service.tranxhistory.request.EZLINGWSTRANXREQENV;
import com.ezlinkwebservices.service.tranxhistory.response.EZLINGWSTRANXRESENV;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TranxHistoryPortType", targetNamespace = "http://ezlinkwebservices.com/service/TranxHistory")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    com.ezlinkwebservices.service.tranxhistory.ObjectFactory.class,
    com.ezlinkwebservices.service.tranxhistory.request.ObjectFactory.class,
    com.ezlinkwebservices.service.tranxhistory.response.ObjectFactory.class
})
public interface TranxHistoryPortType {


    /**
     * 
     * @param parameters
     * @return
     *     returns com.ezlinkwebservices.service.tranxhistory.response.EZLINGWSTRANXRESENV
     * @throws TranxHistoryFault_Exception
     */
    @WebMethod(operationName = "GetTranxHistory")
    @WebResult(name = "EZLING_WS_TRANX_RES_ENV", targetNamespace = "http://ezlinkwebservices.com/service/TranxHistory/response", partName = "parameters")
    public EZLINGWSTRANXRESENV getTranxHistory(
        @WebParam(name = "EZLING_WS_TRANX_REQ_ENV", targetNamespace = "http://ezlinkwebservices.com/service/TranxHistory/request", partName = "parameters")
        EZLINGWSTRANXREQENV parameters)
        throws TranxHistoryFault_Exception
    ;

}