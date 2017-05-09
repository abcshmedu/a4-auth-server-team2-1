package edu.hm.shareit.resources;

/**
 * Created by MatHe on 25.04.2017.
 */
public abstract class Medium {
    private String title;

    /**
     * Ctor.
     * @param title title of the medium.
     */
    public Medium(String title) {
        this.title = title;
    }

    /**
     * Getter.
     * @return title.
     */
    public String getTitle() {
        return title;
    }
    public void setTitle(String t) {
         title = t;
    }
    /**
     * Equals.
     * @param o other medium to check.
     * @return true if the other medium is equal to the other.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Medium medium = (Medium) o;

        return title.equals(medium.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        return "Medium, title: " + getTitle();
    }

}
