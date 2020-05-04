/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.internal.exportimport.data.handler;

import com.liferay.exportimport.kernel.xstream.XStreamAliasRegistryUtil;
import com.liferay.knowledge.base.model.impl.KBArticleImpl;
import com.liferay.knowledge.base.model.impl.KBCommentImpl;
import com.liferay.knowledge.base.model.impl.KBTemplateImpl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Lance Ji
 */
@Component(immediate = true, service = {})
public class XStreamAliasRegister {

	@Activate
	protected void activate() {
		XStreamAliasRegistryUtil.register(KBArticleImpl.class, "KBArticle");
		XStreamAliasRegistryUtil.register(KBCommentImpl.class, "KBComment");
		XStreamAliasRegistryUtil.register(KBTemplateImpl.class, "KBTemplate");
	}

}