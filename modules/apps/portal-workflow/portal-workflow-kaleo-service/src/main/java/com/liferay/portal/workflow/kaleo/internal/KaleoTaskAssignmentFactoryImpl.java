/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.internal;

import com.liferay.portal.workflow.kaleo.KaleoTaskAssignmentFactory;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignment;
import com.liferay.portal.workflow.kaleo.model.impl.KaleoTaskAssignmentImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = KaleoTaskAssignmentFactory.class)
public class KaleoTaskAssignmentFactoryImpl
	implements KaleoTaskAssignmentFactory {

	@Override
	public KaleoTaskAssignment createKaleoTaskAssignment() {
		return new KaleoTaskAssignmentImpl();
	}

}