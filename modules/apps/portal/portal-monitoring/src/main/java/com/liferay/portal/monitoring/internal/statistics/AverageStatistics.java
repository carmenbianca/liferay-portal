/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.monitoring.internal.statistics;

/**
 * @author Rajesh Thiagarajan
 * @author Brian Wing Shun Chan
 */
public class AverageStatistics extends BaseStatistics {

	public AverageStatistics(String name) {
		super(name);

		_countStatistics = new CountStatistics(name);
	}

	public void addDuration(long duration) {
		_countStatistics.incrementCount();

		setLastTime(duration);

		if (getMaxTime() < duration) {
			setMaxTime(duration);
		}
		else if ((getMinTime() == 0) || (getMinTime() > duration)) {
			setMinTime(duration);
		}

		if (_averageTime == 0) {
			_averageTime = duration;
		}
		else {
			long span = 0;

			if (_countStatistics.getCount() < getLowerBound()) {
				span = getLowerBound();
			}
			else if (_countStatistics.getCount() > getUpperBound()) {
				span = getUpperBound();
			}
			else {
				span = _countStatistics.getCount();
			}

			_averageTime = (_averageTime * span + duration) / (span + 1);
		}

		setLastSampleTime(System.currentTimeMillis());
	}

	public long getAverageTime() {
		return _averageTime;
	}

	public long getCount() {
		return _countStatistics.getCount();
	}

	@Override
	public void reset() {
		super.reset();

		_averageTime = 0;
	}

	private long _averageTime;
	private final CountStatistics _countStatistics;

}