package br.com.frwk.redesocial.dto;

public class JwtDTO {

    private String token;

    public JwtDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
