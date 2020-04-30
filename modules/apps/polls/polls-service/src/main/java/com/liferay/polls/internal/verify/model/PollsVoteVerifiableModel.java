/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.internal.verify.model;

import com.liferay.portal.kernel.verify.model.VerifiableGroupedModel;

/**
 * @author Miguel Pastor
 */
public class PollsVoteVerifiableModel implements VerifiableGroupedModel {

	@Override
	public String getPrimaryKeyColumnName() {
		return "voteId";
	}

	@Override
	public String getRelatedPrimaryKeyColumnName() {
		return "questionId";
	}

	@Override
	public String getRelatedTableName() {
		return "PollsQuestion";
	}

	@Override
	public String getTableName() {
		return "PollsVote";
	}

}