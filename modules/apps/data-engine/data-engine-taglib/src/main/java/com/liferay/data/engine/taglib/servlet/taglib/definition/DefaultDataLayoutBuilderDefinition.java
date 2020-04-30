/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.taglib.servlet.taglib.definition;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true, property = "content.type=default",
	service = DataLayoutBuilderDefinition.class
)
public class DefaultDataLayoutBuilderDefinition
	implements DataLayoutBuilderDefinition {
}