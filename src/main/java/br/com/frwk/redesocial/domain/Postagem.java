package br.com.frwk.redesocial.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@SequenceGenerator(name ="seq_tb_postagens",sequenceName = "seq_tb_postagens",allocationSize = 1)
@Table(name = "tb_postagens")
public class Postagem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tb_postagens")
    @Column(name = "id_post")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_usu_post")
    private Usuario usuario;
    @Lob
    @Column(name = "texto_post")
    private String textoPostagem;

    @Column(name = "data_criacao_post")
    private LocalDateTime datacriacao;

    @OneToMany(mappedBy = "postagem", fetch = FetchType.LAZY)
    @Cascade(value = { CascadeType.DELETE})
    private List<Comentario> comentarios = new ArrayList<Comentario>();

    @OneToMany(mappedBy = "postagem", fetch = FetchType.LAZY)
    @Cascade(value = { CascadeType.DELETE})
    private List<Foto> fotos = new ArrayList<Foto>();


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

    public String getTextoPostagem() {
        return textoPostagem;
    }

    public void setTextoPostagem(String textoPostagem) {
        this.textoPostagem = textoPostagem;
    }

    public LocalDateTime getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(LocalDateTime datacriacao) {
        this.datacriacao = datacriacao;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Postagem)) return false;
        Postagem postagem = (Postagem) o;
        return getId().equals(postagem.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
