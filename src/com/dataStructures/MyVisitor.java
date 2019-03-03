
package com.dataStructures;

public class MyVisitor extends AbstractVisitor{
    private String errors="";
    boolean first=true;
    public void visit(Object obj){
        String s= "=>"+(String)obj;
        if(first){
            errors+=s;
        }else{
            errors+="\n"+s;
        }
        first=false;
    }
    public String getErrors(){
        return errors;
    }
} 
