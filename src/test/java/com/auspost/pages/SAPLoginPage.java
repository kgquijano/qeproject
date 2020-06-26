package com.auspost.pages;

import com.auspost.helpers.SAPConnection;

import com.jacob.activeX.ActiveXComponent;


public class SAPLoginPage extends SAPConnection {

    String UserName = "RSYST-BNAME";
    String PasswordName = "RSYST-BCODE";
    String PopupWindowRadioButton2Name  = "MULTI_LOGON_OPT2";
    String PopupWindowType  =  "GuiModalWindow";

    public SAPLoginPage() { }

    public void loginSAPGUI(ActiveXComponent Session, String UserNameValue, String PasswordValue) throws Exception {
        Thread.sleep(2000);
        sapGeneric.SAPGUITextFieldSet(UserName, UserNameValue);
        sapGeneric.SAPGUISetPasswordField(PasswordName, PasswordValue);
        sapGeneric.SAPGUIEnter();
        Thread.sleep(4000);
        String str2 = sapGeneric.getSAPObjectIDHelperMethod(Session, "Name", PopupWindowRadioButton2Name, "", "");
        if (str2 != null) {
            sapGeneric.SAPGUISelectOperation(PopupWindowRadioButton2Name, PopupWindowType);
            sapGeneric.SAPGUIEnter();
            Thread.sleep(2000);
        }

    }

}
