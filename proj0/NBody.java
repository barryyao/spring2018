

public class NBody {
    public static double readRadius(String planetsTxtPath) {
        In in = new In(planetsTxtPath);
        int line = in.readInt();
        return in.readDouble();
    }
    
    public static Planet[]  readPlanets(String planetsTxtPath) {
        In in = new In(planetsTxtPath);
        int line = in.readInt();
        double radius = in.readDouble();
        Planet[] result = new Planet[line];
        for (int i = 0; i < line; i++) {
            Planet planet = new Planet(in.readDouble(), in.readDouble(), in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
            result[i] = planet;
        }
        return result;
    }

    public static void main(String[] args) {
        Double T = Double.valueOf(args[0]);
        Double dt = Double.valueOf(args[1]);
        String filename = args[2];
        double r = readRadius(filename);
        StdDraw.setScale(-r, r);
        StdDraw.enableDoubleBuffering();
        Planet[] planets = readPlanets(filename);
        StdDraw.picture(0.5, 0.5, "./images/starfield.jpg");
        StdDraw.show();
        for (Planet planet : planets) {
            planet.draw();
        }
        for (int i = 0; i < T; i += dt) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i1 = 0; i1 < planets.length; i1++) {
                xForces[i1] = planets[i1].calcNetForceExertedByX(planets);
                yForces[i1] = planets[i1].calcNetForceExertedByY(planets);
            }
            StdDraw.clear();
            StdDraw.picture(0.5, 0.5, "./images/starfield.jpg");
            StdDraw.show();
            for (int i1 = 0; i1 < planets.length; i1++) {
                planets[i1].update(dt, xForces[i1], yForces[i1]);
                planets[i1].draw();
            }
            StdDraw.pause(10);
        }
        System.out.println(planets.length);
        System.out.println(r);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }
}
