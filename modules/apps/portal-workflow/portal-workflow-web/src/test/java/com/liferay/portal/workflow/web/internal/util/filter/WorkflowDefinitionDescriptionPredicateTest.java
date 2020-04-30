/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.web.internal.util.filter;

import com.liferay.portal.kernel.workflow.WorkflowDefinition;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Adam Brandizzi
 */
public class WorkflowDefinitionDescriptionPredicateTest {

	@Test
	public void testFilterWithoutSpace1() {
		WorkflowDefinitionDescriptionPredicate predicate =
			new WorkflowDefinitionDescriptionPredicate("Default");

		WorkflowDefinition workflowDefinition = new WorkflowDefinitionImpl(
			null, "Single Approver", "Default Single Approver");

		boolean result = predicate.test(workflowDefinition);

		Assert.assertTrue(result);
	}

	@Test
	public void testFilterWithoutSpace2() {
		WorkflowDefinitionDescriptionPredicate predicate =
			new WorkflowDefinitionDescriptionPredicate("Def");

		WorkflowDefinition workflowDefinition = new WorkflowDefinitionImpl(
			null, "Single Approver", "Default Single Approver");

		boolean result = predicate.test(workflowDefinition);

		Assert.assertTrue(result);
	}

	@Test
	public void testFilterWithoutSpace3() {
		WorkflowDefinitionDescriptionPredicate predicate =
			new WorkflowDefinitionDescriptionPredicate("Approver");

		WorkflowDefinition workflowDefinition = new WorkflowDefinitionImpl(
			null, "A Different Definition", "Not that one");

		boolean result = predicate.test(workflowDefinition);

		Assert.assertFalse(result);
	}

	@Test
	public void testFilterWithSpace1() {
		WorkflowDefinitionDescriptionPredicate predicate =
			new WorkflowDefinitionDescriptionPredicate("Single Approver");

		WorkflowDefinition workflowDefinition = new WorkflowDefinitionImpl(
			null, "Single Approver Definition",
			"Single Approver by Default Default ");

		boolean result = predicate.test(workflowDefinition);

		Assert.assertTrue(result);
	}

	@Test
	public void testFilterWithSpace2() {
		WorkflowDefinitionDescriptionPredicate predicate =
			new WorkflowDefinitionDescriptionPredicate("Single Approver");

		WorkflowDefinition workflowDefinition = new WorkflowDefinitionImpl(
			null, "A Different Definition", "Not that one");

		boolean result = predicate.test(workflowDefinition);

		Assert.assertFalse(result);
	}

}