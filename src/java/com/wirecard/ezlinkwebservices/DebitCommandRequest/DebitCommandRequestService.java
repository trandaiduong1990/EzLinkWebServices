/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wirecard.ezlinkwebservices.DebitCommandRequest;

import com.ezlinkwebservices.service.debitcommand.DebitCommandFault;
import com.ezlinkwebservices.service.debitcommand.DebitCommandFault_Exception;
import com.ezlinkwebservices.service.debitcommand.response.DebitCommandRes;
import com.ezlinkwebservices.service.debitcommand.response.DebitCommandResError;
import com.ezlinkwebservices.service.debitcommand.response.EZLINGWSRESBODY;
import com.ezlinkwebservices.service.debitcommand.response.EZLINGWSRESENV;
import com.wirecard.ezlinkwebservices.constants.StringConstants;
import com.wirecard.ezlinkwebservices.services.DebitCommandService;
import com.wirecard.ezlinkwebservices.services.impl.DebitCommandServiceImpl;
import com.wirecard.ezlinkwebservices.util.HeaderUtil;
import java.util.Date;
import javax.jws.WebService;

/**
 *
 * @author WCCTTI-JANAHAN
 */
@WebService(serviceName = "DebitCommandService", portName = "DebitCommandSoap", endpointInterface = "com.ezlinkwebservices.service.debitcommand.DebitCommandPortType", targetNamespace = "http://ezlinkwebservices.com/service/DebitCommand", wsdlLocation = "WEB-INF/wsdl/DebitCommandRequestService/DebitCommand.wsdl")
public class DebitCommandRequestService {

    private static final org.apache.log4j.Logger ezlink = org.apache.log4j.Logger.getLogger(DebitCommandRequestService.class);

    public com.ezlinkwebservices.service.debitcommand.response.EZLINGWSRESENV debitCommand(com.ezlinkwebservices.service.debitcommand.request.EZLINGWSREQENV parameters) throws DebitCommandFault_Exception {

        long debitReqTime = System.currentTimeMillis();
        System.out.println("++++++++Recieving from mobile DEBIT REQUEST time :++++++++++++++++ " + debitReqTime);
        ezlink.info("\n-------RECIEVED DEBIT COMMAND REQUEST------TIME----------------   : " + debitReqTime);
        EZLINGWSRESENV objEZLINGWSRESENV = new EZLINGWSRESENV();
        EZLINGWSRESBODY objEZLINGWSRESBODY = new EZLINGWSRESBODY();
        DebitCommandRes objDebitCommandRes;
        DebitCommandService objDebitCommandService = new DebitCommandServiceImpl();
        DebitCommandResError objDebitCommandResError=new DebitCommandResError();
       

        objDebitCommandRes = objDebitCommandService.getDebitCommand(parameters);

        objEZLINGWSRESBODY.setDebitCommandRes(objDebitCommandRes);
        
        objDebitCommandResError.setDCERRORCODE(StringConstants.ResponseCode.SUCCESS);
        objDebitCommandResError.setDCERRORDESC(StringConstants.ResponseCode.SUCCESS);
        
        objEZLINGWSRESBODY.setDebitCommandResError(objDebitCommandResError);
        
        objEZLINGWSRESENV.setEZLINGWSHEADER(HeaderUtil.debitCommandResponseHeader(parameters));
        objEZLINGWSRESENV.setEZLINGWSRESBODY(objEZLINGWSRESBODY);

        long DebitResTime = System.currentTimeMillis();
        System.out.println("++++++++Sending to mobile DEBIT REQUEST time :+++++++++ " + DebitResTime);
        long timeTaken = DebitResTime - debitReqTime;
        System.out.println("++++++++++++Time taken to Serve DEBIT REQUEST ++++++++: " + timeTaken);
        ezlink.info("\n-------SENDING DEBIT COMMAND RESPONSE TO MOBILE---TIME------------ : " + DebitResTime);
        ezlink.info("\n-------TOTAL TIME TAKEN TO SERVE THIS DEBIT COMMAND REQUEST------- : " + timeTaken);

        return objEZLINGWSRESENV;
    }

}
