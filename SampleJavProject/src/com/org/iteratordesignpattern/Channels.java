package com.org.iteratordesignpattern;

public class Channels {

	private double frequency;
	private ChannelTypeEnum type;

	Channels(double frequency, ChannelTypeEnum type) {
		this.frequency = frequency;
		this.type = type;
	}

	public double getFrequency() {
		return frequency;
	}

	public ChannelTypeEnum getType() {
		return type;
	}

}
