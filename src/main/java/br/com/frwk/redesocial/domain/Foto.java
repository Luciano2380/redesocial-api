package br.com.frwk.redesocial.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@SequenceGenerator(name ="seq_tb_fotos",sequenceName = "seq_tb_fotos",allocationSize = 1)
@Table(name = "tb_fotos")
public class Foto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tb_fotos")
    @Column(name = "id_fto")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_usu_fto")
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "id_post_fto")
    private Postagem postagem;

    @Column(name = "link_fto")
    private String linkFoto;

    @Column(name = "data_criacao_fto")
    private LocalDateTime datacriacao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    public LocalDateTime getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(LocalDateTime datacriacao) {
        this.datacriacao = datacriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Foto)) return false;
        Foto foto = (Foto) o;
        return getId().equals(foto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
