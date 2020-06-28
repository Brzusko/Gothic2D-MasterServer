import com.google.gson.Gson;

public class RequestResult {
    private String message;
    private int status;

    public RequestResult(String message, int status){
        this.message = message;
        this.status = status;
    }

    public String toJSON(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
