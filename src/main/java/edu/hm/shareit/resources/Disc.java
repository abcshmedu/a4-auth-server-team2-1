package edu.hm.shareit.resources;


import org.json.JSONObject;

/**
 * Created by MatHe on 26.04.2017.
 */
public class Disc extends Medium {
    private String barcode;
    private String director;
    private int fsk;

    /**
     * Ctor.
     */
    public Disc() {
        super(" ");
    }

    /**
     * Ctor.
     * @param title title of the disc.
     * @param barcode barcode of the disc.
     * @param fsk fsk of the disc.
     * @param director director of the disc.
     */
    public Disc(String title, String barcode, int fsk, String director) {
        super(title);
        this.barcode = barcode;
        this.director = director;
        this.fsk = fsk;
    }

    /**
     * Getter.
     * @return barcode.
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * Getter.
     * @return director.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Getter.
     * @return fsk.
     */
    public int getFsk() {
        return fsk;
    }

    /**
     * ToString.
     * @return string representation of the disc.
     */
    @Override
    public String toString() {
        return "Disc{"
                + "barcode='" + barcode + '\''
                + ", director='" + director + '\''
                + ", fsk=" + fsk
                + '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Disc disc = (Disc) o;

        if (fsk != disc.fsk) {
            return false;
        }
        if (barcode != null ? !barcode.equals(disc.barcode) : disc.barcode != null) {
            return false;
        }
        return director != null ? director.equals(disc.director) : disc.director == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (barcode != null ? barcode.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + fsk;
        return result;
    }



    /**
     * Converts to JSON.
     * @return json Object of the Book.
     */
    public JSONObject toJSON() {
        return new JSONObject()
                .put("barcode", barcode)
                .put("director", director)
                .put("fsk", fsk)
                .put("title", this.getTitle());
    }

}
