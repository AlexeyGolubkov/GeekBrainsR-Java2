abstract public class Fruit {
    protected double weight;
    protected  double radiusSize;
    protected  String color;

    protected double getWeight() {        return weight;  }
    protected double getRadiusSize() {
        return radiusSize;
    }

    @Override
    public String toString() {
        String str = "\"";

        str = str + color + str + radiusSize + str + weight + str;

        return str;
    }
}


