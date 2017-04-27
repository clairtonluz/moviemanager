package br.com.clairtonluz.model.pojo;

public class ErrorInfo {
    public final String url;
    public final String message;

    public ErrorInfo(String url, Exception ex) {
        this.url = url;
        this.message = ex.getLocalizedMessage();
    }
}
