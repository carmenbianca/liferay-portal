/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.creole.processor;

import com.liferay.wiki.processor.BaseWikiPageRenameContentProcessor;
import com.liferay.wiki.processor.WikiPageRenameContentProcessor;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Roberto Díaz
 * @author Daniel Sanz
 */
@Component(
	immediate = true, property = "wiki.format.name=creole",
	service = WikiPageRenameContentProcessor.class
)
public class WikiPageRenameCreoleContentProcessor
	extends BaseWikiPageRenameContentProcessor {

	@Activate
	@Modified
	protected void activate() {
		regexps.put("\\{\\{@old_title@/", "{{@new_title@/");
	}

}