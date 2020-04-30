/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.highlight;

import com.liferay.portal.search.highlight.HighlightFieldBuilder;
import com.liferay.portal.search.highlight.HighlightFieldBuilderFactory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Wade Cao
 * @author André de Oliveira
 */
@Component(service = HighlightFieldBuilderFactory.class)
public class HighlightFieldBuilderFactoryImpl
	implements HighlightFieldBuilderFactory {

	@Override
	public HighlightFieldBuilder builder() {
		return new HighlightFieldImpl.HighlightFieldBuilderImpl();
	}

}