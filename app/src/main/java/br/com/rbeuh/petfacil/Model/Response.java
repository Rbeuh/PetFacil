package br.com.rbeuh.petfacil.Model;

/**
 * Created by enzo on 30/08/2015.
 */
public class Response
{
    private int status;
    private String message;

    public Response(){}

    public int getStatus()
    {
        return status;
    }
    public String getMessage()
    {
        return message;
    }
}
