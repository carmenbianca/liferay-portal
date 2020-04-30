/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo;

import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignment;

/**
 * @author Michael C. Han
 */
public interface KaleoTaskAssignmentFactory {

	public KaleoTaskAssignment createKaleoTaskAssignment();

}