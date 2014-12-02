/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package music.admin;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author michs
 */
public class ifEmptyMark extends TagSupport{
    private String field;
    private String color="blue";

    public void setField(String field) {
        this.field = field;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    public int doStartTag() throws JspException {
        try {
            JspWriter out=pageContext.getOut();
            if(field==null || field.length()==0 || field.equalsIgnoreCase("0.0"))
                out.print("<font color=" + color + "> *</font>");
            
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }       
        return SKIP_BODY;
    }
    
}
