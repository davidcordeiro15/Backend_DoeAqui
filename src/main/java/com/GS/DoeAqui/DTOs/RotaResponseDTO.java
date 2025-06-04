package com.GS.DoeAqui.DTOs;



/**
 * DTO de resposta com informações sobre a rota.
 */
public class RotaResponseDTO {
    private String destino;
    private double distanciaKm;
    private double duracaoMin;

    public RotaResponseDTO(String destino, double distanciaKm, double duracaoMin) {
        this.destino = destino;
        this.distanciaKm = distanciaKm;
        this.duracaoMin = duracaoMin;
    }

    public String getDestino() {
        return destino;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public double getDuracaoMin() {
        return duracaoMin;
    }
}
