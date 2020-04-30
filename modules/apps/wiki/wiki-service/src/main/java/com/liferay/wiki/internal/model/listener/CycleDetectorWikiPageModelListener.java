/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.internal.model.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.wiki.model.WikiPage;

import org.osgi.service.component.annotations.Component;

/**
 * @author Tomas Polesovsky
 */
@Component(immediate = true, service = ModelListener.class)
public class CycleDetectorWikiPageModelListener
	extends BaseModelListener<WikiPage> {

	@Override
	public void onBeforeCreate(WikiPage model) throws ModelListenerException {
		if (isCycleDetectedInWikiPagesGraph(model)) {
			throw new ModelListenerException(
				"Unable to create wiki page " + model.getTitle() +
					" because a cycle was detected");
		}

		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeUpdate(WikiPage model) throws ModelListenerException {
		if (isCycleDetectedInWikiPagesGraph(model)) {
			throw new ModelListenerException(
				"Unable to update wiki page " + model.getTitle() +
					" because a cycle was detected");
		}

		super.onBeforeUpdate(model);
	}

	protected boolean isCycleDetectedInWikiPagesGraph(WikiPage wikiPage) {
		String title = wikiPage.getTitle();

		if (Validator.isBlank(title)) {
			return false;
		}

		WikiPage parentPage = wikiPage;

		title = title.trim();

		while (parentPage != null) {
			String parentTitle = parentPage.getParentTitle();

			if (Validator.isBlank(parentTitle)) {
				return false;
			}

			parentTitle = parentTitle.trim();

			if (StringUtil.equalsIgnoreCase(title, parentTitle)) {
				return true;
			}

			parentPage = parentPage.fetchParentPage();
		}

		return false;
	}

}