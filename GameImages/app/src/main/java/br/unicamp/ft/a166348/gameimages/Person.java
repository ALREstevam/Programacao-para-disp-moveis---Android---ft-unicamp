package br.unicamp.ft.a166348.gameimages;

/**
 * Created by andre on 23/03/2018.
 */

public class Person {
    private String name;
    private int imageId;

    public Person(String name, int resId) {
        this.name = name;
        this.imageId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setResId(int imgId) {
        this.imageId = imgId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (imageId != person.imageId) return false;
        return name.equals( person.name );
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + imageId;
        return result;
    }
}
