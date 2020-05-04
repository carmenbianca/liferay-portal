/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.integration.internal.util;

import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowTaskAssignee;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignmentInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Marcellus Tavares
 */
public class FirstWorkflowTaskAssigneeSupplierTest {

	@Test
	public void testGetWhenFirstKaleoTaskAssignmentInstanceIsNotNull() {
		String expectedAssigneeClassName = StringUtil.randomString();

		long expectedAssigneeClassPK = RandomTestUtil.randomLong();

		KaleoTaskAssignmentInstance firstKaleoTaskAssignmentInstance =
			KaleoRuntimeTestUtil.mockKaleoTaskAssignmentInstance(
				expectedAssigneeClassName, expectedAssigneeClassPK);

		KaleoTaskInstanceToken kaleoTaskInstanceToken =
			KaleoRuntimeTestUtil.mockKaleoTaskInstanceToken(
				firstKaleoTaskAssignmentInstance);

		FirstWorkflowTaskAssigneeSupplier firstWorkflowTaskAssigneeSupplier =
			new FirstWorkflowTaskAssigneeSupplier(kaleoTaskInstanceToken);

		Optional<WorkflowTaskAssignee> firstWorkflowTaskAssigneeOptional =
			firstWorkflowTaskAssigneeSupplier.get();

		Assert.assertTrue(firstWorkflowTaskAssigneeOptional.isPresent());

		KaleoRuntimeTestUtil.assertWorkflowTaskAssignee(
			expectedAssigneeClassName, expectedAssigneeClassPK,
			firstWorkflowTaskAssigneeOptional.get());
	}

	@Test
	public void testGetWhenFirstKaleoTaskAssignmentInstanceIsNull() {
		KaleoTaskInstanceToken kaleoTaskInstanceToken =
			KaleoRuntimeTestUtil.mockKaleoTaskInstanceToken();

		FirstWorkflowTaskAssigneeSupplier firstWorkflowTaskAssigneeSupplier =
			new FirstWorkflowTaskAssigneeSupplier(kaleoTaskInstanceToken);

		Optional<WorkflowTaskAssignee> firstWorkflowTaskAssigneeOptional =
			firstWorkflowTaskAssigneeSupplier.get();

		Assert.assertFalse(firstWorkflowTaskAssigneeOptional.isPresent());
	}

}