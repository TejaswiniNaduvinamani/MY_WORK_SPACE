package com.org.iteratordesignpattern;

import java.util.ArrayList;
import java.util.List;

public class ChannelCollectionImpl implements ChannelCollection {

	private List<Channels> channel;

	ChannelCollectionImpl() {
		channel = new ArrayList<>();
	}

	@Override
	public void addChannel(Channels channel) {
		this.channel.add(channel);

	}

	@Override
	public void removeChannel(Channels channel) {
		this.channel.remove(channel);
	}

	@Override
	public ChannelIterator iterator(ChannelTypeEnum type) {
		return new ChannelIteratorImpl(type, channel);
	}

	private class ChannelIteratorImpl implements ChannelIterator {

		private ChannelTypeEnum type;
		List<Channels> c;
		private int position;

		public ChannelIteratorImpl(ChannelTypeEnum type, List<Channels> c) {
			this.type = type;
			this.c = c;
		}

		@Override
		public boolean hasNext() {
			while (position < c.size()) {

				if (((c.get(position)).getType().name()).equals(type.name())
						|| (type.name()).equals(ChannelTypeEnum.ALL.name())) {
					return true;
				} else
					position++;

			}
			return false;
		}

		@Override
		public Channels next() {
			Channels ch = c.get(position);
			position++;
			return ch;
		}

	}

}
