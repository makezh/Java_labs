class Line implements Comparable<Line> {
    private int a;  // Коэффицент при х
    private int b;  // Коэффицент при у
    private int c;  // Свободный член

    public Line(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    int getX()
    {
        return a;
    }

    int getY()
    {
        return b;
    }

    public double distance(int a, int b) {
        return Math.abs((this.a * a + this.b * b + c) / Math.sqrt(this.a * this.a + this.b * this.b));
    }

    public int intersectLines(Line line) {
        int result = 0;
        if (line != null) {
            if (this.a * line.a + this.b * line.b == 0) {
                result = 1;  // перпендикулярны
            } else if (this.a == line.a && this.b == line.b && this.c != line.c) {
                result = 2;  // параллельны
            } else {
                result = 3;  // пересекаются
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = getBlock(this.a, "x", true);
        result = result.concat(getBlock(this.b, "y", this.a == 0));
        result = result.concat(getBlock(this.c, "", this.a == 0 && this.b == 0));
        return result.concat(" = 0");
    }

    private String getBlock(int number, String prefix, boolean first) {
        String result = "";
        if (number != 0) {
            if (first) {
                result = String.format("%d%s", number, prefix);
            } else {
                String sign = number < 0 ? "-" : "+";
                result = String.format(" %s %d%s", sign, Math.abs(number), prefix);
            }
        }
        return result;
    }

    @Override
    public int compareTo(Line l) {
        if (this.intersectLines(l) == 1) return 1;
        else if (this.intersectLines(l) == 2) return 0;
        else return -1;
    }
}
