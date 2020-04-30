/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.ccr;

import com.liferay.portal.search.engine.adapter.ccr.PutFollowCCRRequest;
import com.liferay.portal.search.engine.adapter.ccr.PutFollowCCRResponse;

/**
 * @author Bryan Engler
 */
public interface PutFollowCCRRequestExecutor {

	public PutFollowCCRResponse execute(
		PutFollowCCRRequest putFollowCCRRequest);

}