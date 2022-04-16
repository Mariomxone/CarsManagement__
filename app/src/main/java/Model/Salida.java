package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Salida {
    public Salida(boolean poliza, boolean circulacion,boolean verificacion, boolean tenencia, boolean llanta, boolean gato, boolean cruceta, boolean extintor, String observaciones, int id_user, int id_carro){
        this.poliza = poliza;
        this.circulacion = circulacion;
        this.verificacion = verificacion;
        this.tenencia = tenencia;
        this.llanta = llanta;
        this.gato = gato;
        this.cruceta = cruceta;
        this.extintor = extintor;
        this.observaciones = observaciones;
        this.id_user = id_user;
        this.id_carro = id_carro;
    }
    @Expose
    @SerializedName("poliza")
    private boolean poliza;

    @Expose
    @SerializedName("circulacion")
    private boolean circulacion;

    @Expose
    @SerializedName("verificacion")
    private boolean verificacion;

    @Expose
    @SerializedName("tenencia")
    private boolean tenencia;

    @Expose
    @SerializedName("llanta")
    private boolean llanta;

    @Expose
    @SerializedName("gato")
    private boolean gato;

    @Expose
    @SerializedName("cruceta")
    private boolean cruceta;

    @Expose
    @SerializedName("extintor")
    private boolean extintor;

    @Expose
    @SerializedName("observaciones")
    private String observaciones;

    @Expose
    @SerializedName("id_user")
    private int id_user;

    @Expose
    @SerializedName("id_carro")
    private int id_carro;



}
