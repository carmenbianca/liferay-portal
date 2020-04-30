/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.editor.alloyeditor.web.internal.spa.navigation.exception.selector.contributor;

import org.osgi.service.component.annotations.Component;

/**
 * @author Chema Balsas
 */
@Component(
	immediate = true,
	property = "javascript.single.page.application.navigation.exception.selector=:not([data-cke-saved-href])",
	service = Object.class
)
public class AlloyEditorSPANavigationExceptionSelectorContributor {
}