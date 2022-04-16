package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Carro {
    @SerializedName("id")
    @Expose
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @SerializedName("marca")
    @Expose
    private String marca;

    @SerializedName("modelo")
    @Expose
    private String modelo;

    @SerializedName("tipo")
    @Expose
    private String tipo;

    @SerializedName("anio")
    @Expose
    private String anio;

    @SerializedName("placa")
    @Expose
    private String placa;

    @SerializedName("vin")
    @Expose
    private String vin;

    @SerializedName("color")
    @Expose
    private String color;

}
