/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.admin.workflow.internal.dto.v1_0.util;

import com.liferay.headless.admin.workflow.dto.v1_0.Transition;
import com.liferay.portal.kernel.language.Language;

import java.util.ResourceBundle;

/**
 * @author Inácio Nery
 */
public class TransitionUtil {

	public static Transition toTransition(
		Language language, String name, ResourceBundle resourceBundle) {

		Transition transition = new Transition();

		transition.setLabel(language.get(resourceBundle, name));
		transition.setName(name);

		return transition;
	}

}