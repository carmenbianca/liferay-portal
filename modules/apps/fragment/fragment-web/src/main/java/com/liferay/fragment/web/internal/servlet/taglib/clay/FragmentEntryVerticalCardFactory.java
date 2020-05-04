/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.web.internal.servlet.taglib.clay;

import com.liferay.fragment.model.FragmentComposition;
import com.liferay.fragment.model.FragmentEntry;
import com.liferay.fragment.web.internal.constants.FragmentTypeConstants;
import com.liferay.frontend.taglib.clay.servlet.taglib.soy.VerticalCard;
import com.liferay.portal.kernel.dao.search.RowChecker;

import java.util.Objects;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Jürgen Kappler
 */
public class FragmentEntryVerticalCardFactory {

	public static FragmentEntryVerticalCardFactory getInstance() {
		return _fragmentEntryVerticalCardFactory;
	}

	public VerticalCard getVerticalCard(
		FragmentComposition fragmentComposition, RenderRequest renderRequest,
		RenderResponse renderResponse, RowChecker rowChecker, String type) {

		if (Objects.equals(type, FragmentTypeConstants.BASIC_FRAGMENT_TYPE)) {
			return new BasicFragmentCompositionVerticalCard(
				fragmentComposition, renderRequest, renderResponse, rowChecker);
		}

		return null;
	}

	public VerticalCard getVerticalCard(
		FragmentEntry fragmentEntry, RenderRequest renderRequest,
		RenderResponse renderResponse, RowChecker rowChecker, String type) {

		if (Objects.equals(type, FragmentTypeConstants.BASIC_FRAGMENT_TYPE)) {
			return new BasicFragmentEntryVerticalCard(
				fragmentEntry, renderRequest, renderResponse, rowChecker);
		}

		if (Objects.equals(
				type, FragmentTypeConstants.INHERITED_FRAGMENT_TYPE)) {

			return new InheritedFragmentEntryVerticalCard(
				fragmentEntry, renderRequest, renderResponse, rowChecker);
		}

		return null;
	}

	private FragmentEntryVerticalCardFactory() {
	}

	private static final FragmentEntryVerticalCardFactory
		_fragmentEntryVerticalCardFactory =
			new FragmentEntryVerticalCardFactory();

}