package com.org.iteratordesignpattern;

public interface ChannelCollection {

	public void addChannel(Channels channel);

	public void removeChannel(Channels channel);

	public ChannelIterator iterator(ChannelTypeEnum type);

}
