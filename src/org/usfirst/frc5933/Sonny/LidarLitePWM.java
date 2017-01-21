package org.usfirst.frc5933.Sonny;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;

public class LidarLitePWM implements Runnable {

	public static final int kPeriodScalar = 10000;
	private DigitalInput input_;
	private DigitalOutput output_;    
	private Counter counter_;
	private boolean running_;
	private boolean debug_;
	private double pulseWidth_;
	private int delay_;

	// TODO: Fill out this table with values that you measure.
	// Make sure that you have 2 more values in your table that are bigger than the
	// maximum value you want to measure.
	private static final double [][] kPulseWidthTable = new double[][] {
		{0, 0},
		{4.3, 12},
		{6.8, 24},
		{10.4, 36}
	};

	public LidarLitePWM(int digitalInput, int digitalOutput, int samples, int delay, boolean debug) {
		input_ = new DigitalInput(digitalInput);
		counter_ = new Counter(input_); 
		counter_.setSemiPeriodMode(true);
		counter_.setSamplesToAverage(samples);
		output_ = new DigitalOutput(digitalOutput);
		debug_ = debug;
		delay_ = delay;
		running_ = false;
		reset();
	}

	private void reset() {
		counter_.reset();
		output_.set(true);
	}

	private void trigger() {
		reset();
		output_.set(false);
		if (debug_)
			System.out.println("LidarLightPWM::trigger");
	}

	private void measure() {
		pulseWidth_ = counter_.getPeriod() * kPeriodScalar;
		if (debug_)
			System.out.println("LidarLightPWM::measure " + pulseWidth_);

		output_.set(true);
	}

	private synchronized boolean isRunning() {
		return running_;
	}

	public synchronized void setRunning(boolean running) {
		running_ = running;
	}

	private static double pulseWidthToInches(double pw) {
		int index = 0;
		while ((kPulseWidthTable[index][0] > pw) && (pw > kPulseWidthTable[index+1][0]) && (kPulseWidthTable.length > index+1)) {
			++index;
		}

		if (index+1 >= kPulseWidthTable.length) {
			System.err.println("Ran off the end of the PulseWidthTable");
			return 0;
		}

		double tableDiff = (kPulseWidthTable[index+1][0] - kPulseWidthTable[index][0]);
		double pulseWidthDiff =  pw - kPulseWidthTable[index][0];
		double pulseWidthRatio =  pulseWidthDiff / tableDiff;
		return (kPulseWidthTable[index][1] * pulseWidthRatio) + kPulseWidthTable[index][1];
	}

	public synchronized double getDistance() {
		return LidarLitePWM.pulseWidthToInches(pulseWidth_);
	}

	private void snooze() {
		try {
			Thread.sleep(delay_);
		} catch (InterruptedException e) {
		}
	}

	public double pidGet() {
		// TODO: Is this correct or Should it be a value of -1 to 1 ?
		return getDistance();
	}

	public void run() {
		while (isRunning())
		{
			trigger();
			snooze();
			measure();
		}
	}
}