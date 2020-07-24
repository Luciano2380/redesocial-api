package br.com.frwk.redesocial.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@SequenceGenerator(name ="seq_tb_comentarios",sequenceName = "seq_tb_comentarios",allocationSize = 1)
@Table(name = "tb_comentarios")
public class Comentario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tb_comentarios")
    @Column(name = "id_cmt", nullable = true)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_usu_cmt")
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "id_post_cmt")
    private Postagem postagem;

    @Column(name = "data_criacao_cmt")
    private LocalDateTime dataCriacao;

    @Column(name = "texto_cmt")
    private String textoComentario;

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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getTextoComentario() {
        return textoComentario;
    }

    public void setTextoComentario(String textoComentario) {
        this.textoComentario = textoComentario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comentario)) return false;
        Comentario that = (Comentario) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
