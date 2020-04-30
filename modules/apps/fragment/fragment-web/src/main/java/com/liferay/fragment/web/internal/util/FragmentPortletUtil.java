/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.web.internal.util;

import com.liferay.fragment.model.FragmentCollection;
import com.liferay.fragment.util.comparator.FragmentCollectionCreateDateComparator;
import com.liferay.fragment.util.comparator.FragmentCollectionNameComparator;
import com.liferay.fragment.util.comparator.FragmentCompositionFragmentEntryCreateDateComparator;
import com.liferay.fragment.util.comparator.FragmentCompositionFragmentEntryNameComparator;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Jürgen Kappler
 */
public class FragmentPortletUtil {

	public static OrderByComparator<FragmentCollection>
		getFragmentCollectionOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator<FragmentCollection> orderByComparator = null;

		if (orderByCol.equals("create-date")) {
			orderByComparator = new FragmentCollectionCreateDateComparator(
				orderByAsc);
		}
		else if (orderByCol.equals("name")) {
			orderByComparator = new FragmentCollectionNameComparator(
				orderByAsc);
		}

		return orderByComparator;
	}

	public static OrderByComparator<Object>
		getFragmentCompositionAndEntryOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator<Object> orderByComparator = null;

		if (orderByCol.equals("create-date")) {
			orderByComparator =
				new FragmentCompositionFragmentEntryCreateDateComparator(
					orderByAsc);
		}
		else if (orderByCol.equals("name")) {
			orderByComparator =
				new FragmentCompositionFragmentEntryNameComparator(orderByAsc);
		}

		return orderByComparator;
	}

}