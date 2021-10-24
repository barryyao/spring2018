

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }
    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p2) {
        double x = this.xxPos - p2.xxPos;
        double y = this.yyPos - p2.yyPos;
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public double calcForceExertedBy(Planet p2) {
        double distance = this.calcDistance(p2);
        return 6.67e-11 * this.mass * p2.mass / Math.pow(distance, 2);
    }

    public double calcForceExertedByX (Planet p2) {
        return this.calcForceExertedBy(p2) * (p2.xxPos - this.xxPos) / this.calcDistance(p2);
    }

    public double calcForceExertedByY (Planet p2) {
        return this.calcForceExertedBy(p2) * (p2.yyPos - this.yyPos) / this.calcDistance(p2);
    }

    public double calcNetForceExertedByX(Planet[] plants){
        double result = 0.0d;
        for (Planet plant : plants) {
            if (plant != this) {
                result += this.calcForceExertedByX(plant);
            }
        }
        return result;
    }

    public double calcNetForceExertedByY(Planet[] plants){
        double result = 0.0d;
        for (Planet plant : plants) {
            if (plant != this) {
                result += this.calcForceExertedByY(plant);
            }
        }
        return result;
    }

    public void update(double dt, double fX, double fY) {
        this.xxVel += dt * fX / this.mass;
        this.yyVel += dt * fY / this.mass;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
        StdDraw.show();
    }

}
