/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.ccr;

import com.liferay.portal.search.engine.adapter.ccr.PauseFollowCCRRequest;
import com.liferay.portal.search.engine.adapter.ccr.PauseFollowCCRResponse;

/**
 * @author Bryan Engler
 */
public interface PauseFollowCCRRequestExecutor {

	public PauseFollowCCRResponse execute(
		PauseFollowCCRRequest pauseFollowCCRRequest);

}