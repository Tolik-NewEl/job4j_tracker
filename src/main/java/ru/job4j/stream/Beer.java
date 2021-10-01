package ru.job4j.stream;

public class Beer {
    private String name;
    private String varieties;
    private String based;
    private int ibu;
    private double alc;
    private double gravity;
    private String color;

    static class Builder {
        private String name;
        private String varieties;
        private String based;
        private int ibu;
        private double alc;
        private double gravity;
        private String color;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildVarieties(String varieties) {
            this.varieties = varieties;
            return this;
        }

        Builder buildBased(String based) {
            this.based = based;
            return this;
        }

        Builder buildIbu(int ibu) {
            this.ibu = ibu;
            return this;
        }

        Builder buildAlc(double alc) {
            this.alc = alc;
            return this;
        }

        Builder buildGravity(double gravity) {
            this.gravity = gravity;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Beer build() {
            Beer beer = new Beer();
            beer.name = name;
            beer.varieties = varieties;
            beer.based = based;
            beer.ibu = ibu;
            beer.alc = alc;
            beer.gravity = gravity;
            beer.color = color;
            return beer;
        }
    }

    public static void main(String[] args) {
        Beer beer = new Builder().buildName("Marzen")
                .buildVarieties("Lager")
                .buildBased("hop")
                .buildIbu(12)
                .buildAlc(6.0)
                .buildGravity(15.0)
                .buildColor("light")
                .build();
        System.out.println(beer);
    }

    @Override
    public String toString() {
        return "Beer{" + "name='" + name + '\''
                + ", varieties='" + varieties + '\''
                + ", based='" + based + '\''
                + ", ibu=" + ibu
                + ", alc=" + alc
                + ", gravity=" + gravity
                + ", color='" + color
                + '\'' + '}';
    }
}
