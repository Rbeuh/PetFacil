package br.com.rbeuh.petfacil.Requistion;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;



/**
 * Created by enzo on 19/05/2015.
 */
public abstract class RequisitionTask
{
    public interface OnRequisitionEnded
    {
        void onRequisitionEnded(String json, int statusCode, Exception e);
    }

    public static void enviar(final OnRequisitionEnded requisitionEnd, final String url, final String method, final Object object, final Context context)
    {
        (new AsyncTask<Void, Void, Object>()
        {
            private int statusCode = -1;
            private ProgressDialog progressDialog;

            @Override
            protected void onPreExecute()
            {
                progressDialog = new ProgressDialog(context);
                progressDialog.setTitle("Aguarde");
                progressDialog.setMessage("Aguarde...");
                progressDialog.show();
            }

            @Override
            protected String doInBackground(Void... params)
            {
                HttpClient httpClient = new DefaultHttpClient();
                HttpUriRequest httpUriRequest = null;

                try
                {
                    if (method.toUpperCase().equals("GET"))
                    {
                        httpUriRequest = new HttpGet(url);
                    }
                    else
                    {
                        if (method.toUpperCase().equals("POST"))
                        {
                            String jsonObject = new Gson().toJson(object);

                            HttpPost httpPost = new HttpPost(url);
                            httpPost.setEntity(new ByteArrayEntity(jsonObject.getBytes()));

                            httpUriRequest = httpPost;
                        }
                    }

                    httpUriRequest.setHeader("Content-Type", "application/json");
                    httpUriRequest.setHeader("Accept-Charset", "utf-8");

                    HttpResponse httpResponse = httpClient.execute(httpUriRequest);

                    statusCode = httpResponse.getStatusLine().getStatusCode();

                    String jsonResponse = "";

                    if (httpResponse.getEntity() != null)
                        jsonResponse = EntityUtils.toString(httpResponse.getEntity());

                    return jsonResponse;
                }
                catch(Exception e)
                {
                    requisitionEnd.onRequisitionEnded(null, statusCode, e);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object s)
            {
                progressDialog.dismiss();
                if (requisitionEnd != null)
                {
                    if (s != null)
                    {
                        requisitionEnd.onRequisitionEnded((String) s, statusCode, null);
                    } else
                    {
                        if (object instanceof Exception)
                        {
                            requisitionEnd.onRequisitionEnded(null, statusCode, (Exception) object);
                        }
                    }
                }
            }
        }).execute();
    }
}
