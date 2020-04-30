/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.wizard;

/**
 * @author Ivica Cardic
 */
public class LiferayConnectionEditWizardDefinition
	extends LiferayConnectionWizardDefinition {

	public static final String COMPONENT_WIZARD_NAME =
		"LiferayConnectionEditWizard";

	@Override
	public String getName() {
		return COMPONENT_WIZARD_NAME;
	}

	@Override
	public boolean isTopLevel() {
		return false;
	}

}