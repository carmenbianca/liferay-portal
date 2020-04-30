/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.web.internal.util.filter;

import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.workflow.web.internal.util.comparator.WorkflowDefinitionModifiedDateComparator;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Adam Brandizzi
 */
public class WorkflowDefinitionModifiedDateComparatorTest {

	@Test
	public void testCompareEqualsAscending() {
		WorkflowDefinitionModifiedDateComparator comparator =
			new WorkflowDefinitionModifiedDateComparator(true);

		Calendar calendar = Calendar.getInstance();

		WorkflowDefinition workflowDefinition1 = new WorkflowDefinitionImpl(
			calendar.getTime());

		WorkflowDefinition workflowDefinition2 = new WorkflowDefinitionImpl(
			calendar.getTime());

		int result = comparator.compare(
			workflowDefinition2, workflowDefinition1);

		Assert.assertEquals(0, result);
	}

	@Test
	public void testCompareEqualsDescending() {
		WorkflowDefinitionModifiedDateComparator comparator =
			new WorkflowDefinitionModifiedDateComparator(false);

		Calendar calendar = Calendar.getInstance();

		WorkflowDefinition workflowDefinition1 = new WorkflowDefinitionImpl(
			calendar.getTime());

		WorkflowDefinition workflowDefinition2 = new WorkflowDefinitionImpl(
			calendar.getTime());

		int result = comparator.compare(
			workflowDefinition2, workflowDefinition1);

		Assert.assertEquals(0, result);
	}

	@Test
	public void testCompareNewerOlderAscending() {
		WorkflowDefinitionModifiedDateComparator comparator =
			new WorkflowDefinitionModifiedDateComparator(true);

		Calendar calendar = Calendar.getInstance();

		WorkflowDefinition workflowDefinition1 = new WorkflowDefinitionImpl(
			calendar.getTime());

		calendar.add(Calendar.DATE, 1);

		WorkflowDefinition workflowDefinition2 = new WorkflowDefinitionImpl(
			calendar.getTime());

		int result = comparator.compare(
			workflowDefinition2, workflowDefinition1);

		Assert.assertEquals(1, result);
	}

	@Test
	public void testCompareNewerOlderDescending() {
		WorkflowDefinitionModifiedDateComparator comparator =
			new WorkflowDefinitionModifiedDateComparator(false);

		Calendar calendar = Calendar.getInstance();

		WorkflowDefinition workflowDefinition1 = new WorkflowDefinitionImpl(
			calendar.getTime());

		calendar.add(Calendar.DATE, 1);

		WorkflowDefinition workflowDefinition2 = new WorkflowDefinitionImpl(
			calendar.getTime());

		int result = comparator.compare(
			workflowDefinition2, workflowDefinition1);

		Assert.assertEquals(-1, result);
	}

	@Test
	public void testCompareOlderNewerAscending() {
		WorkflowDefinitionModifiedDateComparator comparator =
			new WorkflowDefinitionModifiedDateComparator(true);

		Calendar calendar = Calendar.getInstance();

		WorkflowDefinition workflowDefinition1 = new WorkflowDefinitionImpl(
			calendar.getTime());

		calendar.add(Calendar.DATE, 1);

		WorkflowDefinition workflowDefinition2 = new WorkflowDefinitionImpl(
			calendar.getTime());

		int result = comparator.compare(
			workflowDefinition1, workflowDefinition2);

		Assert.assertEquals(-1, result);
	}

	@Test
	public void testCompareOlderNewerDescending() {
		WorkflowDefinitionModifiedDateComparator comparator =
			new WorkflowDefinitionModifiedDateComparator(false);

		Calendar calendar = Calendar.getInstance();

		WorkflowDefinition workflowDefinition1 = new WorkflowDefinitionImpl(
			calendar.getTime());

		calendar.add(Calendar.DATE, 1);

		WorkflowDefinition workflowDefinition2 = new WorkflowDefinitionImpl(
			calendar.getTime());

		int result = comparator.compare(
			workflowDefinition1, workflowDefinition2);

		Assert.assertEquals(1, result);
	}

}