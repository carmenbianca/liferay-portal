/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition.internal.parser;

import com.liferay.portal.workflow.kaleo.definition.Condition;
import com.liferay.portal.workflow.kaleo.definition.Definition;
import com.liferay.portal.workflow.kaleo.definition.exception.KaleoDefinitionValidationException;
import com.liferay.portal.workflow.kaleo.definition.parser.NodeValidator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 * @author Marcellus Tavares
 */
@Component(
	immediate = true, property = "node.type=CONDITION",
	service = NodeValidator.class
)
public class ConditionNodeValidator extends BaseNodeValidator<Condition> {

	@Override
	protected void doValidate(Definition definition, Condition condition)
		throws KaleoDefinitionValidationException {

		if (condition.getIncomingTransitionsCount() == 0) {
			throw new KaleoDefinitionValidationException.
				MustSetIncomingTransition(condition.getName());
		}

		if (condition.getOutgoingTransitionsCount() < 2) {
			throw new KaleoDefinitionValidationException.
				MustSetMultipleOutgoingTransition(condition.getName());
		}
	}

}