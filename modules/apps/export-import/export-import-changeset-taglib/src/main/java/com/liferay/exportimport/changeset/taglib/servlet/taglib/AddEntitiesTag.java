/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.changeset.taglib.servlet.taglib;

import com.liferay.exportimport.changeset.Changeset;
import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.taglib.TagSupport;

import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

/**
 * @author Máté Thurzó
 */
public class AddEntitiesTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		Tag parentTag = getParent();

		if ((parentTag == null) || !(parentTag instanceof CreateTag)) {
			throw new JspException(
				"The add entities tag must exist under a create tag");
		}

		CreateTag createTag = (CreateTag)parentTag;

		Changeset.RawBuilder rawBuilder = createTag.getRawBuilder();

		rawBuilder.addMultipleStagedModel(_stagedModels);

		return EVAL_BODY_INCLUDE;
	}

	public void setStagedModels(Collection<StagedModel> stagedModels) {
		_stagedModels = stagedModels;
	}

	private Collection<StagedModel> _stagedModels;

}