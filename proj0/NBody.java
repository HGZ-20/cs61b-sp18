/** run the simulation */
public class NBody {

	/** read the radius of the universe, which is used to determine the scaling of the drawing window. */
	public static double readRadius(String s){
		In in = new In(s);
		int N = in.readInt();
		return in.readDouble();
	}

	/** return an array of Bodys corresponding to the bodies in the file. */
	public static Planet[] readPlanets(String s){
		In in = new In(s);
		int N = in.readInt();
		double radius = in.readDouble();
		Planet[] arryPlanet = new Planet[N];
		double xxPos, yyPos, xxVel, yyVel, mass;
		String imgFileName;
		for(int i=0; i<N; i++){
			xxPos = in.readDouble();
			yyPos = in.readDouble();
			xxVel = in.readDouble();
			yyVel = in.readDouble();
			mass = in.readDouble();
			imgFileName = in.readString();
			arryPlanet[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return arryPlanet;
	}


	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		double radius = readRadius(filename);
		Planet[] arrayPlanet = readPlanets(filename);

		StdDraw.setScale(-radius, radius);
		StdDraw.enableDoubleBuffering();

		
		double[] xForce = new double[arrayPlanet.length];
		double[] yForce = new double[arrayPlanet.length];
		double time = 0;

		while(time < T){
			for(int i=0; i<arrayPlanet.length; i++){
				xForce[i] = arrayPlanet[i].calcNetForceExertedByX(arrayPlanet);
				yForce[i] = arrayPlanet[i].calcNetForceExertedByY(arrayPlanet);
			}

			StdDraw.clear();
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for (int i=0; i < arrayPlanet.length; i++){
				arrayPlanet[i].update(dt, xForce[i], yForce[i]);
				arrayPlanet[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);

			time += dt;
		}

		StdOut.printf("%d\n", arrayPlanet.length);
		StdOut.printf("%.2e\n", radius);
		for (Planet planet : arrayPlanet) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                planet.xxPos, planet.yyPos, planet.xxVel,
                planet.yyVel, planet.mass, planet.imgFileName);   
		}
	}
}