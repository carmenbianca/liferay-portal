/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition.internal.export.builder;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.workflow.kaleo.definition.Condition;
import com.liferay.portal.workflow.kaleo.model.KaleoCondition;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.service.KaleoConditionLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true, property = "node.type=CONDITION",
	service = NodeBuilder.class
)
public class ConditionNodeBuilder
	extends BaseNodeBuilder<Condition> implements NodeBuilder {

	@Override
	protected Condition createNode(KaleoNode kaleoNode) throws PortalException {
		KaleoCondition kaleoCondition =
			_kaleoConditionLocalService.getKaleoNodeKaleoCondition(
				kaleoNode.getKaleoNodeId());

		return new Condition(
			kaleoNode.getName(), kaleoNode.getDescription(),
			kaleoCondition.getScript(), kaleoCondition.getScriptLanguage(),
			kaleoCondition.getScriptRequiredContexts());
	}

	@Reference
	private KaleoConditionLocalService _kaleoConditionLocalService;

}