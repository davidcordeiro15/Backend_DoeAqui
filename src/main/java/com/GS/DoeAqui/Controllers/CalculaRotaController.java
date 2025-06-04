package com.GS.DoeAqui.Controllers;

import com.GS.DoeAqui.DTOs.EnderecoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Controlador responsável por calcular as agências dos Correios mais próximas com base em um endereço informado.
 */
@RestController
@RequestMapping("/correios")
public class CalculaRotaController {

    /**
     * Endpoint que retorna as 3 agências dos Correios mais próximas do endereço informado.
     *
     * @param enderecoDTO Objeto contendo logradouro, cidade e estado.
     * @return Lista com até 3 agências próximas.
     */
    @PostMapping("/mais-proximos")
    public ResponseEntity<?> buscarCorreiosProximos(@RequestBody EnderecoDTO enderecoDTO) {
        String enderecoCompleto = enderecoDTO.getLogradouro() + ", " + enderecoDTO.getCidade() + ", " + enderecoDTO.getEstado();

        String coordenadas = geocodificarEndereco(enderecoCompleto);
        if (coordenadas == null) {
            return ResponseEntity.badRequest().body("Endereço inválido ou não encontrado.");
        }

        String[] partes = coordenadas.split(",");
        String lon = partes[0];
        String lat = partes[1];

        List<Map<String, Object>> resultados = buscarCorreiosNaCidade(lat, lon, enderecoDTO.getCidade());

        return ResponseEntity.ok(resultados);
    }

    /**
     * Geocodifica um endereço usando a API do OpenStreetMap.
     *
     * @param endereco Endereço em texto.
     * @return Coordenadas no formato "lon,lat", ou null em caso de erro.
     */
    private String geocodificarEndereco(String endereco) {
        String url = "https://nominatim.openstreetmap.org/search?format=json&q=" + endereco.replace(" ", "+");
        RestTemplate restTemplate = new RestTemplate();

        try {
            List<?> response = restTemplate.getForObject(url, List.class);
            if (response != null && !response.isEmpty()) {
                Map<?, ?> local = (Map<?, ?>) response.get(0);
                return local.get("lon") + "," + local.get("lat");
            }
        } catch (Exception ignored) {}

        return null;
    }

    /**
     * Busca as agências dos Correios mais próximas usando a API Nominatim com viewbox da cidade.
     *
     * @param lat    Latitude central.
     * @param lon    Longitude central.
     * @param cidade Cidade para limitar a busca.
     * @return Lista com até 3 agências dos Correios.
     */
    private List<Map<String, Object>> buscarCorreiosNaCidade(String lat, String lon, String cidade) {
        // Limita a área da cidade usando bounded e viewbox para não trazer resultados globais
        String url = "https://nominatim.openstreetmap.org/search?format=json" +
                "&q=correios+" + cidade.replace(" ", "+") +
                "&bounded=1" +
                "&viewbox=" + (Double.parseDouble(lon) - 0.1) + "," + (Double.parseDouble(lat) + 0.1) + "," +
                (Double.parseDouble(lon) + 0.1) + "," + (Double.parseDouble(lat) - 0.1);

        RestTemplate restTemplate = new RestTemplate();

        try {
            List<?> response = restTemplate.getForObject(url, List.class);
            if (response != null && !response.isEmpty()) {
                List<Map<String, Object>> correios = new ArrayList<>();
                for (Object obj : response) {
                    if (correios.size() >= 3) break;
                    if (obj instanceof Map) {
                        correios.add((Map<String, Object>) obj);
                    }
                }
                return correios;
            }
        } catch (Exception ignored) {}

        return Collections.emptyList();
    }
}
