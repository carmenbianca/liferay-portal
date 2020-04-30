/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.web.internal.util.filter;

import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.workflow.web.internal.constants.WorkflowDefinitionConstants;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Adam Brandizzi
 */
public class WorkflowDefinitionActivePredicateTest {

	@Test
	public void testFilterAllIncludeActive() {
		WorkflowDefinitionActivePredicate predicate =
			new WorkflowDefinitionActivePredicate(
				WorkflowDefinitionConstants.STATUS_ALL);

		WorkflowDefinition workflowDefinition = new WorkflowDefinitionImpl(
			true);

		boolean result = predicate.test(workflowDefinition);

		Assert.assertTrue(result);
	}

	@Test
	public void testFilterAllIncludeInactive() {
		WorkflowDefinitionActivePredicate predicate =
			new WorkflowDefinitionActivePredicate(
				WorkflowDefinitionConstants.STATUS_ALL);

		WorkflowDefinition workflowDefinition = new WorkflowDefinitionImpl(
			false);

		boolean result = predicate.test(workflowDefinition);

		Assert.assertTrue(result);
	}

	@Test
	public void testFilterNotPublishedExcludeActive() {
		WorkflowDefinitionActivePredicate predicate =
			new WorkflowDefinitionActivePredicate(
				WorkflowDefinitionConstants.STATUS_NOT_PUBLISHED);

		WorkflowDefinition workflowDefinition = new WorkflowDefinitionImpl(
			true);

		boolean result = predicate.test(workflowDefinition);

		Assert.assertFalse(result);
	}

	@Test
	public void testFilterNotPublishedIncludeInactive() {
		WorkflowDefinitionActivePredicate predicate =
			new WorkflowDefinitionActivePredicate(
				WorkflowDefinitionConstants.STATUS_NOT_PUBLISHED);

		WorkflowDefinition workflowDefinition = new WorkflowDefinitionImpl(
			false);

		boolean result = predicate.test(workflowDefinition);

		Assert.assertTrue(result);
	}

	@Test
	public void testFilterPublishedExcludeInactive() {
		WorkflowDefinitionActivePredicate predicate =
			new WorkflowDefinitionActivePredicate(
				WorkflowDefinitionConstants.STATUS_PUBLISHED);

		WorkflowDefinition workflowDefinition = new WorkflowDefinitionImpl(
			false);

		boolean result = predicate.test(workflowDefinition);

		Assert.assertFalse(result);
	}

	@Test
	public void testFilterPublishedIncludeActive() {
		WorkflowDefinitionActivePredicate predicate =
			new WorkflowDefinitionActivePredicate(
				WorkflowDefinitionConstants.STATUS_PUBLISHED);

		WorkflowDefinition workflowDefinition = new WorkflowDefinitionImpl(
			true);

		boolean result = predicate.test(workflowDefinition);

		Assert.assertTrue(result);
	}

}