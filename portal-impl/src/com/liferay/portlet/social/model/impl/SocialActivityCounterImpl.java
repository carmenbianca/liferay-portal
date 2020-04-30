/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.social.model.impl;

import com.liferay.social.kernel.model.SocialActivityCounterConstants;
import com.liferay.social.kernel.util.SocialCounterPeriodUtil;

/**
 * @author Zsolt Berentey
 */
public class SocialActivityCounterImpl extends SocialActivityCounterBaseImpl {

	@Override
	public boolean isActivePeriod(int periodLength) {
		if (periodLength ==
				SocialActivityCounterConstants.PERIOD_LENGTH_INFINITE) {

			return true;
		}

		if ((periodLength !=
				SocialActivityCounterConstants.PERIOD_LENGTH_SYSTEM) &&
			((getStartPeriod() + periodLength) >
				SocialCounterPeriodUtil.getActivityDay())) {

			return true;
		}

		if ((getStartPeriod() == SocialCounterPeriodUtil.getStartPeriod()) &&
			((getEndPeriod() == -1) ||
			 (getEndPeriod() == SocialCounterPeriodUtil.getEndPeriod()))) {

			return true;
		}

		return false;
	}

}