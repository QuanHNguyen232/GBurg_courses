

public class Skycrane {

	public static void main(String[] args) {
		
		// https://www.space.com/mars-rover-perseverance-landing-explained
		double height = 2100; // meters where the sky crane takes over with thrusters
		double velocity = -320000.0 / 3600; // meters per second initially
		
		double maxHeight = 20; // meters max height for lowering Perseverance
		double maxVelocity = -2700.0 / 3600; // meters per second max speed for lowering Perseverance
		double accelGravity = -3.72076; // m s^-2 https://en.wikipedia.org/wiki/Gravity_of_Mars
		double maxThrust = 8 * 3558.58; // kg m s^-2 max Newtons of thrust (https://www.wired.com/story/how-to-watch-nasa-launch-its-new-perseverance-mars-rover/) 
										// 8 thrusters each capable of 800 lbs. of thrust?
		
		double massSkycrane = 1370; // kg https://weebau.com/satplan/msl.htm (includes Perseverance?)
//		double massPerseverance = 899; // kg https://en.wikipedia.org/wiki/Mars_Science_Laboratory#Spacecraft
		double maxDecel = maxThrust / massSkycrane; // ms^-2
		System.out.println("Max Deceleration: " + maxDecel);
		
		double maxTime = 60; //https://www.nbclosangeles.com/news/local/timeline-nasa-mars-perseverance-rover-landing-seven-minutes-terror-jpl-space/2528737/
		double deltaT = .1; // arbitrary unit of time step for simulation
		double time = 0;
		
		for (; time <= maxTime; time += deltaT) {
			// print status
			// %e - exponential (scientific); %f - floating point; %g - good balance between %e and %f
			System.out.printf("t=%f\th=%g\tv=%g\n", time, height, velocity);
			
			// check for crash
			if (height < 0) {
				System.out.println("Crash!");
				break;
			}
			
			// check for success
			if (Math.abs(velocity) <= Math.abs(maxVelocity) && height <= maxHeight) {
				System.out.println("Success! Lowering Perseverance");
				break;
			}
			
			// compute for acceleration
			double thrusterDecel = 0.27 * maxDecel;	// TODO - can base it on time/height/velocity
			double accel = accelGravity + Math.max(0, Math.min(maxDecel, thrusterDecel));
			
			// compute new state
			height += deltaT * velocity;
			velocity += deltaT * accel;
			
		}
		
		// Check out for out-of-time condition
		if (time > maxTime) {
			System.out.println("Out of time");
		}
		
	}

}
