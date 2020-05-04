/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.core;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.Tag;

/**
 * @author Shuyang Zhou
 */
public class WhenTag extends ConditionalTagSupport {

	@Override
	public int doStartTag() throws JspTagException {
		Tag parentTag = getParent();

		if (!(parentTag instanceof ChooseTag)) {
			throw new JspTagException(
				"The when tag must exist under a choose tag");
		}

		ChooseTag chooseTag = (ChooseTag)parentTag;

		if (!chooseTag.canRun()) {
			return SKIP_BODY;
		}

		if (condition()) {
			chooseTag.markRan();

			return EVAL_BODY_INCLUDE;
		}

		return SKIP_BODY;
	}

	@Override
	public void release() {
		super.release();

		_test = false;
	}

	public void setTest(boolean test) {
		_test = test;
	}

	@Override
	protected boolean condition() {
		return _test;
	}

	private boolean _test;

}