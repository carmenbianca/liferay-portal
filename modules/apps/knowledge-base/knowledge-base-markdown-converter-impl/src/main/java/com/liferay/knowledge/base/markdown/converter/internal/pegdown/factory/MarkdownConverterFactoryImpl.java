/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.markdown.converter.internal.pegdown.factory;

import com.liferay.knowledge.base.markdown.converter.MarkdownConverter;
import com.liferay.knowledge.base.markdown.converter.factory.MarkdownConverterFactory;
import com.liferay.knowledge.base.markdown.converter.internal.pegdown.LiferayPegDownConverter;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	enabled = true, immediate = true, service = MarkdownConverterFactory.class
)
public class MarkdownConverterFactoryImpl implements MarkdownConverterFactory {

	@Override
	public MarkdownConverter create() {
		return new LiferayPegDownConverter();
	}

}