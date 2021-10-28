public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static double precision = 1.0e-5;	//浮点数对比允许的误差精度

	public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	/** calculate distance between planet a and planet b*/
	public double calcDistance(Planet b){
		return Math.sqrt(Math.pow(xxPos-b.xxPos,2)+Math.pow(yyPos-b.yyPos,2));
	}

	/** calculate force between planet a and planet b*/
	public double calcForceExertedBy(Planet b){
		double r = calcDistance(b);
		double G = 6.67e-11;
		return r < precision ? 0:G*mass*b.mass/Math.pow(r,2);
	}

	/** calculate force x */
	public double calcForceExertedByX(Planet b){
		double f = calcForceExertedBy(b);
		double dx = b.xxPos-xxPos;
		double r = calcDistance(b);
		return r < precision ? 0:f*dx/r;
	}

	/** calculate force y */
	public double calcForceExertedByY(Planet b){
		double f = calcForceExertedBy(b);
		double dy = b.yyPos-yyPos;
		double r = calcDistance(b);
		return r < precision ? 0:f*dy/r;
	}

	/** calculate force x by all planets */
	public double calcNetForceExertedByX(Planet[] allPlanets){
		double sum_x_f = 0;
		for (Planet planet:allPlanets){
			if(this.equals(planet)){
				continue;
			}
			sum_x_f += calcForceExertedByX(planet);
		}
		return sum_x_f;
	}

	/** calculate force y by all planets */
	public double calcNetForceExertedByY(Planet[] allPlanets){
		double sum_y_f = 0;
		for (Planet planet:allPlanets){
			if(this.equals(planet)){
				continue;
			}
			sum_y_f += calcForceExertedByY(planet);
		}
		return sum_y_f;
	}

	/** Update velocity and position */
	public void update(double dt, double fx, double fy){
		double a_x = fx/mass;
		double a_y = fy/mass;
		xxVel = xxVel + dt * a_x;
		yyVel = yyVel + dt * a_y;
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;
	}

	/** draw planet*/
	public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
	}
}