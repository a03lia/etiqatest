package com.a03lia.university.model;

import java.util.Collections;
import java.util.List;

public class Response
{
    private int status;
    private String descriptions;
    private List<?> result;

    public Response(int status, String descriptions)
    {
        this.status = status;
        this.descriptions = descriptions;
    }

    public Response(int status, String descriptions, String result)
    {
        this.status = status;
        this.descriptions = descriptions;
        if (result.trim().length()>0)
            this.result = Collections.singletonList(result);
    }

    public Response(int status, String descriptions, List<?> result)
    {
        this.status = status;
        this.descriptions = descriptions;
        this.result = result;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getDescriptions()
    {
        return descriptions;
    }

    public void setDescriptions(String descriptions)
    {
        this.descriptions = descriptions;
    }

    public List<?> getResult()
    {
        return result;
    }

    public void setResult(List<?> result)
    {
        this.result = result;
    }
}
