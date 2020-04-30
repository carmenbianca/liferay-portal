/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Raymond Augé
 */
public class StringPlus {

	public static List<String> asList(Object object) {
		if (object instanceof String) {
			return new ArrayList<>(Collections.singletonList((String)object));
		}
		else if (object instanceof String[]) {
			return new ArrayList<>(Arrays.asList((String[])object));
		}
		else if (object instanceof Collection) {
			Collection<?> collection = (Collection<?>)object;

			if (!collection.isEmpty()) {
				Iterator<?> iterator = collection.iterator();

				Object element = iterator.next();

				if (element instanceof String) {
					return new ArrayList<>((Collection<String>)object);
				}
			}
		}

		return new ArrayList<>();
	}

}