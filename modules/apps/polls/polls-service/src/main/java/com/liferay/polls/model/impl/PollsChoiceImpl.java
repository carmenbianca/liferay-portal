/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.model.impl;

import com.liferay.polls.service.PollsVoteLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class PollsChoiceImpl extends PollsChoiceBaseImpl {

	@Override
	public int getVotesCount() {
		return PollsVoteLocalServiceUtil.getChoiceVotesCount(getChoiceId());
	}

}