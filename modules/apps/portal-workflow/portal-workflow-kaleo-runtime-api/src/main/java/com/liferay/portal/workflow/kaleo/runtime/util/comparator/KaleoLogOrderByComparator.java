/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorAdapter;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.workflow.kaleo.KaleoWorkflowModelConverter;
import com.liferay.portal.workflow.kaleo.model.KaleoLog;

/**
 * @author William Newbury
 */
public class KaleoLogOrderByComparator
	extends OrderByComparatorAdapter<KaleoLog, WorkflowLog> {

	public static OrderByComparator<KaleoLog> getOrderByComparator(
		OrderByComparator<WorkflowLog> orderByComparator,
		KaleoWorkflowModelConverter kaleoWorkflowModelConverter) {

		if (orderByComparator == null) {
			return null;
		}

		return new KaleoLogOrderByComparator(
			orderByComparator, kaleoWorkflowModelConverter);
	}

	@Override
	public WorkflowLog adapt(KaleoLog kaleoLog) {
		return _kaleoWorkflowModelConverter.toWorkflowLog(kaleoLog);
	}

	private KaleoLogOrderByComparator(
		OrderByComparator<WorkflowLog> orderByComparator,
		KaleoWorkflowModelConverter kaleoWorkflowModelConverter) {

		super(orderByComparator);

		_kaleoWorkflowModelConverter = kaleoWorkflowModelConverter;
	}

	private final KaleoWorkflowModelConverter _kaleoWorkflowModelConverter;

}