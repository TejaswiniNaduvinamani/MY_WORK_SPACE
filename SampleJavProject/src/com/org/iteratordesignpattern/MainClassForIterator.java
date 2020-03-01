package com.org.iteratordesignpattern;

public class MainClassForIterator {

	public static void main(String args[]) {
		ChannelCollection channels = populateChannels();

		ChannelIterator engChannelIterator = channels.iterator(ChannelTypeEnum.ENGLISH);

		while (engChannelIterator.hasNext()) {
			Channels c = engChannelIterator.next();
			System.out.println("Channel: " + c.getType() + " with " + c.getFrequency());
		}

		System.out.println("----------------------------");

		ChannelIterator allChannelIterator = channels.iterator(ChannelTypeEnum.ALL);

		while (allChannelIterator.hasNext()) {
			Channels c = allChannelIterator.next();
			System.out.println("Channel: " + c.getType() + " with " + c.getFrequency());
		}

	}

	private static ChannelCollection populateChannels() {
		ChannelCollection channels = new ChannelCollectionImpl();
		channels.addChannel(new Channels(98.5, ChannelTypeEnum.ENGLISH));
		channels.addChannel(new Channels(99.5, ChannelTypeEnum.HINDI));
		channels.addChannel(new Channels(100.5, ChannelTypeEnum.FRENCH));
		channels.addChannel(new Channels(101.5, ChannelTypeEnum.ENGLISH));
		channels.addChannel(new Channels(102.5, ChannelTypeEnum.HINDI));
		channels.addChannel(new Channels(103.5, ChannelTypeEnum.FRENCH));
		channels.addChannel(new Channels(104.5, ChannelTypeEnum.ENGLISH));
		channels.addChannel(new Channels(105.5, ChannelTypeEnum.HINDI));
		channels.addChannel(new Channels(106.5, ChannelTypeEnum.FRENCH));
		return channels;
	}

}
