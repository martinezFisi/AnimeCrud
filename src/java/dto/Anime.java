

package dto;

public class Anime {
    private Integer idAnime;
    private String nombre;
    private String anioEstreno;
    private String genero;
    private Integer rating;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the anioEstreno
     */
    public String getAnioEstreno() {
        return anioEstreno;
    }

    /**
     * @param anioEstreno the anioEstreno to set
     */
    public void setAnioEstreno(String anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the rating
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * @return the idAnime
     */
    public Integer getIdAnime() {
        return idAnime;
    }

    /**
     * @param idAnime the idAnime to set
     */
    public void setIdAnime(Integer idAnime) {
        this.idAnime = idAnime;
    }
}
