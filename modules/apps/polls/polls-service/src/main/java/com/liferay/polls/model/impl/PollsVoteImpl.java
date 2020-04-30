/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.model.impl;

import com.liferay.polls.model.PollsChoice;
import com.liferay.polls.service.PollsChoiceLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class PollsVoteImpl extends PollsVoteBaseImpl {

	@Override
	public PollsChoice getChoice() throws PortalException {
		return PollsChoiceLocalServiceUtil.getChoice(getChoiceId());
	}

}