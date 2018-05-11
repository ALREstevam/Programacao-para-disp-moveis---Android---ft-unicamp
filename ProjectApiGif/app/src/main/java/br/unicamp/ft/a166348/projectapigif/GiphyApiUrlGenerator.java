package br.unicamp.ft.a166348.projectapigif;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by andre on 06/05/2018.
 */

public class GiphyApiUrlGenerator {
    private String baseUrl = "api.giphy.com";
    private String searchEndpoint = "/v1/gifs/search";
    private String randomEndpooint = "/v1/gifs/random";
    private String apiKey;

    public GiphyApiUrlGenerator(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSearchEndpointStr(String query, int limit, int offset, String rating, String lang, String format){
        String urlstr = baseUrl + searchEndpoint;
        try {
            urlstr = appendKeyValue( urlstr, "api_key", this.apiKey );
            urlstr = appendKeyValue( urlstr, "q", query );
            urlstr = appendKeyValue( urlstr, "limit", String.valueOf( limit ));
            urlstr = appendKeyValue( urlstr, "offset", String.valueOf( offset ));
            urlstr = appendKeyValue( urlstr, "rating", rating);
            urlstr = appendKeyValue( urlstr, "lang", lang);
            urlstr = appendKeyValue( urlstr, "fmt", format);
        } catch (UnsupportedEncodingException | MalformedURLException e) {
            e.printStackTrace();
        }
        return urlstr;
    }

    public String getSearchEndpointStr(String query, int limit, int offset, String lang){
        String urlstr = baseUrl + searchEndpoint;
        try {
            urlstr = appendKeyValue( urlstr, "api_key", this.apiKey );
            urlstr = appendKeyValue( urlstr, "q", query );
            urlstr = appendKeyValue( urlstr, "limit", String.valueOf( limit ));
            urlstr = appendKeyValue( urlstr, "offset", String.valueOf( offset ));
            urlstr = appendKeyValue( urlstr, "lang", lang);
        } catch (UnsupportedEncodingException | MalformedURLException e) {
            e.printStackTrace();
        }
        return urlstr;
    }

    public String getSearchEndpointStr(String query){
        String urlstr = baseUrl + searchEndpoint;
        try {
            urlstr = appendKeyValue( urlstr, "api_key", this.apiKey );
            urlstr = appendKeyValue( urlstr, "q", query );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return urlstr;
    }

    public String getRandomEndpointStr(String tag, String rating, String format){
        String urlstr = baseUrl + randomEndpooint;
        try {
            urlstr = appendKeyValue( urlstr, "api_key", this.apiKey );
            urlstr = appendKeyValue( urlstr, "tag", tag );
            urlstr = appendKeyValue( urlstr, "rating", rating );
            urlstr = appendKeyValue( urlstr, "fmt", format );

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return urlstr;
    }

    public String getRandomEndpointStr(String format){
        String urlstr = baseUrl + randomEndpooint;
        try {
            urlstr = appendKeyValue( urlstr, "api_key", this.apiKey );
            urlstr = appendKeyValue( urlstr, "fmt", format );

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return urlstr;
    }

    private String appendKeyValue(String baseUrl, String key, String value) throws UnsupportedEncodingException, MalformedURLException {
        if(key.isEmpty() || value.isEmpty()){
            return baseUrl;
        }


        String encodedKey = URLEncoder.encode(key, "UTF-8");
        String encodedValue = URLEncoder.encode(value, "UTF-8");




        if(!(baseUrl.startsWith( "http://" ) || baseUrl.startsWith( "https://" )) ){
            baseUrl = "https://" + baseUrl;
        }

        Matcher m1 = Pattern.compile("(https:\\/\\/|http:\\/\\/)([a-zA-Z.\\/0-9_]+)(\\?)([a-z.\\/0-9&_=A-Z%]*)").matcher(baseUrl);
        Matcher m2 = Pattern.compile( "(https:\\/\\/|http:\\/\\/)([a-zA-Z.\\/0-9_]+)" ).matcher( baseUrl );


        if (m1.find()){
            return baseUrl + "&" + encodedKey + "=" + encodedValue;
        }
        else if(m2.find()){
            return baseUrl + "?&" + encodedKey + "=" + encodedValue;
        }
        else{
            throw new MalformedURLException( baseUrl );
        }

    }





}
